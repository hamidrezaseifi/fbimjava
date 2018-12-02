

mdmApp.controller('ActivationUserController', function ($scope, $http, $sce, $element, $compile, $mdSidenav) {
	
	$scope.user = {};
	
	$http({
		method: "GET",
		url: "/activation/data/curuser", 
		timeout: 10000				
	}).then(function(response){
	  
		$scope.user = response.data;
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
	
});