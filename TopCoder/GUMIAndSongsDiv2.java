// BEGIN CUT HERE
// PROBLEM STATEMENT
// Gumi loves singing.
She knows N songs.
The songs are numbered 0 through N-1.
She now has some time and she would love to sing as many different songs as possible. 

You are given a int[] duration.
For each i, duration[i] is the duration of song i in Gumi's time units. 

Gumi finds it difficult to sing songs with quite different tones consecutively.
You are given a int[] tone with the following meaning:
If Gumi wants to sing song y immediately after song x, she will need to spend |tone[x]-tone[y]| units of time resting between the two songs.
(Here, || denotes absolute value.) 

You are also given an int T.
Gumi has T units of time for singing.
She can start singing any song she knows immediately at the beginning of this time interval.
Compute the maximal number of different songs she can sing completely within the given time.

DEFINITION
Class:GUMIAndSongsDiv2
Method:maxSongs
Parameters:int[], int[], int
Returns:int
Method signature:int maxSongs(int[] duration, int[] tone, int T)


CONSTRAINTS
-duration and tone will each contain between 1 and 15 elements, inclusive.
-duration and tone will contain the same number of elements.
-Each element of duration will be between 1 and 100,000, inclusive.
-Each element of tone will be between 1 and 100,000, inclusive.
-T will be between 1 and 10,000,000, inclusive.


EXAMPLES

0)
{3, 5, 4, 11}
{2, 1, 3, 1}
17

Returns: 3

There are four songs. 
Two songs have tone 1 and their durations are 5 and 11, respectively.
One song has tone 2 and its duration is 3.
One song has tone 3 and its duration is 4.
Gumi has 17 units of time to sing. 

It is impossible for Gumi to sing all four songs she knows within the given time: even without the breaks the total length of all songs exceeds 17. 

Here is one way how she can sing three songs:
First, she sings song 0 in 3 units of time.
Second, she waits for |2-3|=1 unit of time and then sings song 2 in 4 units of time.
Finally, she waits for |3-1|=2 units of time and then sings song 1 in 5 units of time.
The total time spent is 3+1+4+2+5 = 15 units of time.


1)
{100, 200, 300}
{1, 2, 3}
10

Returns: 0

In this case, T is so small that she can't sing at all.

2)
{1, 2, 3, 4}
{1, 1, 1, 1}
100

Returns: 4

There is plenty of time, so she can sing all 4 songs.


3)
{10, 10, 10}
{58, 58, 58}
30

Returns: 3



4)
{8, 11, 7, 15, 9, 16, 7, 9}
{3, 8, 5, 4, 2, 7, 4, 1}
14

Returns: 1



5)
{5611,39996,20200,56574,81643,90131,33486,99568,48112,97168,5600,49145,73590,3979,94614}
{2916,53353,64924,86481,44803,61254,99393,5993,40781,2174,67458,74263,69710,40044,80853}
302606

Returns: 8



// END CUT HERE
import java.util.*;
public class GUMIAndSongsDiv2 {
    public int maxSongs(int[] duration, int[] tone, int T) {
        int res=0,n=duration.length;
	ArrayList<Node> nodes = new ArrayList<Node>();
	for (int j =0;j<n;j++)
		nodes.add(new Node(duration[j], tone[j],j));

	for (int st=0;st< nodes.size();st++){
		int at = st,t=0,cnt=0;
		if (duration[st]<=T){
			t = duration[st];
			cnt++;
		}

		for (int to = st+1; to< nodes.size(); to++){
			if (t+nodes.get(to).du+Math.abs(nodes.get(to).tone-tone[at]) <= T){
			at = to;
			t += nodes.get(to).du+Math.abs(nodes.get(to).tone-tone[at]);
			cnt++;
		}
	res = Math.max(res,cnt);
		}
	}
        return res;
    }

	static class Node{
		int du,tone,idx;
		Node(int d, int t, int i){
			du =d;
			tone =t;
			idx =i;
			
		}
	}

// BEGIN CUT HERE
    public static void main(String[] args) {
        try {
            eq(0,(new GUMIAndSongsDiv2()).maxSongs(new int[] {3, 5, 4, 11}, new int[] {2, 1, 3, 1}, 17),3);
            eq(1,(new GUMIAndSongsDiv2()).maxSongs(new int[] {100, 200, 300}, new int[] {1, 2, 3}, 10),0);
            eq(2,(new GUMIAndSongsDiv2()).maxSongs(new int[] {1, 2, 3, 4}, new int[] {1, 1, 1, 1}, 100),4);
            eq(3,(new GUMIAndSongsDiv2()).maxSongs(new int[] {10, 10, 10}, new int[] {58, 58, 58}, 30),3);
            eq(4,(new GUMIAndSongsDiv2()).maxSongs(new int[] {8, 11, 7, 15, 9, 16, 7, 9}, new int[] {3, 8, 5, 4, 2, 7, 4, 1}, 14),1);
            eq(5,(new GUMIAndSongsDiv2()).maxSongs(new int[] {5611,39996,20200,56574,81643,90131,33486,99568,48112,97168,5600,49145,73590,3979,94614}, new int[] {2916,53353,64924,86481,44803,61254,99393,5993,40781,2174,67458,74263,69710,40044,80853}, 302606),8);
        } catch( Exception exx) {
            System.err.println(exx);
            exx.printStackTrace(System.err);
        }
    }

// END CUT HERE
}
