import java.util.List;

public class ABB {
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

    //TODO
    // public static boolean existsPath(Node root, int x) {
    //     if (root == null) return false;

    //     boolean lPath, rPath;

    //     if (root.left != null) lPath = existsPath(root.left, x);
    //     if (root.right != null) rPath = existsPath(root.right, x);

    //     if (root.left == null && root.right == null) return lDepth + 1;
    //     else return rDepth + 1;
    // }

    public static boolean isBST(Node root, int min, int max) {
        if (root == null) return true;

        if (root.key < min || root.key > max) return false;
        
        return isBST(root.left, min, root.key - 1) && isBST(root.right, root.key + 1, max);
    }

    static int depthBST(Node root) {
        if (root == null) return -1;

        int lDepth = depthBST(root.left);
        int rDepth = depthBST(root.right);

        if (lDepth > rDepth) return lDepth + 1;
        else return rDepth + 1;
    }

    public static List<Node> listLevel(Node root, int lvl) {
        if (root == null) return null;
        if (lvl == 1) return new List<Node>(root);

        List<Node> currLvl = new List<Node>();
        currLvl.add(listLevel(root.left, lvl - 1));
        currLvl.add(listLevel(root.right, lvl - 1));
    }

    public static List<List<Node>> getNodeListPerLevel(Node root) {
        int depth = depthBST(root);

        List<List<Node>> res = new List<List<Node>>();
        
        for (int i = 1; i <= depth; i++) {
            res.add(listLevel(root, i));
        }

        return res;
    }
    
    public static void main(String[] args) {
        // Node n = null;
        // isBST(n, Integer.MIN_VALUE, Integer.MAX_VALUE);

        List<List<Node>> nodeList = getNodeListPerLevel(root);
    }
}