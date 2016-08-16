(function() {
    'use strict';

    angular
        .module('myApp')
        .config(routeConfig);

    function routeConfig($routeProvider) {
        $routeProvider
            .when('/directors', {
                templateUrl: 'templates/directors/directors.html',
                controller: 'DirectorsController',
                controllerAs: 'vm'
            })
            .when('/director', {
                templateUrl: 'templates/director/director.html',
                controller: 'DirectorController',
                controllerAs: 'vm'
            })
            .otherwise({
                templateUrl: 'templates/inicio/bienvenida.html'
            });
    }
})();