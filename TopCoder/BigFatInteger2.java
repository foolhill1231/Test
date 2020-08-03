// BEGIN CUT HERE
// PROBLEM STATEMENT
// This problem statement contains superscipts that may not display properly outside the applet.

You are given four ints A, B, C and D. Return "divisible" (quotes for clarity) if AB is divisible by CD. Return "not divisible" otherwise.

DEFINITION
Class:BigFatInteger2
Method:isDivisible
Parameters:int, int, int, int
Returns:String
Method signature:String isDivisible(int A, int B, int C, int D)


NOTES
-The return value is case-sensitive.
-Positive integer y divides a positive integer x if and only if there is a positive integer z such that y*z=x. In particular, for each positive integer x, both 1 and x divide x.


CONSTRAINTS
-A, B, C and D will each be between 1 and 1,000,000,000 (109), inclusive.


EXAMPLES

0)
6
1
2
1

Returns: "divisible"

Here, AB = 61 = 6 and CD = 21 = 2. 6 is divisible by 2.

1)
2
1
6
1

Returns: "not divisible"

2 is not divisible by 6.

2)
1000000000
1000000000
1000000000
200000000

Returns: "divisible"

Now the numbers are huge, but we can see that AB is divisible by CD from the fact that A=C and B>D.

3)
8
100
4
200

Returns: "not divisible"

We can rewrite 8100 as (23)100 = 2300.
Similarly, 4200 = (22)200 = 2400.
Thus, 8100 is not divisible by 4200.

4)
999999937
1000000000
999999929
1

Returns: "not divisible"

Here A and C are distinct prime numbers, which means AB cannot have C as its divisor.

5)
2
2
4
1

Returns: "divisible"



// END CUT HERE
import java.util.*;
public class BigFatInteger2 {
	
	int gcd(int A, int C){
		if (C==0) return A;
		else return gcd(C, A%C);
	}
	
    public String isDivisible(int A, int B, int C, int D) {
        String res1="divisible";
    	String res2="not divisible";
    	
    	int f = 1;
    	int s =2;
    	
    	if (C==1) return res1;
    	if (A==1) return res2;
    	
    	if (A%C==0){
    		if (B>=D) return res1;
    	}
    	
    	if (D==1){
    		if (A>=C){
    			if (A%C==0) return res1;	
    		}
    	}
    	
    	while(A<C){
    		 A*=A;
    		f++;
    	}
    	
    	while(C<A){
    		C*=C;
    		s++;
    	}
    	
    	int val1 = B/f;
    	int val2 = D/s;
    	
    	if (A!=C) return res2;
    	if (val1>=val2) return res1;
    	else return res2;
    	
    	
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        try {
            eq(0,(new BigFatInteger2()).isDivisible(6, 1, 2, 1),"divisible");
            eq(1,(new BigFatInteger2()).isDivisible(2, 1, 6, 1),"not divisible");
            eq(2,(new BigFatInteger2()).isDivisible(1000000000, 1000000000, 1000000000, 200000000),"divisible");
            eq(3,(new BigFatInteger2()).isDivisible(8, 100, 4, 200),"not divisible");
            eq(4,(new BigFatInteger2()).isDivisible(999999937, 1000000000, 999999929, 1),"not divisible");
            eq(5,(new BigFatInteger2()).isDivisible(2, 2, 4, 1),"divisible");
        } catch( Exception exx) {
            System.err.println(exx);
            exx.printStackTrace(System.err);
        }
    }

// END CUT HERE
}
