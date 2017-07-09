;(function() {
    angular
        .module('app')
        .service('PedidoService', ['$http', function($http) {
            return {
                get: function() {
                    return $http.get('pedidos/all');
                },
                save: function(data) {
                    return $http.post('pedido/salva', data);
                }
            };
        }]);
})();