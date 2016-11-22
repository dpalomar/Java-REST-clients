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
		vm.exito = false;
		vm.error = false;

		function getUsuario(){
			$http.get('http://localhost:8080/usuario').success(function(data){
			 
			 vm.usuario_recuperado = data;

			});
		}

		function getAll(){
			$http.get('http://localhost:8080/usuarios').success(function(data){
			 
			 vm.usuarios = data;
			});
		}
		function guardarUsuario() {
			$http.post('http://localhost:8080/usuario',vm.usuario_guardado)
			   .then(function success(response){
						vm.mensaje = "Usuario creado correctamente";
						vm.exito = true;
						vm.error = false;

			       },
			   	   function error(response){
			   	   if(response.data.exception == 'org.springframework.http.converter.HttpMessageNotReadableException'){

			   	   	vm.mensaje = "No ha introducido nada ";
			   	   }else{

   				   	   vm.mensaje = response.data.errors[0].field +" "+response.data.errors[0].defaultMessage;
			   	   }
			   	   	vm.error = true;

			   	 })
			
		}

	}
})();