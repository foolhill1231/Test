// BEGIN CUT HERE
// PROBLEM STATEMENT
// Rabbit went to a river to catch eels.
All eels are currently swimming down the stream at the same speed.
Rabbit is standing by the river, downstream from all the eels.


Each point on the river has a coordinate.
The coordinates increase as we go down the stream.
Initially, Rabbit is standing at the origin, and all eels have non-positive coordinates.


You are given two int[]s: l and t.
These describe the current configuration of eels.
The speed of each eel is 1 (one).
For each i, the length of eel number i is l[i].
The head of eel number i will arrive at the coordinate 0 precisely at the time t[i].
Therefore, at any time T the eel number i has its head at the coordinate T-t[i], and its tail at the coordinate T-t[i]-l[i].


Rabbit may only catch an eel when some part of the eel (between head and tail, inclusive) is at the same coordinate as the rabbit.
Rabbit can catch eels at most twice.
Each time he decides to catch eels, he may catch as many of the currently available eels as he wants.
(That is, he can only catch eels that are in front of him at that instant, and he is allowed and able to catch multiple eels at once.)


Return the maximal total number of eels Rabbit can catch.

DEFINITION
Class:EelAndRabbit
Method:getmax
Parameters:int[], int[]
Returns:int
Method signature:int getmax(int[] l, int[] t)


CONSTRAINTS
-l will contain between 1 and 50 elements, inclusive.
-Each element of l will be between 1 and 1,000,000,000, inclusive.
-l and t will contain the same number of elements.
-Each element of t will be between 0 and 1,000,000,000, inclusive.


EXAMPLES

0)
{2, 4, 3, 2, 2, 1, 10}
{2, 6, 3, 7, 0, 2, 0}

Returns: 6

Rabbit can catch 6 eels in the following way:

At time 2, catch Eel 0, Eel 4, Eel 5, and Eel 6.
At time 8, catch Eel 1 and Eel 3.



1)
{1, 1, 1}
{2, 0, 4}

Returns: 2

No two eels are in front of Rabbit at the same time, so Rabbit can catch at most two eels.

2)
{1}
{1}

Returns: 1



3)
{8, 2, 1, 10, 8, 6, 3, 1, 2, 5}
{17, 27, 26, 11, 1, 27, 23, 12, 11, 13}

Returns: 7



// END CUT HERE
import java.util.*;
public class EelAndRabbit {
    public int getmax(int[] l, int[] t) {
        int len = l.length;
	int[] s = new int[len];
	int[] e = new int[len];
	int[] used = new int[len];

	HashSet<Integer> h = new HashSet<Integer>();

	for (int i =0;i<len;i++){
		s[i] = -t[i] - l[i];
		e[i] = -t[i];
		h.add(s[i]);
		h.add(e[i]);
	}

	int max =0;
 	int pos =-1;

	for (int i : h){
		int cnt =0;
		for (int j =0;j<len;j++){
			if (s[j]<=i && e[j]>=i) cnt++;
		}
		if (cnt>= max){
			max = cnt;
			pos = i;
		}
	}
	
	for (int j =0;j<len;j++){
		if (s[j] <= pos && e[j] >= pos) used[j] =1;;
	}

	int max2=0;
	for (int i : h){
		if(i == pos) continue;
		int cnt =0;
		for (int j =0;j<len;j++){
			if (used[j] ==0 && s[j]<=i && e[j]>= i) cnt++;
		}
		if (cnt > max2){
			max2 = cnt;
			pos =i;
		}
	}

	return max+max2;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        try {
            eq(0,(new EelAndRabbit()).getmax(new int[] {2, 4, 3, 2, 2, 1, 10}, new int[] {2, 6, 3, 7, 0, 2, 0}),6);
            eq(1,(new EelAndRabbit()).getmax(new int[] {1, 1, 1}, new int[] {2, 0, 4}),2);
            eq(2,(new EelAndRabbit()).getmax(new int[] {1}, new int[] {1}),1);
            eq(3,(new EelAndRabbit()).getmax(new int[] {8, 2, 1, 10, 8, 6, 3, 1, 2, 5}, new int[] {17, 27, 26, 11, 1, 27, 23, 12, 11, 13}),7);
        } catch( Exception exx) {
            System.err.println(exx);
            exx.printStackTrace(System.err);
        }
    }

// END CUT HERE
}
