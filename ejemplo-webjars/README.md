
Este ejemplo muestras las capacidades de __webjars__.

- Se han importado en el pom.xml los webjars de angularjs, jquery y bootstrap
- En index.html se realiza la importación de las librerías css y js
- Se muestran las capacidades de:
    - clases de bootstrap, tablas, paneles, badgets, formularios,  etc.
    - Directivas de angular, ng-click, ng-class, ng-model, ng-repeat, ng-show
    - Se usan filtros para hacer la tabla ordenable.
- Se habilita CORS
- Se ha añadido posibilidad de usar la consola de la base de datos accediendo a `/h2-console`
- Se puede usar LiveReload
- Se amplia el código de `UsuarioCtrl` para facilitar el uso de las directivas de angular.
- Los recursos estáticos como html, css y javascript son manejados mediante librerías .jar dentro de las dependencias de maven
- URL de acceso [http://localhost:8080/index.html]()
- Habilitar la consola de chrome para ver el paso de información <kbd>F12</kbd>
- Direcciones del API:
    - __GET__  [http://localhost:8080/usuario]()
    - __GET__  [http://localhost:8080/usuarios]()
    - __POST__ [http://localhost:8080/usuario]()

## Referencias

- [http://www.webjars.org/]()

