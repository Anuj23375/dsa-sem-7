import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Main {

    static Node buildTree() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter root value: ");
        int value = sc.nextInt();

        Node root = new Node(value);
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            Node curr = q.poll();

            System.out.print("Enter left child of " + curr.data + " (-1 for no child): ");
            int left = sc.nextInt();

            if (left != -1) {
                curr.left = new Node(left);
                q.add(curr.left);
            }

            System.out.print("Enter right child of " + curr.data + " (-1 for no child): ");
            int right = sc.nextInt();

            if (right != -1) {
                curr.right = new Node(right);
                q.add(curr.right);
            }
        }

        return root;
    }

    static void inorder(Node root) {
        if (root == null) return;

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    static void preorder(Node root) {
        if (root == null) return;

        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    static void postorder(Node root) {
        if (root == null) return;

        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }

    public static void main(String[] args) {
        Node root = buildTree();

        System.out.print("Inorder: ");
        inorder(root);

        System.out.print("\nPreorder: ");
        preorder(root);

        System.out.print("\nPostorder: ");
        postorder(root);
    }
}