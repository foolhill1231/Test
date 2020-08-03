// BEGIN CUT HERE
// PROBLEM STATEMENT
// John and Brus are flying on an airplane and now it's coffee time.

There are n seats in the plane numbered from 1 to n, one seat in each row. All seats are occupied, thus there are n passengers overall (including John and Brus). A stewardess will serve a cup of coffee or tea to each passenger. She needs to serve tea to all passengers whose seat numbers are listed in int[] tea, and she needs to serve coffee to all other passengers.

A coffee and tea machine is located just before the first seat of the plane. The stewardess has a flask that can contain enough coffee or tea to serve at most 7 passengers. Initially, the stewardess is located near the coffee and tea machine and the flask is empty.

The stewardess can perform the following kinds of actions:

Move from the coffee and tea machine to seat 1 or move from seat 1 to the coffee and tea machine. Each of these two actions takes 1 second.
Move from seat i, i > 1, to seat i-1. It takes 1 second.
Move from seat i, i < n, to seat i+1. It takes 1 second.
If she is near seat i, the passenger at this seat has not yet been served and the current type of drink in the flask is the same as the drink this passenger wants, she can serve this passenger with a cup of drink he/she wants. It takes 4 seconds.
If she is near the coffee and tea machine and the flask is empty, she can fill the flask with either tea or coffee (but not both simultaneously). It takes 47 seconds. Note that she can fill the flask partially (to serve less than 7 passengers), but it still takes 47 seconds.


Given int n and int[] tea, return the minimal time needed for the stewardess to serve all passengers with proper drinks and return to the coffee and tea machine.

DEFINITION
Class:TheCoffeeTimeDivTwo
Method:find
Parameters:int, int[]
Returns:int
Method signature:int find(int n, int[] tea)


CONSTRAINTS
-n will be between 2 and 1000, inclusive.
-tea will contain between 1 and 47 elements, inclusive.
-Each element of tea will be between 1 and n, inclusive.
-All elements of tea will be distinct.


EXAMPLES

0)
2
{1}

Returns: 108

The stewardess will serve coffee in 47+2+4+2=55 seconds and tea in 47+1+4+1=53 seconds.

1)
2
{2, 1}

Returns: 59

Here she only needs to serve tea.

2)
15
{1, 2, 3, 4, 5, 6, 7}

Returns: 261

The stewardess will fill the flask three times overall: once with tea and two times with coffee.

3)
47
{1, 10, 6, 2, 4}

Returns: 891

// END CUT HERE
import java.util.*;
public class TheCoffeeTimeDivTwo {
    public int find(int n, int[] tea) {
	Arrays.sort(tea);
	int tee = tea.length;
	int cof = n - tee;
        int res=4*n;
	res += 47*((n+6)/7);

	for (int i=0;i<tee;i+=7){
		res += tea[i]*2;
	}

	int time =(cof+6)/7;

	res += ((cof%7 == 0 ? 7 : cof%7)+ cof) *time;

	for (int i =0;i<tee;i++){
		res += ((n- tea[i] -i +6)/7)*2;
	}
        return res;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        try {
            eq(0,(new TheCoffeeTimeDivTwo()).find(2, new int[] {1}),108);
            eq(1,(new TheCoffeeTimeDivTwo()).find(2, new int[] {2, 1}),59);
            eq(2,(new TheCoffeeTimeDivTwo()).find(15, new int[] {1, 2, 3, 4, 5, 6, 7}),261);
            eq(3,(new TheCoffeeTimeDivTwo()).find(47, new int[] {1, 10, 6, 2, 4}),891);
        } catch( Exception exx) {
            System.err.println(exx);
            exx.printStackTrace(System.err);
        }
    }

// END CUT HERE
}
