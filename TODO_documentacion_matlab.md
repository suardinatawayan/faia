# Cosas para no olvidar al documentar sobre Matlab #

  * En linux hay que instalar el paquete csh para que funcionen las librerías que usan en Engine de Matlab.
  * LD\_LIBRARY\_PATH=/opt/matlab/bin/glnx86/:/opt/matlab/sys/os/glnx86/
  * En Eclipse, poner en la opción VM arguments del proyecto: -Djava.library.path="." para que encuentre la dll de jmathlink en el directorio del proyecto (típicamente "examples").