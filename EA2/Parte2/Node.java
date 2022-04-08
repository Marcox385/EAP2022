public class Node<T extends Comparable<? super T>> {
    public T key;
    public Node left = null, right = null, parent = null;

    public Node(T key) { this.key = key; }

    public String toString() { return this.key.toString(); }
}