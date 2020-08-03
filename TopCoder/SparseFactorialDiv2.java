// BEGIN CUT HERE
// PROBLEM STATEMENT
// For an integer n, let F(n) = (n - 0^2) * (n - 1^2) * (n - 2^2) * (n - 3^2) * ... * (n - k^2), where k is the largest integer such that n - k^2 > 0.
You are given three longs lo, hi and divisor.
It is guaranteed that divisor will be a prime number.
Compute and return the number of integers n between lo and hi, inclusive, such that F(n) is divisible by divisor.

DEFINITION
Class:SparseFactorialDiv2
Method:getCount
Parameters:long, long, long
Returns:long
Method signature:long getCount(long lo, long hi, long divisor)


CONSTRAINTS
-lo will be between 1 and 1,000,000,000,000, inclusive.
-hi will be between lo and 1,000,000,000,000, inclusive.
-divisor will be between 2 and 997, inclusive.
-divisor will be a prime number.


EXAMPLES

0)
4
8
3

Returns: 3

The value of F(n) for each n = 4, 5, ..., 8 is as follows. 

F(4) = 4*3   = 12
F(5) = 5*4*1 = 20
F(6) = 6*5*2 = 60
F(7) = 7*6*3 = 126
F(8) = 8*7*4 = 224

Thus, F(4), F(6), F(7) are divisible by 3 but F(5) and F(8) are not.

1)
9
11
7

Returns: 1


F(9)  = 9*8*5     = 360
F(10) = 10*9*6*1  = 540
F(11) = 11*10*7*2 = 1540

Only F(11) is divisible by 7.

2)
1
1000000000000
2

Returns: 999999999999

Watch out for the overflow. 

3)
16
26
11

Returns: 4



4)
10000
20000
997

Returns: 1211



5)
123456789
987654321
71

Returns: 438184668



// END CUT HERE
import java.util.*;
public class SparseFactorialDiv2 {
    public long getCount(long lo, long hi, long divisor) {
        long res;
        return res;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        try {
            eq(0,(new SparseFactorialDiv2()).getCount(4L, 8L, 3L),3L);
            eq(1,(new SparseFactorialDiv2()).getCount(9L, 11L, 7L),1L);
            eq(2,(new SparseFactorialDiv2()).getCount(1L, 1000000000000L, 2L),999999999999L);
            eq(3,(new SparseFactorialDiv2()).getCount(16L, 26L, 11L),4L);
            eq(4,(new SparseFactorialDiv2()).getCount(10000L, 20000L, 997L),1211L);
            eq(5,(new SparseFactorialDiv2()).getCount(123456789L, 987654321L, 71L),438184668L);
        } catch( Exception exx) {
            System.err.println(exx);
            exx.printStackTrace(System.err);
        }
    }

// END CUT HERE
}
