

fbimApp.controller('ProjectController', function ($scope, $http, $sce, $element, $compile, $mdSidenav, NgTableParams) {

	$scope.showloading = false;
	$scope.project = false;
	$scope.projectId = $("#hdnpid").val();
	$scope.usersColumns = usersColumns;
	$scope.tableUsers = false;
	$scope.users = false;
	$scope.showUserSelect = false;
	
	for(o in $scope.usersColumns){
		$scope.usersColumns[o].show = true;
		
		
		if($scope.usersColumns[o].field == "action"){
			$scope.usersColumns[o].renderValue = renderUsersActions;
		}
		else{
			$scope.usersColumns[o].renderValue = renderData;
		}			
		
	}
	
	function renderData($scope, row, index) {
		return row[this.field];
	}
	
	function renderUsersActions($scope, row, index) {
		var actions = '<a class="toolbar-item" href="/projects/puser/update/' + row['projectId'] + '/' + row['userId'] + '"><i class="material-icons">edit</i></a>';
		actions += '<a class="toolbar-item" href="/projects/puser/delete/' + row['projectId'] + '/' + row['userId'] + '"><i class="material-icons">delete</i></a>';
		
		return actions;
	}

	$scope.toggleUserSelect = function(ev, showSelect){
		var button = $(ev.target).parent();
		//alert(button.position().top);
		$("#user-select-panel").css("top" , button.position().top - 20);
		//$("#user-select-panel").css("left" , button.position().left - 300);
		$scope.showUserSelect = showSelect;
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
	
	$scope.notInProjectUsers = function(){
		return $scope.users ? $scope.users.filter(function(u) { return !isUserIdInProject(u.id); }) : [];
	}
	
	function isUserIdInProject(id){
		return $scope.project && $scope.project.users ? $scope.project.users.filter(function(u) { return u.userId === id; }).length > 0 : false;
	}

	function createUsersTable(){

		var initialParams = {
		        count: $scope.project.users.length // initial page size
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
	
	$scope.loadProject();
	
});

