**LEER ANTES DE CONTINUAR:** Antes de seguir estos pasos es necesario leer [las instrucciones de instalación](http://code.google.com/p/faia/wiki/InstruccionesInstalacion).

**READ BEFORE CONTINUING:** Read the [installation instructions](http://code.google.com/p/faia/wiki/InstruccionesInstalacion) before continuing.


## Importar FAIA / Importing FAIA ##

_NOTAS // NOTES:_
  * Es importante, antes de continuar, haber leído la sección "Instalar FAIA" de la [página de instrucciones de instalación](http://code.google.com/p/faia/wiki/InstruccionesInstalacion). // It is important to read the [installation instructions](http://code.google.com/p/faia/wiki/InstruccionesInstalacion) section before continuing.
  * Estas instrucciones de importación de FAIA se aplican también para los ejemplos, ya que los pasos son muy similares. // These installation instructions are also useful for importing the FAIA examples. The steps to do this are quite similar.
  * Se pone especial énfasis en configurar correctamente la codificación de caracteres de cada proyecto importado o creado, como se indica en uno de los pasos siguientes, ya que de otro modo surgirán errores. // It is necessary to pay attention to the character codification of every imported project, as it is shown in the next steps. Otherwise, errors can occur.

| **1.** Ir al menú _File -> Import..._ // Go to menu _File -> Import..._ |
|:-------------------------------------------------------------------------|
| ![http://faia.googlecode.com/svn/wiki/images/faiaConEclipse/importarFaia1.png](http://faia.googlecode.com/svn/wiki/images/faiaConEclipse/importarFaia1.png) |
| **2.** Elegir la opción _Existing Projects into Workspace_ ubicada dentro de _General_. Luego presionar _Next_. // Select the option _Existing Projects into Workspace_ in _General_. Then, press _Next_.|
| ![http://faia.googlecode.com/svn/wiki/images/faiaConEclipse/importarFaia2.png](http://faia.googlecode.com/svn/wiki/images/faiaConEclipse/importarFaia2.png) |
| **3.** Elegir la opción _Select archive file_, y presionar el botón _Browse_. // Select the option _Select archive file_, and then, press _Browse_. |
| ![http://faia.googlecode.com/svn/wiki/images/faiaConEclipse/importarFaia3.png](http://faia.googlecode.com/svn/wiki/images/faiaConEclipse/importarFaia3.png) |
| **4.** Navegar hacia la carpeta donde fue descargado FAIA y elegir el archivo. Presionar en _Abrir_. // Go to the folder where FAIA has been downloaded and select the file. Then, press _Open_.|
| ![http://faia.googlecode.com/svn/wiki/images/faiaConEclipse/importarFaia4.png](http://faia.googlecode.com/svn/wiki/images/faiaConEclipse/importarFaia4.png) |
| **5.** Asegurarse que en la lista de abajo titulada _Projects_ se encuentra activado el proyecto _faia_, y presionar _Finish_. // Make sure the project _faia_ is selected in the list _Projects_ .|
| ![http://faia.googlecode.com/svn/wiki/images/faiaConEclipse/importarFaia5.png](http://faia.googlecode.com/svn/wiki/images/faiaConEclipse/importarFaia5.png) |
| **6.** El proyecto ha sido importado. Ahora es necesario **cambiar la codificación de caracteres** de _faia_. Hacemos click derecho en el proyecto y elegimos _Properties_. // The project has been imported. Now, it is necessary **to change the _faia_ character codification**. Right click on project and select _Properties_. |
| ![http://faia.googlecode.com/svn/wiki/images/faiaConEclipse/importarFaia6.png](http://faia.googlecode.com/svn/wiki/images/faiaConEclipse/importarFaia6.png) |
| **7.** En la sección _Resource_ dentro del marco _Text file encoding_ activamos la opción _Other_, y de la lista desplegable elegimos la opción _UTF-8_. Presionamos el botón _Apply_ y luego _OK_. // In section _Resource_, within the frame _Text file encoding_ it is necessary to check the option _Other_, and then, select the option _UTF-8_. Press _Apply_ and then _Ok_. |
| ![http://faia.googlecode.com/svn/wiki/images/faiaConEclipse/importarFaia7.png](http://faia.googlecode.com/svn/wiki/images/faiaConEclipse/importarFaia7.png) |


## Configurar un proyecto para que utilice FAIA // Configuring a project to use FAIA ##

_NOTAS // NOTES:_
  * Antes de seguir estos pasos es necesario haber importado FAIA // It is necessary to have imported FAIA before following these steps.
  * Estos son pasos básicos para agregar una referencia a nuestro proyecto para utilizar FAIA. Más abajo se dan pasos detallados para poder utilizar Búsqueda y Cálculo Situacional. // These are the basic steps to add a reference on a project to be able to use FAIA. More details to use Search and Situation Calculus are given bellow.
  * Recordar cambiar la codificación de caracteres de los proyectos recién creados a "UTF-8". Las instrucciones están en la sección para importar FAIA. Remember to change the character codification of the recently created projects into "UTF-8". The instructions are in the section “Importing FAIA”.

| **1.** Creamos un nuevo proyecto yendo a _File -> New -> Java Project_. // To create a new project, go to _File -> New -> Java Project_. |
|:-----------------------------------------------------------------------------------------------------------------------------------------|
| ![http://faia.googlecode.com/svn/wiki/images/faiaConEclipse/configurarProyecto1.png](http://faia.googlecode.com/svn/wiki/images/faiaConEclipse/configurarProyecto1.png) |
| **2.** Colocamos un nombre al mismo y presionamos _Next_. // Input a name and press _Next_|
| ![http://faia.googlecode.com/svn/wiki/images/faiaConEclipse/configurarProyecto2.png](http://faia.googlecode.com/svn/wiki/images/faiaConEclipse/configurarProyecto2.png) |
| **3.** Hacer click en la solapa _Projects_ y presionar el botón _Add_. // Click on the frame _Projects_ and press _Add_. |
| ![http://faia.googlecode.com/svn/wiki/images/faiaConEclipse/configurarProyecto3.png](http://faia.googlecode.com/svn/wiki/images/faiaConEclipse/configurarProyecto3.png) |
| **4.** Elegir _faia_ y presionar el botón _OK_. // Select _faia_ and press _OK_. |
| ![http://faia.googlecode.com/svn/wiki/images/faiaConEclipse/configurarProyecto4.png](http://faia.googlecode.com/svn/wiki/images/faiaConEclipse/configurarProyecto4.png) |
| **5.** Ahora nuestro proyecto referencia a _faia_. Hacer click en el botón _Finish_.  // Click on _Finish_. |
| ![http://faia.googlecode.com/svn/wiki/images/faiaConEclipse/configurarProyecto5.png](http://faia.googlecode.com/svn/wiki/images/faiaConEclipse/configurarProyecto5.png) |
| **6.** Finalmente ya podemos comenzar a utilizar FAIA en nuestro proyecto. // Finally, you can use FAIA. |
| ![http://faia.googlecode.com/svn/wiki/images/faiaConEclipse/configurarProyecto6.png](http://faia.googlecode.com/svn/wiki/images/faiaConEclipse/configurarProyecto6.png) |

Si nuestro proyecto ya ha sido creado, la forma de referenciar _faia_ es siguiendo estos pasos: // If the project has already been created, a reference can be made to _faia_ by following these steps:

  1. Hacer click derecho en nuestro proyecto, y elegir _Build Path -> Configure Build Path_. // Right click on your project. Select _Build Path -> Configure Build Path_.
  1. En la solapa _Projects_ hacer click en el botón _Add_. // Select the frame _Projects_ and click _Add_.
  1. De la lista, elegir el proyecto _faia_ y hacer click en el botón _OK_. // Select the project _faia_ from the list and click _Ok_.
  1. Hacer click en _OK_. // Click _Ok_.


## Configurar un proyecto para utilizar _Búsqueda_ // Configuring a project to use _Search_ ##

Ver UtilizarBusqueda // See the section [Using Search](http://code.google.com/p/faia/wiki/UtilizarBusqueda).


## Configurar un proyecto para utilizar _Cálculo Situacional_ // Configuring a project to use _Situation Calculus_ ##

_NOTAS // NOTES:_
  * Es necesario haber importado FAIA. // It is necessary to have imported FAIA before following these steps.
  * Es necesario tener instalado SWI-Prolog. En InstruccionesInstalacion se dan detalles de cómo hacerlo, ya que la instalación y configuración no es trivial. // It is necessary to have SWI-Prolog installed. Instructions to do this are shown [here](http://code.google.com/p/faia/wiki/InstruccionesInstalacion).

Si se ha instalado SWI-Prolog e importado FAIA correctamente, entonces nuestro proyecto que utiliza Cálculo Situacional ya debería funcionar en Windows. Es altamente recomendable ver el ejemplo "pacman\_logico". // If SWI-Prolog has been correctly installed and FAIA has been correctly imported, the project that uses Situation Calculus should be working in Windows. We recommend to check the example “logic\_pacman” .

**En sistemas GNU/Linux**, es necesario realizar los siguientes pasos // In GNU/Linux systems, it is necessary to follow the next steps:

  1. Hacer click derecho en nuestro proyecto y elegir la opción _Run As -> Run Configurations_. // Right click on the project and select the option _Run As -> Run Configurations_.
  1. En la lista de la izquierda, hacer click derecho en _Java Application_, y elegir la opción _New_. // On the left list, right click _Java Application_, and select _New_.
  1. Se puede colocar algún nombre en el campo _Name_. // Input a name in the field _Name_
  1. Establecer correctamente la clase principal (Main class) haciendo click en el botón _Search_. // Establish the main class correctly by clicking on _Search_.
  1. En la solapa _Arguments_, en la caja de texto _VM arguments_, colocar: _-Djava.library.path="/usr/lib/pl-5.6.57/lib/i386-linux"_. Es importante no olvidarse de colocar las comillas dobles para indicar la ruta del directorio, y así evitarse problemas. // In the frame _Arguments_, in _VM arguments_ input: _-Djava.library.path="/usr/lib/pl-5.6.57/lib/i386-linux"_. Do not forget double quotation marks to indicate the path.
  1. Presionar el botón _Apply_. // Press _Apply_.
  1. Presionar el botón _Run_ para correr el proyecto. // Press _Run_ to run the project.