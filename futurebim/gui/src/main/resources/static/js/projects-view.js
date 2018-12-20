
fbimApp.controller('ProjectController', function ($scope, $http, $sce, $element, $compile, $mdSidenav, NgTableParams) {

	$scope.showloading = false;
	$scope.project = false;
	$scope.projectId = $("#hdnpid").val();
	$scope.usersColumns = usersColumns;
	$scope.tableUsers = false;
	$scope.allUsers = false;
	$scope.showUserSelect = false;
	$scope.showUserEdit = false;
	$scope.editingProjectUser = false;
	$scope.projectRoles = false;
	$scope.accessTypes = false;
	$scope.projectRoles = projectRoles;
	$scope.accessTypes = accessTypes;
	$scope.taskStatusList = taskStatusList;
	$scope.tasksColumns = tasksColumns;
	$scope.tableTasks = false;
	$scope.editingProjectTask = false;
	$scope.showTaskEdit = "hide";
	
	for(o in $scope.usersColumns){
		$scope.usersColumns[o].show = true;
		
		
		if($scope.usersColumns[o].field == "action"){
			$scope.usersColumns[o].renderValue = renderUsersActions;
		}
		else{
			$scope.usersColumns[o].renderValue = renderData;
		}			
		
	}
	
	for(o in $scope.tasksColumns){
		$scope.tasksColumns[o].show = true;
		
		
		if($scope.tasksColumns[o].field == "action"){
			$scope.tasksColumns[o].renderValue = renderUsersActions;
		}
		else{
			$scope.tasksColumns[o].renderValue = renderData;
		}			
		
	}
	
	function renderData($scope, row, index) {
		return row[this.field];
	}
	
	function renderUsersActions($scope, row, index) {
		var actions = '<a class="toolbar-item user-toolbar-item-edit" userid="' + row['userId'] + '"><i class="material-icons">edit</i></a>';
		actions += '<a class="toolbar-item user-toolbar-item-delete" userid="' + row['userId'] + '"><i class="material-icons">delete</i></a>';
		
		return actions;
	}

	$scope.toggleUserSelect = function(showSelect){
		$scope.showUserSelect = showSelect;
	}

	$scope.toggleUserEdit = function(showSelect, projectUser){
		$scope.showUserEdit = showSelect;
		
		projectUser = projectUser !== undefined ? projectUser : false;
		
		$scope.editingProjectUser = angular.copy(projectUser);
		
		if(projectUser){
			$scope.editingProjectUser.roleId = $scope.editingProjectUser.roleId + "";
			$scope.editingProjectUser.accessType = $scope.editingProjectUser.accessType + "";			
		}
		
	}

	$scope.toggleTaskEdit = function(showSelect, task){
		$scope.showTaskEdit = showSelect;
		
		task = task !== undefined ? task : false;
		
		$scope.editingProjectTask = angular.copy(task);
		
		if(task){
			$scope.editingProjectTask.status = $scope.editingProjectTask.status + "";
			$scope.editingProjectTask.assignedTo = $scope.editingProjectTask.assignedTo + "";
			$scope.editingProjectTask.startDate = new Date($scope.editingProjectTask.startDate);			
			$scope.editingProjectTask.deadline = moment($scope.editingProjectTask.deadline).isValid() ? new Date($scope.editingProjectTask.deadline) : null;			
		}
		else{
			$scope.editingProjectTask = {
					id: 0, 
					projectId: $scope.projectId, 
					name: "", 
					comments: "", 
					startDate: new Date(), 
					deadline: null, 
					version: 1, 
					status: "1", 
					reporter: 0, 
					assignedTo: 0, 
				};
		}
		
	}
	
	$scope.loadProject = function(){
		
		$http({
			method: "GET",
			url: "/projects/data/project/read/" + $scope.projectId, 
			timeout: 10000				
		}).then(function(response){
		  
			$scope.project = response.data;
			$scope.project.projectType = $scope.project.projectType + "";
			$scope.project.status = $scope.project.status + "";
			$scope.startdate = new Date($scope.project.startDate);
			$scope.deadline = $scope.project.deadline == null ? null : new Date($scope.project.deadline);
			
			delete $scope.project.created;
			delete $scope.project.updated;
			
			$scope.loadUsers();
			
			createUsersTable();
			createTaskTable();


		}, function errorCallback(response){ 
			$scope.$parent.showloading = false;		
			
		});		
		
	}

	$scope.loadUsers = function(){
		
		$http({
			method: "GET",
			url: "/projects/data/users/all/", 
			timeout: 10000				
		}).then(function(response){
		  
			$scope.allUsers = response.data;
			$scope.test = new Date() + " : " + JSON.stringify($scope.allUsers);

		}, function errorCallback(response){ 
			$scope.$parent.showloading = false;		
			
		});		
		
	}

	$scope.addUser = function(id){
		
		$http({
			method: "GET",
			url: "/projects/data/user/add/" + $scope.projectId + "/" + id, 
			timeout: 10000				
		}).then(function(response){
		  
			$scope.toggleUserSelect(false);
			
			$scope.loadProject();

		}, function errorCallback(response){ 
			$scope.$parent.showloading = false;		
			
		});		
		
	}

	$scope.deleteProjectUser = function(id){
		
		$http({
			method: "GET",
			url: "/projects/data/user/delete/" + $scope.projectId + "/" + id, 
			timeout: 10000				
		}).then(function(response){
		  			
			$scope.loadProject();

		}, function errorCallback(response){ 
			$scope.$parent.showloading = false;		
			
		});		
		
	}

	$scope.editProjectUser = function(){
		if(!$scope.editingProjectUser){
			return;
		}
		
		var editUser = {
			projectId: $scope.editingProjectUser.projectId, 
			userId: $scope.editingProjectUser.userId, 
			roleId: $scope.editingProjectUser.roleId, 
			accessType: $scope.editingProjectUser.accessType, 
		};
		
		$http({
			method: "POST",
			url: "/projects/data/user/update", 
			timeout: 10000,
			data: editUser,
			headers: {
				'Content-Type': 'application/json'
			}
		}).then(function(response){
		  
			$scope.toggleUserEdit(false);
			
			$scope.loadProject();

		}, function errorCallback(response){ 
			$scope.$parent.showloading = false;		
			
		});		
		
	}
	
	$scope.userSortBy = function(column, ev){
		$scope.tableUsers.sorting(column.sortable, column.direction);
		column.direction = column.direction == "asc" ? "desc" : "asc";
	}
	
	$scope.taskSortBy = function(column, ev){
		$scope.tableTasks.sorting(column.sortable, column.direction);
		column.direction = column.direction == "asc" ? "desc" : "asc";
	}
	
	$scope.notInProjectUsers = function(){
		return $scope.allUsers ? $scope.allUsers.filter(function(u) { return !isUserIdInProject(u.id); }) : [];
	}
	
	function isUserIdInProject(id){
		return $scope.project && $scope.project.users ? $scope.project.users.filter(function(u) { return u.userId === id; }).length > 0 : false;
	}

	$scope.addProjectTask = function(){
		if(!$scope.editingProjectTask){
			return;
		}
		
		var editTask = {
			id: 0, 
			projectid: $scope.projectId, 
			name: $scope.editingProjectTask.name, 
			comments: $scope.editingProjectTask.comments, 
			startDate: moment($scope.editingProjectTask.startDate).format("YYYY-MM-DD"), 
			deadline: $scope.editingProjectTask.deadline !== null ? moment($scope.editingProjectTask.deadline).format("YYYY-MM-DD") : "", 
			status: $scope.editingProjectTask.status, 
			reporter: 0, 
			assignedTo: $scope.editingProjectTask.assignedTo, 
		};
		
		$http({
			method: "POST",
			url: "/projects/data/task/add", 
			timeout: 10000,
			data: editTask,
			headers: {
				'Content-Type': 'application/json'
			}
		}).then(function(response){
		  
			$scope.toggleTaskEdit('hide');
			
			$scope.loadProject();

		}, function errorCallback(response){ 
			$scope.$parent.showloading = false;		
			
		});		
		
	}	

	$scope.editProjectTask = function(){
		if(!$scope.editingProjectTask){
			return;
		}
		
		if($scope.showTaskEdit === "new"){
			$scope.addProjectTask();
			return;
		}
		
		var editTask = {
			id: $scope.editingProjectTask.id, 
			projectid: $scope.projectId, 
			name: $scope.editingProjectTask.name, 
			comments: $scope.editingProjectTask.comments, 
			startDate: moment($scope.editingProjectTask.startDate).format("YYYY-MM-DD"), 
			deadline: $scope.editingProjectTask.deadline !== null ? moment($scope.editingProjectTask.deadline).format("YYYY-MM-DD") : "", 
			status: $scope.editingProjectTask.status, 
			reporter: $scope.editingProjectTask.reporter, 
			assignedTo: $scope.editingProjectTask.assignedTo, 
			version: $scope.editingProjectTask.version, 
		};
		
		$http({
			method: "POST",
			url: "/projects/data/task/update", 
			timeout: 10000,
			data: editTask,
			headers: {
				'Content-Type': 'application/json'
			}
		}).then(function(response){
		  
			$scope.toggleTaskEdit('hide');
			
			$scope.loadProject();

		}, function errorCallback(response){ 
			$scope.$parent.showloading = false;		
			
		});		
		
	}	

	$scope.deleteProjectTask = function(task){
		if(!task){
			return;
		}
		
		var editTask = {
			id: task.id, 
			projectid: task.projectid, 
			name: task.name, 
			comments: task.comments, 
			startDate: moment(task.startDate).format("YYYY-MM-DD"), 
			deadline: task.deadline !== null ? moment(task.deadline).format("YYYY-MM-DD") : "", 
			status: task.status, 
			reporter: task.reporter, 
			assignedTo: task.assignedTo, 
			version: task.version, 
		};
		
		$http({
			method: "POST",
			url: "/projects/data/task/delete", 
			timeout: 10000,
			data: editTask,
			headers: {
				'Content-Type': 'application/json'
			}
		}).then(function(response){
			
			$scope.loadProject();

		}, function errorCallback(response){ 
			$scope.$parent.showloading = false;		
			
		});		
		
	}	


	$scope.isTaskValid = function(){
		
		var isValid = true;
		
		if(!$scope.editingProjectTask){
			return;
		}
		
		if($scope.editingProjectTask.name == undefined || $scope.editingProjectTask.name.length < 3){
			isValid = false;
		}
		
		if($scope.editingProjectTask.startDate == undefined || $scope.editingProjectTask.startDate == null){
			isValid = false;
		}
		
		if($scope.editingProjectTask.deadline == undefined || $scope.editingProjectTask.deadline == null){
			isValid = false;
		}
			
		return isValid;
	}	

	
	function createUsersTable(){

		var initialParams = {
		        count: $scope.project.users.length,
		        sorting: { fullname: "asc"}
		      };
		
		var initialSettings = {
		        // page size buttons (right set of buttons in demo)
		        counts: [],
		        // determines the pager buttons (left set of buttons in demo)
		        paginationMaxBlocks: 13,
		        paginationMinBlocks: 2,
		        dataset: $scope.project.users
		      };		
		$scope.tableUsers = new NgTableParams(initialParams, initialSettings);
		 
	}

	function createTaskTable(){

		var initialParams = {
		        count: $scope.project.tasks.length,
		        sorting: { name: "asc"}
		      };
		
		var initialSettings = {
		        // page size buttons (right set of buttons in demo)
		        counts: [],
		        // determines the pager buttons (left set of buttons in demo)
		        paginationMaxBlocks: 13,
		        paginationMinBlocks: 2,
		        dataset: $scope.project.tasks
		      };		
		$scope.tableTasks = new NgTableParams(initialParams, initialSettings);
		 
	}
	
	$scope.loadProject();
	
});

