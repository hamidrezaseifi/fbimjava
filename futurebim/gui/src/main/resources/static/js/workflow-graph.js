

fbimApp.controller('WorkflowGraphController', function ($scope, $http, $sce, $element, $compile, $mdSidenav, NgTableParams) {

	$scope.showloading = false;
	$scope.workflow = {};
	$scope.workflowList = [];
	$scope.workflowId = "1";
	$scope.projectId = "1";
	$scope.lineDays = "5";
	$scope.newchanges = false;

	$scope.timelineContainer = $(".timeline-container-inner");
	
	$scope.loadTimeline = function(){
		$scope.timelineContainer.html("");
		
		var totalDays = $scope.workflow.totalDays;
		if($scope.workflow.tasks == undefined || $scope.workflow.tasks.length == 0){
			return;
		}
		
		//--------------------------------------
		var line_days = new Number($scope.lineDays);
		//--------------------------------------		
				
		var margin = 20;
		var line_width = 30;
		
		var taskContainerHeight = 40;
		var showTasks = $scope.workflow.tasks.length;
		var lastTop = 0;
		for(var i=0; i< $scope.workflow.tasks.length; i++){
			var task = $scope.workflow.tasks[i];

			if(!task.showInGraph){
				showTasks --;
			}
		}
		
		lastTop = showTasks * (taskContainerHeight + 5) + 50;
		
		var container_height = $scope.timelineContainer.height();
		
		var vLine = ""; 
		var lineHeight = 0;

		vLine = $("<div class='horizontal-line'></div>").appendTo($scope.timelineContainer);
		vLine.css("top", 46);
		vLine.css("width", container_width);
		
		var workflowStartDate = moment($scope.workflow.startDate);
		var endDate = moment($scope.workflow.deadline);
		endDate = endDate.add(1, 'months').subtract(1, 'days');

		var startDate = moment([workflowStartDate.year(), workflowStartDate.month(), 1]);
		var curDate = moment([workflowStartDate.year(), workflowStartDate.month(), 1]);
		
		var lastYear = "";
		var lastMonth = "";
		var vline_count = 0;
		while(curDate.isSameOrBefore(endDate)){
			vLine = $("<div class='vertical-line'></div>").appendTo($scope.timelineContainer);
			vLine.css("left", vline_count * line_width + 20);
			vLine.css("top", 46);
			vLine.css("height", lastTop);
			lineHeight = vLine.height();
			
			vLine = $("<div class='line-date-text'>" + curDate.format("DD") + "</div>").appendTo($scope.timelineContainer);
			vLine.css("left", vline_count * line_width + 13);
			vLine.css("top", 32);

			if(lastMonth != curDate.format("MMM")){
				vLine = $("<div class='line-date-text'>" + curDate.format("MMM") + "</div>").appendTo($scope.timelineContainer);
				vLine.css("left", vline_count * line_width + 10);
				vLine.css("top", 16);
				lastMonth = curDate.format("MMM");
			}


			if(lastYear != curDate.format("YYYY")){
				vLine = $("<div class='line-date-text'>" + curDate.format("YYYY") + "</div>").appendTo($scope.timelineContainer);
				vLine.css("left", vline_count * line_width + 10);
				vLine.css("top", 0);
				lastYear = curDate.format("YYYY");
			}

			curDate = curDate.add(line_days, 'days');
			vline_count++;
		}
		
		var container_width = (vline_count * 30) + (margin * 2);
		$scope.timelineContainer.css("width", container_width);

		var taskHeight = taskContainerHeight - 4;
		var index = 0;
		for(var i=0; i< $scope.workflow.tasks.length; i++){
			var task = $scope.workflow.tasks[i];

			if(!task.showInGraph){
				continue;
			}

			var taskContainer = $("<div class='task-line-container'></div>").appendTo($scope.timelineContainer);
			taskContainer.css("top", index * (taskContainerHeight + 5) + 46);
			taskContainer.css("width", container_width);
			taskContainer.css("height", taskContainerHeight);

			var taskStart = moment(task.startDate);
			var taskEnd = moment(task.deadline);
			var taskDurection = taskEnd.diff(taskStart, 'days');
			var taskWidth = taskDurection * line_width / line_days;
			var taskStartUntilGraphStart = taskStart.diff(startDate, 'days');
			var taskLeft = (line_width * taskStartUntilGraphStart) / line_days;

			var taskItem = $("<div class='task-line-item task-line-item" + task.id + "' data-taskid='" + task.id + "'><div class='taskname'>" + task.name + "</div></div>").appendTo($scope.timelineContainer);
			taskItem.css("top", index * (taskContainerHeight + 5) + 46 + 2);
			taskItem.css("left", taskLeft + margin);
			taskItem.css("width", taskWidth);
			taskItem.css("height", taskHeight);
			taskItem.css("line-height", taskHeight + "px");
			
			if(task.editable){
				$("<i class='material-icons'>edit</i>").appendTo(taskItem);
			}
						
			//taskItem.resizable({ animate: true, containment: taskContainer, ghost: true, handles: "e", });
			//taskItem.draggable({ axis: "x", cursor: "crosshair", stop: function() {}, });
			$scope.test = JSON.stringify(task);
			index ++;
		}
		
		var now = moment();
		if(now.isBetween(startDate, endDate)){
			
			var todayUntilGraphStart = now.diff(startDate, 'days');
			var left = (line_width * todayUntilGraphStart) / line_days;
			
			vLine = $("<div class='today-vertical-line'></div>").appendTo($scope.timelineContainer);
			vLine.css("left", left + margin);
			vLine.css("top", 0);
			vLine.css("height", lastTop + 50);			
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
			
			for(o in $scope.workflow.tasks){
				$scope.workflow.tasks[o].showInGraph = true;
			}
			
			delete $scope.workflow.created;
			delete $scope.workflow.updated;
			delete $scope.workflow.reporterUser;
			delete $scope.workflow.responsibleUser;
			$scope.test = new Date() + " : " + JSON.stringify($scope.workflow);
			$scope.loadTimeline();
			
			$scope.newchanges = false;
			
			//checkNewWorkflowChanges();
			
		}, function errorCallback(response){ 
			$scope.$parent.showloading = false;		
			
		});		
		
	}

	function checkNewWorkflowChanges(){
		var data = {workflowId : $scope.workflowId, taskList: []};
		for(var i=0; i< $scope.workflow.tasks.length; i++){
			var t = {id: $scope.workflow.tasks[i].id, value: $scope.workflow.tasks[i].version};
			
			data.taskList.push(t);

		}
		
		alert(JSON.stringify(data));
		//return;
		$http({
			method: "POST",
			url: "/workflow/data/changecheck/" + $scope.workflowId, 
			timeout: 100000,
			data: data,
			headers: {
				'Content-Type': 'application/json'
			}
		}).then(function(response){
			alert("res: " + response.data);	
			

		}, function errorCallback(response){
			
			
			
			alert("error: " + response.data.error);	
			
		});	
	}
	
	
	$scope.loadWorkflowList();
	
	
});

