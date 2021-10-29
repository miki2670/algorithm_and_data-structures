package Introduction1;

public class Recursion {

    // Write a recursive method that returns the number of 1’s in the binary representation
    // of N. Use the fact that this is equal to the number of 1’s in the representation of N/2,
    // plus 1, if N is odd.
    public int onesInBinaryRepresentation(int n) {
        if (n < 2) {
            return n;
        }
        return n % 2 + onesInBinaryRepresentation(n/2);
    }



}
