// Made by Daniyal Syed 250979014
public class Assignment3<V, E> {

    // max flow
    public int MFlow = 0;
    // array to store visited nodes
    public int[] visitedNodesStore;

    public int breadthFirstPathSearch(Graph graph, int startVertex, int threshold) {

        //init visitedNodes and visitedNodesStore arrays
        int[] visitedNodes = new int[graph.numVertices()];
        visitedNodesStore = new int[graph.numVertices()];

        //set all visitedNodes to 0, all visitedNodesStore values to -1
        for (int i = 0; i < graph.numVertices(); i++) {
            visitedNodes[i] = 0;
            visitedNodesStore[i] = -1;
        }


        //get starting vertex
        Vertex<V> start = graph.getVertex(startVertex);

        //init queue and enqueue getHead node, declare vertex
        LinkedListQueue<Vertex<V>> linkedListQueue = new LinkedListQueue<>();
        linkedListQueue.enqueue(start);
        Vertex<V> vertex;

        while (!linkedListQueue.isEmpty()) {

            // Dequeue from list and assign to vertex
            vertex = linkedListQueue.dequeue();

            //check if node had been visited
            if (visitedNodes[vertex.getLabel()] == 0) {

                //mark node as visited
                visitedNodes[vertex.getLabel()] = 1;
                Iterable<Edge<E>> iterableEdges = graph.outgoingEdges(vertex);

                //iterate over edges, then enqueue some of them
                for (Edge<E> e : iterableEdges) {

                    if (visitedNodes[vertex.getLabel()] == 0 && e.flow < e.flowCap) {

                        visitedNodesStore[graph.opposite(vertex, e).getLabel()] = 1;
                        linkedListQueue.enqueue(graph.opposite(vertex, e));
                    }
                }
            }
        }
        //check if threshold reached and return appropriately
        if (visitedNodes[threshold] == 1)
            return 1;

        return 0;
    }

    public void maximizeFlowNetwork(Graph graph, int start, int threshold) {

        while (breadthFirstPathSearch(graph, start, threshold) == 1) {

            //set this to max value so it can eventually be comparedto smaller values
            int maxPathFlow = Integer.MAX_VALUE;

            for (int j = threshold; j != start; j = visitedNodesStore[j]) {

                int i = visitedNodesStore[j];

                //find maximum possible flow
                maxPathFlow = Math.min(maxPathFlow, (graph.getEdge(graph.getVertex(i), graph.getVertex(j)).flowCap - graph.getEdge(graph.getVertex(i), graph.getVertex(j)).flow));
            }

            //update graph and account for backflow
            for (int j = threshold; j != start; j = visitedNodesStore[j]) {

                int i = visitedNodesStore[j];

                graph.getEdge(graph.getVertex(i), graph.getVertex(j)).flow += maxPathFlow;

                graph.getEdge(graph.getVertex(i), graph.getVertex(j)).flowCap -= maxPathFlow;

                graph.getEdge(graph.getVertex(j), graph.getVertex(i)).flowCap += maxPathFlow;
            }
            //update max flow
            MFlow += maxPathFlow;
        }
    }
}
