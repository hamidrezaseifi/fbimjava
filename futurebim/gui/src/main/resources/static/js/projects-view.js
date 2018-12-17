

fbimApp.controller('ProjectController', function ($scope, $http, $sce, $element, $compile, $mdSidenav, NgTableParams) {

	$scope.showloading = false;
	$scope.project = false;
	$scope.projectId = $("#hdnpid").val();
	$scope.usersColumns = usersColumns;
	$scope.tableUsers = false;
	
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
			
			createUsersTable();
			$scope.test = new Date() + " : " + JSON.stringify($scope.project);


		}, function errorCallback(response){ 
			$scope.$parent.showloading = false;		
			
		});		
		
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

