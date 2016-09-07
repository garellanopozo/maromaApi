/**
 * Created by garellano on 05/09/2016.
 */

(function(angular){
    var VentasController = function($rootScope,$timeout,$translate,dialogs,directorsService){
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

       /* var _progress = 33;

         vm.name = '';
         vm.confirmed = 'No confirmation yet!';

         vm.custom = {
         val: 'Initial Value'
         };

         vm.launch = function(which){
         switch(which){
         case 'error':
         dialogs.error();
         break;
         case 'wait':
         var dlg = dialogs.wait(undefined,undefined,_progress);
         _fakeWaitProgress();
         break;
         case 'customwait':
         var dlg = dialogs.wait('Custom Wait Header','Custom Wait Message',_progress);
         _fakeWaitProgress();
         break;
         case 'notify':
         dialogs.notify();
         break;
         case 'confirm':
         var dlg = dialogs.confirm();
         dlg.result.then(function(btn){
         vm.confirmed = 'You confirmed "Yes."';
         console.log(vm.confirmed);
         },function(btn){
         vm.confirmed = 'You confirmed "No."';
         console.log(vm.confirmed);
         });
         break;
         }
         };*/

       /* var _fakeWaitProgress = function(){
            $timeout(function(){
                if(_progress < 100){
                    _progress += 33;
                    $rootScope.$broadcast('dialogs.wait.progress',{'progress' : _progress});
                    _fakeWaitProgress();
                }else{
                    $rootScope.$broadcast('dialogs.wait.complete');
                    _progress = 0;
                }
            },1000);
        };*/
    };
    VentasController.$inject = ['$rootScope','$timeout','$translate','dialogs','directorsService'];
    angular.module("myApp.controllers").controller("VentasController",VentasController);
}(angular));

