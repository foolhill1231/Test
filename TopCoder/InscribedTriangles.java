// BEGIN CUT HERE
// PROBLEM STATEMENT
// A triangle is "inscribed" in a circle if all 3 points of the triangle are on the edge of the circle.  For this problem, our circle will be centered at the origin and have a radius of 5.  Our goal is to find the largest triangle (by area) we can inscribe in this circle.  Normally, this would be any equilateral triangle, but in this case we have the added restriction that each point of our triangle must be within one (or more) of the valid ranges of degrees.  The degree ranges are given in thousandths of degrees in corresponding elements of angleFrom and angleTo.  For each range, angleFrom will be less than or equal to angleTo and each will be between 0 and 360000.  All ranges are inclusive; see the examples for clarification.  Return the area of the largest inscribed triangle that can be made while following these restrictions.  If no triangle can be made, return 0.

DEFINITION
Class:InscribedTriangles
Method:findLargest
Parameters:int[], int[]
Returns:double
Method signature:double findLargest(int[] angleFrom, int[] angleTo)


NOTES
-The ranges may overlap.
-Your return value must have an absolute or relative error less than 1e-9.


CONSTRAINTS
-angleFrom and angleTo will each contain between 1 and 30 elements, inclusive.
-angleFrom and angleTo will contain the same number of elements.
-Each element of angleFrom and angleTo will be between 0 and 360000, inclusive.
-Each element of angleFrom will be less than or equal to the corresponding element of angleTo.


EXAMPLES

0)
{0}
{360000}

Returns: 32.47595264191645

We can use any point we want on the circle - so we can draw an equilateral triangle (which will be the biggest we can ever draw).

1)
{15000,25000,100000,265000,330000}
{15000,25000,100000,265000,330000}

Returns: 27.433829549752186

In this case, each of our ranges are single points.  The biggest triangle can be made by using the points at 15Åã, 100Åã, and 265Åã.

2)
{245900,246500,249900}
{245915,246611,252901}

Returns: 0.002789909594714814

We only have 3 small ranges, all near to each other - so our best triangle is still really small.

3)
{42}
{42}

Returns: 0.0

It's hard to draw a triangle with one point.

// END CUT HERE
import java.util.*;
public class InscribedTriangles {
    public double findLargest(int[] angleFrom, int[] angleTo) {
        double res;
        return res;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        try {
            eq(0,(new InscribedTriangles()).findLargest(new int[] {0}, new int[] {360000}),32.47595264191645);
            eq(1,(new InscribedTriangles()).findLargest(new int[] {15000,25000,100000,265000,330000}, new int[] {15000,25000,100000,265000,330000}),27.433829549752186);
            eq(2,(new InscribedTriangles()).findLargest(new int[] {245900,246500,249900}, new int[] {245915,246611,252901}),0.002789909594714814);
            eq(3,(new InscribedTriangles()).findLargest(new int[] {42}, new int[] {42}),0.0);
        } catch( Exception exx) {
            System.err.println(exx);
            exx.printStackTrace(System.err);
        }
    }

// END CUT HERE
}
