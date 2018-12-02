

mdmApp.controller('ActivationUserController', function ($scope, $http, $sce, $element, $compile, $mdSidenav) {
	
	$scope.user = {};
	$scope.dataValidation = {'firstname' : true, 'firstname' : true, 'firstname' : true, };
	$scope.isValidate = true;
	
	$http({
		method: "GET",
		url: "/activation/data/curuser", 
		timeout: 10000				
	}).then(function(response){
	  
		$scope.user = response.data;
		delete $scope.user.created;
		delete $scope.user.updated;
		$scope.user.hashPassword = "";
		
		
		for(o in $scope.user){
			$scope.datavalidation[o] = true;
			$scope.validate(o);
		}
		
		$scope.user.birthdateDate = new Date($scope.user.birthdate);
		$scope.userjson = JSON.stringify($scope.user);

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
		if($scope.user[item] == undefined || $scope.user[item] == null){
			$scope.dataValidation[item] = false;
			$scope.isValidate = false;
			return false;
		}
		
		return true;
	}
	
});