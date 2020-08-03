// BEGIN CUT HERE
// PROBLEM STATEMENT
// A triple (x, y, z) is called an arithmetic progression if the equality y - x = z - y holds.

You are given three ints a, b and c. Your goal is to change the triple (a, b, c) into an arithmetic progression.
You are only allowed to change one of the three numbers.
The change must proceed as follows:
First, you choose a non-negative real (not necessarily integer) number r.
Then, you either add r to one of the three given numbers, or you subtract r from one of them. Return the minimum value of r which allows you to create an arithmetic progression.

DEFINITION
Class:TheArithmeticProgression
Method:minimumChange
Parameters:int, int, int
Returns:double
Method signature:double minimumChange(int a, int b, int c)


CONSTRAINTS
-a will be between 0 and 1000, inclusive.
-b will be between 0 and 1000, inclusive.
-c will be between 0 and 1000, inclusive.


EXAMPLES

0)
0
1
2

Returns: 0.0

The triple (0, 1, 2) is an arithmetic progression. Thus, you can choose r = 0.0 and add or subtract it from any of the given numbers without changing the triple.

1)
0
2
1

Returns: 1.5

Note that while (0, 1, 2) is an arithmetic progression, you cannot rearrange the numbers within the triple. You can choose r = 1.5 and subtract it from b, obtaining the triple (0, 0.5, 1).

2)
3
2
1

Returns: 0.0



3)
4
4
8

Returns: 2.0



// END CUT HERE
import java.util.*;
public class TheArithmeticProgression {
    public double minimumChange(int a, int b, int c) {
	double x=a;
	double y=b;
	double z=c;
        double res=Math.abs(y-(x+z)/2);

	
        return res;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        try {
            eq(0,(new TheArithmeticProgression()).minimumChange(0, 1, 2),0.0);
            eq(1,(new TheArithmeticProgression()).minimumChange(0, 2, 1),1.5);
            eq(2,(new TheArithmeticProgression()).minimumChange(3, 2, 1),0.0);
            eq(3,(new TheArithmeticProgression()).minimumChange(4, 4, 8),2.0);
        } catch( Exception exx) {
            System.err.println(exx);
            exx.printStackTrace(System.err);
        }
    }

// END CUT HERE
}
