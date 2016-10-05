/**
 * Created by garellano on 05/09/2016.
 */

(function(angular){
    var VentasController = function($rootScope,$timeout,$translate,dialogs,ventasService){

        angular.isUndefinedOrNull = function(val) {
            return angular.isUndefined(val) || val === null || val ==='' || Object.getOwnPropertyNames(val).length === 0
        }

        /* ====================================== INITIAL VALUE ====================================== */
        var vm = this;
        vm.numDoc_view = false;
        vm.apellidos_view =  false;
        vm.panelDetalleVenta_View=false;
        vm.panelAddClient = false;
        vm.numIdent_view = false;
        vm.nombreClient_view = false;
        vm.apellidoClient_view = false;
        vm.razonSocial_view = false;
        vm.requiredNum = true;
        vm.requiredApellidos = false;
        vm.documentIdentList = [
            {label:'DNI', value: 'DNI'},
            {label:'RUC', value: 'RUC'},
            {label:'Apellidos', value: 'Apellidos'}
        ];
        vm.documentIdentSelected = vm.documentIdentList[0];
        vm.maxSize = 8;
        vm.minSize = 8;

        vm.tipDocChange = function(){
            switch (vm.documentIdentSelected.value) {
                case 'RUC':
                    vm.requiredNum = true
                    vm.requiredApellidos = false;
                    vm.numDoc=null;
                    vm.numDoc_view = true;
                    vm.apellidos_view =  false;
                    vm.maxSize = 11;
                    vm.minSize = 11;
                    break;
                case 'Apellidos':
                    vm.requiredNum = false;
                    vm.requiredApellidos = true;
                    vm.apellidos=null;
                    vm.numDoc_view = false;
                    vm.apellidos_view = true;
                    break;
                default:
                    vm.requiredNum = true;
                    vm.requiredApellidos = false;
                    vm.numDoc = '';
                    vm.numDoc_view = true;
                    vm.apellidos_view =  false;
                    vm.maxSize = 8;
                    vm.minSize = 8;
            }
        };

        vm.tipDocChange();

        /* ====================================== SEARCH CLIENT ====================================== */

        vm.searchClient = function(){
                dialogs.wait('buscando Cliente','Por favor, espere se está buscando el cliente<br><br>Esto solo debería tomar un momento.');
                ventasService.getCliente(informacionABuscar())
                .then(function(data){
                    $rootScope.$broadcast('dialogs.wait.complete');
                    if(!angular.isUndefinedOrNull(data.data.respuesta)){
                        vm.panelDetalleVenta_View = true;
                    }else{
                        agregarCliente();
                    }
                });
        }

        function informacionABuscar(){
            var params='';
            if(!angular.isUndefinedOrNull(vm.numDoc)){
                params = {'documentoIdentidad': vm.numDoc};
            }
            if(!angular.isUndefinedOrNull(vm.apellidos)){
                params = {'apellido': vm.apellidos};
            }
            return params;
        }

        /* ====================================== ADD CLIENT ====================================== */

         function agregarCliente() {
            var dlg = dialogs.confirm('Confirm','El cliente no existe, desea registrarlo?');
            dlg.result.then(function(btn) {
                    vm.panelAddClient = true;
                },
                function(btn) {
                    vm.panelAddClient = false;
                });
        };


    };
    VentasController.$inject = ['$rootScope','$timeout','$translate','dialogs','ventasService'];
    angular.module("myApp.controllers").controller("VentasController",VentasController);
}(angular));

