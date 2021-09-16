public class CircularQueue {

    int arr[] = null;
    int capacity = 4;

    int front = 0;
    int rear = -1;

    int size = 0;

    public CircularQueue() {
        this.arr = new int[capacity];
    }

    public CircularQueue(int capacity) {
        this.capacity = capacity;
        this.arr = new int[capacity];
    }

    public void enqueue(int data) {
        if (isFull()) {
            System.out.println("Queue is full can't insert");
            return;
        }
        rear = (rear + 1) % capacity;
        arr[rear] = data;
        size++;
        System.out.println(data + " enqueued into queue");
        System.out.println("After enqueued Rear is " + rear);

        // first increase the rear + 1
        // set the data into array arr[rear]
        // increase size + 1
    }

    public void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        int data = arr[front];
        front = (front + 1) % capacity;
        size--;
        System.out.println(data + " dequeued from queue");
        System.out.println("After dequeued front is " + front);

        // fetch the data using arr[front]
        // increase the front + 1
        // reduce size - 1
    }

    public int front() {
        if (isEmpty()) {
            return Integer.MIN_VALUE;
        }
        return arr[front];
    }

    public int rear() {
        if (isEmpty()) {
            return Integer.MIN_VALUE;
        }
        return arr[rear];
    }

    public int size() {
        return size;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
