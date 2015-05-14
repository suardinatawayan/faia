# ¿Qué es FAIA?  ¿What is FAIA? #
FAIA es un framework para el desarrollo de aplicaciones de interés académico que utilizan técnicas de Inteligencia Artificial (IA). El objetivo del mismo es permitir que el alumno pueda enfocarse en modelar y resolver el problema desde el punto de vista de la IA facilitando el proceso de implementación de la aplicación. Para lograr esto FAIA dispone de un conjunto de clases y algoritmos que deben ser utilizados y/o extendidos por el alumno. Se puede encontrar información más detallada en el paper FAIA: Framework para la enseñanza de agentes en IA, que se encuentra en la [página de la cátedra](http://www.frsf.utn.edu.ar/matero/visitante/index.php?id_catedra=142) en la sección "Repositorio".


FAIA is a framework for academic application development using Artificial Intelligence (AI)technique. The aim is to enable the student can focus on modeling and solving the problem from the point of view of AI to facilitate the process of implementing the application. To accomplish this goal, FAIA has a set of classes and algorithms that must be used and / or extended by the student. You can find more detailed information in the paper FAIA: Framework for teaching agents in AI, which is in the http://www.frsf.utn.edu.ar/matero/visitante/index.php?id_catedra=142 in the section "repositorio".


# ¿Cómo puedo obtener FAIA?  How can I obtain FAIA? #
La página principal del proyecto es esta: http://code.google.com/p/faia/
En la sección de [Downloads](http://code.google.com/p/faia/downloads/list) se pueden bajar las últimas versiones estables y el software relacionado. También se puede acceder a la versión en desarrollo en el [repositorio Subversion](http://code.google.com/p/faia/source/checkout).

The proyect URL is: http://code.google.com/p/faia/ in the downloads section you can download the last version and the related software. Also, you can access to the development version at [Subversion repository ](http://code.google.com/p/faia/source/checkout).

# ¿Cómo importar FAIA en Eclipse o NetBeans? How can I import FAIA in Eclipse or NetBeans? #
En la [wiki](http://code.google.com/p/faia/w/list) se pueden encontrar documentos que explican como importar FAIA y utilizarlo, tanto para [Eclipse](http://code.google.com/p/faia/wiki/FaiaConEclipse) como para [Netbeans](http://code.google.com/p/faia/wiki/FaiaConNetbeans).

In the [wiki](http://code.google.com/p/faia/w/list) you can find documents that explain how to import FAIA from Eclipse [Eclipse](http://code.google.com/p/faia/wiki/FaiaConEclipse) and from netBeans [Netbeans](http://code.google.com/p/faia/wiki/FaiaConNetbeans)



# ¿Hay algún ejemplo disponible que me permita ver cómo utilizar FAIA? Are there examples available? #
Si, hay ejemplos disponibles en los releases en la página de Downloads o accediendo al código disponible en el repositorio Subversion (aunque es recomendable utilizar las versiones estables). Hay ejemplos que demuestran la funcionalidad de FAIA en los enfoques de Búsqueda y Calculo Situacional.

El de '''Búsqueda''' es una versión simplificada del juego "Pacman". El enunciado del ejemplo lo pueden encontrar en la sección "Trabajos prácticos" de la cátedra de [Inteligencia Artificial](http://www.frsf.utn.edu.ar/matero/visitante/index.php?id_catedra=142&ver=12). Para correr y probar los ejemplos, es necesario seguir una serie de pasos detallados en la wiki. Hay instrucciones tanto para Eclipse como para Netbeans.

El ejemplo de '''Cálculo Situacional''' es el mismo problema que el "Pacman" mencionado en el párrafo anterior, pero utilizando Prolog para resolverlo.


Yes. There are examples available in the Downloads page or in the Subversion repository. The examples use search and Situation Calculus strategies.

The example that uses Search, is a more simple Pac-man version. The practical work that explain the problem is available in [Artificial Inteligence](http://www.frsf.utn.edu.ar/matero/visitante/index.php?id_catedra=142&ver=12). To execute the examples, follow the instructions given in "instalation guide" in the wiki.

The example that uses situation calculus is the same problem as Pacman mentioned previusly. This example uses Prolog for solve the problem.

# ¿Qué contienen los ejemplos? What is the content of the examples? #
El ejemplo de Búsqueda contiene la solución al problema del “Pacman”. Esta compuesta por:

  * Operadores: Comer.java, IrAbajo.java, IrArriba.java, IrDerecha.java, IrIzquierda.java, Pelear.java.
  * Agente: AgentePacman.java, EstadoPacman.java
  * Ambiente: AmbientePacman.java, EstadoAmbiente.java
  * Meta: MetaPacman.java
  * Clase principal (Main): Pacman.java

The examples include the problem solution and contains:
  * Agent definition: AgentePacman.java, EstadoPacman.java
  * operators: comer.java, IrAbajo.java, IrArriba.java, IrDerecha.java, IrIzquierda.java, Pelear.java
  * Environment definition: AmbientePacman.java, EstadoAmbiente.java
  * goal: MetaPacman.java
  * main method: Pacman.java

# ¿Cómo se ejecuta el ejemplo?  How can I execute the examples? #
Las instrucciones están en la wiki, tanto para Eclipse como para Netbeans.

Follow the instruction in the wiki page "instalation guide"

# ¿Cómo debo configurar Eclipse o Netbeans para que mi proyecto utilice FAIA? How do I have to configure Eclipse or Netbeans in my proyecto in order to use FAIA? #
Las instrucciones están en la wiki, tanto para Eclipse como para Netbeans.

The instructions are in the wiki page: "FAIAconEclipse" and "FAIAconNetBeans" sections.

# ¿Cómo puedo exportar mi proyecto para utilizarlo en el Java Lab? #
_TODO:_ Indicar las instrucciones tanto para Eclipse (ya están en la FAQ versión PDF) como para Netbeans.