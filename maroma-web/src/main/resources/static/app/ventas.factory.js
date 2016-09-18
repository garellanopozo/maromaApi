/**
 * Created by German on 10/09/2016.
 */
(function(angular){
    var VentasFactory = function($resource,$http,$q){


        var service = {
            getCliente: getClient,
            saveClient: saveClient
        };
        return service;

        function getClient(params) {
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

        function saveClient(){
            console.log(saveClient)
        }
    };
    VentasFactory.$inject = ['$resource','$http','$q'];
    angular.module("myApp.services").factory("ventasService",VentasFactory);
}(angular));