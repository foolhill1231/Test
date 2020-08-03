// BEGIN CUT HERE
// PROBLEM STATEMENT
// Note that the memory limit for all tasks in this SRM is 256 MB.
This problem statement contains subscripts that may not display properly if viewed outside of the applet.

Manao is playing a solitaire game called OR-solitaire. In this game, the player starts with a number X = 0 and should obtain the number goal in one or more moves. The set of valid moves is determined by a int[] numbers. In each move, the player chooses some element of numbers and replaces X with the bitwise OR of X and the chosen element.

Fox Ciel wants Manao to stop playing OR-solitaire and move on with his life. She decided to erase some of the elements from numbers in such a way that it becomes impossible to complete the game. Return the minimum number of elements that need to be removed to achieve this.

DEFINITION
Class:ORSolitaireDiv2
Method:getMinimum
Parameters:int[], int
Returns:int
Method signature:int getMinimum(int[] numbers, int goal)


NOTES
-If a and b are single bits then a | b is defined as max(a, b). For two integers, A and B, in order to calculate A | B, they need to be represented in binary: A = (an...a1)2, B = (bn...b1)2 (if the lengths of their representations are different, the shorter one is prepended with the necessary number of leading zeroes). Then A | B = C = (cn...c1)2, where ci = ai | bi. For example, 10 | 3 = (1010)2 | (0011)2 = (1011)2 = 11.


CONSTRAINTS
-numbers will contain between 1 and 20 elements, inclusive.
-Each element of numbers will be between 1 and 1,000,000,000.
-The elements in numbers will be distinct.
-goal will be between 1 and 1,000,000,000.


EXAMPLES

0)
{1, 2, 4}
7

Returns: 1

The goal of the game is to obtain X = 7 from X = 0. The possible moves are to replace X with bitwise OR of X and 1, bitwise OR of X and 2 and bitwise OR of X and 4. X = 7 can be obtained only by using each of the three moves at least once, so removing any single element from numbers will make the game impossible to finish.

1)
{1, 2, 4, 7, 8}
7

Returns: 2

In this example, Fox Ciel should remove the number 7 and one of the numbers 1, 2, 4.

2)
{12571295, 2174218, 2015120}
1

Returns: 0

There is no need to remove elements from numbers, since the game cannot be completed in its initial version.

3)
{5, 2, 4, 52, 62, 9, 8, 3, 1, 11, 6}
11

Returns: 3



4)
{503, 505, 152, 435, 491, 512, 1023, 355, 510, 500, 502, 255, 63, 508, 509, 511, 60, 250, 254, 346}
510

Returns: 5



// END CUT HERE
import java.util.*;
public class ORSolitaireDiv2 {
    public int getMinimum(int[] numbers, int goal) {
        int go = goal;
    	int[] g = new int[32];
    	int[] s = new int[32];
    	int n= numbers.length;
    	int i=0;
    	
    	while(goal>0){
    		g[i++]=goal%2;
    		goal/=2;
    	}
    	
    	for (int j=0;j<n;j++){
    		goal = numbers[j];
    		if (goal>go) continue;
    		i=0;
    		boolean flg = true;
    		int[] b = new int[32];
    		
    		while(goal>0){
    				b[i]=goal%2;
    			if (b[i]==1 && g[i] ==0) flg =false;
    			goal/=2;
    			i++;
    		}
    		if (flg){
    			for (i=0;i<32;i++){
    				s[i]+=b[i];	
    			}
    		}
    	}
    	
    	int min=Integer.MAX_VALUE;
    	
    	for (int j=0;j<32;j++){
    		if (g[j]==1){
    			min = Math.min(s[j],min);	
    		}
    	}
    	return min;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        try {
            eq(0,(new ORSolitaireDiv2()).getMinimum(new int[] {1, 2, 4}, 7),1);
            eq(1,(new ORSolitaireDiv2()).getMinimum(new int[] {1, 2, 4, 7, 8}, 7),2);
            eq(2,(new ORSolitaireDiv2()).getMinimum(new int[] {12571295, 2174218, 2015120}, 1),0);
            eq(3,(new ORSolitaireDiv2()).getMinimum(new int[] {5, 2, 4, 52, 62, 9, 8, 3, 1, 11, 6}, 11),3);
            eq(4,(new ORSolitaireDiv2()).getMinimum(new int[] {503, 505, 152, 435, 491, 512, 1023, 355, 510, 500, 502, 255, 63, 508, 509, 511, 60, 250, 254, 346}, 510),5);
        } catch( Exception exx) {
            System.err.println(exx);
            exx.printStackTrace(System.err);
        }
    }

// END CUT HERE
}
