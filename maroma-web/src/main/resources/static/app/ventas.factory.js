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
                method : 'POST',
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
    };
    VentasFactory.$inject = ['$resource','$http','$q'];
    angular.module("myApp.services").factory("ventasService",VentasFactory);
}(angular));