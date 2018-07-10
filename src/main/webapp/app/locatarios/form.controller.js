(function () {
    'use strict'

    angular.module('app')
        .controller('LocatarioFormController', LocatarioFormController);

    LocatarioFormController.$inject = ['LocatarioService', '$state', '$stateParams', 'DialogBuilder'];

    function LocatarioFormController(LocatarioService, $state, $stateParams, DialogBuilder) {

        var vm = this;
        vm.registro = {};
        vm.error = {};
        vm.titulo = 'Novo Locatário';

        vm.salvar = salvar;

        if ($stateParams.id) {
            LocatarioService.findById($stateParams.id)
                .then(function (data) {
                    vm.registro = data;
                    vm.titulo = 'Editando Locatário';
                });
        }

        function salvar() {
            if (!vm.registro.id) {
                LocatarioService.insert(vm.registro)
                    .then(function (dado) {
                        DialogBuilder.message('Registro inserido com sucesso!');
                        $state.go("locatariosList");
                    })
                    .catch(function (error) {
                        vm.error = error.data;
                    });
            } else {
                LocatarioService.update(vm.registro)
                    .then(function (dado) {
                        DialogBuilder.message('Registro alterado com sucesso!');
                        $state.go("locatariosList");
                    })
                    .catch(function (error) {
                        vm.error = error.data;
                    });
            }
        }    
    }
})();