// BEGIN CUT HERE
// PROBLEM STATEMENT
// Andrew has a combination lock.
The lock consists of multiple dials that are placed next to each other.
Each dial contains the digits 0 through 9, in order.
At any moment, exactly one of the digits on each dial is visible.
The string formed by the currently visible digits is called the current combination.

The visible digit on a dial can be changed by rotating the dial up or down.
Rotating the dial up changes 0 to 1, 1 to 2, and so on.
Note that the digits on a dial wrap around: if we rotate up a dial that shows a 9, it will show a 0 again.
Naturally, rotating the dial down changes the digit in the other direction.

We are able to rotate multiple dials at the same time, as long as they are next to each other.
More precisely, in a single turn we can take an arbitrarily long segment of consecutive dials, and rotate all of them one step in the same direction (i.e., either all of them up, or all of them down).

For example, suppose that the current combination is "123".
In one step, we can change it to many different combinations, including "012" (all three dials down), "234" (all three dials up), "133" (middle dial up), and "013" (first two dials down).
Note that we cannot change "123" to "224" in a single step.

You are given two Strings: S and T.
S is the current combination, T is the secret combination that unlocks the lock.
That is, to open the lock we need to change S into T by rotating some of the dials.
Return the smallest number of steps needed.

DEFINITION
Class:CombinationLockDiv2
Method:minimumMoves
Parameters:String, String
Returns:int
Method signature:int minimumMoves(String S, String T)


CONSTRAINTS
-S will contain between 1 and 50 characters, inclusive.
-S will contain the same number of characters as T.
-Each character in S and T will be a digit ('0'-'9').


EXAMPLES

0)
"123"
"112"

Returns: 1

Rotate the last two dials down.

1)
"1"
"7"

Returns: 4

Rotate the dial down 4 times: from 1 to 0, from 0 to 9, from 9 to 8, and from 8 to 7.

2)
"607"
"607"

Returns: 0



3)
"1234"
"4567"

Returns: 3



4)
"020"
"909"

Returns: 2



5)
"4423232218340"
"6290421476245"

Returns: 18



// END CUT HERE
import java.util.*;
public class CombinationLockDiv2 {
    public int minimumMoves(String S, String T) {
        int res;
        return res;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        try {
            eq(0,(new CombinationLockDiv2()).minimumMoves("123", "112"),1);
            eq(1,(new CombinationLockDiv2()).minimumMoves("1", "7"),4);
            eq(2,(new CombinationLockDiv2()).minimumMoves("607", "607"),0);
            eq(3,(new CombinationLockDiv2()).minimumMoves("1234", "4567"),3);
            eq(4,(new CombinationLockDiv2()).minimumMoves("020", "909"),2);
            eq(5,(new CombinationLockDiv2()).minimumMoves("4423232218340", "6290421476245"),18);
        } catch( Exception exx) {
            System.err.println(exx);
            exx.printStackTrace(System.err);
        }
    }

// END CUT HERE
}
