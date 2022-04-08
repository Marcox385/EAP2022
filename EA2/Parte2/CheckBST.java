public class CheckBST<T extends Comparable<? super T>> {
    private Node<T> root = new Node<>(null);

    public CheckBST(Node<T> root) {
        this.root = root;
    }

    private Node<T> maximum(Node<T> node) {
        if (node == null) return null;

        while (node.right != null) node = node.right;

        return node;
    }

    public T maximum() {
        Node<T> max = maximum(root);
        return (max == null) ? null : max.key;
    }

    private Node<T> minimum(Node<T> node) {
        if (node == null) return null;

        while (node.left != null) node = node.left;

        return node;
    }

    public T minimum() {
        Node<T> min = minimum(root);
        return (min == null) ? null : min.key;
    }


    public boolean isBST(Node<T> root) {
        if (root == null) return true;

        
        if (root.left != null && maximum(root.left).key.compareTo(root.key) >= 0 ||
        root.right != null && minimum(root.right).key.compareTo(root.key) <= 0 ||
        !isBST(root.left) || !isBST(root.right)) return false;
        
        return true;
    }
}