﻿#summary Instrucciones para la instalación de FAIA tanto en Windows como en GNU/Linux. // FAIA installation instructions for Windows and GNU/Linux
#labels Featured

_NOTAS // NOTES:_:

  * Las pruebas fueron realizadas en Windows XP SP 2 y Ubuntu Linux 8.04, así como en ciertas versiones de otros programas. Si se encuentran problemas al seguir la guía, por favor dejar un comentario en esta página.
  * Tests have been performed in Windows XP SP2 and Ubuntu Linux 8.04, as well as on other software versions. Please, leave a comment on this page if any problems are found when following these instructions.

# Software necesario / Required Software #

Es muy probable que se puedan utilizar versiones más actualizadas, aunque quizá la guía no contemple por ejemplo cambios en las interfaces gráficas. Además, con estas versiones se ha probado FAIA, por lo tanto si es posible, es mejor utilizar éstas.

More updated versions are likely to be used, although changes on graphical interfaces may not be considered in this documentation. In addition, FAIA has been tested with these versions, so it is advisable to use them.

  * [NetBeans](http://www.netbeans.org/) 6.1 (es necesario tener instalado el JDK 6. Se puede bajar un bundle con NetBeans y JDK [aquí](http://java.sun.com/javase/downloads/netbeans.html) // it is necessary to have JDK 6 installed. A bundle with NetBeans and JDK can be downloaded [here](http://java.sun.com/javase/downloads/netbeans.html)).
  * [Eclipse 3.4](http://www.eclipse.org/)
  * [SWI-Prolog](http://www.swi-prolog.org/) 5.6.57.

## Software opcional // Optional Software ##

  * LaTeX (Si se desea la generación de archivos PDF con los árboles de búsqueda. La opción con Graphviz es más simple que ésta, aunque los archivos generados con LaTeX son más aptos para imprimirse en el caso de árboles de búsqueda grandes):
    * En Windows: [MiKTeX](http://miktex.org/) 2.7 (Bajar la versión "Basic").
    * En GNU/Linux: el nombre del paquete a instalar depende de la distribución utilizada. Más abajo, en la sección de instalación de MiKTeX/LaTeX se darán detalles.

  * Graphviz (Para generar archivos DOT, que luego se pueden transformar a otros formatos como PDF o JPEG de una manera más sencilla). Los archivos de instalación se pueden bajar desde la página principal del software: http://www.graphviz.org/ En Ubuntu Linux se lo puede obtener instalando el paquete 'graphviz'.

  * LaTeX (To generate PDF files with search trees. Using Graphviz is simpler than this option, although files generated with LaTeX are more suitable for printing when search trees are too big):
    * In Windows: [MiKTeX](http://miktex.org/) 2.7 (Download the “basic” version).
    * o	In GNU/Linux: the name of the package to be installed depends on the used distribution. Further details in the MiKTeX/LaTeX installation section will be given bellow.

  * Graphviz (To generate DOT files, which then can be transformed to other formats, like PDF or JPEG in an simpler way). Instalation files can be downloaded from the main page of this software: http://www.graphviz.org/ In Ubuntu Linux it can be installed with the 'graphviz' package.

## Instalación de SWI-Prolog // SWI-Prolog Installation ##

### En Windows XP // In Windows XP ###

La instalación de este software para ser utilizado por FAIA no es trivial. Luego de haber instalado SWI-Prolog con el instalador para Windows, hay que agregar a la variable de entorno PATH la ruta al directorio '_DirectorioInstalacionSWIProlog_\bin', como por ejemplo "C:\Archivos de programa\pl\bin".

After installing SWI-Prolog with the Windows’ installer, the path to the directory 'SWIPrologInstallationDirectory\bin' (for instance C:\Program Files\p\bin) has to be added to the environment variable called PATH.

Para esto:

  * Hacer click derecho en "Mi PC" y elegir la opción "Propiedades".
  * En la solapa "Opciones avanzadas", presionar el botón "Variables de entorno".
  * En la sección de "Variables de sistema", hacer doble click en la variable "Path" para editarla.
  * Aún sin haberla modificado, verificar que el contenido del campo "Valor de variable" finalice con punto y coma (;).
  * Luego agregar el path correspondiente como se ha dicho, que puede variar dependiendo de dónde se haya instalado SWI-Prolog. Abajo se puede observar una imagen.
  * Presionar el botón "Aceptar" para guardar los cambios.
  * Es necesario reiniciar el IDE (tanto Eclipse como NetBeans) para que tomen los cambios realizados.

To do this:

  * Right click on “My PC” and choose the option “Properties”.
  * In the frame “Advanced options” press the button “Environment variables”.
  * In the section “System variables”, double click on the variable “Path” to edit it.
  * Verify that the content of the field “Variable value” ends with a semicolon (;).
  * After that, add the corresponding path, which can vary depending on where SWI-Prolog has been installed. An image is shown bellow.
  * Press “Accept” to save changes.
  * It is necessary to restart the IDE (Eclipse as well as NetBeans) so that the changes can be performed.


![http://faia.googlecode.com/svn/wiki/images/instalacion/variablePath.png](http://faia.googlecode.com/svn/wiki/images/instalacion/variablePath.png)


### En GNU/Linux (Ubuntu) // In GNU/Linux (Ubuntu) ###

Para instalar SWI-Prolog en Ubuntu Linux, vamos a utilizar una versión especial que se provee en este sitio, y no la oficial de la distribución.

To install SWI-Prolog in Ubuntu Linux, it is necessary to use a special versión that is provided on this site, and not the oficial distribution.

  * Descargar el archivo "pl\_5.6.57\_i386-linux.deb" desde la [sección de Downloads](http://code.google.com/p/faia/downloads/list) de éste sitio.
  * Para realizar la instalación, es posible:
    * **Utilizar la interfaz gráfica:** hacer doble click en el archivo para instalarlo desde el "Instalador de paquetes", y luego presionar el botón "Instalar el paquete"
    * **Utilizar la línea de comandos:** abrir una termina y ubicarse en el directorio de descarga. Ejecutar el comando: _sudo dpkg -i pl\_5.6.57\_i386-linux.deb_

  * Download the file "pl\_5.6.57\_i386-linux.deb" from section  ["Downloads"](http://code.google.com/p/faia/downloads/list) on this site.
  * To perform the installation, it is possible:
    * To use the graphical interface: double click on the file to install it from the “Package installer”, and then press the button “Install package”
    * o	To use the command line: open a terminal and go to the directory where Linux was downloaded. Execute the command: _sudo dpkg -i pl\_5.6.57\_i386-linux.deb_


The RPM version can be downloaded from the [SWI-Prolog](http://www.swi-prolog.org/dl-stable.html) download site for distributions that use this kind of packages.

## Instalación de MiKTeX/LaTeX // MiKTeX/LaTeX installation ##

### En Windows XP // In Windows XP ###

La instalación de MiKTeX en Windows XP es simple como la instalación de cualquier programa. Sin embargo hay que mencionar un par de cosas:

The MiKTeX installation procedure in Windows XP is as easy as any other software installation procedure. However, it is necessary to make some comments:

  * Durante la instalación, cuando aparezca la sección de "Settings", asegurarse de que la opción "Install missing packages on-the-fly" esté seteada a "Ask me first". De esta forma MiKTeX preguntará antes de instalar automáticamente algún paquete necesario. **Para el uso en FAIA no es importante esta opción**.

  * Luego de que el instalador de MiKTeX haya finalizado, hay que instalar un paquete que por defecto no es incluído en la instalación estándar. El nombre del paquete es "pict2e". Para esto, ir a Inicio -> Programas -> MiKTeX 2.7 -> Browse Packages. Para buscar el paquete que tenemos que instalar, colocar en el campo "Name" el valor "pict2e" (sin las comillas) y presionar el botón "Filter". Elegir del resultado el paquete con ese nombre, hacer click derecho y elegir la opción "Install". El paquete se bajará de Internet y luego será instalado. Finalmente, presionar el botón "Close" cuando la instalación haya terminado.

  * During the installation procedure, when the section “Settings” appears, make sure that the option “Install missing packages on-the-fly” is set to “Ask me first”. This is necessary in order to allow MiKTeX to ask you before installing any package automatically. This option is not important to use FAIA.

  * Once the MiKTeX installing procedure has been performed, it is necessary to install a package that is not included by default in the standard installation procedure. The name of the package is “pict2e”. In order to do this it is necessary to go to the menu Start -> Programs -> MiKTeX 2.7 -> Browse Packages. In the field “Name” input the value “pict2e” (without quotes) and press “Filter”. Choose the package with that name, right click, and select the option “Install”. The package will be downloaded from the internet and then it will be installed. Finally, press “Close” when the installation procedure is completed.


### En GNU/Linux (Ubuntu) // In GNU/Linux (Ubuntu) ###

Para instalar LaTeX en Ubuntu son necesarios los siguientes paquetes (TODO: Hay que corroborar que estos paquetes sean suficientes y necesarios):

The following packages are necessary to install LaTeX in Ubuntu:

  * texlive-latex-extra
  * texlive-latex-recommended
  * texlive-fonts-recommended

# FAIA desde Eclipse y NetBeans // Using FAIA with Eclipse and NetBeans #

Se pueden encontrar instrucciones de cómo usar FAIA en la wiki del proyecto: tanto para [Eclipse](http://code.google.com/p/faia/wiki/FaiaConEclipse) como para [NetBeans](http://code.google.com/p/faia/wiki/FaiaConNetbeans).

The instructions to use FAIA with [Eclipse](http://code.google.com/p/faia/wiki/FaiaConEclipse) and [NetBeans](http://code.google.com/p/faia/wiki/FaiaConNetbeans) can be found in the project wiki.


# Instalar FAIA // Installing FAIA #

Si bien los detalles para importar FAIA en Eclipse o NetBans están en sus respectivas páginas wiki, aquí se dan unas breves instrucciones para armar correctamente la estructura de directorios al descomprimir los archivos de FAIA y los ejemplos:

Brief instructions are given here to correctly organize the directory structure of FAIA and the examples that use FAIA. More details to import FAIA into Eclipse and NetBeans are given in their corresponding wiki pages:

  1. Crear una carpeta para almacenar FAIA y los ejemplos.
  1. Descomprimir el contenido **exacto** de los archivos correspondientes a FAIA y a los ejemplos en esa misma carpeta. La estructura final debería ser similar a la imagen que se muestra abajo.

  1. Create a folder to store FAIA and its examples.
  1. Decompress the precise content of the files corresponding to FAIA and its examples in the folder created in the previous step. The final structure should be similar to the one that is shown in the image bellow.


| Estructura de directorios  // Directory structure |
|:--------------------------------------------------|
| ![http://faia.googlecode.com/svn/wiki/images/instalacion/estructura_directorios_faia.png](http://faia.googlecode.com/svn/wiki/images/instalacion/estructura_directorios_faia.png) |