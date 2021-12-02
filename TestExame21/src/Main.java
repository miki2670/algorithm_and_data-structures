import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {

        System.out.println(myMethod(100));

        System.out.println(sumDivisibleBy3(12));

        System.out.println(decideNaturalNumber(6561));

    }

    // Problem 1
    // Time complexity of:
    static int myMethod(int N) { // O(n^1/2 * n^2)
        int x = 0; // O(1)
        for (int i = 1; i <= Math.sqrt(N); i++) { //square root; C++: #include <math.h>
            for (int j = 1; j <= N; j++) // O(n)
                for (int k = 1; k < N;)  { // O(n)
                    x++; // O(1)
                    k = k * 2; // O(1)
                }
        } return x;
    }
    // Answer: O(n^1/2 * n^2)


    // Problem 2
    // Write a recursive method
    // Answer:
    static int sumDivisibleBy3 (int n) {

        if (n <= 0) {
            return 0;
        }
        if (n % 3 == 0) {
            return 3 + sumDivisibleBy3(n-1);
        }

        return sumDivisibleBy3(n-1);
    }

    // Problem 3
    // Binary tree
    // Answer:
    // Postorder: 1 8 5 15 12 10 22 20 28 30 38 45 50 48 40 36 25
    // Preorder: 25 20 10 5 1 8 12 15 22 36 30 28 40 38 48 45 50
    // Internal path length: 4
    // Is it an AVL-tree?: No it is not an AVL-tree as the height of the tree's two subtrees does not
    // differ from more or equal to 1. Both sides of the tree is equally high. With an AVL-tree the height
    // of the two should differ by > 1.

    // Problem 4
    // Answer:
    static String decideNaturalNumber(int Z) {

        ArrayList solutions = new ArrayList();

        for (int X = 2; X < Z/2; X++) {
            for (int Y = 2; Y < Z/2; Y++) {
                if (Math.pow(X, Y) == Z) {
                    solutions.add(X + "^" + Y);
                }
            }
        }

        if (solutions.size() == 1) {
            return (String) solutions.get(0);
        }

        if (solutions.size() > 1) {
            return String.valueOf(solutions.get(solutions.size()-1));
        }

        return "error";

    }

    // Problem 5
    // Answer:
    // Minimum spanning tree list: h-g g-f (i-c) f-c (a-b) c-d (h-a) d-f

    // Problem 6
    // Answer:
    // Yes it can

    // Problem 7
    // 0 |
    // 1 |
    // 2 | V
    // 3 | R
    // 4 |
    // 5 |
    // 6 | P
    // 7 |
    // 8 | E
    // 9 |
    // 10 | F
    // Answer
    // First insertion of Q:
    // Index 7 is free so insertion of Q will go into index 7.
    // Second insertion of C:
    // 8^2 = 64 % 11 = 9. Index 9 is free so insertion of C will go into index 9.
    // Third insertion of H:
    // 2^2 = 4. Index 4 is free so insertion of H will go into index 4.


}
