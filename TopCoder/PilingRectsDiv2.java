// BEGIN CUT HERE
// PROBLEM STATEMENT
// Snake Snuke has N rectangles cut out of paper.
The rectangles are labeled 0 through N-1.
You are given int[]s X and Y with N elements each.
For each i, the sides of rectangle i have lengths X[i] and Y[i].

Snake Snuke will choose some of his rectangles and place them onto a table, one rectangle at a time, in any order he likes.
Each rectangle (except for the first one) must overlap the immediately previous one, so at the end Snuke will have a pile of rectangles.
Snuke may rotate the rectangles, but once placed, the sides of each rectangle must be parallel to the sides of the table.
(I.e., he may only swap the width and height of some rectangles he places.)
After placing all the rectangles, Snuke computes the area that is covered by all N rectangles.
(Formally, the area of their intersection.)

You are also given an int limit.
The area computed by Snuke must be greater than or equal to limit.

Return the largest positive R such that Snuke can select some R of his rectangles and place them in such a way that the area of their intersection is at least limit. If there is no such R, return -1 instead.


DEFINITION
Class:PilingRectsDiv2
Method:getmax
Parameters:int[], int[], int
Returns:int
Method signature:int getmax(int[] X, int[] Y, int limit)


CONSTRAINTS
-X and Y will contain between 1 and 50 elements, inclusive.
-X and Y will contain the same number of elements.
-Each element of X and Y will be between 1 and 200, inclusive.
-limit will be between 1 and 40000, inclusive.


EXAMPLES

0)
{1,2,3,1}
{3,2,4,4}
3

Returns: 3

He can choose rectangles 0, 2, and 3. These three rectangles can then be placed in such a way that both rectangle 2 and rectangle 3 cover rectangle 0 completely. For this placement, the area of their intersection will be exactly 3.

1)
{4,7}
{7,4}
25

Returns: 2

Note that he can rotate rectangles.

2)
{10}
{10}
9999

Returns: -1

There is no possible choice.

3)
{10}
{3}
30

Returns: 1



4)
{3,6,5,8,2,9,14}
{14,6,13,8,15,6,3}
27

Returns: 4



5)
{121,168,86,106,36,10,125,97,53,26,148,129,41,18,173,55,13,73,91,174,177,190,28,164,122,92,5,26,58,188,14,67,48,196,41,94,24,89,54,117,12,6,155,103,200,128,184,29,92,149}
{199,182,43,191,2,145,15,53,38,37,61,45,157,129,119,123,177,178,183,188,132,108,112,137,92,59,75,196,102,152,114,121,181,93,32,3,24,116,4,163,96,159,196,43,59,150,79,113,20,146}
5345

Returns: 24



// END CUT HERE
import java.util.*;
public class PilingRectsDiv2 {
    public int getmax(int[] X, int[] Y, int limit) {
        int[][] map = new int[201][201];
    	
    	for (int i= 0;i<X.length;i++){
    		int x=0;
    		int y=0;
    		if (X[i]<Y[i]){
    			 x= X[i];
    			 y= Y[i];
    		}else{
    			
    			x=Y[i];
    			y=X[i];
    		}
    		for (int j=1;j<x+1;j++){
    			for (int k=1;k<y+1;k++){
    				map[j][k]++;
    			}
    		}
    	}
    	
    	int res=0;
    	
    	for (int i=1;i<201;i++){
    		for (int j=1;j<201;j++){
    			if (i*j>=limit && map[i][j]>res){
    				res=map[i][j];	
    			}
    		}
    	}
    	if (res==0) return -1;
        else return res;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        try {
            eq(0,(new PilingRectsDiv2()).getmax(new int[] {1,2,3,1}, new int[] {3,2,4,4}, 3),3);
            eq(1,(new PilingRectsDiv2()).getmax(new int[] {4,7}, new int[] {7,4}, 25),2);
            eq(2,(new PilingRectsDiv2()).getmax(new int[] {10}, new int[] {10}, 9999),-1);
            eq(3,(new PilingRectsDiv2()).getmax(new int[] {10}, new int[] {3}, 30),1);
            eq(4,(new PilingRectsDiv2()).getmax(new int[] {3,6,5,8,2,9,14}, new int[] {14,6,13,8,15,6,3}, 27),4);
            eq(5,(new PilingRectsDiv2()).getmax(new int[] {121,168,86,106,36,10,125,97,53,26,148,129,41,18,173,55,13,73,91,174,177,190,28,164,122,92,5,26,58,188,14,67,48,196,41,94,24,89,54,117,12,6,155,103,200,128,184,29,92,149}, new int[] {199,182,43,191,2,145,15,53,38,37,61,45,157,129,119,123,177,178,183,188,132,108,112,137,92,59,75,196,102,152,114,121,181,93,32,3,24,116,4,163,96,159,196,43,59,150,79,113,20,146}, 5345),24);
        } catch( Exception exx) {
            System.err.println(exx);
            exx.printStackTrace(System.err);
        }
    }

// END CUT HERE
}