// BEGIN CUT HERE
// PROBLEM STATEMENT
// Manao has N cards arranged in a sequence. He numbered them from left to right with numbers from 0 to N-1. Each card is colored black on one side and white on the other. Initially, each of the cards may lie on a different side. That is, some of the cards (possibly none or all of them) will be black side up and others will be white side up. Manao wants to flip some cards over to obtain an alternating configuration: every pair of successive cards must be of different colors.

You are given a String cardFront consisting of N characters. For each i, character i of cardFront is 'B' if card i lies black side up, and 'W' otherwise. Count and return the minimum number of cards which must be flipped to obtain an alternating configuration.

DEFINITION
Class:BlackAndWhiteSolitaire
Method:minimumTurns
Parameters:String
Returns:int
Method signature:int minimumTurns(String cardFront)


CONSTRAINTS
-cardFront will be between 3 and 50 characters long, inclusive.
-Each character in cardFront will be either 'B' or 'W'.


EXAMPLES

0)
"BBBW"

Returns: 1

The first three cards lie with their black side up and the fourth card lies with its white side up. Flipping the second card will give us the alternating configuration "BWBW".

1)
"WBWBW"

Returns: 0

The cards already form an alternating configuration.

2)
"WWWWWWWWW"

Returns: 4

Manao only needs to flip 4 cards to make the alternating configuration "WBWBWBWBW".

3)
"BBWBWWBWBWWBBBWBWBWBBWBBW"

Returns: 10



// END CUT HERE
import java.util.*;
public class BlackAndWhiteSolitaire {
    public int minimumTurns(String cardFront) {
        int res1=0;
	int res2 =0;
	
	char n = 'B';

	for (int i =0;i<cardFront.length();i+=2){
		if (cardFront.charAt(i)==n) res1++;
	}
	for (int i =1;i<cardFront.length();i+=2){
		if (cardFront.charAt(i)!=n) res1++;
	}

	char m = 'W';

	for (int i =0;i<cardFront.length();i+=2){
		if (cardFront.charAt(i)==m) res2++;
	}
	for (int i =1;i<cardFront.length();i+=2){
		if (cardFront.charAt(i)!=m) res2++;
	}

	if (res1>res2) res1 = res2;
        return res1;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        try {
            eq(0,(new BlackAndWhiteSolitaire()).minimumTurns("BBBW"),1);
            eq(1,(new BlackAndWhiteSolitaire()).minimumTurns("WBWBW"),0);
            eq(2,(new BlackAndWhiteSolitaire()).minimumTurns("WWWWWWWWW"),4);
            eq(3,(new BlackAndWhiteSolitaire()).minimumTurns("BBWBWWBWBWWBBBWBWBWBBWBBW"),10);
        } catch( Exception exx) {
            System.err.println(exx);
            exx.printStackTrace(System.err);
        }
    }

// END CUT HERE
}
