public class EmployeeDirectory {
    // Represents one employee record
    static class Node {
        int empId;
        String name;
        Node left, right;

        Node(int id, String name) {
            this.empId = id;
            this.name  = name;
        }
    }

    Node root;

    // Insert employee
    public Node insert(Node root, int id, String name) {
        if (root == null) return new Node(id, name);
        if (id < root.empId)  root.left  = insert(root.left, id, name);
        else if (id > root.empId) root.right = insert(root.right, id, name);
        return root;
    }

    // Search employee by ID
    public Node search(Node root, int id) {
        if (root == null || root.empId == id) return root;
        if (id < root.empId) return search(root.left, id);
        return search(root.right, id);
    }

    // Print all employees sorted by ID
    public void inorder(Node root) {
        if (root == null) return;
        inorder(root.left);
        System.out.println("ID: " + root.empId + " | Name: " + root.name);
        inorder(root.right);
    }

    public static void main(String[] args) {
        EmployeeDirectory dir = new EmployeeDirectory();
        dir.root = dir.insert(dir.root, 1050, "Alice");
        dir.root = dir.insert(dir.root, 1020, "Bob");
        dir.root = dir.insert(dir.root, 1080, "Carol");
        dir.root = dir.insert(dir.root, 1010, "David");
        dir.root = dir.insert(dir.root, 1035, "Eve");

        System.out.println("--- All Employees (Sorted by ID) ---");
        dir.inorder(dir.root);
        // ID: 1010 | Name: David
        // ID: 1020 | Name: Bob
        // ID: 1035 | Name: Eve
        // ID: 1050 | Name: Alice
        // ID: 1080 | Name: Carol

        Node emp = dir.search(dir.root, 1035);
        System.out.println("Found: " + (emp != null ? emp.name : "Not found"));
        // Found: Eve
    }
}
