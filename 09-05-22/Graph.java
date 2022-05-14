import java.util.PriorityQueue;

public class Graph {
    void Dijkstra(Vertex start) {
        PriorityQueue<Vertex> pq = new PriorityQueue<Vertex>(this.vertices.size());

        for (Vertex v : this.vertices) {
            v.d = Integer.MAX_VALUE;
            v.parent = null;
            pq.offer(v);
        }

        start.d = 0;
        pq.decreaseKey(start);

        while (!pq.isEmpty()) {
            Vertex u = pq.poll();

            for (Edge e : u.adj) {
                Vertex v = e.v;

                if (pq.contains(v) && v.d > u.d + e.w) { // Suprimir u.d para Prim
                    v.parent = u;
                    v.d = u.d + e.w; // Suprimir u.d para Prim
                    pq.decreaseKey(v);
                }
            }
        }
    }
}