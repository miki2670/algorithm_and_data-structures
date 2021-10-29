package ListsStacksQueues3;

import java.util.Iterator;

public class Lists {

    // Task 3.1
    // You are given a list, L, and another list, P, containing integers sorted in ascending
    // order. The operation printLots(L,P) will print the elements in L that are in positions
    // specified by P. For instance, if P = 1, 3, 4, 6, the elements in positions 1, 3, 4, and 6
    // in L are printed. Write the procedure printLots(L,P). You may use only the public
    // Collections API container operations. What is the running time of your procedure?
    public <AnyType> void printLots(java.util.List<AnyType> L, java.util.List<Integer> P) {
        Iterator<AnyType> iterL = L.iterator();
        Iterator<Integer> iterP = P.iterator();

        AnyType itemL = null;
        Integer itemP = 0;
        int start = 0;

        while(iterL.hasNext() && iterP.hasNext()) {
            itemP = iterP.next();

            System.out.println("ELement " + itemP);
            while (start < itemP && iterL.hasNext()) {
                start++;
                itemL = iterL.next();
            }
            System.out.println(itemL);
        }
    }

    // Task 3.2
    // Swap two adjacent elements by adjusting only the links (and not the data) using:
    // a. Singly linked lists.
    // b. Doubly linked lists.

    // a. singly linked list
    public void swapWithNext(Node beforep) {
        Node p, afterp;

        p = beforep.next;
        afterp = p.next;

        p.next = afterp.next;
        beforep.next = afterp;
        afterp.next = p;
    }
}
