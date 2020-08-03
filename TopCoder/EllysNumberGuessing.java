// BEGIN CUT HERE
// PROBLEM STATEMENT
// Elly and Kris play the following game. In the beginning Kristina thinks of a number between 1 and 1,000,000,000, inclusive. After that Elly starts trying to guess it. In each round she says a number and Kristina says what is the absolute difference between the number she has thought of, and the number Elly guessed. Now Elly wonders if the guesses she has already made are sufficient to uniquely determine Kristina's number.

You are given a int[] guesses and a int[] answers of the same length. For each valid i, in round i of the game (0-based index) Elly guessed the number guesses[i] and Kristina answered answers[i]. If Kristina's number can be uniquely determined, return that number. If there are multiple possibilities that are consistent with the current set of guesses and answers, return -1. If it can be shown that at some point Kristina has lied (some of her answers were inconsistent), return -2.

DEFINITION
Class:EllysNumberGuessing
Method:getNumber
Parameters:int[], int[]
Returns:int
Method signature:int getNumber(int[] guesses, int[] answers)


CONSTRAINTS
-guesses and answers will each contain between 1 and 50 elements, inclusive.
-guesses and answers will contain the same number of elements.
-Each element of guesses will be between 1 and 1,000,000,000, inclusive.
-Each element of answers will be between 1 and 999,999,999, inclusive.


EXAMPLES

0)
{600, 594}
{6, 12}

Returns: 606

Apparently Kristina has thought of the number of this SRM.

1)
{100, 50, 34, 40}
{58, 8, 8, 2}

Returns: 42

It is not guaranteed that Elly has used a perfect strategy so far.

2)
{500000, 600000, 700000}
{120013, 220013, 79987}

Returns: -2

The answers here are inconsistent. After the second guess we can conclude that the answer is below 500000. But the third one indicates that it is above 500000. Thus, Kristina is a liar and you should return -2.

3)
{500000000}
{133742666}

Returns: -1

There are multiple possibilities here, thus you should return -1.

4)
{76938260, 523164588, 14196746, 296286419, 535893832,
 41243148, 364561227, 270003278, 472017422, 367932361,
 395758413, 301278456, 186276934, 316343129, 336557549,
 52536121, 98343562, 356769915, 89249181, 335191879}
{466274085, 20047757, 529015599, 246925926, 7318513,
 501969197, 178651118, 273209067, 71194923, 175279984,
 147453932, 241933889, 356935411, 226869216, 206654796,
 490676224, 444868783, 186442430, 453963164, 208020466}

Returns: 543212345



5)
{42}
{42}

Returns: 84

Don't forget that the number Kris has thought of must be between 1 and 1,000,000,000.

6)
{999900000}
{100001}

Returns: 999799999

Don't forget that the number Kris has thought of must be between 1 and 1,000,000,000.

// END CUT HERE
import java.util.*;
public class EllysNumberGuessing {
	
	
    public int getNumber(int[] guesses, int[] answers) {
    	
    	int[] p = new int[2];
    	p[0] = guesses[0] - answers[0];
    	p[1] = guesses[0]+ answers[0];
    	
    	int n = guesses.length;
    	
    	boolean[] flg = new boolean[2];
    	
    	for (int i =0;i<=1;i++){
    		if (p[i]>=1 && p[i] <=1000000000){
    			flg[i]= true;
    			for (int j=1;j<n;j++){
    				if (Math.abs(p[i] -guesses[j])!= answers[j]){
    					flg[i] = false;	
    				}
    			}
    		}
    	}
    	
    	if (flg[0] && flg[1]) return -1;
    	
    	if (flg[0]) return p[0];
    	if (flg[1]) return p[1];
    	return -2;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        try {
            eq(0,(new EllysNumberGuessing()).getNumber(new int[] {600, 594}, new int[] {6, 12}),606);
            eq(1,(new EllysNumberGuessing()).getNumber(new int[] {100, 50, 34, 40}, new int[] {58, 8, 8, 2}),42);
            eq(2,(new EllysNumberGuessing()).getNumber(new int[] {500000, 600000, 700000}, new int[] {120013, 220013, 79987}),-2);
            eq(3,(new EllysNumberGuessing()).getNumber(new int[] {500000000}, new int[] {133742666}),-1);
            eq(4,(new EllysNumberGuessing()).getNumber(new int[] {76938260, 523164588, 14196746, 296286419, 535893832,
                41243148, 364561227, 270003278, 472017422, 367932361,
                395758413, 301278456, 186276934, 316343129, 336557549,
                52536121, 98343562, 356769915, 89249181, 335191879}, new int[] {466274085, 20047757, 529015599, 246925926, 7318513,
                501969197, 178651118, 273209067, 71194923, 175279984,
                147453932, 241933889, 356935411, 226869216, 206654796,
                490676224, 444868783, 186442430, 453963164, 208020466}),543212345);
            eq(5,(new EllysNumberGuessing()).getNumber(new int[] {42}, new int[] {42}),84);
            eq(6,(new EllysNumberGuessing()).getNumber(new int[] {999900000}, new int[] {100001}),999799999);
        } catch( Exception exx) {
            System.err.println(exx);
            exx.printStackTrace(System.err);
        }
    }

// END CUT HERE
}
