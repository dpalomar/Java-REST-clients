# Ejemplos de Clientes REST con SpringBoot

> Este repositorio contiene varios ejemplos de creación de clientes REST usando Springboot.
> 
> Se usa SpringBoot como gestor del servicio REST y los clientes se incluyen en los disintos proyectos simulando conexiones remotas.

## Tipos de clientes

- [Cliente JQuery](ejemplo-jquery/README.md)
- [Cliente AngularJS](ejemplo-angular/README.md)
- [Cliente Java con RestTemplate](ejemplo-restTemplate/README.md)

## Escenarios

En todos los proyectos se realizan los mismos tres escenarios:

- Recuperar un usuario sin estar en la base de datos. __PETICION GET__
- Recuperar un listado de usuarios de la base de datos y por PK por tanto. __PETICION GET__
- Insertar un usuario en la base de datos. __PETICION POST__

## Componentes usados.

- Además de springboot se hace uso de componentes `@RestController` salvo en el proyecto _cliente java_ donde también se usa `@Controller`.
- Se usa __Spring-data__ y se manejan los datos mediante _Repositorios_.
- Se utiliza una base de datos embebida y en memoria que se inicia al arrancar la aplicación: [H2](http://www.h2database.com/html/main.html)
- En todos los proyectos se usa html excepto en el _cliente java_ que se usa también __thymeleaf__

## Demostración

En los distintos proyectos se muestra como configurar librerías javascript y/o templates thymeleaf, así como el lugar donde poner todos los recursos estáticos para que estén accesibles.

> En todos los proyectos se puede usar la consola de la base de datos accediendo a:
> 
>           http://localhost:8080/h2-console
> 
>   Usuario: sa y Password: vacío

> Los proyectos también están preparados para poder usar __LiveReload__ si se tiene instalado en el navegador.
> 





