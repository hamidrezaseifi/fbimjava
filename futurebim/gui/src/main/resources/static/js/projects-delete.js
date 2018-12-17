

fbimApp.controller('ProjectController', function ($scope, $http, $sce, $element, $compile, $mdSidenav, NgTableParams) {

	$scope.showloading = false;
	$scope.project = false;
	$scope.projectId = $("#hdnpid").val();
	
	$("#deletemsgpanel").html($("#deletemsgpanel").html().replace("%s" , "&nbsp; <strong>'" + $("#hdnpname").val() + "'</strong> &nbsp;"));

	$scope.loadProject = function(){
		
		$http({
			method: "GET",
			url: "/projects/data/project/read/" + $scope.projectId, 
			timeout: 10000				
		}).then(function(response){
		  
			$scope.project = response.data;
			
			delete $scope.project.created;
			delete $scope.project.updated;


		}, function errorCallback(response){ 
			$scope.$parent.showloading = false;		
			
		});		
		
	}

	$scope.deleteProject = function(){
		
		$http({
			method: "POST",
			url: "/projects/data/project/delete", 
			timeout: 10000,
			data: $scope.project,
			headers: {
				'Content-Type': 'application/json'
			}
		}).then(function(response){
		  
			window.location = "/projects";
			

		}, function errorCallback(response){ 
			
			alert(response.data);
			$scope.$parent.showloading = false;		
			
		});		
		
	}
	
	$scope.loadProject();
	
	
});

