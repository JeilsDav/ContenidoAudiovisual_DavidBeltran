# Proyecto: Contenido Audiovisual

## Descripción

Este programa está diseñado para gestionar y almacenar información relacionada con contenido audiovisual. El sistema permite registrar datos de diferentes tipos de contenido (como películas, series de TV, cortometrajes, etc.), así como gestionar y realizar pruebas unitarias para verificar su correcto funcionamiento.

## Estructura del Programa

El programa está organizado en varios paquetes (packages) con funciones específicas:

### 1. **Paquete: controlador**
   - **Clase: PruebaCompleta**  
     Esta clase es la encargada de ejecutar el programa. Su principal función es gestionar la entrada de datos y coordinar las operaciones dentro de los otros paquetes.

### 2. **Paquete: uni1a**
   Este paquete contiene las clases principales que modelan diferentes tipos de contenido audiovisual:
   - **Actor**
   - **Cortometraje**
   - **Documental**
   - **Episodio**
   - **Investigadores**
   - **Pelicula**
   - **SerieDeTV**
   - **Temporada**
   - **VideoYouTube**

   Estas clases representan las entidades de contenido y almacenan la información relevante de cada tipo, como título, duración, elenco, entre otros.

### 3. **Paquete: utils**
   Este paquete contiene las clases encargadas de realizar las pruebas unitarias:
   - **FileManager**  
     Se encarga de la gestión de archivos, como leer y escribir en los archivos CSV.
   - **FileManagerTestActor, FileManagerTestCortometraje, etc.**  
     Son clases derivadas de FileManager que realizan pruebas unitarias específicas para cada tipo de contenido, asegurando que la funcionalidad de manejo de archivos sea correcta para cada clase.

## Funcionalidad Principal

1. El usuario puede introducir información de diferentes tipos de contenido (películas, series, cortometrajes, etc.).
2. Los datos introducidos se almacenan en archivos CSV correspondientes, lo que permite gestionar y consultar la información de manera persistente, la aplicacion tiene una funcion para mostrar la ruta en donde se guardan los archivos CSV, para consultarlos, se debe presionar esa opcion, copiar y pegar la ruta, y se podran ver los archivos CSV.
3. El sistema incluye pruebas unitarias para asegurar el correcto funcionamiento de la gestión de archivos y las operaciones sobre las entidades.

## Tecnologías Utilizadas

- Java
- Archivos CSV para almacenamiento de datos

## Cómo Ejecutar el Programa

1. Clona este repositorio a tu máquina local.
2. Abre el proyecto en tu IDE favorito (como Eclipse).
3. Ejecuta la clase PruebaCompleta para comenzar a introducir los datos.
4. Los archivos CSV se actualizarán con la información proporcionada por el usuario.

## Pruebas Unitarias

El paquete utils contiene clases de prueba que validan el correcto funcionamiento de la clase FileManager y sus derivadas. Estas pruebas aseguran que las operaciones de lectura y escritura en los archivos CSV se realicen correctamente.