

fbimApp.controller('ProjectController', function ($scope, $http, $sce, $element, $compile, $mdSidenav, NgTableParams) {

	$scope.showloading = false;
	$scope.workflow = false;
	$scope.workflowId = $("#hdnwid").val();

	$scope.timelineContainer = $(".timeline-container");
	
	$scope.timelineContainer.html("");
	var w = $scope.timelineContainer.width();
	var vline_count = 30;
	var vline_width = w / vline_count;
	var vLines = ""; 
	for(var i=1; i< vline_count; i++){
		var vLine = $("<div class='vertical-line'></div>").appendTo($scope.timelineContainer);
		vLine.css("left", i * vline_width);
	}
	
	
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
			
			delete $scope.workflow.created;
			delete $scope.workflow.updated;
			delete $scope.workflow.reporterUser;
			delete $scope.workflow.responsibleUser;

		}, function errorCallback(response){ 
			$scope.$parent.showloading = false;		
			
		});		
		
	}

	
	
	$scope.loadWorkflow();
	
	
});

