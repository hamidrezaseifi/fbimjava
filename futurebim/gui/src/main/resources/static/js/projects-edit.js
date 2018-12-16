

fbimApp.controller('ProjectController', function ($scope, $http, $sce, $element, $compile, $mdSidenav, NgTableParams) {

	$scope.showloading = false;
	$scope.project = false;
	$scope.startdate = null;
	$scope.deadline = null;
	$scope.projectId = $("#hdnpid").val();
	
	$scope.validations = {projectName: true , projectType: true, startDate: true, deadline: true, status: true };

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


		}, function errorCallback(response){ 
			$scope.$parent.showloading = false;		
			
		});		
		
	}

	$scope.save = function(){
		
		$http({
			method: "POST",
			url: "/projects/data/project/save", 
			timeout: 10000,
			data: $scope.project,
			headers: {
				'Content-Type': 'application/json'
			}
		}).then(function(response){
		  
			window.location = "/projects";
			

		}, function errorCallback(response){ 
			
			alert(response.data);
			$scope.$parent.showloading = false;		
			
		});		
		
	}
	
	$scope.validate = function(){
		
		var valid = true;
		if(!$scope.project){
			return true;
		}
		
		$scope.project.startDate = moment($scope.startdate).format('YYYY-MM-DD');
		$scope.project.deadline = $scope.deadline == null ? null : moment($scope.deadline).format('YYYY-MM-DD');
		$scope.test = new Date() + " : " + JSON.stringify($scope.project);
		
		$scope.validations.projectName = true;
		if($scope.project.projectName == undefined || $scope.project.projectName.length < 3){
			valid = false;
			$scope.validations.projectName = false;
		}
		
		$scope.validations.projectType = true;
		if($scope.project.projectType == undefined || $scope.project.projectType == 0){
			valid = false;
			$scope.validations.projectType = false;
		}
		
		$scope.validations.status = true;
		if($scope.project.status == undefined || $scope.project.status == 0){
			valid = false;
			$scope.validations.status = false;
		}
		
		$scope.validations.startDate = true;
		if($scope.project.startDate == undefined || $scope.project.startDate == null){
			valid = false;
			$scope.validations.startDate = false;
		}
		
		$scope.validations.deadline = true;
		if(moment($scope.startdate).isAfter(moment($scope.deadline))){
			valid = false;
			$scope.validations.deadline = false;
		}
		
		return valid;
	}

	$scope.loadProject();
	
});

