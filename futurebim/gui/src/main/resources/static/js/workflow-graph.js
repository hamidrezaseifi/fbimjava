

fbimApp.controller('WorkflowGraphController', function ($scope, $http, $sce, $element, $compile, $mdSidenav, NgTableParams) {

	$scope.showloading = false;
	$scope.workflow = {};
	$scope.workflowList = [];
	$scope.workflowId = "1";
	$scope.projectId = "1";

	$scope.timelineContainer = $(".timeline-container");
	
	$scope.loadTimeline = function(){
		$scope.timelineContainer.html("");
		
		var totalDays = $scope.workflow.totalDays;
		if($scope.workflow.tasks == undefined || $scope.workflow.tasks.length == 0){
			return;
		}
		
		var w = $scope.timelineContainer.width() - 40;
		var vline_count = totalDays / 20;
		var vline_width = w / vline_count;
		var vLines = ""; 
		for(var i=0; i<= vline_count; i++){
			var vLine = $("<div class='vertical-line'></div>").appendTo($scope.timelineContainer);
			vLine.css("left", i * vline_width + 20);
		}
		
		var startDate = moment($scope.workflow.startDate);
		var curDate = moment($scope.workflow.startDate);
		var startDay = moment($scope.workflow.startDate).date() + 0;
		var dayDiff = Math.floor(totalDays / (vline_count - 1));
		var lastYear = "";
		for(var i=0; i<= vline_count; i++){
			var vLine = $("<div class='line-date-text'>" + curDate.format("MMM DD") + "</div>").appendTo($scope.timelineContainer);
			vLine.css("left", (i * vline_width) + 15);

			if(lastYear != curDate.format("YYYY")){
				//vLine = $("<div class='line-date-text line-year-text'>" + curDate.format("YYYY") + "</div>").appendTo($scope.timelineContainer);
				//vLine.css("left", (i * vline_width) + 0);
				lastYear = curDate.format("YYYY");
			}

			curDate = curDate.add(dayDiff, 'days');
		}

		for(var i=0; i< $scope.workflow.tasks.length; i++){
			var task = $scope.workflow.tasks[i];

			var vLine = $("<div class='task-line-container'></div>").appendTo($scope.timelineContainer);
			vLine.css("top", i * 35 + 30);
			//task.startDate + ", " + task.deadline
			var taskStart = moment(task.startDate);
			var taskEnd = moment(task.deadline);
			var taskDurection = taskEnd.diff(taskStart, 'days', true);
			var taskWidth = (vline_width * taskDurection) / dayDiff;
			var taskStartUntilWorkflowStart = taskStart.diff(startDate, 'days', true);
			var taskLeft = (vline_width * taskStartUntilWorkflowStart) / dayDiff;

			vLine = $("<div class='task-line-item'>" + task.name + ", " + taskStartUntilWorkflowStart + ", " + taskDurection + ", " + task.startDate + " , " + task.deadline + "</div>").appendTo($scope.timelineContainer);
			vLine.css("top", i * 35 + 2 + 30);
			vLine.css("left", taskLeft + 20);
			vLine.css("width", taskWidth);
			
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

