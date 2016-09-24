/**
 * Created by German on 10/09/2016.
 */
(function(angular){
    var VentasFactory = function($resource,$http,$q){


        var service = {
            getCliente: getClient,
            saveClient: saveClient,
            getCliente1:getCliente1,
            getCliente2:getCliente2
        };
        return service;

        function getClient(params) {
            var defer = $q.defer();
            /*$http.defaults.headers.common['Access-Control-Allow-Origin'] = '*';
            $http.defaults.headers.post['dataType'] = 'json'
            $http.post('../api/maroma/buscarCliente',params)
                .then(function(data){
                    defer.resolve(data.data);
                })
                .catch(function(){
                    defer.reject();
                });
            return defer.promise;*/
            $http({
                method : 'get',
                url : '/api/maroma/buscarCliente',
                data : angular.toJson(params),
                headers : {
                    'Content-Type' : 'application/json'
                }
            }).then(function(data){
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

        function getCliente1(dni){
            var defer = $q.defer();
            $http.get('http://localhost:8080/api/maroma/buscarCliente01')
                .then(function(data){
                    defer.resolve(data.data);
                })
                .catch(function(){
                    defer.reject();
                });
            return defer.promise;
        }

        function getCliente2(dni){
            var defer = $q.defer();
            $http.post('http://localhost:8080/api/maroma/buscarCliente02',dni)
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