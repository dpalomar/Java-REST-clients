
Este ejemplo usa `Thymeleaf` como vistas del navegador y un Controlador que hace de cliente de un servicio REST.

El controlador cliente se llama **PaginaUsuarioController** y utiliza la anotación `@Controller` y es el responsable de mostrar las vistas e invocar al servicio remoto mediante `RestTemplate`, mientras que el servicio REST simulado se llama **UsuarioController** y usa `@RestController`.

Para que springboot use las vistas thymeleaf hay que poner la dependencia en el `pom.xml` y luego todas las páginas bajo el directorio `src/main/resources/templates`.

`RestTemplate` es una clase de utilidad de Spring que hace muy fácil invocar peticiones de tipo REST y serializar los documentos JSON a objetos Java.



