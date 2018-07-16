(function () {
    'use strict'

    angular.module('app')
        .controller('LocacaoFormController', LocacaoFormController);

    LocacaoFormController.$inject = [
        'LocacaoService',
        '$state',
        '$stateParams',
        'DialogBuilder',
        'LocatarioService',
        'ImovelService'
    ];

    function LocacaoFormController(LocacaoService, $state, $stateParams, DialogBuilder, LocatarioService, ImovelService) {

        var vm = this;
        vm.registro = {
            locacao: new Date(),
            valorLocacao:0,
            itens: []
        };
        vm.error = {};
        vm.titulo = 'Nova Locação';
        
        vm.locatarios = [];
        vm.imoveis = [];
        
        vm.salvar = salvar;
        
        vm.itemOriginal = null;
        vm.registroItem = {};

        vm.excluirItem = excluirItem;
        vm.editarItem = editarItem;
        vm.salvarItem = salvarItem;
        vm.novoItem = novoItem;

        LocatarioService.findAllOver()
            .then(function (data) {
                vm.locatarios = data;
            });

        ImovelService.findAllOver()
            .then(function (data) {
                vm.imoveis = data;
            });

        if ($stateParams.id) {
            LocacaoService.findById($stateParams.id)
                .then(function (data) {
                    vm.registro = data;
                    vm.registro.itens = vm.registro.itens || [];
                    vm.titulo = 'Editando Locação';
                });
        }

        function salvar() {
            if (!vm.registro.id) {
                LocacaoService.insert(vm.registro)
                    .then(function (dado) {
                        DialogBuilder.message('Registro incluído com sucesso!');
                        $state.go('locacoesList');
                    })
                    .catch(function (error) {
                        vm.error = error.data;
                    });
            } else {
                LocacaoService.update(vm.registro)
                    .then(function (dado) {
                        DialogBuilder.message('Registro alterado com sucesso!');
                        $state.go('locacoesList');
                    })
                    .catch(function (error) {
                        vm.error = error.data;
                    });
            }
        }

        function novoItem() {
            vm.itemOriginal = null;
            vm.registroItem = {};            
        }

        function editarItem(selecionado) {
            vm.itemOriginal = selecionado;
            angular.copy(selecionado, vm.registroItem);
        }

        function salvarItem() {
            // calcula o total do item
            if (vm.registro.valorLocacao == 0){
                vm.registro.valorLocacao = vm.registroItem.imovel.preco;
            }

            var index = vm.registro.itens.indexOf(vm.itemOriginal);
            if (index != -1) {
                vm.registro.itens[index] = vm.registroItem;
            } else {
                vm.registro.itens.push(vm.registroItem);
            }
            vm.itemOriginal = null;
            vm.registro.valorLocacao += vm.registroItem.valorItem;                  
        }

        function excluirItem(selecionado) {
            var index = vm.registro.itens.indexOf(selecionado);
            vm.registro.itens.splice(index, 1);
            vm.registro.valorLocacao -= selecionado.valorItem;
            if(vm.registro.itens.length ==0){    
                vm.registro.valorLocacao = 0;    
            }
        }
    }
})();