

fbimApp.controller('WorkflowController', function ($scope, $http, $sce, $element, $compile, $mdSidenav, NgTableParams) {

	$scope.showloading = false;
	$scope.workflow = false;
	$scope.startdate = null;
	$scope.deadline = null;
	$scope.workflowId = $("#hdnwid").val();
	$scope.lastSelectedProjectId = null;
	$scope.users = [];
	
	$scope.validations = {name: true , type: true, responsible: true, status: true, project: true,  };

	$scope.loadWorkflow = function(){
		
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
			$scope.lastSelectedProjectId = $scope.workflow.projectid;
			
			delete $scope.workflow.created;
			delete $scope.workflow.updated;
			delete $scope.workflow.reporterUser;
			delete $scope.workflow.responsibleUser;


		}, function errorCallback(response){ 
			$scope.$parent.showloading = false;		
			
		});		
		
	}

	$scope.save = function(){
		
		$http({
			method: "POST",
			url: "/workflow/data/workflow/save", 
			timeout: 10000,
			data: $scope.workflow,
			headers: {
				'Content-Type': 'application/json'
			}
		}).then(function(response){
		  
			window.location = "/workflow/view/" + response.data.id;
			

		}, function errorCallback(response){ 
			
			alert(response.data);
			$scope.$parent.showloading = false;		
			
		});		
		
	}
	
	$scope.validate = function(){
		
		var valid = true;
		if(!$scope.workflow){
			return true;
		}
		
		$scope.test = new Date() + " : " + JSON.stringify($scope.workflow);
		
		$scope.validations.project = true;
		if($scope.workflow.projectid < 1){
			valid = false;
			$scope.validations.project = false;
		}
		
		$scope.validations.name = true;
		if($scope.workflow.name == undefined || $scope.workflow.name.length < 3){
			valid = false;
			$scope.validations.name = false;
		}
		
		$scope.validations.type = true;
		if($scope.workflow.type == undefined || $scope.workflow.type == 0){
			valid = false;
			$scope.validations.type = false;
		}
		
		$scope.validations.responsible = true;
		if($scope.workflow.responsible == undefined || $scope.workflow.responsible == 0){
			valid = false;
			$scope.validations.responsible = false;
		}
		
		$scope.validations.status = true;
		if($scope.workflow.status == undefined || $scope.workflow.status < 0){
			valid = false;
			$scope.validations.status = false;
		}
		
		if($scope.lastSelectedProjectId !== $scope.workflow.projectid){
			$scope.lastSelectedProjectId = $scope.workflow.projectid;
			
			$http({
				method: "GET",
				url: "/workflow/data/user/list/" + $scope.workflow.projectid, 
				timeout: 10000				
			}).then(function(response){
			  
				$scope.users = response.data;

			}, function errorCallback(response){ 
				$scope.$parent.showloading = false;		
				
			});		
						
		}
		
		return valid;
	}

	$scope.loadWorkflow();
	
});

