import java.util.PriorityQueue;
import java.util.Properties;

public class sol {
    static int currElems = 0;

    public static class Vertex {
        final int index;
        final String s;
        int d = Integer.MAX_VALUE;

        public Vertex(int index, String s) {
            this.index = index;
            this.s = s;
        }
    }

    public static class Edge {
        Vertex A, B;
        int w;

        public Edge(Vertex A, Vertex B, int w) {
            this.A = A; this.B = B; this.w = w;
        }
    }

    public static class Graph {
        Edge[] edges;
        Vertex[] vertices;

        public Graph(int e, int v) {
            this.edges = new Edge[e];
            this.vertices = new Vertex[v];
        }

        public void addNode(String s) {
            vertices[currElems] = new Vertex(currElems++, s);
        }

        public int findIndex(String s) {
            for (Vertex v : vertices) {
                if (v.s == s) return v.index;
            }

            return -1;
        }

        public void addEdge(String A, String B, int w) {
            int iA = findIndex(A), iB = findIndex(B);
        }
    }

    public static void main(String[] args) {

    }
}