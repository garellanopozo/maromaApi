/**
 * Created by German on 14/06/2016.
 */

(function(angular){
    var DirectorsController = function($location,directorsService){
        console.log("Hello DirectorsController");
        var vm = this;
        vm.allData = [];
        vm.gridData = {};
        vm.mySelections = [];
        vm.totalServerItems = 0;
        activate();

        function activate() {
            directorsService.getData()
                .then(function(data){
                    vm.allData = data;
                    vm.totalServerItems = data.length;
                });
        }

        vm.gridData = {
            enableRowSelection: true,
            enableRowHeaderSelection: false,
            modifierKeysToMultiSelect: true,
            multiSelect: true,
            onRegisterApi: function(gridApi){
                vm.gridApi = gridApi;
                gridApi.selection.on.rowSelectionChanged(null,function(){
                    vm.mySelections = gridApi.selection.getSelectedRows();
                    $location.path('/director/');
                });
            },
            data: 'vm.allData',
            columnDefs: [
                { name:'name' , displayName: 'Name'},
                { name:'sex' , displayName: 'Sex'},
                { name:'nationality' , displayName: 'Nationality'},
                { name:'city' , displayName: 'City'},
                { name:'dob' , displayName: 'Dob', cellFilter: 'date: "dd/MM/yyyy"'},
                { name:'age' , displayName: 'Age'},
                { name:'blockbuster' , displayName: 'Blockbuster'}
            ]
        };

    };

    DirectorsController.$inject = ['$location','directorsService'];
    angular.module("myApp.controllers").controller("DirectorsController",DirectorsController);
}(angular));
