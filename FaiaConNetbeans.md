**LEER ANTES DE CONTINUAR:** Antes de seguir estos pasos es necesario leer [las instrucciones de instalación](http://code.google.com/p/faia/wiki/InstruccionesInstalacion).
**READ BEFORE CONTINUING:** Before following this guide, it is necessary to read the [installation instructions](http://code.google.com/p/faia/wiki/InstruccionesInstalacion).


## Importar FAIA // Importing FAIA ##

_NOTAS // NOTES:_
  * Es importante, antes de continuar, haber leído la sección "Instalar FAIA" de la [página de instrucciones de instalación](http://code.google.com/p/faia/wiki/InstruccionesInstalacion).
  * Estas instrucciones de importación de FAIA se aplican también para los ejemplos, ya que los pasos son muy similares.
  * Se pone especial énfasis en configurar correctamente la codificación de caracteres de cada proyecto importado o creado, como se indica en uno de los pasos siguientes, ya que de otro modo surgirán errores.

**Before continuing, it is important to read the section “Installing FAIA” from the installation instructions [page](http://code.google.com/p/faia/wiki/InstruccionesInstalacion).
  * These instructions are also valid for importing the FAIA examples, because the steps are quite similar.
  * Special emphasis must be put in correctly configuring the character codification of every imported or created project, as it is shown in one of the next steps.**

| **1.** Descomprimir los archivos de FAIA y los ejemplos en alguna carpeta. // Decompress the FAIA files and examples in a folder |
|:---------------------------------------------------------------------------------------------------------------------------------|
| **2.** Ir al menú _File -> Open Project..._ // Go to menu _File -> Open Project..._ |
| ![http://faia.googlecode.com/svn/wiki/images/faiaConNetBeans/importarFaia1.png](http://faia.googlecode.com/svn/wiki/images/faiaConNetBeans/importarFaia1.png) |
| **3.** Dirigirse a la carpeta donde se han descomprimido FAIA y los ejemplos. Manteniendo presionada la tecla _Control_, es posible abrir únicamente el proyecto 'faia' o éste junto con todos los ejemplos. Finalmente presionar la tecla _Open Project_.  // Go to the folder where FAIA and its examples have been decompressed. Select the projects to be opened. Finally, click on _Open project_. |
| ![http://faia.googlecode.com/svn/wiki/images/faiaConNetBeans/importarFaia2.png](http://faia.googlecode.com/svn/wiki/images/faiaConNetBeans/importarFaia2.png) |
| **4.** Ahora es necesario **cambiar la codificación de caracteres** de _faia_ y los demás proyectos importados. Hacemos click derecho en el proyecto y elegimos _Properties_. // Now, it is necessary to **change the character codification** of _faia_ and the other imported projects. Right click on the project and select _Properties_.|
| ![http://faia.googlecode.com/svn/wiki/images/faiaConNetBeans/importarFaia3.png](http://faia.googlecode.com/svn/wiki/images/faiaConNetBeans/importarFaia3.png) |
| **5.** En la sección _Sources_, asegurarse que el campo _Encoding_ tenga seleccionada la opción "UTF-8". Presionar el botón _OK_.  // In section _Sources_, make sure that the field _Encoding_ has "UTF-8" selected. |
| ![http://faia.googlecode.com/svn/wiki/images/faiaConNetBeans/importarFaia4.png](http://faia.googlecode.com/svn/wiki/images/faiaConNetBeans/importarFaia4.png) |


## Configurar un proyecto para que utilice FAIA // Configuring a project to use FAIA ##

_NOTAS // NOTES:_
  * Antes de seguir estos pasos es necesario haber importado FAIA.  // Before following these steps, it is necessary to have imported FAIA.
  * Estos son pasos básicos para agregar una referencia a un proyecto para que pueda utilizar FAIA. Más abajo se dan pasos detallados para poder utilizar Búsqueda y Cálculo Situacional. // These are the basic steps to add a reference on a project to be able to use FAIA. More details to use Search and Situation Calculus are given bellow.
  * Recordar cambiar la codificación de caracteres de los proyectos recién creados a "UTF-8". Las instrucciones están en la sección para importar FAIA. // Remember to change the character codification of the recently created projects into "UTF-8". The instructions are in the section “Importing FAIA”.

| **1.** Creamos un nuevo proyecto yendo a _File -> New Project_.  // Create a new project by going to _File -> New Project_.   |
|:------------------------------------------------------------------------------------------------------------------------------|
| ![http://faia.googlecode.com/svn/wiki/images/faiaConNetBeans/configurarProyecto1.png](http://faia.googlecode.com/svn/wiki/images/faiaConNetBeans/configurarProyecto1.png) |
| **2.** En _Categories_ elegimos la opción _Java_, y luego en _Projects_ elegimos _Java Application_. Presionamos _Next_.  // In _Categories_ select the option _Java_, and then in _Projects_ choose _Java Application_. Then, press _Next_. |
| ![http://faia.googlecode.com/svn/wiki/images/faiaConNetBeans/configurarProyecto2.png](http://faia.googlecode.com/svn/wiki/images/faiaConNetBeans/configurarProyecto2.png) |
| **3.** Colocamos un nombre en el campo _Project Name_. Podemos cambiar algunas opciones del proyecto, como su ubicación (es conveniente almacenarlo en la misma carpeta padre en donde se encuentra el proyecto _faia_). Cuando finalicemos, presionamos _Finish_.  // Input a name in the field _Project Name_. It is possible to change some project options such as its location. Finally, press _Finish_.|
| ![http://faia.googlecode.com/svn/wiki/images/faiaConNetBeans/configurarProyecto3.png](http://faia.googlecode.com/svn/wiki/images/faiaConNetBeans/configurarProyecto3.png) |
| **4.** El proyecto ha sido creado. Ahora agregamos una referencia al proyecto FAIA: hacemos click derecho en _Libraries_, y elegimos _Add Project..._. // The project has been created. Now, it is necessary to add a reference to the FAIA project. Right click on _Libraries_ and select _Add Project…_.|
| ![http://faia.googlecode.com/svn/wiki/images/faiaConNetBeans/configurarProyecto4.png](http://faia.googlecode.com/svn/wiki/images/faiaConNetBeans/configurarProyecto4.png) |
| **5.** Buscamos la carpeta donde tenemos el proyecto FAIA, lo seleccionamos y presionamos _Add Project JAR Files_. // Find the folder where the project FAIA is located, then select it and press _Add Project JAR Files_.|
| ![http://faia.googlecode.com/svn/wiki/images/faiaConNetBeans/configurarProyecto5.png](http://faia.googlecode.com/svn/wiki/images/faiaConNetBeans/configurarProyecto5.png) |
| **6.** Finalmente ya podemos comenzar a utilizar FAIA en nuestro proyecto. // Finally you can start to use FAIA in your project.|
| ![http://faia.googlecode.com/svn/wiki/images/faiaConNetBeans/configurarProyecto6.png](http://faia.googlecode.com/svn/wiki/images/faiaConNetBeans/configurarProyecto6.png) |


## Configurar un proyecto para utilizar _Búsqueda_  // Configuring a project to use _Search_ ##

Ver UtilizarBusqueda. // See UsingBusqueda.


## Configurar un proyecto para utilizar _Cálculo Situacional_ // Configuring a project to use _Situation Calculus_ ##

_NOTAS // NOTES:_
  * Es necesario haber importado FAIA // It is necessary to have imported FAIA.
  * Es necesario tener instalado SWI-Prolog. En InstruccionesInstalacion se dan detalles de cómo hacerlo, ya que la instalación y configuración no es trivial. // It is necessary to have SWI-Prolog installed. The details to do this can be found in the section InstruccionesInstalacion.

| **1.** Hacemos click derecho sobre _Libraries_ en nuestro proyecto, y elegimos la opción _Add JAR/Folder_. // Right click on _Libraries_ in your project. Select _Add JAR/Folder_.|
|:-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| ![http://faia.googlecode.com/svn/wiki/images/faiaConNetBeans/prolog1.png](http://faia.googlecode.com/svn/wiki/images/faiaConNetBeans/prolog1.png) |
| **2.** Nos dirigimos al directorio del proyecto _faia_, en la carpeta _lib_, y elegimos el archivo _jpl.jar_. Presionamos _Abrir_.  // Go to the _lib_ folder in _faia_ project and select the file _jpl.jar_. |
| ![http://faia.googlecode.com/svn/wiki/images/faiaConNetBeans/prolog2.png](http://faia.googlecode.com/svn/wiki/images/faiaConNetBeans/prolog2.png) |

Con los pasos anteriores ya tenemos agregado el archivo 'jpl.jar' a nuestro classpath. Con esto ya podemos utilizar Prolog en Windows (suponiendo que ya ha sido instalado con los pasos dados en la página de instalación, modificando la variable Path de Windows como se indica allí).

After performing the previous steps we have the file 'jpl.jar' set into the classpath. Now, it is possible to use Prolog in Windows (this is valid only if Prolog has been installed following the installation procedure given in the installation page).

Con estos pasos realizados, debería ser posible poder correr proyectos que utilicen Cálculo Situacional con NetBeans. Es altamente recomendable ver el ejemplo "pacman\_logico".

With these steps, it should be possible to run the projects that use Situation Calculus with NetBeans. It is strongly recommended to see  the example "logic\_pacman".

Esta guía es para comenzar un ejemplo de cero. Si se desea correr los ejemplos de FAIA (que se pueden bajar en la sección de Downloads), es necesario, en Windows, ir a las propiedades del proyecto 'examples' y en la sección _Run_ dejar en blanco el campo _VM Options_. De esta forma NetBeans busca los binarios de SWI-Prolog siguiendo la variable de sistema PATH.

This guide is intended to start a new Calculus project from scratch. If you want to run the FAIA examples (you can download them in the Downloads section), is necessary, on Windows, change the properties of the 'examples' project. Go to the _Run_ section and leave the _VM Options_ field blank. This way NetBeans search for the SWI-Prolog binaries according to the PATH environment variable.

**En sistemas GNU/Linux**, es necesario realizar, _además_, los siguientes pasos: // In GNU/Linux, it is also necessary to follow the next steps:

  1. Hacer click derecho en el proyecto, y elegir la opción _Properties_. // Right click in the project and select the option _Properties_.
  1. En "Run", dentro de la caja de texto "VM Options" colocar: _-Djava.library.path="/usr/lib/pl-5.6.57/lib/i386-linux"_. Es importante no olvidarse de colocar las comillas dobles para indicar la ruta del directorio, y así evitarse problemas. // In "Run", inside the text box "VM Options", input: _-Djava.library.path="/usr/lib/pl-5.6.57/lib/i386-linux"_. It is important not to forget the double quotes to set the directory path.