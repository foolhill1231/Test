// BEGIN CUT HERE
// PROBLEM STATEMENT
// Let A be a sequence of integers. We want to create this sequence as a concatenation of some (one or more) strictly increasing sequences. The LISNumber of A is the smallest number of strictly increasing sequences we need.

For example, the LISNumber of the sequence A = {1, 4, 4, 2, 6, 3} is 4, since A can be created as {1, 4} + {4} + {2, 6} + {3}, and there is no way to create A by concatenating 3 (or fewer) strictly increasing sequences.

Another example: The LISNumber of the sequence B = {10, 20, 30} is 1, since B is already a strictly increasing sequence.

Note that the optimal way of writing a sequence as a concatenation of some strictly increasing sequences is always unique.

You are given a int[] seq. Return the LISNumber of the sequence seq.

DEFINITION
Class:LISNumberDivTwo
Method:calculate
Parameters:int[]
Returns:int
Method signature:int calculate(int[] seq)


CONSTRAINTS
-seq will contain between 1 and 50 elements, inclusive.
-Each element of seq will be between 1 and 50, inclusive.


EXAMPLES

0)
{1, 4, 4, 2, 6, 3}

Returns: 4

This is the example from the problem statement.

1)
{5, 8, 9, 12, 16, 32, 50}

Returns: 1

In this case, seq itself is already strictly increasing. Thus, the LISNumber of this sequence is 1.

2)
{1, 1, 9, 9, 2, 2, 3, 3}

Returns: 6

{1, 1, 9, 9, 2, 2, 3, 3} = {1} + {1, 9} + {9} + {2} + {2, 3} + {3}

3)
{50, 40, 30, 20, 10}

Returns: 5



4)
{42}

Returns: 1



// END CUT HERE
import java.util.*;
public class LISNumberDivTwo {
    public int calculate(int[] seq) {
      
  int res=1;
	for (int i =0;i<seq.length-1;i++){
		if (seq[i]>=seq[i+1]) res++;
	}
        return res;
       
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        try {
            eq(0,(new LISNumberDivTwo()).calculate(new int[] {1, 4, 4, 2, 6, 3}),4);
            eq(1,(new LISNumberDivTwo()).calculate(new int[] {5, 8, 9, 12, 16, 32, 50}),1);
            eq(2,(new LISNumberDivTwo()).calculate(new int[] {1, 1, 9, 9, 2, 2, 3, 3}),6);
            eq(3,(new LISNumberDivTwo()).calculate(new int[] {50, 40, 30, 20, 10}),5);
            eq(4,(new LISNumberDivTwo()).calculate(new int[] {42}),1);
        } catch( Exception exx) {
            System.err.println(exx);
            exx.printStackTrace(System.err);
        }
    }

// END CUT HERE
}
