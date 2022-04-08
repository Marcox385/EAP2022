public class NodeAVL<T extends Comparable<? super T>> extends Node {
    int h;

    public NodeAVL(T key, int h) {
        super(key);
        this.h = h;
    }
}