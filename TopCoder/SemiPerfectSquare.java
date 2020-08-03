// BEGIN CUT HERE
// PROBLEM STATEMENT
// Magical Girl Iris loves perfect squares.
A positive integer n is a perfect square if and only if there is a positive integer b >= 1 such that b*b = n.
For example, 1 (=1*1), 16 (=4*4), and 169 (=13*13) are perfect squares, while 2, 54, and 48 are not.

Iris also likes semi-squares.
A positive integer n is called a semi-square if and only if there are positive integers a >= 1 and b > 1 such that a < b and a*b*b = n.
For example, 81 (=1*9*9) and 48 (=3*4*4) are semi-squares, while 24, 63, and 125 are not.
(Note that we require that a < b.
Even though 24 can be written as 6*2*2, that does not make it a semi-square.)

You are given a int N.
Return "Yes" (quotes for clarity) if N is a semi-square number.
Otherwise, return "No".

DEFINITION
Class:SemiPerfectSquare
Method:check
Parameters:int
Returns:String
Method signature:String check(int N)


NOTES
-The return value is case-sensitive. Make sure that you return the exact strings "Yes" and "No".


CONSTRAINTS
-N will be between 2 and 1000, inclusive.


EXAMPLES

0)
48

Returns: "Yes"

48 can be expressed as 3 * 4 * 4. Therefore, 48 is a semi-square.

1)
1000

Returns: "No"

1000 can be represented as 10 * 10 * 10, but it doesn't match the definition of semi-perfect squares.

2)
25

Returns: "Yes"



3)
47

Returns: "No"



4)
847

Returns: "Yes"



// END CUT HERE
import java.util.*;
public class SemiPerfectSquare {
    public String check(int N) {
        String res="No";
	
	int[] h = {4,9,16,25,36,49,64,81,100,121,144,169,196,225,256,289,324,361,400,441,484,529,576,625,676,729,784,841,900,961};

	for (int i =0;i<h.length;i++){
		if (N % h[i] ==0) {
			if (N / h[i] < Math.sqrt(h[i]))res ="Yes";
		}
	}
	
        return res;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        try {
            eq(0,(new SemiPerfectSquare()).check(48),"Yes");
            eq(1,(new SemiPerfectSquare()).check(1000),"No");
            eq(2,(new SemiPerfectSquare()).check(25),"Yes");
            eq(3,(new SemiPerfectSquare()).check(47),"No");
            eq(4,(new SemiPerfectSquare()).check(847),"Yes");
        } catch( Exception exx) {
            System.err.println(exx);
            exx.printStackTrace(System.err);
        }
    }

// END CUT HERE
}
