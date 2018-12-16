
var fbimApp = angular.module('fbimApp', ['ngMaterial', 'ngTable', 'ngMaterialAccordion', 'ngSanitize']);

fbimApp.config(function($mdDateLocaleProvider) {
    $mdDateLocaleProvider.formatDate = function(date) {
    	if(date != null){
    		return moment(date).format('DD.MM.YYYY');
    	}
       return null;
    };
});


fbimApp.config(['$httpProvider', function($httpProvider) {
    $httpProvider.defaults.timeout = 10000;
}]);

fbimApp.controller('BodyController', function ($scope, $http, $sce, $element, $compile, $mdSidenav) {

	$scope.showloading = false;
	$scope.isShowError = true;
	$scope.isShowMessage = false;
	
	$scope.errorMessage = "";
	$scope.menulist = [];

	$scope.messageTitle = "";
	$scope.messageContent = "";
	
	$scope.$watch(
			function(scope) { return $('[data-toggle="tooltip"]').length },
            function(newValue, oldValue) {
				$('[data-toggle="tooltip"]').tooltip();
            }
           );	

	$scope.toggleRight = function(){
		$mdSidenav('rightSidenav').toggle();
    };

	$scope.closeSideRight = function () {
	      $mdSidenav('rightSidenav').close();
	};
	
	$scope.navMenu = function(url){
		window.location = url;
	};
    
	$('[data-toggle="tooltip"]').tooltip();   
  
  $scope.ShowErrorBox = function(message){
    $scope.errorMessage = message;
    $scope.isShowError = true;
  };
  
  $scope.closeErrorBox = function(){

    $scope.isShowError = false;
  };
  
  $scope.ShowMessageBox = function(message, title){
    if(title == undefined){
      title = "";
    }
    $scope.messageTitle = title;
    $scope.messageContent = message;
    $scope.isShowMessage = true;
  };
  
  $scope.closeMessageBox = function(){

    $scope.isShowMessage = false;
  };
  
  $("#left-panel").mouseover(function(event){
	
	  event.stopPropagation();
	  event.preventDefault();
	  
	if(!$("#left-panel").hasClass("open")){
		$( "#left-panel" ).animate({
		    width: 280
		  }, 300, function() {
			  if(!$("#left-panel").hasClass("open")){
				  $("#left-panel").addClass("open");  
			  }
			  
		  });
	}
	  
  });
  
  $("body").mouseover(function(){
	  
		if($("#left-panel").hasClass("open")){
			
			$("#left-panel").removeClass("open");
			
			$( "#left-panel" ).animate({
			    width: 50
			  }, 200, function() {
				  
			  });
		}
	  
  });
    
  
	if(angular.element("md-sidenav[md-component-id='rightSidenav']").length == 1){
		$scope.$watch(function(){
	      return $mdSidenav('rightSidenav').isOpen();
	    }, 
	    function(newVal){
	    	if($mdSidenav('rightSidenav').isOpen()){ 
	    		if(!angular.element("body").hasClass("overdialog")){
	    			angular.element("body").addClass("overdialog");
	    		}
	    		
	    	} 
	    	else{
	    		angular.element("body").removeClass("overdialog");
	    	}
	});
	}
    
	
    

});

