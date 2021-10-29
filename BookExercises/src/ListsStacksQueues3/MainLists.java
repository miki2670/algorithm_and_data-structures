package ListsStacksQueues3;

import java.util.ArrayList;
import java.util.List;

public class MainLists {

    public static void main(String[] args) {

        //List Stacks and Queues - Part 3 ----------------------------------------

        // Task 3.1
        Lists lists1 = new Lists();

        List<Integer> lsqListL = new ArrayList<>();
        List<Integer> lsqListP = new ArrayList<>();
        // L has values
        lsqListL.add(12);
        lsqListL.add(16);
        lsqListL.add(5);
        lsqListL.add(420);
        lsqListL.add(1800);
        lsqListL.add(300);
        // P gets values from elements
        lsqListP.add(1);
        lsqListP.add(3);
        lsqListP.add(4);
        lsqListP.add(6);
        lists1.printLots(lsqListL, lsqListP);

        // Task 3.2
        Lists lists2 = new Lists();
        LinkedListCustom llist = new LinkedListCustom();

        llist.addNode(5);
        llist.addNode(25);
        llist.addNode(30);
        llist.addNode(37);

        lists2.swapWithNext(llist.getNode(25));

        llist.printList();

        // Task 3.3


    }
}
