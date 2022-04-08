import java.util.List;

public class NodeBTree<T extends Comparable<? super T>> {
    NodeBTree parent = null; 
    List<NodeBTree<T>> children = null;
    List<T> key = null;
    public int n = 0;
    boolean isLeaf = false;

    public NodeBTree(List<T> key) {
        this.key = key;
        this.n = key.size();
    }
}