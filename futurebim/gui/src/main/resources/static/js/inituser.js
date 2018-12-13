

mdmApp.controller('ActivationUserController', function ($scope, $http, $sce, $element, $compile, $mdSidenav) {
	
	$scope.savedata = {user:{}, "password":"", "passwordconfirm":"", };
	$scope.dataValidation = {'firstname' : true, 'lastname' : true, 'password' : true, 'passwordconfirm' : true, 'birthdate' : true, 'email' : true, };
	$scope.isValidate = true;
	
	var weakRegex = new RegExp("^(((?=.*[a-z])))(?=.{4,})");
	var mediumRegex = new RegExp("^(((?=.*[a-z])(?=.*[A-Z]))|((?=.*[a-z])(?=.*[0-9]))|((?=.*[A-Z])(?=.*[0-9])))(?=.{6,})");
	var strongRegex = new RegExp("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\$%\^&\*])(?=.{8,})");
	
	$scope.passwordStrength = {
		    
		    "background-color": "green",

		};
	
	$http({
		method: "GET",
		url: "/activation/data/curuser", 
		timeout: 10000				
	}).then(function(response){
	  
		$scope.savedata.user = response.data;
		delete $scope.savedata.user.created;
		delete $scope.savedata.user.updated;
		$scope.savedata.password = "";
		$scope.savedata.passwordconfirm = "";
		
		$scope.savedata.user.birthdateDate = new Date($scope.savedata.user.birthdate);
		
		$scope.validate();

	  //$scope.$parent.showloading = false;
		
	}, function errorCallback(response){ 
		$scope.$parent.showloading = false;	
		alert(response.data);
		
	});		
	
	$scope.saveUser = function(){
		//alert("save !!!!");
		
		//$("#userform").submit();
		
		$http({
			method: "post",
			url: "/activation/data/saveuser", 
			timeout: 10000,
			data: $scope.savedata,
			headers: {
				'Content-Type': 'application/json'
			}
		}).then(function(response){
		  
			//$scope.test = response.data;
			
			//alert(response.data);
			  //$scope.$parent.showloading = false;
			
			//if(response.data == 'ok'){
			
				window.location = rooturl;
			//}
			
		}, function errorCallback(response){ 
			$scope.$parent.showloading = false;		
			alert(response.data);
			
		});		
		
	}
	
	$scope.validate = function(){
		
		$scope.isValidate = true;
		for(dataItem in $scope.dataValidation){
			$scope.dataValidation[dataItem] = true;
		}
		
		if($scope.savedata.user.birthdateDate == null){
			$scope.dataValidation['birthdate'] = false;
			$scope.isValidate = false;
		}
		else{
			$scope.savedata.user['birthdate'] = moment($scope.savedata.user.birthdateDate).format("YYYY-MM-DD");
		}
		
		if($scope.savedata.password !== $scope.savedata.passwordconfirm){
			$scope.dataValidation['passwordconfirm'] = false;
			$scope.isValidate = false;

		}
		
		if(!$scope.analyzePassword($scope.savedata['password'])){
			$scope.dataValidation['password'] = false;
			$scope.isValidate = false; 
		}
	
		for(dataItem in $scope.dataValidation){

			if(dataItem == 'password' || dataItem == 'passwordconfirm'){
				if($scope.savedata[dataItem] == undefined || $scope.savedata[dataItem] == null || $scope.savedata[dataItem].length < 3){
					$scope.dataValidation[dataItem] = false;
					$scope.isValidate = false;
				}
			}
			else{
				if($scope.savedata.user[dataItem] == undefined || $scope.savedata.user[dataItem] == null || $scope.savedata.user[dataItem].length < 3){
					$scope.dataValidation[dataItem] = false;
					$scope.isValidate = false;
				}	
			}
					
		}
		
		
		return $scope.isValidate;
	}
	
	$scope.analyzePassword = function(value) { var dt = new Date(); $scope.test = "test password: " + dt.toLocaleString("de-DE") + ": " + value;
        if(strongRegex.test(value)) {
            $scope.passwordStrength["background-color"] = "rgb(30, 183, 0)";
            return true;
        } else if(mediumRegex.test(value)) {
            $scope.passwordStrength["background-color"] = "#rgb(93, 93, 234)";
            return true;
        } else if(weakRegex.test(value)) {
            $scope.passwordStrength["background-color"] = "orange";
            return true;
        } else {
            $scope.passwordStrength["background-color"] = "red";
            return false;
        }
        return false;
    };
	
});