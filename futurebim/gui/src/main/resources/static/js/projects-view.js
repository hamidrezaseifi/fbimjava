
fbimApp.controller('ProjectController', function ($scope, $http, $sce, $element, $compile, $mdSidenav, NgTableParams) {

	$scope.showloading = false;
	$scope.project = false;
	$scope.projectId = $("#hdnpid").val();
	$scope.usersColumns = usersColumns;
	$scope.tableUsers = false;
	$scope.users = false;
	$scope.showUserSelect = false;
	$scope.showUserEdit = false;
	$scope.editingProjectUser = false;
	$scope.projectRoles = false;
	$scope.accessTypes = false;
	$scope.projectRoles = projectRoles;
	$scope.accessTypes = accessTypes;
	$scope.tasksColumns = tasksColumns;
	$scope.tableTasks = false;
	
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
		
		$scope.editingProjectUser = projectUser;
		
		if(projectUser){
			$scope.editingProjectUser.roleId = $scope.editingProjectUser.roleId + "";
			$scope.editingProjectUser.accessType = $scope.editingProjectUser.accessType + "";			
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
		  
			$scope.users = response.data;
			$scope.test = new Date() + " : " + JSON.stringify($scope.users);

		}, function errorCallback(response){ 
			$scope.$parent.showloading = false;		
			
		});		
		
	}

	$scope.addUser = function(id){
		
		$http({
			method: "GET",
			url: "/projects/data/adduser/" + $scope.projectId + "/" + id, 
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
			url: "/projects/data/deluser/" + $scope.projectId + "/" + id, 
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
			url: "/projects/data/edituser/", 
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
	
	$scope.pSortBy = function(column, ev){

		var val = $scope.tableUsers.sorting(column.sortable, column.direction);

		column.direction = column.direction == "asc" ? "desc" : "asc";

	}
	
	$scope.notInProjectUsers = function(){
		return $scope.users ? $scope.users.filter(function(u) { return !isUserIdInProject(u.id); }) : [];
	}
	
	function isUserIdInProject(id){
		return $scope.project && $scope.project.users ? $scope.project.users.filter(function(u) { return u.userId === id; }).length > 0 : false;
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

