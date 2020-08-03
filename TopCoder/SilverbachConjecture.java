// BEGIN CUT HERE
// PROBLEM STATEMENT
// In this problem, some test cases have more than one correct output. We are using a special checker to verify that the output of your program is correct.

A positive integer x is called composite if there are positive integers y > 1 and z > 1 such that x = yz.
In other words, a composite positive integer has a positive integer divisor other than 1 and itself.
For example, 48 is composite because 48 = 4*12.
The smallest few composite integers are 4, 6, 8, 9, and 10.

You are given an int n.
Return a int[] with two elements.
Both elements of the returned int[] must be positive composite integers, and their sum must be n.

For the given constraints on n at least one such pair always exists.
Note that if there are many such pairs, your solution can return any one of them.

DEFINITION
Class:SilverbachConjecture
Method:solve
Parameters:int
Returns:int[]
Method signature:int[] solve(int n)


CONSTRAINTS
-n will be between 20 and 2000, inclusive.


EXAMPLES

0)
20

Returns: {8, 12 }

For n=20 there are seven correct answers: {4,16}, {6,14}, {8,12}, {10,10}, {12,8}, {14,6}, and {16,4}. Your program must return one of these seven answers.

1)
30

Returns: {15, 15 }

You may return two identical numbers.

2)
999

Returns: {699, 300 }



3)
45

Returns: {15, 30 }



// END CUT HERE
import java.util.*;
public class SilverbachConjecture {
	
	public boolean check(int n){
		for (int i=2;i<n;i++){
			if (n%2==0) return true;	
		}
		return false;
	}
    public int[] solve(int n) {
    	int[] res={0,0};
    	
    	
    	boolean flg = false;
    	
    	for (int i=4 ; i<n/2+1;i++){
    		if (check(i)){
    			int j = n-i;
    			for (int k =2;k<j;k++){
    				if (j%k==0){
    					res[0]=i;
    					res[1]=j;
    					flg = true;
    				}
    			}
    		}
    		if (flg) break;
    	}
        return res;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        try {
            eq(0,(new SilverbachConjecture()).solve(20),new int[] {8, 12 });
            eq(1,(new SilverbachConjecture()).solve(30),new int[] {15, 15 });
            eq(2,(new SilverbachConjecture()).solve(999),new int[] {699, 300 });
            eq(3,(new SilverbachConjecture()).solve(45),new int[] {15, 30 });
        } catch( Exception exx) {
            System.err.println(exx);
            exx.printStackTrace(System.err);
        }
    }

// END CUT HERE
}
