public class Main {

    public static void main(String[] args) {

        CircularQueue q = new CircularQueue(4);
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);
        q.enqueue(50);
        q.dequeue();
        System.out.println("Size of Queue is " + q.size());
        q.enqueue(60);
        System.out.println("Front item is " + q.front());
        System.out.println("Rear item is " + q.rear());
        System.out.println("Is Queue full : " + q.isFull());
        System.out.println("Is Queue empty : " + q.isEmpty());
    }
}
