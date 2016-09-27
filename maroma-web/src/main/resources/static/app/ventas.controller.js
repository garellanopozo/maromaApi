/**
 * Created by garellano on 05/09/2016.
 */

(function(angular){
    var VentasController = function($rootScope,$timeout,$translate,dialogs,ventasService){

        /*Funtion Global*/
        angular.isUndefinedOrNull = function(val) {
            return angular.isUndefined(val) || val === null || val ==='' || Object.getOwnPropertyNames(val).length === 0
        }
        var vm = this;
        /*show and hidden */
        vm.panelDetalleVenta_View=false;
        vm.panelAddClient = false;
        vm.numIdent_view = false;
        vm.nombreClient_view = false;
        vm.apellidoClient_view = false;
        vm.razonSocial_view = false;
        /*var defaultValues = {
            defaultValuesView: defaultValuesView
        };
        return defaultValues;*/

        function defaultValuesView(){
            vm.panelDetalleVenta_View=false;
            vm.panelAddClient = false;
            vm.numIdent_view = false;
            vm.nombreClient_view = false;
            vm.apellidoClient_view = false;
            vm.razonSocial_view = false;
        };

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
                    console.log(vm.info.data.respuesta.length);
                    console.log('object:'+typeof vm.info.data.respuesta);
                    if(!angular.isUndefinedOrNull(vm.info.data.respuesta)){
                        vm.panelDetalleVenta_View = true;
                    }else{
                        agregarCliente();
                    }
                });
            }
        }

         function agregarCliente() {
            var dlg = dialogs.confirm('Confirm','El cliente no existe, desea registrarlo?');
            dlg.result.then(function(btn) {
                    vm.panelAddClient = true;
                    vm.addTipDocSelected = vm.documentIdentList[0];
                    vm.tipDocChange(vm.addTipDocSelected);
                },
                function(btn) {
                    defaultValuesView();
                });
        };

        vm.tipDocChange = function(){
            switch (vm.addTipDocSelected.value) {
                case 'DNI':
                    vm.numIdent_view = true;
                    vm.nombreClient_view = true;
                    vm.apellidoClient_view = true;
                    vm.razonSocial_view = false;
                    break;
                case 'RUC':
                    vm.numIdent_view = true;
                    vm.nombreClient_view = false;
                    vm.apellidoClient_view = false;
                    vm.razonSocial_view = true;
                    break;
                case 'Apellidos':
                    vm.numIdent_view = false;
                    vm.nombreClient_view = true;
                    vm.apellidoClient_view = true;
                    vm.razonSocial_view = false;
                    break;
                default:
            }
        };
    };
    VentasController.$inject = ['$rootScope','$timeout','$translate','dialogs','ventasService'];
    angular.module("myApp.controllers").controller("VentasController",VentasController);
}(angular));

