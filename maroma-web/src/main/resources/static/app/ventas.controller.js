/**
 * Created by garellano on 05/09/2016.
 */

(function(angular){
    var VentasController = function($rootScope,$timeout,$filter,$translate,dialogs,ventasService){

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
        vm.producto='';
        vm.listProducto=[];
        vm.clienteResultName = '';
        vm.cont=0;

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
                dialogs.wait('buscando Cliente','Por favor, espere se está procesando su solicitud<br><br>Esto solo debería tomar un momento.');
                ventasService.buscarCliente(informacionABuscar())
                .then(function(data){
                    $rootScope.$broadcast('dialogs.wait.complete');
                    if(!angular.isUndefinedOrNull(data.data.message)){
                        vm.panelDetalleVenta_View = true;
                        vm.cliente=data.data.clientes[0];
                        vm.clienteResultName =  vm.cliente.nombre + ' ' + vm.cliente.apellido;
                    }else{
                        agregarCliente();
                    }
                });
        }

        function informacionABuscar(){
            var params='';
            if(!angular.isUndefinedOrNull(vm.numDoc)){
                params = {'numeroDocumento': vm.numDoc};
            }
            if(!angular.isUndefinedOrNull(vm.apellidos)){
                params = {'apellido': vm.apellidos};
            }
            return params;
        }

        /* ====================================== VALIDATE ADD CLIENT ====================================== */

         function agregarCliente() {
            var dlg = dialogs.confirm('Confirm','El cliente no existe, desea registrarlo?');
            dlg.result.then(function(btn) {
                    vm.panelAddClient = true;
                    detalleAgregarCliente();
                },
                function(btn) {
                    vm.panelAddClient = false;
                });
        };

        /* ====================================== FIELDS TO ADDS ====================================== */
        function detalleAgregarCliente(){
            switch (vm.documentIdentSelected.value) {
                case 'RUC':
                    vm.numIdent_view = false;
                    vm.nombreClient_view = false;
                    vm.razonSocial_view = true;
                    break;
                case 'Apellidos':
                    vm.razonSocial_view = false;
                    vm.numIdent_view = false;
                    vm.nombreClient_view = true;
                    vm.apellidoClient_view = true;
                    break;
                case 'DNI':
                    vm.razonSocial_view = false;
                    vm.numIdent_view = true;
                    vm.nombreClient_view = true;
                    vm.apellidoClient_view = true;
                    break;
            }
        }

        /* ====================================== ADD CLIENT ====================================== */
        vm.addClient = function(){
            vm.params = {
                'tipoCliente'      : vm.documentIdentSelected.value==='DNI'?'PERSONA':'EMPRESA',
                'numeroDocumento'  : vm.numDoc,
                'nombre'           : angular.isUndefinedOrNull(vm.nombreCliente)?'':vm.nombreCliente,
                'apellido'         : angular.isUndefinedOrNull(vm.apellidosCliente)?'':vm.apellidosCliente,
                'razonSocial'      : angular.isUndefinedOrNull(vm.razonSocial)?'':vm.razonSocial
            };
            dialogs.wait('Agregando Cliente','Por favor, espere se está procesando su solicitud<br><br>Esto solo debería tomar un momento.');
            ventasService.agregarCliente(vm.params)
                .then(function(data){
                    $rootScope.$broadcast('dialogs.wait.complete');
                    if(data.data.mensaje==='OK'){
                        dialogs.notify("Informacion", "El cliente ha sido agregado satisfactoriamente");
                    }else{
                        dialogs.error("Error", data.data.mensaje);
                    }
                });
        }

        /* ====================================== SEARCH PRODUCT ====================================== */
        vm.searchProduct = function(){
            console.log("longitud de la cadena del producto es: "+ vm.producto.length);
            if(vm.producto.length>=3){
                if(vm.cont==0){
                    ventasService.buscarProducto({'descripcion': vm.producto})
                        .then(function(data){
                            if(!angular.isUndefinedOrNull(data.data.producto)){
                                firstArrayComplete(data.data.producto);
                                vm.cont=1;
                            }
                        });
                }
                /*else{
                    for (var i=0; i<vm.listProducto.length; i++){
                        isNotExistProducto(listProducto[i].descripcion)
                    }
                }*/
            }
        }

        function firstArrayComplete(productList){
            for (var i=0; i<productList.length; i++){
                //if(cont==0){
                    vm.listProducto.push(productList[i].descripcion);
                //}
            }
        }

        function isNotExistProducto(prodDescription){
            var found = $filter('getById')(vm.listProducto,prodDescription);
            console.log(found);
            vm.selected = JSON.stringify(found);
            if(angular.isUndefinedOrNull(vm.selected)){
                vm.listProducto.push(vm.selected);
            }
            else{
                console.log("Nada");
            }
        }

        vm.doSomethingElse = function(suggestion){
            console.log("Suggestion selected: " + suggestion);
        }
    };
    VentasController.$inject = ['$rootScope','$timeout','$filter','$translate','dialogs','ventasService'];
    angular.module("myApp.controllers").controller("VentasController",VentasController);
}(angular));

