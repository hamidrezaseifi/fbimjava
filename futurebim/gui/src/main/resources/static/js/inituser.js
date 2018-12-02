

mdmApp.controller('ActivationUserController', function ($scope, $http, $sce, $element, $compile, $mdSidenav) {
	
	$scope.user = {};
	$scope.dataValidation = {'firstname' : true, 'lastname' : true, 'hashPassword' : true, 'passwordconfirm' : true, 'birthdate' : true, 'email' : true, };
	$scope.isValidate = true;
	
	var mediumRegex = new RegExp("^(((?=.*[a-z])(?=.*[A-Z]))|((?=.*[a-z])(?=.*[0-9]))|((?=.*[A-Z])(?=.*[0-9])))(?=.{6,})");
	var strongRegex = new RegExp("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\$%\^&\*])(?=.{8,})");
	
	$scope.passwordStrength = {
		    //"float": "left",
		    "width": "265px",
		    "height": "5px",
		    "margin-left": "106px",
		    "margin-top": "-5px",
		    //"background-color": "green",
		    "position": "relative",
		};
	
	$http({
		method: "GET",
		url: "/activation/data/curuser", 
		timeout: 10000				
	}).then(function(response){
	  
		$scope.user = response.data;
		delete $scope.user.created;
		delete $scope.user.updated;
		$scope.user.hashPassword = "";
		$scope.user.passwordconfirm = "";
		
		$scope.user.birthdateDate = new Date($scope.user.birthdate);
		
		$scope.validate('hashPassword');
		$scope.validate('passwordconfirm');

	  //$scope.$parent.showloading = false;
		
	}, function errorCallback(response){ 
		$scope.$parent.showloading = false;		
		
	});		
	
	$scope.saveUser = function(){
		//alert("save !!!!");
		
		//$("#userform").submit();
		
		$http({
			method: "post",
			url: "/activation/data/saveuser", 
			timeout: 10000,
			data: $scope.user,
			headers: {
				'Content-Type': 'application/json'
			}
		}).then(function(response){
		  
			$scope.test = response.data;
			
			  //$scope.$parent.showloading = false;
			
			
		}, function errorCallback(response){ 
			$scope.$parent.showloading = false;		
			
		});		
		
	}
	
	$scope.validate = function(item){
		
		$scope.dataValidation[item] = true;
		$scope.isValidate = true;
		
		if(item == 'birthdate'){
			if($scope.user.birthdateDate == null){
				$scope.dataValidation[item] = false;
				$scope.isValidate = false;
				return false;
			}
			else{
				$scope.user[item] = moment($scope.user.birthdateDate).format("YYYY-MM-DD");
				return true;
			}
		}
		
		if(item == 'passwordconfirm'){
			
			if($scope.user.hashPassword !== $scope.user.passwordconfirm){
				$scope.dataValidation['passwordconfirm'] = false;
				$scope.isValidate = false;
				return false;
			}
			
			return true;
		}
		
		if(item == 'hashPassword'){
			if(!$scope.analyzePassword($scope.user['hashPassword'])){
				$scope.dataValidation['hashPassword'] = false;
				$scope.isValidate = false;
				return false;
			}
			return true;
		}
		
		if($scope.user[item] == undefined || $scope.user[item] == null || $scope.user[item].length < 3){
			$scope.dataValidation[item] = false;
			$scope.isValidate = false;
			return false;
		}
		
		return true;
	}
	
	$scope.analyzePassword = function(value) {
        if(strongRegex.test(value)) {
            $scope.passwordStrength["background-color"] = "green";
            return true;
        } else if(mediumRegex.test(value)) {
            $scope.passwordStrength["background-color"] = "orange";
            return true;
        } else {
            $scope.passwordStrength["background-color"] = "red";
            return false;
        }
        return false;
    };
	
});