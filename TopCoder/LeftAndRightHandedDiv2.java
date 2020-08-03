// BEGIN CUT HERE
// PROBLEM STATEMENT
// Some students are seated in a row next to each other.
Each of them is either left-handed or right-handed.
You are given a String S that describes the row of students.
Each character of S is either 'L' or 'R', representing a left-handed or a right-handed person, respectively.
The characters describe the row from the left to the right: for all i, the person described by character i+1 sits to the right of the person described by character i.

The students are trying to write down lecture notes.
Whenever a left-handed person sits immediately to the right of a right-handed person, their elbows collide when they both try to write at the same time.
Compute and return the number of elbow collisions, assuming that all students in the row attempt to write at the same time.

DEFINITION
Class:LeftAndRightHandedDiv2
Method:count
Parameters:String
Returns:int
Method signature:int count(String S)


CONSTRAINTS
-S will contain between 1 and 50 characters, inclusive.
-Each character of S will be either 'L' or 'R'.


EXAMPLES

0)
"L"

Returns: 0

There's only one person in the row so there are no collisions.

1)
"RRR"

Returns: 0

Everybody is right-handed so there are no collisions.

2)
"LRLRLR"

Returns: 2

There will be two collisions: one of them between the second and the third person from the left (described by S[1] and S[2]) and the other between the fourth and the fifth person.

3)
"LLLRRR"

Returns: 0



4)
"RLRLRL"

Returns: 3



// END CUT HERE
import java.util.*;
public class LeftAndRightHandedDiv2 {
    public int count(String S) {
        int res=0;
    	
    	for (int i=0;i<S.length()-1;i++){
    		if (S.charAt(i)=='R'){
    			if (S.charAt(i+1)=='L'){
    				res++;
    			}
    		}
    	}
        return res;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        try {
            eq(0,(new LeftAndRightHandedDiv2()).count("L"),0);
            eq(1,(new LeftAndRightHandedDiv2()).count("RRR"),0);
            eq(2,(new LeftAndRightHandedDiv2()).count("LRLRLR"),2);
            eq(3,(new LeftAndRightHandedDiv2()).count("LLLRRR"),0);
            eq(4,(new LeftAndRightHandedDiv2()).count("RLRLRL"),3);
        } catch( Exception exx) {
            System.err.println(exx);
            exx.printStackTrace(System.err);
        }
    }

// END CUT HERE
}
