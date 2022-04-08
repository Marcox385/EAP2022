import java.util.List;

public class BTree<T extends Comparable<? super T>> {

    // Primera condición
    private boolean orderedKeys(NodeBTree<T> node) {
        if (node == null) return true;

        for (int i = 0; i < node.key.size() - 1; i++) {
            if (node.key.get(i).compareTo(node.key.get(i + 1)) > 0) return false;
        }

        for (NodeBTree<T> child : node.children) {
            if (!(orderedKeys(child))) return false;
        }

        return true;
    }

    // Segunda condición
    private boolean holdsOrder(NodeBTree<T> node) {
        if (node == null) return true;

        for (int i = 0; i < node.key.size(); i++) {
            T currVal = node.key.get(i);

            for (int j = 0; j < node.children.size(); j++) {
                List<T> currChild = node.children.get(j).key;

                for (int k = 0; k < currChild.size(); k++) {
                    if (j <= i && currChild.get(i).compareTo(currVal) >= 0) return false;
                    if (j > i && currChild.get(i).compareTo(currVal) <= 0) return false;
                }
            }
        }

        for (NodeBTree<T> child : node.children) {
            if (!(holdsOrder(child))) return false;
        }

        return true;
    }

    // Tercera condición
    private boolean minimumKeys(NodeBTree<T> node, int mn) {
        if (node == null || node.children == null) return true;

        for (NodeBTree<T> child : node.children) {
            if (child.key.size() < mn) return false;
            if (!(minimumKeys(child, mn))) return false;
        }

        return true;
    }

    // Cuarta condición
    private boolean maximumKeys(NodeBTree<T> node, int mx) {
        if (node == null || node.children == null) return true;

        for (NodeBTree<T> child : node.children) {
            if (child.key.size() < mx) return false;
            if (!(maximumKeys(child, mx))) return false;
        }

        return true;
    }

    // Quinta condición
    private boolean nChilds(NodeBTree<T> node) {
        if (node == null || node.children == null) return true;

        if (node.children.size() < (node.n + 1)) return false;

        for (NodeBTree<T> child : node.children) {
            if (!(nChilds(child))) return false;
        }

        return true;
    }

    // Sexta condición
    private boolean nodeNotLeaf(NodeBTree<T> node) {
        if (node == null) return true;

        if (node.children != null && node.isLeaf == true) return false;
        else {
            for (NodeBTree<T> child : node.children) {
                if (!(nodeNotLeaf(child))) return false;
            }

            return true;
        }
    }
    
    // Séptima condición
    private boolean leafNotNode(NodeBTree<T> node) {
        if (node == null) return true;

        if (node.children == null && node.isLeaf != true) return false;
        else {
            for (NodeBTree<T> child : node.children) {
                if (!(leafNotNode(child))) return false;
            }

            return true;
        }
    }

    public boolean isBTree(NodeBTree<T> root) {
        // Primera condición: nodos ascendentes
        if (!(orderedKeys(root))) return false;
        
        // Segunda condición: orden tipo BST
        if (!(holdsOrder(root))) return false;

        // Tercera condición: mínimo de llaves
        if (!minimumKeys(root, root.n - 1)) return false;

        // Cuarta condición: máximo de llaves
        if (!maximumKeys(root, (2 * root.n) - 1)) return false;

        // Quinta condición: número de hijos
        if (!(nChilds(root))) return false;

        // Sexta condición: nodos no son hojas
        if (!(nodeNotLeaf(root))) return false;

        // Séptima condición: hojas no son nodos
        if (!(leafNotNode(root))) return false;

        return true;
    }
}