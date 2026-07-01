//class Node {
//
//    int data;
//    Node next;
//
//    Node(int data) {
//        this.data = data;
//    }
//}

class LinkedListTraversal {

    private Node head;
    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null)
            temp = temp.next;
        temp.next = newNode;
    }
    public void traverse() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public int countNodes() {
        int count = 0;
        Node temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    public static void main(String[] args) {
        LinkedListTraversal list = new LinkedListTraversal();
        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.insert(40);
        list.traverse();
        System.out.println("Total Nodes = " + list.countNodes());
    }
}