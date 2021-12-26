public class main {

    public static void main(String[] args) {

        BinaryHeap<Integer> binaryHeap = new BinaryHeap<>(10);

        binaryHeap.insert(109);
        binaryHeap.insert(59);
        binaryHeap.insert(10);
        binaryHeap.insert(23);
        binaryHeap.insert(36);
        binaryHeap.insert(42);

        System.out.println(binaryHeap.findMin());
        System.out.println(binaryHeap.deleteMin());
        System.out.println(binaryHeap.findMin());

    }

}
