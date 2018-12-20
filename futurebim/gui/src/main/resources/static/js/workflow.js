

fbimApp.controller('WorkflowController', function ($scope, $http, $sce, $element, $compile, $mdSidenav, NgTableParams) {

	$scope.showloading = false;
	$scope.company = false;
	$scope.selectedProjectId = firstProjectId + "";
	$scope.workflowlist = false;
	$scope.tableParams = false;
	$scope.columns = columns;
	
	for(o in $scope.columns){
		$scope.columns[o].show = true;
		$scope.columns[o].headerClass = "test";
		
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
	

	$scope.loadWorkflows = function(){
		
		$http({
			method: "GET",
			url: "/workflow/data/list/" + $scope.selectedProjectId, 
			timeout: 10000				
		}).then(function(response){
		  
			$scope.workflowlist = prepareListData(response.data);
			
			createTable();
			
		  //$scope.$parent.showloading = false;
			
		}, function errorCallback(response){ 
			$scope.$parent.showloading = false;		
			
		});		
		
	}

	function prepareListData(dataList){
		
		var list = [];
		
		for(index in dataList){
			list.push(angular.copy(dataList[index]));
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
		var actions = '<a class="toolbar-item" href="/workflow/view/' + row['id'] + '"><i class="material-icons">pageview</i></a>';
		actions += '<a class="toolbar-item" href="/workflow/update/' + row['id'] + '"><i class="material-icons">edit</i></a>';
		actions += '<a class="toolbar-item" href="/workflow/delete/' + row['id'] + '"><i class="material-icons">delete</i></a>';
		
		return actions;
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
		        dataset: $scope.workflowlist
		      };
		
		$scope.tableParams = new NgTableParams(initialParams, initialSettings);
		 
	}
	
	$scope.loadWorkflows();
	
});

