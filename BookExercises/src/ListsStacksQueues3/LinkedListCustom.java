package ListsStacksQueues3;

public class LinkedListCustom {
    Node head;

    public void printList() {
        Node n = head;

        while (n != null) {
            System.out.println(n.data + " ");
            n = n.next;
        }
    }

    public void addNode(int data) {
        Node node = new Node(data);

        if (head == null) {
            head = node;
            return;
        }

        Node n = head;
        // hvis der er en næste node
        while (n.next != null) {
            // sæt den nye node til den vi er på
            n = n.next;
        }
        // hvis der ingen næste node er
        n.next = node;
    }

    public Node getNode(int data) {

        if (head.data == data) {
            return head;
        }

        Node n = head;
        // hvis der er en næste node der ikke har den data
        while (n.data != data) {
            // sæt den nye node til den vi er på
            n = n.next;
        }
        return n;
    }
}
