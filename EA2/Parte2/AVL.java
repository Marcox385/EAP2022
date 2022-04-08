public class AVL<T extends Comparable<? super T>> {
    private int height(Node<T> root) {
        if (root == null) return -1;

        int hl = height(root.left);
        int hr = height(root.right);

        if (hl > hr) return hl + 1;
        else return hr + 1;
    }

    private boolean isBalanced(Node<T> n) {
        if (n == null) return true;

        int hl = height(n.left), hr = height(n.right);

        if (Math.abs(hl - hr) <= 1
            && isBalanced(n.left) && isBalanced(n.right))
            return true;

        return false;

    }

    public boolean checkAVL(Node<T> root) {
        if (root == null) return true;

        // Primera condición: BST
        CheckBST<T> helper = new CheckBST<>(root);
        if (!(helper.isBST(root))) return false;

        // Segunda condición: balance
        if (!(isBalanced(root))) return false;

        return true;
    }
}