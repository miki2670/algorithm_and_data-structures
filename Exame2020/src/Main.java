import java.util.Arrays;

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
    public static int myMethod(int N) { // O(log n * n^2)
        int x = 0; // O(1)
        for (int i = 0; i < N; i++) { // O(n)
            for (int j = 0; j < N/2; j++) { // O(n/2) = O(n)
                for (int k = 1; k < N;) { // O(n*2) = O(n)
                    x++;
                    k *= 2; // log
                }
            }
        }
        return x;
    }

    // Problem 2
    // Write a recursive method/algorithm. The algorithm returns the number of occurences of a
    // certain integer (parameter x). Parameter n is the number of elements in the array.
    // Example: called with the array {7,4,1,3,5,6,4,8}, n=8 and val=4, the correct return value is 2
    // Answer:
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
    // Answer: O(n^2)

    // Problem 4
    // Specify a method that can change the priority of an element in a priority queue of integers
    // and reestablish the heap order. The signature could be
        // changePriority(int fromP, int toP);
    // Preconditions of the method are that an element with priority fromP exists, and that toP != fromP
    // Explain in detail, step by step, how you would write/implement the method (in ordinary language/pseudo code
    // you do not need to implement it in a real programming language
    // Answer:
    public void changePriority(int fromP, int toP) {
        int pos = 0;
        for (int i = 1; i < currentSize; i++) {
            if (array[i] == fromP) {
                pos = i;
                break;
            }
        }
        if (toP < fromP) {
            array[pos] = toP;
            while (pos > 1 && array[pos] < array[pos/2]) {
                int temp = array[pos];
                array[pos] = array[pos/2];
                array[pos/2] = temp;
                pos /= 2;
            }
        }
        else {
            array[pos] = toP;
            percolateDown(pos);
        }
    }

    // Problem 5
    // Consider the hash-table below
    // Indexes 3,4,6,9 and 10 are vacant. What happens if an element hashing to index 1 is to be inserted?
    // The strategy used for collision resolution is quadratic probing
    // Answer:
    // First try: 1^2 = 2. Index 2 is already taken.
    // Second try: 1+2^2 = 5. Index 5 is already taken.
    // Third try: 1+3^2 = 10. Index 10 is free. Element will be inserted to index 10.


    // Problem 6
    // Write an algorithm that takes a string as input and return the most frequently occurring word
    // contained in the string. The string is plain text (small and capital letters), and words are
    // separated with blanks, commas, and fulls tops and combinations of these (see example below - you
    // may assume that there is always a blank between two words and that the last character is always a
    // full stop). Words are considered the same, even if some occurrences begin with a small letter
    // and others with a capital letter.
    // You mayassume as a precondition for your algorithm that the input parameter can only contain small
    // letters [a-z] capital letters [A-Z], blanks, commas (,) and fulls tops (.)
    // Example:
    // { The cattle were running back and forth, but there was no wolf to be seen, heard or smelled, so
    // the shepherd decided to take a little nap in a bed of grass and early summer flowers. Soon he was
    // awakened by a sound he had never heard before. }
    // The correct answer in the example is the word "a", which occurs three times.
    // Your algorithm must be optimized for running time efficiency, and you must provide a Big-Oh
    // running time of your solution
    // Answer:
    private static String mostFrequentWord(String s) {
        String s1= "";
        int noOfWords = 1;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                noOfWords++;
            }
            if (s.charAt(i) == ',' || s.charAt(i) == '.') {
                continue;
            }
            if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
                s1 = s1 + (char) (s.charAt(i) + 32); // transform capital letters into small letters
            }
            else {
                s1 = s1 + s.charAt(i);
            }
        }
        System.out.println("Words" + noOfWords);
        String [] arr = new String[noOfWords];
        int index = 0;
        for (int i = 0; i < s1.length(); i++) {
            String s2 = "";
            while (s1.charAt(i) != ' ' && i < s1.length()-1) { // if it is a word and we go to the end
                s2 += s1.charAt(i);
                i++;
            }
            arr[index++] = s2;
        }
        Arrays.sort(arr);
        String word = arr[0];
        int count = 1;
        int max = 0;
        for (int i = 1; i < noOfWords; i++) {
            if (arr[i].compareTo(arr[i-1]) == 0) { // compare a word to the previous word
                count++;
                if (count > max) {
                    max = count;
                    word = arr[i];
                }
            }
            else {
                count = 0;
            }
        }

        return word;
    }



}
