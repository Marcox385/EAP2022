public class NodeRN<T extends Comparable<? super T>> extends Node {
    boolean isRed;
    NodeRN left = null, right = null, parent = null;

    public NodeRN(T key, boolean isRed) {
        super(key);
        this.isRed = isRed;
    }
}