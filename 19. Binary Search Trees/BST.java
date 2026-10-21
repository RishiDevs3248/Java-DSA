
public class BST {

    // Build a BST
    static class Node {

        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    public static Node insert(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }

        if (val < root.data) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }

        return root;
    }

    // Inorder of BST
    public static void inorder(Node root) {
        if (root == null) {
            return;
        }

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    // Search in a BST // time Complexity - O(H) -> H = height of the tree
    public static boolean searchInBST(Node root, int key) {
        if (root == null) {
            return false;
        }

        if (root.data == key) {
            return true;
        } else if (key < root.data) {
            return searchInBST(root.left, key);
        } else {
            return searchInBST(root.right, key);
        }
    }

    // Delete a node 
    public static Node delete(Node root, int val) {
        if (root.data < val) {
            root.right = delete(root.right, val);
        } else if (root.data > val) {
            root.left = delete(root.left, val);
        } else {
            // case 1 - leaf node
            if (root.left == null && root.right == null) {
                return null;
            }

            // case 2 - single child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // case 3 - both children
            Node inorderSuccessoe = findInorderSuccessor(root.right);
            root.data = inorderSuccessoe.data;
            root.right = delete(root.right, inorderSuccessoe.data);
        }

        return root;
    }

    public static Node findInorderSuccessor(Node root) {
        while (root.left != null) {
            root = root.left;
        }

        return root;
    }

    // Print in range 
    public static void printInRange(Node root, int k1, int k2) {
        if (root == null) {
            return;
        }

        if (k1 <= root.data && root.data <= k2) {
            printInRange(root.left, k1, k2);
            System.out.print(root.data + " ");
            printInRange(root.right, k1, k2);
        } else if (root.data < k1) {
            printInRange(root.left, k1, k2);
        } else {
            printInRange(root.right, k1, k2);
        }
    }

    // Mirror a BST
    public static Node mirrorBST(Node root){
        if(root == null){
            return null;
        }

        Node left = mirrorBST(root.left);
        Node right = mirrorBST(root.right);

        root.left = right;
        root.right = left;

        return root;
    }

    public static void main(String[] args) {
        // int values[] = {5,1,3,4,2,7};
        int values[] = {8, 5, 3, 1, 4, 6, 10, 11, 14};
        Node root = null;

        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }

        System.out.print("Inorder traversal of BST : ");
        inorder(root);
        System.out.println();

        System.out.print("Search '3' in BST : " + searchInBST(root, 3));
        System.out.println();

        System.out.print("Search '10' in BST : " + searchInBST(root, 10));
        System.out.println();

        System.out.print("Before Delete : ");
        inorder(root);
        System.out.println();
        System.out.print("delete '10' in BST : " + delete(root, 1));
        System.out.println();
        System.out.print("After Delete : ");
        inorder(root);
        System.out.println();


        System.out.print("Print in range 5 - 12 : ");
        printInRange(root, 5, 12);
        System.out.println();
        
        System.out.print("Before Mirror : ");
        inorder(root);
        System.out.println();
        System.out.print("After Mirror : ");
        inorder(mirrorBST(root));

    }
}
