
var bimSurfer = false;


function highlight(oid, selected) {
    // Clicking an explorer node fits the view to its object and selects
	
	//alert(typeof selected);
	/*for( o in oid){
		alert(o + " : " + oid[o]);
	}*/
	
    if (selected.length) {
        bimSurfer.viewFit({
            ids: selected,
            animate: true
        });
    }
    bimSurfer.setSelection({
        ids:selected,
        clear:true,
        selected:true
    });
    
    //alert("my selected: " + selected);
}        

function stopSurfer(viewerContainer, detailsContainerId){
	if(bimSurfer && bimSurfer.destroy){
		bimSurfer.destroy();
	}
	
	$("#" + detailsContainerId).html("");
}

function startSurfer(ifcId, viewerContainerId, detailsContainerId, ifcData){

	require([
	    "../bimsurfer/src/BimSurfer",
	    "../bimsurfer/src/StaticTreeRenderer",
	    "../bimsurfer/src/MetaDataRenderer",
	    "../bimsurfer/src/Request",
	    "../bimsurfer/src/Utils",
	    "../bimsurfer/lib/domReady!",
	],
	function (BimSurfer, StaticTreeRenderer, MetaDataRenderer, Request, Utils) {
	    bimSurfer = new BimSurfer({
	        domNode: "viewerContainer"
	    });
	    
	    var modelName = window.location.hash;
	    if (modelName.length < 1) {
	        modelName = "Duplex_A_20110907_optimized";
	    } else {
	        modelName = modelName.substr(1);
	    }
	    modelName = "/models/" + modelName;
	    
	    //http://localhost:1010/pifc/read/readifc
	    
	    /*var tree = new StaticTreeRenderer({
	        domNode: "treeContainer"
	    });
	    tree.addModel({id: 1, src: modelName + ".xml"});
	    tree.build();
	    */
	    
	    //tree.on("click", highlight);
	    
	    var data = new MetaDataRenderer({
	        domNode: detailsContainerId
	    });
	    //data.addModel({id: 1, src: modelName + ".xml"});
	    //data.addModel({id: 1, src: "http://localhost:1010/pifc/read/get/" + ifcId});
	    data.addModel({id: 1, modelJson: ifcData});
	    
	    bimSurfer.load({
	        src: modelName + ".gltf"
	    }).then(function (model) {
	        
	        var scene = bimSurfer.viewer.scene;
	        
	        var aabb = scene.worldBoundary.aabb;
	        
	        var diag = xeogl.math.subVec3(aabb.slice(3), aabb, xeogl.math.vec3()); 
	        var modelExtent = xeogl.math.lenVec3(diag); 
	    
	        scene.camera.project.near = modelExtent / 1000.;
	        scene.camera.project.far = modelExtent * 100.;
	       
	        scene.camera.view.eye = [-1,-1,5];
	        scene.camera.view.up = [0,0,1];
	        bimSurfer.viewFit({centerModel:true});
	        
	        bimSurfer.viewer.scene.canvas.canvas.style.display = 'block';
	        bimSurfer.viewer.scene.canvas.canvas.style.width = "1660px";
	        bimSurfer.viewer.scene.canvas.canvas.style.height = "660px";
	    });

	    bimSurfer.on("selection-changed", function(selected) {  //alert(selected);
	        data.setSelected(selected.map(function(id) { //alert(Utils.CompressGuid(id.split("#")[1].substr(8, 36).replace(/-/g, "")));
	            return Utils.CompressGuid(id.split("#")[1].substr(8, 36).replace(/-/g, ""));
	        }));
	    });
	    
	    // Lets us play with the Surfer in the console
	    window.bimSurfer = bimSurfer;
	});	
}
