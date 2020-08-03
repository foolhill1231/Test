// BEGIN CUT HERE
// PROBLEM STATEMENT
// For any non-empty sequence of positive integers s1, s2, ..., sK their least common multiple is the smallest positive integer that is divisible by each of the given numbers.
We will use "lcm" to denote the least common multiple.
For example, lcm(3) = 3, lcm(4,6) = 12, and lcm(2,5,7) = 70.


You are given a int[] S and an int x.
Find out whether we can select some elements from S in such a way that their least common multiple will be precisely x.
Formally, we are looking for some s1, s2, ..., sK, K >= 1, such that each si belongs to S, and x=lcm(s1, s2, ..., sK).
Return "Possible" if such elements of S exist, and "Impossible" if they don't.

DEFINITION
Class:LCMSetEasy
Method:include
Parameters:int[], int
Returns:String
Method signature:String include(int[] S, int x)


CONSTRAINTS
-S will contain between 1 and 50 elements, inclusive.
-Each element in S will be between 1 and 1,000,000,000, inclusive.
-Elements in S will be distinct.
-x will be between 2 and 1,000,000,000, inclusive.


EXAMPLES

0)
{2,3,4,5}
20

Returns: "Possible"

We can obtain 20 in multiple ways. One of them: 20 = lcm(4, 5).

1)
{2,3,4}
611

Returns: "Impossible"

If S={2,3,4}, the only values we can obtain are 2, 3, 4, 6, and 12.

2)
{2,3,4}
12

Returns: "Possible"



3)
{1,2,3,4,5,6,7,8,9,10}
24

Returns: "Possible"



4)
{100,200,300,400,500,600}
2000

Returns: "Possible"



5)
{100,200,300,400,500,600}
8000

Returns: "Impossible"



6)
{1000000000,999999999,999999998}
999999999

Returns: "Possible"



// END CUT HERE
import java.util.*;
public class LCMSetEasy {
	
	public long gcd(long a, long b){
		return b==0 ? a : gcd(b, a%b);	
	}
	public long lcm(long a, long b){
		return a*b/ gcd(a,b);
	}
	
    public String include(int[] S, int x) {
    	
    	long t=1;
    	
    	for (int i= 0;i<S.length;i++){
    		if (x % S[i] ==0){
    			t = lcm(t,S[i]);
    			
    			if (t > x) return "Impossible";
    		}
    		
    	}
    	if (t==x) return "Possible";
        return "Impossible";
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        try {
            eq(0,(new LCMSetEasy()).include(new int[] {2,3,4,5}, 20),"Possible");
            eq(1,(new LCMSetEasy()).include(new int[] {2,3,4}, 611),"Impossible");
            eq(2,(new LCMSetEasy()).include(new int[] {2,3,4}, 12),"Possible");
            eq(3,(new LCMSetEasy()).include(new int[] {1,2,3,4,5,6,7,8,9,10}, 24),"Possible");
            eq(4,(new LCMSetEasy()).include(new int[] {100,200,300,400,500,600}, 2000),"Possible");
            eq(5,(new LCMSetEasy()).include(new int[] {100,200,300,400,500,600}, 8000),"Impossible");
            eq(6,(new LCMSetEasy()).include(new int[] {1000000000,999999999,999999998}, 999999999),"Possible");
        } catch( Exception exx) {
            System.err.println(exx);
            exx.printStackTrace(System.err);
        }
    }

// END CUT HERE
}
