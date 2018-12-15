

fbimApp.controller('ProjectController', function ($scope, $http, $sce, $element, $compile, $mdSidenav, NgTableParams) {

	$scope.showloading = false;
	$scope.company = false;
	$scope.projectlist = false;
	$scope.tableParams = false;
	$scope.columns = columns;
	$scope.projectTypes = projectTypes;
	
	for(o in $scope.columns){
		$scope.columns[o].show = true;
		
		if($scope.columns[o].field == "index"){
			$scope.columns[o].renderValue = renderFixedValue;
		}
		else{
			if($scope.columns[o].field == "action"){
				$scope.columns[o].renderValue = renderActions;
			}
			else{
				$scope.columns[o].renderValue = renderData;
			}			
		}
	}
		
	$scope.getProjectTypeName = function(typeId){
		
		for(o in $scope.projectTypes){
			if($scope.projectTypes[0].type == typeId){
				return $scope.projectTypes[0].name;
			}
		}
		return "";
	}

	$scope.loadProjects = function(){
		
		$http({
			method: "GET",
			url: "/projects/data/projectlist", 
			timeout: 10000				
		}).then(function(response){
		  
			$scope.company = response.data.company;
			$scope.projectlist = prepareListData(response.data.projects);
			
			createTable();
			
		  //$scope.$parent.showloading = false;
			
		}, function errorCallback(response){ 
			$scope.$parent.showloading = false;		
			
		});		
		
	}

	function prepareListData(dataList){
		
		var list = [];
		
		for(var i=0; i< 30; i++){
			for(index in dataList){
				list.push(angular.copy(dataList[index]));
			}
			//list = list.concat(dataList);
		}
		
		return list;
	}
	
	function renderData($scope, row, index) {
		return row[this.field];
	}

	function renderFixedValue($scope, row, data) {
		return data;
	}
	
	function renderActions($scope, row, index) {
		return "";
	}
	
	function createTable(){
		
		var initialParams = {
		        count: 15 // initial page size
		      };
		
		var initialSettings = {
		        // page size buttons (right set of buttons in demo)
		        counts: [15, 30, 50, 100, ],
		        // determines the pager buttons (left set of buttons in demo)
		        paginationMaxBlocks: 13,
		        paginationMinBlocks: 2,
		        dataset: $scope.projectlist
		      };
		
		$scope.tableParams = new NgTableParams(initialParams, initialSettings);
		 
	}
	
	$scope.loadProjects();
	
});

