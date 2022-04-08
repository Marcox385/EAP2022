/* public class DSTree <T extends Comparable<? super T>> {
    private int bitLen = 0;

    private class NodeDST<K extends Comparable<? super K>> extends Node {
        public NodeDST(T key) {
            super(key);
        }
    }

    NodeDST<T> root = null;

    public DSTree(NodeDST<T> root) {
        this.root = root;
    }
} */

public class DSTree<T extends Comparable<? super T>> {
    private boolean value(int n, int pos) { // Obtiene bits de derecha a izquierda
        return (((n >> pos) & 1) == 0) ? true : false;
    }

    private boolean check(Node<Integer> node, int bitLen, int level) {
        if (node == null) return true;

        if (node.left != null && !(value((Integer)node.left.key, bitLen - (level + 1)))) return false;
        if (node.right != null && value((Integer)node.right.key, bitLen - (level + 1))) return false;

        return check(node.left, bitLen, level + 1) && check(node.right, bitLen, level + 1);
    }
    
    public boolean isDST(Node<Integer> root, int bitLen) {
        return check(root, bitLen, 0);
    }
}