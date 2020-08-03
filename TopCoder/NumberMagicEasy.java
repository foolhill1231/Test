// BEGIN CUT HERE
// PROBLEM STATEMENT
// NOTE: This problem statement contains images that may not display properly if viewed outside of the applet.


Taro shows a magic trick to Hanako.



Taro: Hello Hanako. I'll show you a magic trick. Please imagine a positive integer less than or equal to 16.
Hanako: OK. I imagined it.
Taro: (Taro shows card 1 to Hanako.) Does this card contain your number?
Hanako: Yes.
Taro: (Taro shows card 2 to Hanako.) Does this card contain your number?
Hanako: No.
Taro: (Taro shows card 3 to Hanako.) Does this card contain your number?
Hanako: Yes.
Taro: (Taro shows card 4 to Hanako.) Does this card contain your number?
Hanako: Yes.
Taro: Your number is 5!




(Card 1 contains 1, 2, 3, 4, 5, 6, 7 and 8. Card 2 contains 1, 2, 3, 4, 9, 10, 11 and 12. Card 3 contains 1, 2, 5, 6, 9, 10, 13 and 14. Card 4 contains 1, 3, 5, 7, 9, 11, 13 and 15.)


Your task is to write a program that simulates this magic trick. You are given Hanako's answers in the String answer. The i-th character is 'Y' if she answered "yes" to the i-th question, and 'N' if she answered "no" to the i-th question. Return the integer Hanako imagined.

DEFINITION
Class:NumberMagicEasy
Method:theNumber
Parameters:String
Returns:int
Method signature:int theNumber(String answer)


CONSTRAINTS
-answer will contain exactly 4 characters.
-Each character in answer will be 'Y' or 'N'.


EXAMPLES

0)
"YNYY"

Returns: 5

The example from the statement.

1)
"YNNN"

Returns: 8

8 is the only number that exists on the first card and does not exist on any other cards.

2)
"NNNN"

Returns: 16



3)
"YYYY"

Returns: 1



4)
"NYNY"

Returns: 11



// END CUT HERE
import java.util.*;
public class NumberMagicEasy {
    public int theNumber(String answer) {

        int res=0;
	int[] n ={8,4,2,1};
	for(int i=0;i<4;i++){
		if (answer.charAt(i)=='Y') {
			res=res+n[i];
		}
	}
        return (16-res);
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        try {
            eq(0,(new NumberMagicEasy()).theNumber("YNYY"),5);
            eq(1,(new NumberMagicEasy()).theNumber("YNNN"),8);
            eq(2,(new NumberMagicEasy()).theNumber("NNNN"),16);
            eq(3,(new NumberMagicEasy()).theNumber("YYYY"),1);
            eq(4,(new NumberMagicEasy()).theNumber("NYNY"),11);
        } catch( Exception exx) {
            System.err.println(exx);
            exx.printStackTrace(System.err);
        }
    }

// END CUT HERE
}
