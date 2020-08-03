// BEGIN CUT HERE
// PROBLEM STATEMENT
// Andrew drew a bunch of points on a sheet of graph paper.
You are given the coordinates of these points in two int[]s: X and Y.
That is, for each valid i, there is a point at the coordinates (X[i], Y[i]).

Now Andrew wants to draw a rectangle.
The sides of the rectangle must be parallel to the coordinate axes.
(In other words, each side of the rectangle must be either horizontal or vertical.)
Additionally, each of Andrew's points must be inside the rectangle or on its boundary.

Return the area of the smallest possible rectangle Andrew can draw.

DEFINITION
Class:BoundingBox
Method:smallestArea
Parameters:int[], int[]
Returns:int
Method signature:int smallestArea(int[] X, int[] Y)


CONSTRAINTS
-X will have between 2 and 50 elements, inclusive.
-X and Y will have the same number of elements.
-Each element of X and Y will be between -100 and 100, inclusive.
-The points described by X and Y will not be in a straight line horizontally or vertically. That is, the smallest rectangle will have a positive area.


EXAMPLES

0)
{0,1}
{1,0}

Returns: 1



1)
{0,-2,-1}
{-1,-1,-2}

Returns: 2



2)
{0,0,1,0,-1,2}
{0,1,2,-2,0,-1}

Returns: 12



3)
{9,-88,-40,98,-55,41,-38}
{-65,56,-67,7,-58,33,68}

Returns: 25110



// END CUT HERE
import java.util.*;
public class BoundingBox {
    public int smallestArea(int[] X, int[] Y) {
        int res=0;
    	
    	int Xmax=-101;
    	int Xmin=101;
    	int Ymax=-101;
    	int Ymin=101;
    	
    	for (int i=0;i<X.length;i++){
    		if (Xmax<X[i]) Xmax=X[i];
    		if (Xmin>X[i]) Xmin=X[i];
    		if (Ymax<Y[i]) Ymax=Y[i];
    		if (Ymin>Y[i]) Ymin=Y[i];
    	}
    	
    	int x = Xmax-Xmin;
    	int y = Ymax-Ymin;
    	
    	res = x*y;
    	
        return res;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        try {
            eq(0,(new BoundingBox()).smallestArea(new int[] {0,1}, new int[] {1,0}),1);
            eq(1,(new BoundingBox()).smallestArea(new int[] {0,-2,-1}, new int[] {-1,-1,-2}),2);
            eq(2,(new BoundingBox()).smallestArea(new int[] {0,0,1,0,-1,2}, new int[] {0,1,2,-2,0,-1}),12);
            eq(3,(new BoundingBox()).smallestArea(new int[] {9,-88,-40,98,-55,41,-38}, new int[] {-65,56,-67,7,-58,33,68}),25110);
        } catch( Exception exx) {
            System.err.println(exx);
            exx.printStackTrace(System.err);
        }
    }

// END CUT HERE
}
