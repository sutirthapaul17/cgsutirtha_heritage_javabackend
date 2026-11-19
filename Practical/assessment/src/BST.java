import java.util.ArrayList;
import java.util.List;

public class BST {

    private static class Node {
        int value;
        Node left, right;

        Node(int value) {
            this.value = value;
        }
    }

    private Node root;
    public void insert(int value) {
        root = insertRec(root, value);
    }

    private Node insertRec(Node node, int value) {
        if (node == null) {
            return new Node(value);
        }
        if (value < node.value) {
            node.left = insertRec(node.left, value);
        } else if (value > node.value) {
            node.right = insertRec(node.right, value);
        }
        return node;
    }

    public boolean search(int value) {
        return searchRec(root, value);
    }

    private boolean searchRec(Node node, int value) {
        if (node == null) {
            return false;
        }
        if (value == node.value) {
            return true;
        }
        return value < node.value
                ? searchRec(node.left, value)
                : searchRec(node.right, value);
    }

    public List<Integer> inorderTraversal() {
        List<Integer> result = new ArrayList<>();
        inorderRec(root, result);
        return result;
    }

    private void inorderRec(Node node, List<Integer> result) {
        if (node == null) {
            return;
        }
        inorderRec(node.left, result);
        result.add(node.value);
        inorderRec(node.right, result);
    }

    public static void main(String[] args) {
        BST tree = new BST();
        int[] values = {50, 30, 70, 20, 40, 60, 80};
        for (int v : values) {
            tree.insert(v);
        }

        List<Integer> sorted = tree.inorderTraversal();
        StringBuilder sb = new StringBuilder();
        for (int v : sorted) {
            sb.append(v).append(" ");
        }
        System.out.println(sb.toString().trim());

        System.out.println("search(60) -> " + tree.search(60));
        System.out.println("search(25) -> " + tree.search(25));
    }
}