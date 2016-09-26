/**
 * Created by garellano on 05/09/2016.
 */

(function(angular){
    var VentasController = function($rootScope,$timeout,$translate,dialogs,ventasService){
        console.log("Hello Ventas-Controller");
        var vm = this;
        vm.today = function() {
            vm.dt = new Date();
        };
        vm.today();
        vm.panelView=false;
        vm.formats = ['dd-MMMM-yyyy', 'yyyy/MM/dd', 'dd.MM.yyyy', 'shortDate'];
        vm.format = vm.formats[2];
        vm.altInputFormats = ['M!/d!/yyyy'];
        vm.popup1 = {
            opened: false
        };
        vm.open1 = function() {
            vm.popup1.opened = true;
        };
        vm.documentIdentList = [
            {label:'DNI', value: 'DNI'},
            {label:'RUC', value: 'RUC'},
            {label:'Apellidos', value: 'Apellidos'}
        ];
        vm.documentIdentSelected = vm.documentIdentList[0];

        vm.searchClient = function(){
            var params = {'documentoIdentidad': vm.numDoc};
            if(!angular.isUndefined(vm.documentIdentSelected)){
                dialogs.wait('buscando Cliente','Por favor, espere se está buscando el cliente<br><br>Esto solo debería tomar un momento.');
                ventasService.getCliente(params)
                .then(function(data){
                    $rootScope.$broadcast('dialogs.wait.complete');
                    vm.info = data;
                    vm.panelView = true;
                    console.log(vm.info.data.respuesta);
                    if(!angular.isUndefinedOrNullOrEmpty(vm.info.data.respuesta)){
                        console.log(vm.info.data.respuesta);
                    }else{
                        var dlg = dialogs.confirm('', $filter('translate')('EDIT_STORE_MSG_CONFIRM_CANCEL') );
                    }
                });
            }
        }
    };
    VentasController.$inject = ['$rootScope','$timeout','$translate','dialogs','ventasService'];
    angular.module("myApp.controllers").controller("VentasController",VentasController);
}(angular));

