public class LinkedList {

    public Node head = null;
    public Node tail = null;
    public Node tmp = null;

    public void addNodeToTail(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            tail = newNode;
        }
        else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void addNodeToHead(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            tail = newNode;
        }//
        else {
            tmp = head;
            head = newNode;
            head.next = tmp;
        }
    }

    public boolean inList(int i) {
        Node node = head;
        if (head == null) {
            return false;
        }
        while (node != null) {
            if (i == node.data) {
                System.out.println("Node with value " + i + " is in the list");
                return true;
            }
            node = node.next;
        }
        return false;
    }

    public void display() {
        Node current = head;

        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        System.out.println("Nodes of singly linked list: ");
        while(current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

}
