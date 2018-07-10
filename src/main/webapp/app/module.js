(function () {

    angular.module('app', [
        'ui.router'
    ]);

    angular.module('app').config(AppConfig);

    AppConfig.$inject = ['$stateProvider'];

    function AppConfig($stateProvider) {
        $stateProvider
            .state({
                name: 'locatariosList',
                url: '/locatarios',
                templateUrl: '/views/locatarios/list.html',
                controller: 'LocatarioListController',
                controllerAs: 'vm'
            })
            .state({
                name: 'locatariosNovo',
                url: '/locatarios/novo',
                templateUrl: '/views/locatarios/form.html',
                controller: 'LocatarioFormController',
                controllerAs: 'vm'
            })
            .state({
                name: 'locatariosEditar',
                url: '/locatarios/{id}',
                templateUrl: '/views/locatarios/form.html',
                controller: 'LocatarioFormController',
                controllerAs: 'vm'
            })
            .state({
                name: 'imoveisList',
                url: '/imoveis',
                templateUrl: '/views/imoveis/list.html',
                controller: 'ImovelListController',
                controllerAs: 'vm'
            })
            .state({
                name: 'imoveisNovo',
                url: '/imoveis/novo',
                templateUrl: '/views/imoveis/form.html',
                controller: 'ImovelFormController',
                controllerAs: 'vm'
            })
            .state({
                name: 'imoveisEditar',
                url: '/imoveis/{id}',
                templateUrl: '/views/imoveis/form.html',
                controller: 'ImovelFormController',
                controllerAs: 'vm'
            })
            .state({
                name: 'locacoesList',
                url: '/locacoes',
                templateUrl: '/views/locacoes/list.html',
                controller: 'LocacaoListController',
                controllerAs: 'vm'
            })
            .state({
                name: 'locacoesNovo',
                url: '/locacoes/novo',
                templateUrl: '/views/locacoes/form.html',
                controller: 'LocacaoFormController',
                controllerAs: 'vm'
            })
            .state({
                name: 'locacoesEditar',
                url: '/locacoes/{id}',
                templateUrl: '/views/locacoes/form.html',
                controller: 'LocacaoFormController',
                controllerAs: 'vm'
            });
    }
})();