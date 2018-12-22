

fbimApp.controller('ProjectController', function ($scope, $http, $sce, $element, $compile, $mdSidenav, NgTableParams) {

	$scope.showloading = false;
	$scope.workflow = false;
	$scope.workflowId = $("#hdnwid").val();
	
	$("#deletemsgpanel").html($("#deletemsgpanel").html().replace("%s" , "&nbsp; <strong>'" + $("#hdnwname").val() + "'</strong> &nbsp;"));

	$scope.loadProject = function(){
		
		$http({
			method: "GET",
			url: "/workflow/data/workflow/read/" + $scope.workflowId, 
			timeout: 10000				
		}).then(function(response){
		  
			$scope.workflow = response.data;
			$scope.workflow.type = $scope.workflow.type + "";
			$scope.workflow.status = $scope.workflow.status + "";
			$scope.workflow.responsible = $scope.workflow.responsible + "";
			$scope.workflow.projectid = $scope.workflow.projectid + "";
			
			delete $scope.workflow.created;
			delete $scope.workflow.updated;
			delete $scope.workflow.reporterUser;
			delete $scope.workflow.responsibleUser;

		}, function errorCallback(response){ 
			$scope.$parent.showloading = false;		
			
		});		
		
	}

	$scope.deleteWorkflow = function(){
		
		$http({
			method: "POST",
			url: "/workflow/data/workflow/delete", 
			timeout: 10000,
			data: $scope.workflow,
			headers: {
				'Content-Type': 'application/json'
			}
		}).then(function(response){
		  
			window.location = "/workflow";
			

		}, function errorCallback(response){ 
			
			alert(response.data);
			$scope.$parent.showloading = false;		
			
		});		
		
	}
	
	$scope.loadProject();
	
	
});

