
var ifc_id = -1;

mdmApp.controller('IfcViewerController', function ($scope, $http, $sce, $element, $compile, $mdSidenav, $mdComponentRegistry) {

	$scope.requestTimeout = 20000;
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
		    	        	//ifc_id = node.id;
		    	        	//require(["/js/ifcview/ifcLoader.js"]);
		    	        	
		    	        }
		    	        if(node.type == "project"){
		    	        	stopSurfer(false, "modeldetail");
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
			
			var node = {name : project.projectName, id: 1, type: "project", children: []};
			
			for(var idx in project.ifcList){
				var ifc = project.ifcList[idx];
				node.children.push({name: ifc.ifcName, id: ifc.id, type: "ifc"});
			}
			
			//node.children.push({name: "ifc1", id: 1, type: "ifc"});
			
			res.push(node);
		}
		
		return res;
	}
	
	function loadIfcData(id){
		
		$http({
			method: "GET",
			url: loadIfcUrl + id, 
			timeout: $scope.requestTimeout
		}).then(function(response){
			
			if(response.data.status == "OK"){
				alert("data loaded.\n ifc name:  " + response.data.projectIfc.header.file_schema.schema_identifiers);
				if(false){
					startSurfer(node.id, false, "modeldetail", response.data.projectIfc);
				}
			}
			else{
				alert(response.data.message);
			}
			

		}, function errorCallback(response){
      
			if(response.status == -1){
				
				alert("Connection Error!");
			}
			else{
				alert(response.data.message);
			}
			
			dialogScope.lockEdit = false;
			
		});	
		
	}

});


