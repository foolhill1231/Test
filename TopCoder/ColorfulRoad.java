// BEGIN CUT HERE
// PROBLEM STATEMENT
// 
There is a one-dimensional road.
The road is separated into N consecutive parts.
The parts are numbered 0 through N-1, in order.
Ciel is going to walk from part 0 to part N-1.


Ciel also noticed that each part of the road has a color: either red, green, or blue.
Part 0 is red.


Ciel is going to perform a sequence of steps.
Each step must lead in the positive direction.
That is, if her current part is i, the next step will take her to one of the parts i+1 through N-1, inclusive.
Her steps can be arbitrarily long.
However, longer steps are harder: a step of length j costs j*j energy.


Additionally, Ciel wants to step on colors in a specific order: red, green, blue, red, green, blue, ...
That is, she starts on the red part 0, makes a step to a green part, from there to a blue part, and so on, always repeating red, green, and blue in a cycle.
Note that the final part N-1 also has some color and thus Ciel must reach it in a corresponding step.


You are given a String road containing N elements.
For each i, element i of road is the color of part i: 'R' represents red, 'G' green, and 'B' blue.
If Ciel can reach part N-1 in the way described above, return the smallest possible total cost of doing so.
Otherwise, return -1.



DEFINITION
Class:ColorfulRoad
Method:getMin
Parameters:String
Returns:int
Method signature:int getMin(String road)


CONSTRAINTS
-road will contain between 2 and 15 characters, inclusive.
-Each character of road will be either 'R' or 'G' or 'B'.
-The first character of road will be 'R'.


EXAMPLES

0)
"RGGGB"

Returns: 8

The optimum solution is to step part 0 -> part 2 -> part 4.
The total cost is 2*2 + 2*2 = 8.

1)
"RGBRGBRGB"

Returns: 8

The optimum solution is to make steps of length 1.
It costs 1*1 = 1 per each step, so the total cost is 8.

2)
"RBBGGGRR"

Returns: -1

It is impossible to reach the destination.


3)
"RBRRBGGGBBBBR"

Returns: 50



4)
"RG"

Returns: 1



5)
"RBRGBGBGGBGRGGG"

Returns: 52



// END CUT HERE

import java.util.*;
public class ColorfulRoad {

	private String p;
	private char[] color = new char[]{'R','G','B'};
	private int m = 999999;

	private int minRoad(int old , int i ,int c, int val){
		if (i==p.length()-1) return val;
		int pos =-2, oldval = val;

		for (int j =i+1;j<p.length();j++){
			if (p.charAt(j)==color[c]){
				int temp = oldval +(j-i)*(j-i);
				if (pos ==-2) val = m;
				val = Math.min(minRoad(i,j,(c+1)%3,temp),val);
				pos =j;
			}
		}
		return pos ==-2?m:val;
	}
    public int getMin(String road) {
	int val = m;
	if (road.charAt(0) =='R'){
		p=road;
		val = minRoad(0,0,1,0);
	}
	return val == m ? -1:val;

    }



// BEGIN CUT HERE
    public static void main(String[] args) {
        try {
            eq(0,(new ColorfulRoad()).getMin("RGGGB"),8);
            eq(1,(new ColorfulRoad()).getMin("RGBRGBRGB"),8);
            eq(2,(new ColorfulRoad()).getMin("RBBGGGRR"),-1);
            eq(3,(new ColorfulRoad()).getMin("RBRRBGGGBBBBR"),50);
            eq(4,(new ColorfulRoad()).getMin("RG"),1);
            eq(5,(new ColorfulRoad()).getMin("RBRGBGBGGBGRGGG"),52);
        } catch( Exception exx) {
            System.err.println(exx);
            exx.printStackTrace(System.err);
        }
    }

// END CUT HERE
}
