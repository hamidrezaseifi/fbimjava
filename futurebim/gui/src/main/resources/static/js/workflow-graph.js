

fbimApp.controller('WorkflowGraphController', function ($scope, $http, $sce, $element, $compile, $mdSidenav, NgTableParams) {

	$scope.showloading = false;
	$scope.workflow = {};
	$scope.workflowList = [];
	$scope.workflowId = "0";
	$scope.projectId = "0";

	$scope.timelineContainer = $(".timeline-container");
	
	$scope.loadTimeline = function(){
		var totalDays = $scope.workflow.totalDays;
		
		$scope.timelineContainer.html("");
		var w = $scope.timelineContainer.width();
		var vline_count = 30;
		var vline_width = w / vline_count;
		var vLines = ""; 
		for(var i=1; i< vline_count; i++){
			var vLine = $("<div class='vertical-line'></div>").appendTo($scope.timelineContainer);
			vLine.css("left", i * vline_width);
		}
		
		var startDate = moment($scope.workflow.startDate);
		var curDate = startDate;
		var startDay = moment($scope.workflow.startDate).date() + 0;
		var dayDiff = Math.floor(totalDays / 30);
		var lastYear = "";
		for(var i=1; i< vline_count; i++){
			var vLine = $("<div class='line-date-text'>" + curDate.format("MMM DD") + "</div>").appendTo($scope.timelineContainer);
			vLine.css("left", (i * vline_width) - 20);

			if(lastYear != curDate.format("YYYY")){
				vLine = $("<div class='line-date-text line-year-text'>" + curDate.format("YYYY") + "</div>").appendTo($scope.timelineContainer);
				vLine.css("left", (i * vline_width) - 16);
				lastYear = curDate.format("YYYY");
			}

			curDate = curDate.add(dayDiff, 'days');
		}
	}
	
	$scope.loadWorkflowList = function(){
		
		$scope.workflowList = [];
		$scope.test = new Date() + " : " + JSON.stringify($scope.workflowList);
		if($scope.projectId == 0){
			return;
		}
		
		$http({
			method: "GET",
			url: "/workflow/data/list/" + $scope.projectId, 
			timeout: 10000				
		}).then(function(response){
		  
			$scope.workflowList = response.data;
			$scope.test = new Date() + " : " + JSON.stringify($scope.workflowList);
			$scope.loadWorkflow();

		}, function errorCallback(response){ 
			$scope.$parent.showloading = false;		
			
		});		
		
	}
	
	$scope.loadWorkflow = function(){
		
		$scope.workflow = {};
		$scope.test = new Date() + " : " + JSON.stringify($scope.workflow);
		if($scope.workflowId == 0){
			return;
		}
		$scope.test = new Date() + " : " + JSON.stringify($scope.workflow);
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
			$scope.test = new Date() + " : " + JSON.stringify($scope.workflow);
			$scope.loadTimeline();
			
		}, function errorCallback(response){ 
			$scope.$parent.showloading = false;		
			
		});		
		
	}

	
	
	$scope.loadWorkflowList();
	
	
});

