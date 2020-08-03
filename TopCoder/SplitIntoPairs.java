// BEGIN CUT HERE
// PROBLEM STATEMENT
// You are given a int[] A with N elements, where N is even.
Note that some elements of A may be negative.
You are also given a int X which is guaranteed to be negative.
You must divide the elements of A into N/2 disjoint pairs.
(That is, each element of A must be in exactly one of those pairs.)
Your goal is to maximize the number of pairs in which the product of the two elements is greater than or equal to X.
Return the largest possible number of such pairs.

DEFINITION
Class:SplitIntoPairs
Method:makepairs
Parameters:int[], int
Returns:int
Method signature:int makepairs(int[] A, int X)


CONSTRAINTS
-A will contain between 2 and 50 elements, inclusive.
-The number of elements in A will be even.
-Each element in A will be between -1,000,000,000 and 1,000,000,000, inclusive.
-X will be between -1,000,000,000 and -1, inclusive.


EXAMPLES

0)
{2,-1}
-1

Returns: 0

One possible pair has product -2, which is lower than needed.

1)
{1,-1}
-1

Returns: 1

Here product is -1, it's enough.

2)
{-5,-4,2,3}
-1

Returns: 2

If first pair contains numbers -5 and -4, and second contains 2 and 3, both will have positive product.

3)
{5,-7,8,-2,-5,3}
-7

Returns: 3

Acceptable splitting is {5,8}, {-7,-5} and {-2,3}.

4)
{3,4,5,6,6,-6,-4,-10,-1,-9}
-2

Returns: 4



5)
{1000000,1000000}
-5

Returns: 1

Beware overflow.

// END CUT HERE
import java.util.*;
public class SplitIntoPairs {
    public int makepairs(int[] A, int X) {
        Arrays.sort(A);
        int res=0;
    	
    	for (int i=0;i<A.length;i+=2){
    		long a = A[i];
    		long b= A[i+1];
    		if (a*b>=X){
    			res++;
    		}
    	}
        return res;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        try {
            eq(0,(new SplitIntoPairs()).makepairs(new int[] {2,-1}, -1),0);
            eq(1,(new SplitIntoPairs()).makepairs(new int[] {1,-1}, -1),1);
            eq(2,(new SplitIntoPairs()).makepairs(new int[] {-5,-4,2,3}, -1),2);
            eq(3,(new SplitIntoPairs()).makepairs(new int[] {5,-7,8,-2,-5,3}, -7),3);
            eq(4,(new SplitIntoPairs()).makepairs(new int[] {3,4,5,6,6,-6,-4,-10,-1,-9}, -2),4);
            eq(5,(new SplitIntoPairs()).makepairs(new int[] {1000000,1000000}, -5),1);
        } catch( Exception exx) {
            System.err.println(exx);
            exx.printStackTrace(System.err);
        }
    }

// END CUT HERE
}
