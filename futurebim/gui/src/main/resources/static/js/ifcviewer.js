
var ifc_id = -1;

mdmApp.controller('IfcViewerController', function ($scope, $http, $sce, $element, $compile, $mdSidenav, $mdComponentRegistry) {

	$scope.showloading = false;
	$scope.isShowError = true;
	$scope.isShowMessage = false;

	$scope.ifcviewerProjectsContainerHeight = 0;
	$scope.ifcviewerProjectsContainerWidth = 0;
	
	$scope.projectsData = [];

	$scope.reloadProjects = function(){
		loadProjects();
	}
	
	
	setTimeout(function(){ 
		$scope.ifcviewerProjectsContainerHeight = $(".ifcviewer-projects-container").height(); 
		$scope.ifcviewerProjectsContainerWidth = $(".ifcviewer-projects-container").width(); 
		}, 500);
	
	$scope.toggleProjectTree = function($event){
		
		
		
		if($(".ifcviewer-projects-container").hasClass("pannel-close")){
			
		  $(".ifcviewer-projects-container").removeClass("pannel-close");  
		  
		  $(".ifcviewer-projects-container").animate({
			    height: $scope.ifcviewerProjectsContainerHeight,
			    width: $scope.ifcviewerProjectsContainerWidth
		  	}, 200, function() {
			  $("#project-tree").show();
			  
		  });			  
		}	
		else{
			
			$("#project-tree").hide();
			$(".ifcviewer-projects-container").animate({
			    height: 40,
			    width: 40
			  }, 200, function() {
				  if(!$(".ifcviewer-projects-container").hasClass("pannel-close")){
					  $(".ifcviewer-projects-container").addClass("pannel-close");  
				  }
				  
			  });
			
		}
		
	}
	
	
	loadProjects();

	function loadProjects(){
		
		$scope.$parent.showloading = true;
		
		$http({
			method: "GET",
			url: "data/projects/all", 
			timeout: 10000				
		}).then(function(response){
		  
		  $scope.projectsData = createTreeData(response.data);
			
		  $('#project-tree').tree({
		        data: $scope.projectsData
		    }).on(
		    	    'tree.click',
		    	    function(event) {
		    	        // The clicked node is 'event.node'
		    	        var node = event.node;
		    	        if(node.type == "ifc"){
		    	        	ifc_id = node.id;
		    	        	require(["/js/gltf_app.js"]);
		    	        }
		    	    }
		    	);
			
			$scope.$parent.showloading = false;
			
		}, function errorCallback(response){ 
			$scope.$parent.showloading = false;		
			
		});		
	}
	
	function createTreeData(projectData){
		
		var res = [];
		
		for(idx in projectData){
			var project = projectData[idx];
			var node = {name : project.projectName, id: 1, type: "project", children: [{name: "ifc1", id: 1, type: "ifc"}, {name: "ifc2", id: 2, type: "ifc"}]};
			res.push(node);
		}
		
		return res;
	}
	

});


