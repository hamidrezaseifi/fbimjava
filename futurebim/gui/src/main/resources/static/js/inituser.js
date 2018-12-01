

mdmApp.controller('ActivationUserController', function ($scope, $http, $sce, $element, $compile, $mdSidenav) {
	
	$scope.user = "aaaaaaaaaa";
	
	$http({
		method: "GET",
		url: "/activation/data/curuser", 
		timeout: 10000				
	}).then(function(response){
	  
		$scope.user = response.data;
		$scope.user.birthdateDate = new Date($scope.user.birthdate);
		
		for(o in $scope.user){
			//alert(o + " : " + $scope.user[o]);
		}
		
	  //$scope.$parent.showloading = false;
		
	}, function errorCallback(response){ 
		$scope.$parent.showloading = false;		
		
	});		
	
	
	$scope.saveUser = function(){
		alert("save !!!!");
	}
	
});