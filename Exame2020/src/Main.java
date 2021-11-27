public class Main {

    // Exame tasks from last year (2020)
    // 1-6 Problems

    public static void main(String[] args) {

        // Problem 1
        System.out.println("Problem 1: " + myMethod(100));

        // Problem 2
        int[] intArr = {7,4,1,3,5,6,4,8};
        System.out.println("Problem 2: " + getNumberEqual(intArr, 8, 4));

        // Problem 3
        // Teori (rul ned for svaret)

    }

    // Problem 1
    // What is the big-oh time complexity of the following method?
    // please explain
    // Answer:
    public static int myMethod(int N) { // O(n^3)
        int x = 0; // O(1)
        for (int i = 0; i < N; i++) { // O(n)
            for (int j = 0; j < N/2; j++) { // O(n/2) = O(n)
                for (int k = 1; k < N;) { // O(n*2) = O(n)
                    x++;
                    k *= 2;
                }
            }
        }
        return x;
    }

    // Problem 2
    // Write a recursive method/algorithm. The algorithm returns the number of occurences of a
    // certain integer (parameter x). Parameter n is the number of elements in the array.
    // Example: called with the array {7,4,1,3,5,6,4,8}, n=8 and val=4, the correct return value is 2
    public static int getNumberEqual(int[] x, int n, int val) {

        if (n <= 0) { // if no more elements in array left
            return 0;
        }
        if (x[n-1] == val) {
            return 1 + getNumberEqual(x, n-1, val); // if we find match plus result with 1
        }
        
        return getNumberEqual(x, n-1, val); // if no match, continue
    }

    // Problem 3
    // Solve the following recurrence. All relevant steps must be shown leading to a Big-Oh answer.
    // T(N) = T(N-1)+(N-1)



}
