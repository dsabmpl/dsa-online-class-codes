import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import org.w3c.dom.Node;

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode(int data) {
        this.data = data;
    }
}

class TreeBasic {
    static Scanner scanner = new Scanner(System.in);

    static TreeNode createTree() {
        System.out.println("Enter the Data of a Node or Press -1 for Null ");
        int data = scanner.nextInt();
        // i dont want to create a node
        if (data == -1) {
            return null;
        }
        // i want to create a node
        TreeNode node = new TreeNode(data);
        System.out.println("Enter the data of Left Child for " + data);
        // build left
        node.left = createTree();
        // BackTrack time , it will right
        // build right
        System.out.println("Enter the data of Right Child for " + data);
        node.right = createTree();
        return node;
    }

    static void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        inOrder(root.left);
        System.out.println(root.data);
        // BackTrack
        inOrder(root.right);
    }

    static void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        postOrder(root.left);

        // BackTrack
        postOrder(root.right);
        System.out.println(root.data);
    }

    static void levelOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.poll();
            System.out.println(currentNode.data);
            if (currentNode.left != null) {
                queue.add(currentNode.left);
            }
            if (currentNode.right != null) {
                queue.add(currentNode.right);
            }
        }
    }
    // static void preOrder(TreeNode root) {

    static void printTree(TreeNode root) {

        if (root == null) {
            return;
        }
        System.out.println(root.data);
        printTree(root.left);
        // BackTrack
        printTree(root.right);
    }

    static void formattedTree(TreeNode root, String prefix, boolean isLeft) {
        final String left = "|--";
        final String right = "└──";
        final String pipe = "|  ";
        final String space = "   ";

        if (root == null) {
            System.out.println(prefix + (isLeft ? left : right) + "NULL");
            return;
        }
        System.out.println(prefix + (isLeft ? left : right) + root.data);
        formattedTree(root.left, prefix + (isLeft ? pipe : space), true);
        // BackTrack
        formattedTree(root.right, prefix + (isLeft ? pipe : space), false);
        // System.out.println("|--");
        // char treeCorner = '\u2514';
        // char line = '\u2500';
        // System.out.println(treeCorner + "" + line + line);
    }

    public static void main(String[] args) {

        TreeNode root = createTree();
        // printTree(root);
        formattedTree(root, "", true);

    }
}