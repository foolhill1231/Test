// BEGIN CUT HERE
// PROBLEM STATEMENT
// 
Little Elephant from the Zoo of Lviv likes integers.




You are given an int[] A. On a single turn, Little Elephant can double (i.e., multiply by 2) any element of A. He may double the same element more than once, if he wants to. He wants to obtain an array in which all elements are equal. Return "YES" (quotes for clarity) if it is possible to do that and "NO" otherwise.



DEFINITION
Class:LittleElephantAndDouble
Method:getAnswer
Parameters:int[]
Returns:String
Method signature:String getAnswer(int[] A)


NOTES
-The return value is case-sensitive. Make sure that you return the exact strings "YES" and "NO".


CONSTRAINTS
-A will contain between 1 and 50 elements, inclusive.
-Each element of A will be between 1 and 1,000,000,000, inclusive.


EXAMPLES

0)
{1, 2}

Returns: "YES"

One possible way of making all elements equal is to double the element at index 0.

1)
{1, 2, 3}

Returns: "NO"

It's impossible to make all three elements equal in this case.

2)
{4, 8, 2, 1, 16}

Returns: "YES"



3)
{94, 752, 94, 376, 1504}

Returns: "YES"



4)
{148, 298, 1184}

Returns: "NO"



5)
{7, 7, 7, 7}

Returns: "YES"



// END CUT HERE
import java.util.*;
public class LittleElephantAndDouble {
    public String getAnswer(int[] A) {
        String res="";
    	
    	
    	for (int i=0;i<A.length;i++){
    		while((A[i] % 2)==0){
    			A[i] /=2;	
    		}	
    	}
    	
    	for (int i=0;i<A.length-1;i++){
    		if (A[i] != A[i+1]){
    			 res= "NO";
    		
    		}
    	}
        return res;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        try {
            eq(0,(new LittleElephantAndDouble()).getAnswer(new int[] {1, 2}),"YES");
            eq(1,(new LittleElephantAndDouble()).getAnswer(new int[] {1, 2, 3}),"NO");
            eq(2,(new LittleElephantAndDouble()).getAnswer(new int[] {4, 8, 2, 1, 16}),"YES");
            eq(3,(new LittleElephantAndDouble()).getAnswer(new int[] {94, 752, 94, 376, 1504}),"YES");
            eq(4,(new LittleElephantAndDouble()).getAnswer(new int[] {148, 298, 1184}),"NO");
            eq(5,(new LittleElephantAndDouble()).getAnswer(new int[] {7, 7, 7, 7}),"YES");
        } catch( Exception exx) {
            System.err.println(exx);
            exx.printStackTrace(System.err);
        }
    }

// END CUT HERE
}
