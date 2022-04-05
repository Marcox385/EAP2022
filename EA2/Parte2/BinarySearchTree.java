public class BinarySearchTree<T extends Comparable<? super T>> {
    
    private class Node {
        public T key;
        public Node left = null, right = null, parent = null;

        public Node(T key) {
            this.key = key;
        }

        public String toString() {
            return this.key.toString();
        }
    }

    private Node root = null;
    private int size = 0;

    public int size() {
        return this.size;
    }

    private void print(Node node) {
        if (node != null) {
            print(node.left);
            System.out.println(node.key);
            print(node.right);
        }
    }

    public void print() {
        print(this.root);
        System.out.println("-------");
    }

    public boolean add(T toAdd) {
        if (root == null) {
            Node newNode = new Node(toAdd);
            root = newNode;
            size++;
            return true;
        }

        Node current = root, aux;
        int cmp;

        do {
            aux = current;
            cmp = toAdd.compareTo(current.key);

            if (cmp == 0) return false;
            else if (cmp < 0) current = current.left;
            else current = current.right;
        } while (current != null);

        if (cmp < 0) {
            aux.left = new Node(toAdd);
            aux.left.parent = aux;
        } else if (cmp > 0) {
            aux.right = new Node(toAdd);
            aux.left.parent = aux;
        } size++;
        return true;
    }

    private Node search(T toSearch, Node current) { // Método iterativo
        do {
            int cmp = toSearch.compareTo(current.key);
            if (cmp == 0) return current;
            else if(cmp < 0) current = current.left;
            else current = current.right;
        } while (current != null);

        return null;
    }

    private Node searchR(T toSearch, Node current) { // Método recursivo
        if (current == null) return null;

        int cmp = toSearch.compareTo(current.key);

        if (cmp == 0) return current;
        else if (cmp < 0) return searchR(toSearch, current.left);
        else return searchR(toSearch, current.right);
    }

    public boolean contains(T key) {
        return search(key, root) != null;
    }

    private Node maximum(Node node) {
        if (node == null) return null;

        while (node.right != null) node = node.right;

        return node;
    }

    public T maximum() {
        Node max = maximum(root);
        return (max == null) ? null : max.key;
    }

    private Node minimum(Node node) {
        if (node == null) return null;

        while (node.left != null) node = node.left;

        return node;
    }

    public T minimum() {
        Node min = minimum(root);
        return (min == null) ? null : min.key;
    }

    private Node predecessor(Node node) {
        if (node.left != null) return maximum(node.left);

        Node current = node, aux;

        while (current.parent != null) {
            aux = current;
            current = current.parent;

            if (aux == current.right) return aux;
        }

        return null;
    }

    public T predecessor(T key) {
        Node n = search(key, root);
        Node pre = (n == null) ? null : predecessor(n);

        return (pre == null) ? null : pre.key;
    }

    private Node successor(Node node) {
        if (node.right != null) return maximum(node.right);

        Node current = node, aux;

        while (current.parent != null) {
            aux = current;
            current = current.parent;

            if (aux == current.left) return aux;
        }

        return null;
    }

    public T successor(T key) {
        Node n = search(key, root);
        Node suc = (n == null) ? null : successor(n);

        return (suc == null) ? null : suc.key;
    }

    private void remove(Node node) {
        if (node.left == null && node.right == null) {
            if (node.parent != null) {
                if (node.parent.left == node) node.parent.left = null;
                else node.parent.right = null;
            } else root = null;
            size--;
        } else if (node.left == null && node.right != null) {
            if (node.parent != null) {
                if (node.parent.left == node) node.parent.left = node.parent.right;
                else node.parent.right = node.right;
            } else root = node.right;
            size--;
        } else if (node.left != null && node.right == null) {
            if (node.parent != null) {
                if (node.parent.left == node) node.parent.left = node.left;
                else node.parent.right = node.left;
            } else root = node.left;
            size--;
        } else {
            Node n = predecessor(node);
            node.key = n.key;

            remove(n);
        }
    }

    public boolean remove(T key) {
        Node n = search(key, root);

        if(n == null) return false;

        remove(n); return true;
    }
}