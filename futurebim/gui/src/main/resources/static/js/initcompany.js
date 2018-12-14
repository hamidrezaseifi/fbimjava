

fbimApp.controller('ActivationCompanyController', function ($scope, $http, $sce, $element, $compile, $mdSidenav) {
	
	$scope.savedata = {company:{}, contactperson: -1, };
	$scope.dataValidation = {'companyName' : true, 'contactperson' : true, };
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
		
		
		$scope.savedata.contactperson = -1;
		if($scope.savedata.company.contactPersons.length > 0){
			$scope.savedata.contactperson = $scope.savedata.company.contactPersons[0] + "";
			
			
		}
		
		delete $scope.savedata.company.created;
		delete $scope.savedata.company.updated;
		
		$scope.validate();

	  //$scope.$parent.showloading = false;
		
	}, function errorCallback(response){ 
		$scope.$parent.showloading = false;		
		
	});		
	
	$scope.addEmail = function(){
		$scope.savedata.company.emails = $scope.savedata.company.emails.concat({});
	}
	
	$scope.deleteEmail = function(id){
		$scope.savedata.company.emails.splice(id, 1);
	}
	
	$scope.addTel = function(){
		$scope.savedata.company.phoneNumbers = $scope.savedata.company.phoneNumbers.concat({});
	}
	
	$scope.deleteTel = function(id){
		$scope.savedata.company.phoneNumbers.splice(id, 1);
	}
	
	$scope.addAddress = function(){
		$scope.savedata.company.postalAddresses = $scope.savedata.company.postalAddresses.concat({});
	}
	
	$scope.deleteAddress = function(id){
		$scope.savedata.company.postalAddresses.splice(id, 1);
	}
	
	$scope.saveUser = function(){
		//alert("save !!!!");
		
		//$("#userform").submit();
		if($scope.savedata.contactperson < 1){
			return;
		}
				
		$scope.savedata.company.contactPersons = [$scope.savedata.contactperson];

		$http({
			method: "post",
			url: "/activation/data/savecompany", 
			timeout: 10000,
			data: $scope.savedata.company,
			headers: {
				'Content-Type': 'application/json'
			}
		}).then(function(response){
		  
			$scope.test = response.data;
			
			window.location = rooturl ;
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
		
		if($scope.savedata.contactperson < 1){
			$scope.dataValidation["contactperson"] = false;
			$scope.isValidate = false;			
		}
	
		for(dataItem in $scope.dataValidation){

			
			//if($scope.savedata.company[dataItem] == undefined || $scope.savedata.company[dataItem] == null || $scope.savedata.company[dataItem].length < 3){
				//$scope.dataValidation[dataItem] = false;
				//$scope.isValidate = false;
			//}	
			
					
		}
		
		
		return $scope.isValidate;
	}
	
	
});