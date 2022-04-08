public class ARN<T extends Comparable<? super T>> {
    private boolean redProperty(NodeRN<T> node) {
        if (node == null) return true;

        if (node.left != null && node.isRed && node.left.isRed) return false;
        if (node.right != null && node.isRed && node.right.isRed) return false;

        return redProperty(node.left) && redProperty(node.right);
    }

    private int countBlacks(NodeRN<T> node, int count) {
        if (node == null) return count;

        if (!(node.isRed)) count++;

        int countL =  countBlacks(node.left, 0), countR = countBlacks(node.right, 0);

        return count + countL + countR;
    }

    private boolean blackProperty(NodeRN<T> node) {
        return (countBlacks(node.left, 0) - countBlacks(node.right, 0) == 0) ? true : false;
    }

    public boolean isRB(NodeRN<T> root) {
        if (root == null) return true;

        // Primera condición: BST
        CheckBST<T> helper = new CheckBST<>(root);
        if (!(helper.isBST(root))) return false;

        // Segunda condición: raíz negra
        if (root.isRed) return false;

        // Tercera condición: propiedad roja
        if (!(redProperty(root))) return false;

        // Cuarta condición: propiedad negra
        if (!(blackProperty(root))) return false;

        return true;
    }
}