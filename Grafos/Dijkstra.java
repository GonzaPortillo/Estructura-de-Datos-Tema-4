//Implementacion en codigo de un grafo

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


