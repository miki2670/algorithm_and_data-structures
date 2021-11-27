public class Main {

    public static void main(String[] args) {

        //TEST from task description:
        Tree tree = new Tree();
        System.out.println("Test: " + tree.minimum_steps(8,8, 4, 4, 3,2));

        //TEST 1:
        Tree tree1 = new Tree();
        System.out.println("Test 1: " + tree1.minimum_steps(8, 8, 4, 4, 4, 5));
        //output: 3

        //TEST 2:
        Tree tree2 = new Tree();
        System.out.println("Test 2: " + tree2.minimum_steps(8, 8, 0, 0, 7, 7));
        //output: 6

        //TEST 3:
        Tree tree3 = new Tree();
        System.out.println("Test 3: " + tree3.minimum_steps(8, 8, 0, 0, 0, 7));
        //output: 5

        //TEST 4:
        Tree tree4 = new Tree();
        System.out.println("Test 4: " + tree4.minimum_steps(20, 10, 0, 4, 9, 15));
        //output: 8

        //TEST 5:
        Tree tree5 = new Tree();
        System.out.println("Test 5: " + tree5.minimum_steps(100, 10, 4, 4, 9, 99));
        //output: 48

        //TEST 6:
        Tree tree6 = new Tree();
        System.out.println("Test 6: " + tree6.minimum_steps(8, 8, 4, 4, 4, 4));
        //output: 0

        //TEST 7:
        Tree tree7 = new Tree();
        System.out.println("Test 7: " + tree7.minimum_steps(100, 100, 50, 50, 57, 57));
        //output: 6

    }
}
