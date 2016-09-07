/**
 * Created by garellano on 05/09/2016.
 */

(function(angular){
    var VentasController = function(dialogs,directorsService){
        console.log("Hello Ventas-Controller");
        var vm = this;
        vm.today = function() {
            vm.dt = new Date();
        };
        vm.today();
        vm.formats = ['dd-MMMM-yyyy', 'yyyy/MM/dd', 'dd.MM.yyyy', 'shortDate'];
        vm.format = vm.formats[2];
        vm.altInputFormats = ['M!/d!/yyyy'];

        vm.popup1 = {
            opened: false
        };

        vm.open1 = function() {
            vm.popup1.opened = true;
        };

        vm.launch = function(which){
            switch(which){
                case 'error':
                    dialogs.error();
                    break;
            }
        };
    };
    VentasController.$inject = ['dialogs','directorsService'];
    angular.module("myApp.controllers").controller("VentasController",VentasController);
}(angular));
