
fbimApp.controller('UserListController', function ($scope, $http, $sce, $element, $compile, $mdSidenav, NgTableParams) {

	$scope.showloading = false;
	$scope.user = false;
	$scope.editUser = false;
	$scope.userId = $("#hdnuid").val();
	$scope.isEdit = $scope.userId == "0";
	$scope.isCreate = $scope.userId == "0";

	
	$scope.loadUser = function(){
		
		$scope.$parent.showloading = true;
		$http({
			method: "GET",
			url: "/admin/data/user/read/" + $scope.userId, 
			timeout: 10000				
		}).then(function(response){
		  
			$scope.user = prepareUser(response.data);
			$scope.editUser = angular.copy($scope.user);
			

		}, function errorCallback(response){ 
			$scope.$parent.showloading = false;		
			
		});		
		
	}

	$scope.toggleEdit = function(doEdit){
		$scope.editUser = angular.copy($scope.user);
		$scope.isEdit = doEdit;
	};

	$scope.applyEdit = function(){
		
		if(!validateEditData()){
			return;
		}
		
		$scope.$parent.showloading = true;
		$http({
			method: "POST",
			url: "/admin/data/user/save", 
			timeout: 10000,
			data: $scope.editUser,
			headers: {
				'Content-Type': 'application/json'
			}
		}).then(function(response){
		  
			$scope.isEdit = false;
			$scope.$parent.showloading = false;
			
			$scope.user = prepareUser(response.data);
			
			if($scope.isCreate){
				window.location = "/admin/users/view/" + $scope.user.id
			}

		}, function errorCallback(response){ 
			
			alert(response.data);
			$scope.$parent.showloading = false;
			
		});		
		
		
	};
	
	$scope.loadUser();
	
	$(".form-err-message").hide();
	
	function prepareUser(user){

		user.status = user.status + "";
		user.gender = user.gender + "";
		
		delete user.created;
		delete user.updated;

		return user;
	}
	
	function validateEditData(){
		
		$(".error-input").removeClass("error-input");
		
		var res = true;
		if(stringHasMinimum($scope.editUser.firstname, 4) ){
			$(".input-firstname").addClass("error-input");
			res &= false;
		}
		
		if(stringHasMinimum($scope.editUser.lastname, 4) ){
			$(".input-lastname").addClass("error-input");
			res &= false;
		}
		
		if(stringHasMinimum($scope.editUser.username, 5) ){
			$(".input-username").addClass("error-input");
			res &= false;
		}
		
		if(stringHasMinimum($scope.editUser.email, 5) ){
			$(".input-email").addClass("error-input");
			res &= false;
		}
		
		if(stringHasMinimum($scope.editUser.birthdate, 5) ){
			$(".input-birthdate").addClass("error-input");
			res &= false;
		}
		
		return res;
	}
	
});

