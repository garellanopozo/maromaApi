/**
 * Created by German on 13/06/2016.
 */
(function(angular){
    angular.module('myApp.controllers',[]);
    angular.module('myApp.services',[]);
    angular.module('myApp',['ngResource','ngRoute', 'ngAnimate','ngSanitize', 'ui.bootstrap', 'ui.grid', 'ui.grid.selection','myApp.controllers','myApp.services']);
})(angular);