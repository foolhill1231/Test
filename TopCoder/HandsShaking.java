// BEGIN CUT HERE
// PROBLEM STATEMENT
// Consider a meeting of n businessmen sitting around a circular table. To start the meeting, they must shake hands. Each businessman shakes the hand of exactly one other businessman. All handshakes happen simultaneously. We say that the shake is perfect if no arms cross each other. Given an int n, return the number of perfect shakes that exist for n businessmen. See examples for further clarification.

DEFINITION
Class:HandsShaking
Method:countPerfect
Parameters:int
Returns:long
Method signature:long countPerfect(int n)


NOTES
-Businessmen are distinguishable. Rotating a perfect shake can yield a different perfect shake (see example 1).


CONSTRAINTS
-n will be between 2 and 50, inclusive.
-n will be even.


EXAMPLES

0)
2

Returns: 1

Two businessmen have only one possibility - just to shake each other's hand.

1)
4

Returns: 2

Two out of three possible shakes are perfect.
? ? 

2)
8

Returns: 14



// END CUT HERE
import java.util.*;
public class HandsShaking {
    public long countPerfect(int n) {
        long res;
        return res;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        try {
            eq(0,(new HandsShaking()).countPerfect(2),1L);
            eq(1,(new HandsShaking()).countPerfect(4),2L);
            eq(2,(new HandsShaking()).countPerfect(8),14L);
        } catch( Exception exx) {
            System.err.println(exx);
            exx.printStackTrace(System.err);
        }
    }

// END CUT HERE
}
