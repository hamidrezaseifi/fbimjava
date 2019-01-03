

fbimApp.controller('WorkflowController', function ($scope, $http, $sce, $element, $compile, $mdSidenav, NgTableParams) {

	$scope.showloading = false;
	$scope.workflow = false;
	$scope.startdate = null;
	$scope.deadline = null;
	$scope.workflowId = $("#hdnwid").val();
	$scope.showTaskEdit = "hide";
	$scope.showTaskSelect = false;
	$scope.tasksColumns = tasksColumns;
	$scope.tableTasks = false;
	$scope.editingTask = false;
	$scope.allTasks = [];
	$scope.taskStatusList = taskStatusList;
	$scope.allProjectUsers = allUsers;

	for(o in $scope.tasksColumns){
		$scope.tasksColumns[o].show = true;
		
		
		if($scope.tasksColumns[o].field == "action"){
			$scope.tasksColumns[o].renderValue = renderUsersActions;
		}
		else{
			if($scope.tasksColumns[o].field == "subtask"){
				$scope.tasksColumns[o].renderValue = renderSubTasklist;
			}
			else{
				$scope.tasksColumns[o].renderValue = renderData;
			}			
		}			
		
	}

	function renderData($scope, row, index) {
		return row[this.field];
	}

	function renderSubTasklist($scope, row, index) {
		res = "";
		for(index in row.subTasks){
			var sub = row.subTasks[index]; 
			res += "<div >" + sub.title + " (" + sub.progress + "%)" +"</div>";
		}
		
		return res;
	}

	$scope.validations = {name: true , type: true, responsible: true, status: true };

	$scope.toggleTaskSelect = function(show){
		$scope.showTaskSelect = show;
	}

	$scope.toggleTaskEdit = function(show, task){
		$scope.showTaskEdit = show;
		
		task = task !== undefined ? task : false;

		if(task){
			$scope.editingTask = angular.copy(task);
			$scope.editingTask.status = $scope.editingTask.status + "";
			$scope.editingTask.assignedTo = $scope.editingTask.assignedTo + "";
			$scope.editingTask.startDate = new Date($scope.editingTask.startDate);			
			$scope.editingTask.deadline = moment($scope.editingTask.deadline).isValid() ? new Date($scope.editingTask.deadline) : null;			
		}
		else{
			$scope.editingTask = {
					id: 0, 
					projectid: $scope.workflow.projectid, 
					name: "", 
					comments: "", 
					startDate: new Date(), 
					deadline: null, 
					version: 1, 
					status: "1", 
					reporter: 0, 
					assignedTo: "0", 
				};		
			
		}

	}
	
	function loadWorkflow(){
		
		$http({
			method: "GET",
			url: "/workflow/data/workflow/read/" + $scope.workflowId, 
			timeout: 10000				
		}).then(function(response){
		  
			$scope.workflow = response.data;
			$scope.workflow.type = $scope.workflow.type + "";
			$scope.workflow.status = $scope.workflow.status + "";
			$scope.workflow.responsible = $scope.workflow.responsible + "";
			
			delete $scope.workflow.created;
			delete $scope.workflow.updated;
			delete $scope.workflow.reporterUser;
			delete $scope.workflow.responsibleUser;

			createTaskTable();
			
			loadAllTasks();

		}, function errorCallback(response){ 
			$scope.$parent.showloading = false;		
			
		});		
		
	}

	
	$scope.addTask = function(row){
		
		$http({
			method: "GET",
			url: "/workflow/data/workflow/task/add/" + $scope.workflowId + "/" + row.id, 
			timeout: 10000				
		}).then(function(response){
		  
			loadWorkflow();
			
			$scope.toggleTaskSelect(false);

		}, function errorCallback(response){ 
			$scope.$parent.showloading = false;		
			
		});		
	}
	
	$scope.deleteWorkflowTask = function(row){
		
		$http({
			method: "GET",
			url: "/workflow/data/workflow/task/delete/" + $scope.workflowId + "/" + row.id, 
			timeout: 10000				
		}).then(function(response){
		  
			loadWorkflow();

		}, function errorCallback(response){ 
			$scope.$parent.showloading = false;		
			
		});		
	}

	function loadAllTasks(){
		
		
		$http({
			method: "GET",
			url: "/workflow/data/task/list/" + $scope.workflow.projectid, 
			timeout: 10000				
		}).then(function(response){
		  
			$scope.allTasks = response.data;

		}, function errorCallback(response){ 
			$scope.$parent.showloading = false;		
			
		});		
		
	}
	
	$scope.notInWorkflowTasks = function(){
		return $scope.allTasks ? $scope.allTasks.filter(function(t) { return !isTaskIdInWorkflow(t.id); }) : [];
	}
	
	function isTaskIdInWorkflow(id){
		return $scope.workflow && $scope.workflow.tasks ? $scope.workflow.tasks.filter(function(t) { return t.id === id; }).length > 0 : false;
	}


	$scope.addWorkflowTask = function(){
		if(!$scope.editingTask){
			return;
		}
		
		var editTask = {
			id: 0, 
			projectid: $scope.workflow.projectid,  
			name: $scope.editingTask.name, 
			comments: $scope.editingTask.comments, 
			startDate: moment($scope.editingTask.startDate).format("YYYY-MM-DD"), 
			deadline: $scope.editingTask.deadline !== null ? moment($scope.editingTask.deadline).format("YYYY-MM-DD") : "", 
			status: $scope.editingTask.status, 
			reporter: 0, 
			assignedTo: $scope.editingTask.assignedTo, 
		};
		
		$http({
			method: "POST",
			url: "/workflow/data/task/create/" + $scope.workflowId, 
			timeout: 10000,
			data: editTask,
			headers: {
				'Content-Type': 'application/json'
			}
		}).then(function(response){
		  
			$scope.toggleTaskEdit('hide');
			$scope.toggleTaskSelect(false);
			
			loadWorkflow();

		}, function errorCallback(response){ 
			$scope.$parent.showloading = false;		
			
		});		
		
	}	

	$scope.saveTask = function(){
		if(!$scope.editingTask){
			return;
		}
		
		if($scope.showTaskEdit === "new"){
			$scope.addWorkflowTask();
			return;
		}
		
		var editTask = {
			id: $scope.editingTask.id, 
			projectid: $scope.workflow.projectid,  
			name: $scope.editingTask.name, 
			comments: $scope.editingTask.comments, 
			startDate: moment($scope.editingTask.startDate).format("YYYY-MM-DD"), 
			deadline: $scope.editingTask.deadline !== null ? moment($scope.editingTask.deadline).format("YYYY-MM-DD") : "", 
			status: $scope.editingTask.status, 
			reporter: $scope.editingTask.reporter, 
			assignedTo: $scope.editingTask.assignedTo, 
			version: $scope.editingTask.version, 
		};
		
		$http({
			method: "POST",
			url: "/workflow/data/task/update", 
			timeout: 10000,
			data: editTask,
			headers: {
				'Content-Type': 'application/json'
			}
		}).then(function(response){
		  
			$scope.toggleTaskEdit('hide');
			$scope.toggleTaskSelect(false);
			
			loadWorkflow();

		}, function errorCallback(response){ 
			$scope.$parent.showloading = false;		
			
		});		
		
	}
	
	$scope.isTaskValid = function(){
		
		var isValid = true;
		
		if(!$scope.editingTask){
			return;
		}
		
		if($scope.editingTask.name == undefined || $scope.editingTask.name.length < 3){
			isValid = false;
		}
		
		if($scope.editingTask.startDate == undefined || $scope.editingTask.startDate == null){
			isValid = false;
		}
		
		if($scope.editingTask.deadline == undefined || $scope.editingTask.deadline == null){
			isValid = false;
		}
			
		return isValid;
	}	

	function createTaskTable(){

		var initialParams = {
		        count: $scope.workflow.tasks.length,
		        sorting: { name: "asc"}
		      };
		
		var initialSettings = {
		        // page size buttons (right set of buttons in demo)
		        counts: [],
		        // determines the pager buttons (left set of buttons in demo)
		        paginationMaxBlocks: 13,
		        paginationMinBlocks: 2,
		        dataset: $scope.workflow.tasks
		      };		
		$scope.tableTasks = new NgTableParams(initialParams, initialSettings);
		 
	}

	loadWorkflow();
	
});

