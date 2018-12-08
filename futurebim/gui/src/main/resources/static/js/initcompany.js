

mdmApp.controller('ActivationCompanyController', function ($scope, $http, $sce, $element, $compile, $mdSidenav) {
	
	$scope.savedata = {company:{}, contactperson: -1, };
	$scope.dataValidation = {'companyname' : true, 'contactperson' : true, };
	$scope.isValidate = true;
		
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
		url: "/activation/data/curcompany", 
		timeout: 10000				
	}).then(function(response){
	  
		$scope.savedata.company = response.data;
		delete $scope.savedata.company.created;
		delete $scope.savedata.company.updated;
		
		$scope.validate();

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
			data: $scope.savedata,
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
	
	$scope.validate = function(){
		
		$scope.isValidate = true;
		for(dataItem in $scope.dataValidation){
			$scope.dataValidation[dataItem] = true;
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
	
	
});