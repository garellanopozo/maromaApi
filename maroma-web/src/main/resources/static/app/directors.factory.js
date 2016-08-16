(function(angular){
    var DirectorsFactory = function($resource,$http,$q){
        var service = {
            getData: getData,
            getDirector: getDirector
        };
        return service;

        function getData() {
            var defer = $q.defer();
            $http.get('../json/directors.json')
                .then(function(data){
                    defer.resolve(data.data);
                })
                .catch(function(){
                    defer.reject();
                });
            return defer.promise;
        }

        function getDirector() {
            var defer = $q.defer();
            $http.get('../json/director.json')
                .then(function(data){
                    defer.resolve(data.data);
                })
                .catch(function(){
                    defer.reject();
                });
            return defer.promise;
        }
    };

    DirectorsFactory.$inject = ['$resource','$http','$q'];
    angular.module("myApp.services").factory("directorsService",DirectorsFactory);
}(angular));
