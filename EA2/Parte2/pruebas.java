import java.util.List;

public class pruebas {
    static void printLists(List<List<Node>> levels) {
        for (List<Node> level : levels) {
            System.out.println(level);
        }
    }

    public static void main(String[] args) {
        // ABB

        /* Node<Integer> root = new Node(5), n2 = new Node(2),
             n3 = new Node(8), n4 = new Node(4),
             n5 = new Node(7), n6 = new Node(9);
        
        root.left = n2; root.right = n3;
        n2.left = null; n2.right = n4;
        n3.left = n5; n3.right = n6;
        n4.left = null; n4.right = null;
        n5.left = null; n5.right = null;
        n6.left = null; n6.right = null;

        n2.parent = root; n3.parent = root;
        n4.parent = n2; n5.parent = n3; n6.parent = n3;

        Node<Integer> root = new Node<>(5),
                      n1 = new Node<>(3), n2 = new Node<>(9),
                      n3= new Node<>(4), n4 = new Node<>(8), n5 = new Node<>(2),
                      n6 = new Node<>(6), n7 = new Node<>(1);
        
        root.left = n1; root.right = n2;
        n1.right = n3; n2.left = n4; n2.right = n5;
        n4.left = n6; n4.right = n7;

        ABB<Integer> helper = new ABB<>(root);
        System.out.println(helper.existsPath(root, 4));
        System.out.println(helper.isBST(root)); 
        List<List<Node>> nodeList = helper.getNodeListPerLevel(root);
        printLists(nodeList); */

        // AVL
        /* Node<Integer> root = new NodeAVL<>(12,0 ), n1 = new NodeAVL<>(8, 1),
                        n2 = new NodeAVL<>(18, 1), n3 = new NodeAVL<>(5, 2),
                        n4 = new NodeAVL<>(11, 2), n5 = new NodeAVL<>(17, 2),
                        n6 = new NodeAVL<>(4, 3);
        
        root.left = n1; root.right = n2;
        n1.left = n3; n1.right = n4;
        n2.left = n5; n3.left = n6;

        AVL<Integer> avl = new AVL<>();
        System.out.println(avl.checkAVL(root));

        NodeAVL<Integer> n7 = new NodeAVL<>(3, 4);
        n6.left = n7;
        System.out.println(avl.checkAVL(root)); */

        // ARN
        /* NodeRN<Integer> root = new NodeRN<>(13, false),
        n1 = new NodeRN<>(8, true), n2 = new NodeRN<>(17, true),
        n3 = new NodeRN<>(1, false), n4 = new NodeRN<>(11, false), n5 = new NodeRN<>(15, false), n6 = new NodeRN<>(25, false),
        n7 = new NodeRN<>(6, true), n8 = new NodeRN<>(22, true), n9 = new NodeRN<>(27, true);

        root.left = n1; root.right = n2;
        n1.left = n3; n1.right = n4; n2.left = n5; n2.right = n6;
        n3.right = n7; n6.left = n8; n6.right = n9;

        ARN<Integer> arn = new ARN<>();
        System.out.println(arn.isRB(root)); */
    
        // DST
        /* Node<Integer> root = new Node<>(7), n1 = new Node<>(5),
                      n2 = new Node<>(3), n3 = new Node<>(4);

        root.left = n1; root.right = n2;
        n1.right = n3;

        DSTree<Integer> dstree = new DSTree<>();
        System.out.println(dstree.isDST(root, 4)); */

        // BTree


        // Trie
    }
}