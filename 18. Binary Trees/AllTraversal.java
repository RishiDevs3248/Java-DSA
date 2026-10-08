
import java.util.LinkedList;
import java.util.Queue;

public class AllTraversal {

    // build tree
    static class Node {

        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree {

        static int idx = -1;

        public static Node buildTree(int nodes[]) {
            idx++;
            if (nodes[idx] == -1) {
                return null;
            }

            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        };
    }
    

    //DFS
    //preOrder
    public static void preOrder(Node root) {
        if (root == null) {
            // System.out.print( "-1 ");
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    //inOrder
    public static void inOrder(Node root) {
        if (root == null) {
            // System.out.print("-1 ");
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    //postOrder
    public static void postOrder(Node root) {
        if (root == null) {
            // System.out.print("-1 ");
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    //BFS
    //levelOrder
    public static void levelOrder(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while (!q.isEmpty()) {
            Node currNode = q.remove();
            if (currNode == null) {
                System.out.println();
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                System.out.print(currNode.data + " ");
                if (currNode.left != null) {
                    q.add(currNode.left);
                }
                if (currNode.right != null) {
                    q.add(currNode.right);
                }
            }
        }
    }

    // height of the tree
    public static int heightOfTree(Node root) {
        if (root == null) {
            return 0;
        }

        int left = heightOfTree(root.left);
        int right = heightOfTree(root.right);

        return Math.max(left, right) + 1;
    }

    // Count of the nodes in a tree
    public static int countOfNodes(Node root) {
        if (root == null) {
            return 0;
        }

        int left = countOfNodes(root.left);
        int right = countOfNodes(root.right);

        return left + right + 1;
    }

    // Sum of the nodes in a tree
    public static int sumOfNodes(Node root) {
        if (root == null) {
            return 0;
        }

        int left = sumOfNodes(root.left);
        int right = sumOfNodes(root.right);

        return left + right + root.data;
    }


    // Diameter of a tree. //Time complexity = O(n^2)
    static int maxDia = Integer.MIN_VALUE;
    public static int maxDiameter(Node root){
        if(root == null){
            return 0;
        }

        int ld = maxDiameter(root.left);
        int rd = maxDiameter(root.right);

        int currDia = ld + rd + 1;
        maxDia = Math.max(maxDia, currDia);

        return Math.max(ld, rd)+1;
    }


    public static void main(String[] args) {
        int preOrder[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        int nodes[] = {
            1,
            2,
            4,
            8,
            7, -1, -1,
            -1,
            -1,
            5,
            -1,
            6,
            -1,
            9, -1, -1,
            3, -1, -1
        };
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);

        // System.out.println("preorder : ");
        // preOrder(root);
        // System.out.println();
        // System.out.println();
        // System.out.println("inorder : ");
        // inOrder(root);
        // System.out.println();
        // System.out.println();
        // System.out.println("postorder : ");
        // postOrder(root);
        // System.out.println("");
        // System.out.println("levelorder : ");
        // levelOrder(root);

        // System.out.println("");
        // System.out.println("");
        // System.out.println("");
        // System.out.println("");
        // System.out.print("Height Of Tree : ");
        // System.out.println(heightOfTree(root));
        // System.out.print("Count of nodes : ");
        // System.out.println(countOfNodes(root));
        // System.out.print("Sum of nodes : ");
        // System.out.println(sumOfNodes(root));


        maxDiameter(root);
        System.out.println(maxDia);
    }
}
