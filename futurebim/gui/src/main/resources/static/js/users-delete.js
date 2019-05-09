
fbimApp.controller('UserDeleteController', function ($scope, $http, $sce, $element, $compile, $mdSidenav, NgTableParams) {

	$scope.showloading = false;
	$scope.user = false;
	$scope.userId = $("#hdnuid").val();


	$scope.applyDelete = function(){
		
		$("#userdeleteform").submit();
		
		
	};
	
	
});

