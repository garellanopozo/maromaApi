/**
 * Created by German on 13/06/2016.
 */
(function(angular){
    angular.module('myApp.controllers',[]);
    angular.module('myApp.services',[]);
    angular.module('myApp.directive',[]);
    angular.module('myApp',['ngResource','ngRoute', 'ngAnimate','ngSanitize', 'ui.bootstrap', 'dialogs.main', 'pascalprecht.translate', 'dialogs.default-translations', 'ui.grid', 'ui.grid.selection','myApp.controllers','myApp.services', 'myApp.directive', 'myApp.filter']);
})(angular);