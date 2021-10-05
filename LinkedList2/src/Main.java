public class Main {

    public static void main(String[] args) {

        LinkedList linkedList = new LinkedList();

        linkedList.addNodeToTail(1);
        linkedList.addNodeToTail(2);
        linkedList.addNodeToTail(3);
        linkedList.addNodeToTail(4);
        linkedList.addNodeToTail(5);
        linkedList.addNodeToHead(6);
        linkedList.inList(3);

        linkedList.display();
    }
}
