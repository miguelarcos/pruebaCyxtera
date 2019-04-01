# Contacts Test

Contacts Test, es un proyecto construido para la administración de contactos, en donde se puede agregar y consultar los mismos.

## Instalación
Para subir la Base de Datos se ejcuta el comando "docker run -p 3306:3306 --name some-mysql -e MYSQL_ROOT_PASSWORD=my-secret-pw -d mysql:latest"

Para desplegar la aplicación se debe ejecutar el comando "mvn spring-boot:run", teniendo como precondición Maven instalado.

Cuando aplicación se inicializa, esta misma creará la estructura de la Base de Datos si esta no se encuentra creada.

## Contribución
Prueba técnica solicitada por la empresa Cyxtera con el objetivo de gestionar contactos, presentada por parte de Miguel Fernando Arcos Meneses. 

Proyecto construido, basado en:

Framework [Spring](https://start.spring.io/)
Base de datos [Mysql](https://dev.mysql.com/downloads/file/?id=484900)
Herramienta de software para la gestión y construcción de proyectos [Maven](https://maven.apache.org/download.cgi?Preferred=ftp://mirror.reverse.net/pub/apache/).
Servidor de aplicaciones embebido [Tomcat](https://tomcat.apache.org/download-70.cgi).
Front sugerido por Cyxtera [Vaadin](http://vaadin.com).

El proyecto Contacts Test, es un proyecto construido para la administración de contactos, en donde se puede agregar y consultar los mismos.

## Uso

Los servicios creados para la creación y la consulta de los contactos, son servicios REST que se definen de la siguietne manera:

POST: Para la creación de un contacto
http://localhost:8080/api/conctact 

GET: Para obtener los contactos que comiencen por la palabra ingresada y como parámetro del servicio es "nametoSearch"
http://localhost:8080/api/conctact/{nameToSearch} get y es para obtener

Front o framework de presentación se utilizó Vaadin, utilizandolo para la implentación gráfica para las funcionalidades asignadas, por medio de su implementación de objetos java accediendo a su interfaz del proyecto en la url http://localhost:8080/

Se puede ingresar a la carpeta img del repositorio y encontrar las evidencias de los servcios en ejecución.
