package ListsStacksQueues3;

public class MyLinkedList<AnyType> implements Iterable<AnyType> {

    public static class NodeMyLinkedList<AnyType> {
        public NodeMyLinkedList(AnyType d, NodeMyLinkedList<AnyType> p, NodeMyLinkedList<AnyType> n) {
            data = d;
            prev = p;
            next = n;
        }

        public AnyType data;
        public NodeMyLinkedList<AnyType> prev;
        public NodeMyLinkedList<AnyType> next;
    }

    private void doClear() {
        beginMarker = new NodeMyLinkedList<AnyType>(null, null, null);
        endMarker = new NodeMyLinkedList<AnyType>(null, beginMarker, null);
        beginMarker.next = endMarker;

        theSize = 0;
        modCount++;
    }

    public MyLinkedList() {
        doClear();
    }

    public void clear() {
        doClear();
    }

    public int size() {
        return theSize;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean add(AnyType x) {
        add(size(), x);
        return true;
    }

    public void add(int idx, AnyType x) {
        addBefore(getNode(idx, 0, size()), x);
    }

    public AnyType get(int idx) {
        return getNode(idx).data;
    }

    public AnyType set(int idx, AnyType newVal) {
        NodeMyLinkedList<AnyType> p = getNode(idx);
        AnyType oldVal = p.data;
        p.data = newVal;
        return oldVal;
    }

    public AnyType remove(int idx) {
        return remove(getNode(idx));
    }

    private void addBefore(NodeMyLinkedList<AnyType> p, AnyType x) {
        NodeMyLinkedList<AnyType> newNode = new NodeMyLinkedList<>(x, p.prev, p);
        newNode.prev.next = newNode;
        p.prev = newNode;
        theSize++;
        modCount++;
    }

    private AnyType remove(NodeMyLinkedList<AnyType> p) {
        p.next.prev = p.prev;
        p.prev.next = p.next;
        theSize--;
        modCount++;

        return p.data;
    }

    private NodeMyLinkedList<AnyType> getNode(int idx) {
        return getNode(idx, 0, size() - 1 );
    }

    private NodeMyLinkedList<AnyType> getNode(int idx, int lower, int upper) {
        NodeMyLinkedList<AnyType> p;
        if(idx < lower || idx > upper)
            throw new IndexOutOfBoundsException( );
        if(idx < size( ) / 2) {
            p = beginMarker.next;
            for(int i = 0; i < idx; i++)
                p = p.next;
            }
        else {
            p = endMarker;
            for(int i = size( ); i > idx; i--)
                p = p.prev;
            }

        return p;
    }

    public java.util.Iterator<AnyType> iterator() {
        return new LinkedListIterator();
    }

    public class LinkedListIterator implements java.util.Iterator<AnyType> {
        private NodeMyLinkedList<AnyType> current = beginMarker.next;
        private int expectedModCount = modCount;
        private boolean okToRemove = false;

        public boolean hasNext() {
            return current != endMarker;
        }

        public AnyType next( ) {
            if(modCount != expectedModCount)
                throw new java.util.ConcurrentModificationException( );
            if(!hasNext())
                throw new java.util.NoSuchElementException( );

            AnyType nextItem = current.data;
            current = current.next;
            okToRemove = true;

            return nextItem;
        }

        public void remove() {
            if(modCount != expectedModCount)
                throw new java.util.ConcurrentModificationException();
            if(!okToRemove)
                throw new IllegalStateException();

            MyLinkedList.this.remove(current.prev);
            expectedModCount++;
            okToRemove = false;
        }
    }

    public int theSize;
    public int modCount = 0;
    public NodeMyLinkedList<AnyType> beginMarker;
    public NodeMyLinkedList<AnyType> endMarker;
}
