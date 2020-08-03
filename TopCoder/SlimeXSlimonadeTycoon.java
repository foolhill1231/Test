// BEGIN CUT HERE
// PROBLEM STATEMENT
// You are playing a game called Slime Tycoon.
You will be selling Slimonades in this game, and your goal is to sell as many as you can.

The game will consist of N game days, numbered 0 through N-1 in order.
You are given two int[]s morning and customers with N elements each, and an int stale_limit.
These represent constraints on how many Slimonades you can produce and sell, as explained below.

In each game day, three things happen, in the following order:

Early in the morning of day i: All Slimonades that were produced stale_limit days ago (i.e., on day i-stale_limit) go stale. You cannot sell stale Slimonades, you must throw them away immediately.
During day i: You can produce at most morning[i] new Slimonades. (Formally, you choose an integer X between 0 and morning[i], inclusive, and produce X Slimonades.)
In the evening of day i: You can sell at most customers[i] Slimonades. (That is, if you have at most customers[i] Slimonades, you sell all of them. Otherwise, you sell exactly customers[i] Slimonades. In that case, you get to choose which Slimonades you sell and which ones you keep for later days.)


What is the maximum total number of Slimonades that you can sell during these N days?

DEFINITION
Class:SlimeXSlimonadeTycoon
Method:sell
Parameters:int[], int[], int
Returns:int
Method signature:int sell(int[] morning, int[] customers, int stale_limit)


CONSTRAINTS
-morning will contain between 2 and 50 elements, inclusive.
-Each element of morning will be between 0 and 10000, inclusive.
-customers will contain the same number of elements as morning.
-Each element of customers will be between 0 and 10000, inclusive.
-stale_limit will be between 1 and N, inclusive.


EXAMPLES

0)
{5, 1, 1}
{1, 2, 3}
2

Returns: 5

Here's one optimal solution.

Day 0: We produce 4 Slimonades, then sell 1 of them.
Day 1: We produce 1 Slimonade (so now we have 4). In the evening, we sell two of the Slimonades that were made yesterday.
Day 2: We still have one Slimonade that was made on day 0. It goes stale and we throw it away. We produce one more Slimonade. In the evening, we sell 2 Slimonades (the one made yesterday and the one made today).


1)
{10, 20, 30}
{30, 20, 10}
1

Returns: 40

As stale_limit=1, each evening we can only sell Slimonades made during that day. Hence, we can sell at most 10 Slimonades on day 0, 20 on day 1, and 10 on day 2.

2)
{1, 2, 3, 4, 5}
{5, 5, 5, 5, 5}
5

Returns: 15



3)
{10000, 0, 0, 0, 0, 0, 0}
{1, 2, 4, 8, 16, 32, 64}
4

Returns: 15



// END CUT HERE
import java.util.*;
public class SlimeXSlimonadeTycoon {
    public int sell(int[] m, int[] c, int lm) {
        int res=0;
    	
    	
    	List<Integer> list = new ArrayList<Integer>();
    	
    	for (int i=0;i<m.length;i++){
    		if (list.size()==lm){
    			list.remove(0);
    		}
    		list.add(m[i]);
    		int cc = c[i];
    		
    		int idx =0;
    		
    		while(true){
    			if ( cc==0||idx>lm-1) break;
    			if (list.get(idx)>=cc){
    				list.set(idx,(list.get(idx)-cc));
    				res+=cc;
    			}else{
    				res+=list.get(idx);
    				cc-=list.get(idx);
    				list.set(idx,0);
    				idx++;
    			}
    			
    		}
    	}
        return res;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        try {
            eq(0,(new SlimeXSlimonadeTycoon()).sell(new int[] {5, 1, 1}, new int[] {1, 2, 3}, 2),5);
            eq(1,(new SlimeXSlimonadeTycoon()).sell(new int[] {10, 20, 30}, new int[] {30, 20, 10}, 1),40);
            eq(2,(new SlimeXSlimonadeTycoon()).sell(new int[] {1, 2, 3, 4, 5}, new int[] {5, 5, 5, 5, 5}, 5),15);
            eq(3,(new SlimeXSlimonadeTycoon()).sell(new int[] {10000, 0, 0, 0, 0, 0, 0}, new int[] {1, 2, 4, 8, 16, 32, 64}, 4),15);
        } catch( Exception exx) {
            System.err.println(exx);
            exx.printStackTrace(System.err);
        }
    }

// END CUT HERE
}
