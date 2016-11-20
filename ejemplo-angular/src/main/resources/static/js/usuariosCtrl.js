(function(){
	'use strict';
	angular.module('demoApp', [])
	.controller('UsuariosController',UsuariosController);

	UsuariosController.$inject = ['$scope','$http'];
	
	function UsuariosController($scope,$http){
		var vm = this;
		vm.usuarios = [];
		vm.usuario_recuperado;
		vm.usuario_guardado;
		vm.mensaje;
		vm.getUsuario = getUsuario;
		vm.getAll = getAll;
		vm.guardarUsuario = guardarUsuario;

		function getUsuario(){
			$http.get('usuario').success(function(data){
			 
			 vm.usuario_recuperado = data;
			});
		}

		function getAll(){
			$http.get('usuarios').success(function(data){
			 
			 vm.usuarios = data;
			});
		}
		function guardarUsuario() {
			$http.post('usuario',vm.usuario_guardado)
			   .then(function success(response){
						vm.mensaje = "Usuario creado correctamente";
						
			       },
			   	   function error(response){
			   	   	console.log(response.data.message);
			   	   	vm.mensaje = response.data.message;

			   	 })
			
		}

	}
})();