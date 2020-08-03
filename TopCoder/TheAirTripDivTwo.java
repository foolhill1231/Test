// BEGIN CUT HERE
// PROBLEM STATEMENT
// John and Brus have their own airplane. They are going to take several consecutive flights. 
The i-th element of flights is the number of liters of fuel needed for the i-th flight.
The flights can be performed only in the same order as they are described in flights.

Initially there are fuel liters of fuel in the airplane. In order to perform a flight, the amount of fuel in the airplane must be at least as much as the amount of fuel needed for this flight. Return the maximum number of flights they will be able to make without a refuel.


DEFINITION
Class:TheAirTripDivTwo
Method:find
Parameters:int[], int
Returns:int
Method signature:int find(int[] flights, int fuel)


CONSTRAINTS
-flights will contain between 1 and 47 elements, inclusive.
-Each element of flights will be between 1 and 1000, inclusive.
-fuel will be between 1 and 1000, inclusive.


EXAMPLES

0)
{1, 2, 3, 4, 5, 6, 7}
10

Returns: 4

Exactly 10 liters of fuel are required to perform the first four flights.

1)
{7, 6, 5, 4, 3, 2, 1}
10

Returns: 1

These are the same flights as in the previous example, but in different order.

2)
{1}
1000

Returns: 1

A single flight here.

3)
{8, 7, 7, 1, 5, 7, 9}
21

Returns: 2

// END CUT HERE
import java.util.*;
public class TheAirTripDivTwo {
    public int find(int[] flights, int fuel) {
        int res=0;
	for (int i=0;i<flights.length;i++){
		if (fuel - flights[i]>=0) {
			fuel -= flights[i];
			res++;
		}else {break;}
	}
        return res;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        try {
            eq(0,(new TheAirTripDivTwo()).find(new int[] {1, 2, 3, 4, 5, 6, 7}, 10),4);
            eq(1,(new TheAirTripDivTwo()).find(new int[] {7, 6, 5, 4, 3, 2, 1}, 10),1);
            eq(2,(new TheAirTripDivTwo()).find(new int[] {1}, 1000),1);
            eq(3,(new TheAirTripDivTwo()).find(new int[] {8, 7, 7, 1, 5, 7, 9}, 21),2);
        } catch( Exception exx) {
            System.err.println(exx);
            exx.printStackTrace(System.err);
        }
    }

// END CUT HERE
}
