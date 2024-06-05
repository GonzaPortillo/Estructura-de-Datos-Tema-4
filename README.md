# Estructuras no lineales

## Indice 
1. [Introduccion](https://github.com/GonzaPortillo/Estructura-de-Datos-Tema-4?tab=readme-ov-file#introduccion)
2. [Investigacion](https://github.com/GonzaPortillo/Estructura-de-Datos-Tema-4/blob/main/README.md#investigacion)
    * [Arboles](https://github.com/GonzaPortillo/Estructura-de-Datos-Tema-4/blob/main/README.md#arboles)
    * [Grafos](https://github.com/GonzaPortillo/Estructura-de-Datos-Tema-4/blob/main/README.md#grafos)
3. [Implementacion en Java](https://github.com/GonzaPortillo/Estructura-de-Datos-Tema-4/blob/main/README.md#implementación-en-java)
    * [Arboles](https://github.com/GonzaPortillo/Estructura-de-Datos-Tema-4/edit/main/README.md#arboles-1)
    * [Grafos (Algoritmo de Dijkstra)](https://github.com/GonzaPortillo/Estructura-de-Datos-Tema-4/edit/main/README.md#grafos-algoritmo-de-dijkstra)
4. [Conclusión](https://github.com/GonzaPortillo/Estructura-de-Datos-Tema-4/edit/main/README.md#conclusion)

## Introduccion
En el campo de las estructuras de datos, los árboles y los grafos son dos conceptos fundamentales que permiten organizar y representar relaciones entre datos de manera eficiente y flexible. Estas estructuras juegan un papel crucial en una amplia gama de aplicaciones informáticas, desde la organización de datos en bases de datos hasta la representación de redes complejas en sistemas de transporte. Los árboles son estructuras jerárquicas que consisten en nodos interconectados de una manera específica. Cada nodo en un árbol tiene un padre (excepto el nodo raíz) y cero o más hijos. Los árboles se utilizan comúnmente para representar relaciones de jerarquía, como la estructura de un sistema de archivos o la organización de elementos en un árbol genealógico. Además, los árboles binarios, donde cada nodo tiene como máximo dos hijos, son especialmente importantes en algoritmos de búsqueda y ordenación. 

Por otro lado, los grafos son estructuras más generales que representan relaciones entre un conjunto de elementos. Un grafo consta de un conjunto de vértices (o nodos) y un conjunto de aristas que conectan estos vértices. Los grafos pueden ser dirigidos, donde las aristas tienen una dirección, o no dirigidos, donde las aristas no tienen dirección. Además, los grafos pueden tener pesos asociados a sus aristas, lo que permite representar costos o distancias entre los vértices. En este documento, desarrollaremos código en el lenguaje Java dónde haremos implementaciones de árboles y grafos.

## Investigacion

### Arboles 
Es una estructura de datos jerárquica que consta de nodos conectados entre sí de manera organizada. La estructura de árbol se caracteriza por tener un nodo especial llamado "nodo raíz" desde el cual se ramifican otros nodos, y cada nodo puede tener cero o más "nodos hijos", que a su vez pueden tener sus propios hijos y así sucesivamente.

Operaciones básicas
* Inserción: Agregar un nuevo nodo al árbol.
* Búsqueda: Buscar un valor específico en el árbol.
* Eliminación: Eliminar un nodo específico del árbol.
* Recorridos: Visitar todos los nodos del árbol en un orden específico, como preorden, inorden y postorden.
* Altura: Calcular la altura del árbol, es decir, la longitud del camino más largo desde la raíz hasta una hoja.
* Tamaño: Contar el número total de nodos en el árbol.
* Búsqueda del mínimo y máximo: Encontrar el valor más pequeño y el más grande en el árbol, respectivamente.
* Verificación de vacío: Comprobar si el árbol está vacío o no.

### Grafos
Es una estructura de datos que se utiliza para representar relaciones entre objetos. Consiste en un conjunto de nodos (también llamados vértices) que están conectados entre sí mediante enlaces (también llamados aristas). Cada arista puede tener una dirección (grafo dirigido) o no tenerla (grafo no dirigido).

Operaciones básicas:
* Agregar un nodo: Permite añadir un nuevo nodo al grafo.
* Eliminar un nodo: Elimina un nodo existente del grafo, junto con todas las aristas asociadas a él.
* Agregar una arista: Añade una arista que conecta dos nodos existentes en el grafo. Dependiendo del tipo de grafo (dirigido o no dirigido), la arista puede tener una dirección específica o no.
* Eliminar una arista: Elimina una arista existente del grafo, rompiendo la conexión entre dos nodos.
* Verificar la existencia de un nodo: Permite verificar si un nodo específico está presente en el grafo.
* Verificar la existencia de una arista: Permite verificar si existe una arista que conecta dos nodos específicos en el grafo.
* Obtener los vecinos de un nodo: Devuelve una lista de nodos adyacentes a un nodo específico en el grafo. En un grafo dirigido, esto puede incluir los nodos que son sucesores o predecesores del nodo.
* Recorrer el grafo: Permite visitar todos los nodos y aristas del grafo, ya sea en profundidad (DFS) o en anchura (BFS), con el fin de realizar tareas como búsqueda de caminos, análisis de componentes conectados, etc.

## Implementación en Java

### Arboles 

    class Nodo {
        char valor;
        Nodo izquierda, derecha;

        public Nodo(char item) {
            valor = item;
            izquierda = null;
            derecha = null;
        }
    }

    class Arbol {
        Nodo raiz;

        public Arbol() {
            raiz = null;
        }

        void preOrden(Nodo nodo) {
            if (nodo != null) {
                System.out.print(nodo.valor);
                preOrden(nodo.izquierda);
                preOrden(nodo.derecha);
            }
        }

        void inOrden(Nodo nodo) {
            if (nodo != null) {
                inOrden(nodo.izquierda);
                System.out.print(nodo.valor);
                inOrden(nodo.derecha);
            }
        }

        void PostOrden(Nodo nodo) {
            if (nodo != null){
                PostOrden(nodo.izquierda);
                PostOrden(nodo.derecha);
                System.out.print(nodo.valor);
            }
        }

        public Nodo construirArbol(String postfix) {
            Stack<Nodo> pila = new Stack<>();
            Nodo nodo, izquierda, derecha;

            for (int i = 0; i < postfix.length(); i++) {
                char c = postfix.charAt(i);

                if (Character.isLetterOrDigit(c)) {
                    nodo = new Nodo(c);
                    pila.push(nodo);
                } else {
                    nodo = new Nodo(c);
                    derecha = pila.pop();
                    izquierda = pila.pop();
                    nodo.derecha = derecha;
                    nodo.izquierda = izquierda;
                    pila.push(nodo);
                    nodo = pila.peek();
                    pila.pop();
                }
            }
            return nodo;
        }
    }

    public class Main {
        public static void main(String[] args) {
            Arbol arbol = new Arbol();
            String expresion = "a+b*c-d/e";
            String postfix = arbol.infixToPostfix(expresion);
            Nodo raiz = arbol.construirArbol(postfix);
        
            System.out.println("Recorrido en preorden del árbol:");
            arbol.preOrden(raiz);
        
            System.out.println("Recorrido en inorden del árbol:");
            arbol.inOrden(raiz);
        
            System.out.println("Recorrido en postorden del árbol:");
            arbol.postOrden(raiz);
        
            System.out.println("De infix a postfix:");
            System.out.print(arbol.infixToPostfix("a+b*c-d/e"));
        }
    }
### Grafos (Algoritmo de Dijkstra)

    public class Dijkstra {

      public static void dijkstra(int[][] graph, int source) {
        int count = graph.length;
        boolean[] visitedVerted = new boolean[count];
        int[] distance = new int[count];
        for (int i = 0; i < count; i++) {
          visitedVertex[i] = false;
          distance[i] = Integer.MAX_VALUE;
        }

        // La distancia del bucle automático es cero.
        distance[source] = 0;
        for (int i = 0; i < count; i++) {

          // Update the distance between neighbouring vertex and source vertex
          int u = findMinDistance(distance, visitedVertex);
          visitedVertex[u] = true;

          //Actualiza todas las distancias de los vértices vecinos.
          for (int v = 0; v < count; v++) {
            if (!visitedVertex[v] && graph[u][v] != 0 && (distance[u] + graph[u][v] < distance[v])) {
              distance[v] = distance[u] + graph[u][v];
            }
          }
        }
        for (int i = 0; i < distance.length; i++) {
          System.out.println(String.format("Distance from %s to %s is %s", source, i, distance[i]));
        }

      }

      // Encontrar la distancia mínima
      private static int DistanciaMinima(int[] distance, boolean[] visitedVertex) {
        int minimadistancia = Integer.MAX_VALUE;
        int distanciavertice = -1;
        for (int i = 0; i < distance.length; i++) {
          if (!visitedVertex[i] && distance[i] < minDistance) {
            minimadistancia = distance[i];
            distanciavertice = i;
          }
        }
        return minDistanceVertex;
      }

      public static void main(String[] args) {
        int graph[][] = new int[][] { { 0, 0, 1, 2, 0, 0, 0, 0 }, { 0, 0, 2, 0, 0, 3, 0, 0 }, { 1, 2, 0, 1, 3, 0, 0, 0 },
            { 2, 0, 1, 0, 0, 0, 1, 0}, { 0, 0, 3, 0, 0, 2, 0, 5 }, { 0, 3, 0, 0, 2, 0, 1, 0 }, { 0, 0, 0, 1, 0, 1, 0, 0 } ,
            { 0, 0, 0, 0, 5, 0, 0, 0 }
        };
        Dijkstra T = new Dijkstra();
        T.dijkstra(graph, 0);
      }
    }

## Conclusion
Los grafos y los árboles son conceptos fundamentales en la estructura de datos que juegan un papel crucial en la organización y manipulación eficiente de datos en una amplia variedad de aplicaciones. Además de los grafos representan relaciones entre elementos y se utilizan en redes de computadoras, redes sociales, sistemas de transporte, etc. mientras que los árboles se emplean para organizar datos en estructuras como árboles genealógicos, estructuras de archivos y árboles de búsqueda binaria.
