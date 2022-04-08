import java.util.ArrayList;
import java.util.List;

public class ABB<T extends Comparable<? super T>> extends CheckBST {

    public ABB(Node<T> root) {
        super(root);
    }

    private boolean countOdd(Node<Integer> node, int goal, int count) {
        if (node.key % 2 != 0) count++;

        if (node.left == null && node.right == null) {
            if (count == goal) return true;
            else return false;
        }

        return countOdd(node.left, goal, count) || countOdd(node.right, goal, count);
    }

    public boolean existsPath(Node<Integer> root, int goal) {
        return countOdd(root, goal, 0);
    }

    public int depthBST(Node root) {
        if (root == null) return -1;

        int lDepth = depthBST(root.left);
        int rDepth = depthBST(root.right);

        if (lDepth > rDepth) return lDepth + 1;
        else return rDepth + 1;
    }

    private void getNodesOnLevel(Node<T> node, int level, List<T> list) {
        if (node == null) return;
        if (level == 0) {
            list.add(node.key);
        } else {
            getNodesOnLevel(node.left, level - 1, list);
            getNodesOnLevel(node.right, level - 1, list);
        }
    }

    private List<T> getNodesOnLevel(Node<T> root, int level) {
        List<T> list = new ArrayList<>();
        getNodesOnLevel(root, level, list);
        return list;
    }

    public List<List<Node>> getNodeListPerLevel(Node root) {
        int depth = depthBST(root);

        List<List<Node>> res = new ArrayList<>(depth);
        
        for (int i = 0; i <= depth; i++) {
            res.add(getNodesOnLevel(root, i));
        }

        return res;
    }
}