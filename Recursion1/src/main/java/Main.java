import java.util.Map;

public class Main {

    public static void main(String[] args) {

        //System.out.println(sum(5));
        System.out.println(evenSquares(10));
        //System.out.println(fib(10));
        //System.out.println(linear("c", 'c', 1));

    }

    // recursion - returns the sum of the first n natural numbers
    public static int sum(int n) {

        if (n == 0)
            return 0;
        else
            return n + sum(n - 1);
            // 5 + (4 + (3 + (2 + (1 = 15
    }

    // recursion - returns the sum of the first n even numbers' squares
    public static int evenSquares(int n) {

        if (n <= 1)
            return 0;
        else
            return evenSquares(n - 2) + n * n;

        // 2^2 + 4^2 + 6^2 + 8^2 + 10^2 = 220
    }

    // recursion - returns the nth Fibonacci number
    public static int fib(int n) {

        if (n <= 1) {
            return n;
        }

        return fib(n - 1) + fib(n - 2);
        //
    }

    // recursion - returns true if string s with the length 1 contains char c - else false
    public static boolean linear(String s, char c, int l) {

        return true;

    }

}
