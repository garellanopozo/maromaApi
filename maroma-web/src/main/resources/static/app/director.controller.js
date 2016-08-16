/**
 * Created by German on 14/06/2016.
 */

(function(angular){
    var DirectorController = function(directorsService){
        console.log("Hello Director-Controller");
        var vm = this;
        activate();
        function activate() {
            directorsService.getDirector()
                .then(function(data){
                    vm.allData = data;
                });
        }
    };

    DirectorController.$inject = ['directorsService'];
    angular.module("myApp.controllers").controller("DirectorController",DirectorController);
}(angular));
