// BEGIN CUT HERE
// PROBLEM STATEMENT
// There are some cities and some roads connecting them together.
The road network has the topology of a perfect binary tree (see below for a picture), in which the cities are nodes and the roads are edges.

You are given the int treeHeight giving the height of the tree.
(The height of a perfect binary tree is the number of edges on the path between the root node and any leaf node.)
Thus, there are 2^(treeHeight+1)-1 cities and 2^(treeHeight+1)-2 roads in total.

The picture below shows how the road network looks like when treeHeight = 2.



We want to send some cars into the road network.
Each car will be traveling from its starting city to its destination city without visiting the same city twice.
(Note that the route of each car is uniquely determined by its starting and its destination city.)
It is possible for the starting city to be equal to the destination city, in that case the car only visits that single city.

Our goal is to send out the cars in such a way that each city will be visited by exactly one car. Compute and return the smallest number of cars we need in order to do so.


DEFINITION
Class:TrafficCongestionDivTwo
Method:theMinCars
Parameters:int
Returns:long
Method signature:long theMinCars(int treeHeight)


NOTES
-The answer will always fit into a 64-bit signed integer data type.


CONSTRAINTS
-treeHeight will be between 0 and 60, inclusive.


EXAMPLES

0)
1

Returns: 1

In this case, one car can visit all the cities.





1)
2

Returns: 3

Here is one way to visit all cities exactly once by three cars:




2)
3

Returns: 5



3)
10

Returns: 683



4)
60

Returns: 768614336404564651



// END CUT HERE
import java.util.*;
public class TrafficCongestionDivTwo {
    public long theMinCars(int treeHeight) {
        long res;
	long[] dp = new long[61];
  	dp[0]= 0;
	dp[1]= 1;
	dp[2]= 3;
	
	
	for (int i =3;i<treeHeight+1;i++){
		res=2;
		for (int j=2;j<i;j++){
            		res*=2;
        	}
		dp[i] = res+dp[i-2];
		
	}
	
        return dp[treeHeight];
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        try {
            eq(0,(new TrafficCongestionDivTwo()).theMinCars(1),1L);
            eq(1,(new TrafficCongestionDivTwo()).theMinCars(2),3L);
            eq(2,(new TrafficCongestionDivTwo()).theMinCars(3),5L);
            eq(3,(new TrafficCongestionDivTwo()).theMinCars(10),683L);
            eq(4,(new TrafficCongestionDivTwo()).theMinCars(60),768614336404564651L);
        } catch( Exception exx) {
            System.err.println(exx);
            exx.printStackTrace(System.err);
        }
    }

// END CUT HERE
}
