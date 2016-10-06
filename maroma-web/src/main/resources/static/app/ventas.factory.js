/**
 * Created by German on 10/09/2016.
 */
(function(angular){
    var VentasFactory = function($resource,$http,$q){
        var service = {
            buscarCliente: buscarCliente,
            agregarCliente:agregarCliente
        };
        return service;

        function buscarCliente(params) {
            var defer = $q.defer();
            $http.post('http://localhost:8080/api/maroma/buscarCliente',params)
                .then(function(data){
                    defer.resolve(data.data);
                })
                .catch(function(){
                    defer.reject();
                });
            return defer.promise;
        }

        function agregarCliente(params){
            var defer = $q.defer();
            $http.post('http://localhost:8080/api/maroma/agregarCliente',params)
                .then(function(data){
                    defer.resolve(data.data);
                })
                .catch(function(){
                    defer.reject();
                });
            return defer.promise;
        }
    };
    VentasFactory.$inject = ['$resource','$http','$q'];
    angular.module("myApp.services").factory("ventasService",VentasFactory);
}(angular));