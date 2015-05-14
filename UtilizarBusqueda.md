## Configurar nuestro proyecto para que utilice Búsqueda ##

Para comenzar a utilizar estrategias de Búsqueda simplemente se deben especializar las clases que correspondan, proveídas por el framework FAIA. Para aprender cómo hacerlo, es conveniente observar los ejemplos incluidos.

Vale aclarar aquí una cuestión. Cuando se corre un proyecto que utiliza alguna estrategia de Búsqueda con FAIA, es posible indicarle al framework que genere cierto tipo de salidas sobre la corrida, para poder observar luego el funcionamiento interno del agente, esto es, el árbol de búsqueda generado. FAIA provee dos tipos de salidas:

  * Archivos **XML**, que se almacenan en el directorio "searchTrees" dentro de la carpeta del proyecto.
  * Archivos **PDF** (esta opción está _obsoleta_, ver la siguiente opción que utiliza Graphviz), que muestran de una forma gráfica los árboles generados durante el proceso de búsqueda. Se almacenan en el directorio "pdfLatex" de la carpeta del proyecto. Esta opción utiliza LaTeX. En la página de instrucciones de instalación hay una guía para su instalación en Windows y GNU/Linux.
  * Archivo **DOT**: esta opción es más sencilla que utilizar LaTeX para generar archivos PDF. Aquí se utiliza Graphviz para generar una representación de los árboles en el lenguaje DOT, que se almacenan en la carpeta "searchGVTrees". Luego de que se generen los archivos DOT, éstos se pueden pasar a varios formatos, como JPEG o PDF de una manera sencilla. Aunque la opción con LaTeX genera archivos PDF aptos para ser impresos.

Para configurar el agente y obtener alguna de estas salidas, se puede utilizar el método _setVisibleTree_ de la clase _Search_. En el ejemplo del Pacman esta opción es seteada en el método _selectAction_ de la clase _AgentePacman:_

```
Search busqueda = new Search(estrategiaBusqueda);

// Indica que el árbol de búsqueda debe ser mostrado en formato PDF
busqueda.setVisibleTree(Search.PDF_TREE);
```


## Generar archivos PDF en una estrategia de Búsqueda ##

Si se ha configurado FAIA para generar un PDF, entonces la carpeta "pdfLatex" luce de esta forma:

![http://faia.googlecode.com/svn/wiki/images/busqueda/carpetaPdflatex.png](http://faia.googlecode.com/svn/wiki/images/busqueda/carpetaPdflatex.png)

En Eclipse por ejemplo, la salida de ejecución será algo parecido a esto:

![http://faia.googlecode.com/svn/wiki/images/busqueda/salidaEclipse.png](http://faia.googlecode.com/svn/wiki/images/busqueda/salidaEclipse.png)

Los archivos .tex son archivos de LaTeX, y no son importantes. Son eliminados al finalizar la compilación de los mismos a PDF. En el directorio "pdfLatex", como se puede ver en la imagen mostrada antes, sólo se mantienen los archivos PDF.

[En éste enlace](http://faia.googlecode.com/svn/wiki/images/busqueda/arbolGenerado.pdf) se puede bajar un archivo PDF de ejemplo. La lectura del mismo debe realizarse de izquierda a derecha, de arriba hacia abajo.

De esta forma, en el PDF de ejemplo, si observamos a la izquierda arriba, veremos un subárbol en el que su nodo padre tiene su "Execution Order" (EO) igual a 0 (o sea, es el primer nodo creado, y el que representa el estado actual del agente). Allí podemos ver que el agente ha aplicado 4 operaciones posibles sobre el mismo (Izquierda, Arriba, Derecha y Abajo), generando 4 nodos más. Observar que el costo del nodo inicial (EO = 0) es 0 (cero), en cambio sus hijos tienen un valor de -1. Esto es así porque se utiliza una estructura tipo lista ordenada para todas las estrategias, y para simular el comportamiento de una pila (que es la estructura que deberíamos utilizar para almacenar los nodos expandidos en "Primero en Profundidad") el costo de los nodos hijos es una unidad menos que el padre.

En el subárbol de la derecha, podemos observar que el nodo padre del mismo es aquel con EO igual a 1. O sea, es el nodo que se ha generado al aplicar el operador Izquierda sobre el nodo 0 (EO = 0). De esta forma entendemos que nuestra estrategia de búsqueda ha escogido ese nodo para expandir en el paso siguiente. Observar que esta vez se aplicaron 3 operadores: Izquierda, Arriba y Abajo.

Luego podemos ver que el agente ha escogido los nodos: 5, 8, 11, 14, 17, 19, 22, etc... terminando su ejecución en el nodo 40, donde ha llegado al objetivo. Por lo tanto, la acción que va a tomar es la que indica el nodo EO = 1: Izquierda.


## Generar archivos DOT ##

Esta es la manera recomendada de generar archivos gráficos desde los árboles de búsqueda. Para generar archivos DOT es necesario utilizar la opción "GRAPHVIZ\_TREE" en el método 'setVisibleTree' como se muestra a continuación:

```
searchSolver.setVisibleTree(Search.GRAPHVIZ_TREE);
```

Cuando se utiliza esta opcion, de una manera similar a LaTeX, se generan archivos DOT en el directorio "searchGVTrees". El paso siguiente para transformar éstos archivos en otro formato como JPEG, es utilizar el comando **dot** (o la utilidad Gvedit si se lo utiliza desde Windows). Por ejemplo, el siguiente comando en una terminal en GNU/Linux genera un archivo JPEG desde el archivo "0.dot" de un árbol de búsqueda:

```
$ dot -Tjpg 10.dot -o 10.jpg
```

El mismo se puede observar en la imagen siguiente:

![http://faia.googlecode.com/svn/wiki/images/busqueda/graphviz.jpg](http://faia.googlecode.com/svn/wiki/images/busqueda/graphviz.jpg)

Existen mucho más formatos de salida (como PDF), además de otras opciones. Se puede leer la documentación de Graphviz.

Como se dijo antes, en sistemas Windows se puede utilizar Gvedit, una vez instalado Graphviz en el sistema. Se debe abrir el archivo DOT generado y ejecutar la opción _Run_. En el diálogo que aparece se pueden elegir las opciones de salida.

Si se requiere cambiar las etiquetas de los nodos en el árbol (por ejemplo, si se quiere mostrar más información), se pueden modificar los archivos de código fuente relacionados con la generación de los árboles de búsqueda en el lenguaje DOT. Este código se encuentra en las siguientes clases y métodos:

  * Clase _GraphvizTree_ en el paquete _frsf.cidisi.faia.util_
  * Método _toGraphviz()_ en la clase _NTree_ (paquete _frsf.cidisi.faia.solver.search_).
  * Método _showTree()_ en la clase _Search_ (paquete _frsf.cidisi.faia.solver.search_)




## Configuring a project to use Search Strategies ##

To begin using simple search strategies, some classes provided by the framework must be specialized. When there is a project that uses a search strategy from FAIA, you can tell the framework to create two kind of outputs, to observe the inner functioning of the agent, such as the search tree generated. FAIA provides two types of outputs:

  * XML files that are stored in the directory "searchTrees" within the project folder.
  * PDF files (this option is _deprecated_, see the next option which uses Graphviz), which show a graphical representation of the trees generated during the search process. They are stored in the "pdflatex" folder from the project folder. This option uses LaTeX. On the second page of instructions there is a guide for installation on Windows and GNU/Linux.
  * **DOT** files: this is a simpler option than using LaTeX to generate PDF files. Here Graphviz is used to generate a tree's representation in the DOT language, which will be stored in the "searchGVTrees" folder. After the DOT files were generated, these can be transformed to other formats, like JPEG or PDF in an easy way. Although the LaTeX option generate more suitable PDF files for printing.

To configure an agent and to get some of these output, you can use the method _setVisibleTree_ in the _Search_ class. In the Pacman example, this option is set on the _selectAction_ from the _AgentePacman\_class:_


```
Search busqueda = new Search(estrategiaBusqueda);

// Show search tree in PDF file
busqueda.setVisibleTree(Search.PDF_TREE);
```


## Generating PDF files for the Search strategies ##

If FAIA has been set to generate a PDF-tree, the folder "pdfLatex" should look like:

![http://faia.googlecode.com/svn/wiki/images/busqueda/carpetaPdflatex.png](http://faia.googlecode.com/svn/wiki/images/busqueda/carpetaPdflatex.png)

In Eclipse, the execution output will look like:

![http://faia.googlecode.com/svn/wiki/images/busqueda/salidaEclipse.png](http://faia.googlecode.com/svn/wiki/images/busqueda/salidaEclipse.png)

The .tex file are LaTeX files. They are eliminated once their compiling to PDF is finished. The "pdfLatex" folder only contains the resulting PDF files.

[In this link](http://faia.googlecode.com/svn/wiki/images/busqueda/arbolGenerado.pdf) you may find a PDF example file (it should be read from left to right, from top to bottom).

This way, in the PDF example, if you look at the top left, you will see a sub-tree whose parent node is "Execution Order" (EO) equal to 0 (that is to say, the first node is created, and that represents the current state of the agent). You can see that the agent has applied 4 operations on its current state (goLeft, goUp, goRight and goDown), generating 4 nodes. Observe that the cost of the initial node (EO = 0) is 0 (zero), however their children have a value of -1. This is because it uses a standard data structure, an ordered list, for all implemented search strategies, and to simulate the behavior of a stack (which is the structure that should be used, for example, to store nodes to be expanded in the Depth-First strategy) where the cost of a child node is a unit less than the father one.

In the right subtree, we can see that its parent node is the one with the same EO equal to 1. Therefore, it is the node that is generated by applying the operator goLeft to the node 0 (EO = 0). In this way it can be seen that the search strategy has chosen to expand this node in the next iteration. Observe that this time, 3 operators haven been applied: goLeft, goUp and goDown.

After that, it can be seen that the agent has chosen the nodes 5, 8, 11, 14, 17, 19, 22, etc ... stopping execution on node 40, where it has reached its goal.


## Generate DOT files with Graphviz ##

This is the recommended way to generate graphic files from the search trees. To generate DOT files is necessary to use the "GRAPHVIZ\_TREE" option in the 'setVisibleTree' method as shown above:

```
searchSolver.setVisibleTree(Search.GRAPHVIZ_TREE);
```

When this option is used, similar to LaTeX, DOT files are generated in the "searchGVTrees" folder. The next step to transform these in other format like JPEG, is using the **dot** command (or the Gvedit utility if you are in Windows). For example, the next command in a GNU/Linux terminal generates a JPEG image from the "0.dot" file:

```
$ dot -Tjpg 10.dot -o 10.jpg
```

As can be seen in the next image:

![http://faia.googlecode.com/svn/wiki/images/busqueda/graphviz.jpg](http://faia.googlecode.com/svn/wiki/images/busqueda/graphviz.jpg)

There are other posible output formats (like PDF), as well as other options. You can read the documentation of Graphviz.

As said before, in Windows you can use Gvedit, after Graphviz is installed in the system. You can open the DOT file and execute the _Run_ command. A dialog appears where you can change the output options.

If you need to change the labels of the nodes in the tree (for example, if you want to show more information), you can modify the source files related to the generation of search trees in the DOT language. This code can be found in the next classes and methods:

  * _GraphvizTree_ class in _frsf.cidisi.faia.util_ package.
  * _toGraphviz()_ method in the _NTree_ class (_frsf.cidisi.faia.solver.search_ package).
  * _showTree()_ method in the _Search_ class (_frsf.cidisi.faia.solver.search_ package)