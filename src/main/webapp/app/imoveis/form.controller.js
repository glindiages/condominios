(function () {
    'use strict'

    angular.module('app')
        .controller('ImovelFormController', ImovelFormController);

    ImovelFormController.$inject = ['ImovelService', '$state', '$stateParams', 'DialogBuilder'];

    function ImovelFormController(ImovelService, $state, $stateParams, DialogBuilder) {

        var vm = this;
        vm.registro = {};
        vm.error = {};
        vm.titulo = 'Novo Imóvel';

        vm.salvar = salvar;

        if ($stateParams.id) {
            ImovelService.findById($stateParams.id)
                .then(function (data) {
                    vm.registro = data;
                    vm.titulo = 'Editando Imóvel';
                });
        }

        function salvar() {
            if (!vm.registro.id) {
                ImovelService.insert(vm.registro)
                    .then(function (dado) {
                        DialogBuilder.message('Registro inserido com sucesso!');
                        $state.go("imoveisList");
                    })
                    .catch(function (error) {
                        vm.error = error.data;
                    });
            } else {
                ImovelService.update(vm.registro)
                    .then(function (dado) {
                        DialogBuilder.message('Registro alterado com sucesso!');
                        $state.go("imoveisList");
                    })
                    .catch(function (error) {
                        vm.error = error.data;
                    });
            }
        }
    }
})();