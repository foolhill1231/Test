// BEGIN CUT HERE
// PROBLEM STATEMENT
// Hero is learning a new algorithm to encode a string.
You are given a String s that consists of lowercase letters only.
Your task is to simulate the algorithm described below on this string, so that Hero can see how it works.

The algorithm starts with a given input string s and an empty output string t.
The execution of the algorithm consists of multiple steps.
In each step, s and t are modified as follows:

If the length of s is odd, the middle character of s is added to the end of t, and then deleted from s.
If the length of s is even, the two characters in the middle of s are compared. The smaller one of them (either one in case of a tie) is added to the end of t, and then deleted from s.

If after some step the string s is empty, the algorithm terminates.
The output of the algorithm is the final string t.

Return the String t that will be produced by the above algorithm for the given String s.

DEFINITION
Class:MiddleCode
Method:encode
Parameters:String
Returns:String
Method signature:String encode(String s)


NOTES
-When comparing letters, the smaller one is the one earlier in the alphabet - i.e., the character with the smaller ASCII code.


CONSTRAINTS
-s will contain between 1 and 50 characters, inclusive.
-Each character in s will be a lowercase letter ('a'-'z').


EXAMPLES

0)
"word"

Returns: "ordw"


In the first step, 'o' is smaller than 'r', thus 'o' is selected.
After the first step: s="wrd", t="o".
After the second step: s="wd", t="or".
In the third step, 'w' is greater than 'd', thus 'd' is selected.
After the third step: s="w", t="ord".
After the fourth step: s="", t="ordw", and the algorithm terminates.


1)
"aaaaa"

Returns: "aaaaa"



2)
"abacaba"

Returns: "caabbaa"



3)
"shjegr"

Returns: "ejghrs"



4)
"adafaaaadafawafwfasdaa"

Returns: "afawadafawafaafsadadaa"



// END CUT HERE
import java.util.*;
public class MiddleCode {
	
	private static char removeCharAt(StringBuilder sb, int i){
		char c = sb.charAt(i);
		sb.delete(i,i+1);
		return c;
	}
    public String encode(String s) {
        StringBuilder sb = new StringBuilder(s);
    	StringBuilder res = new StringBuilder();
    	
    	int m=sb.length();
    	
    	for (int i=0;i<m;i++){
    		int n = (m-i)/2;
    		if ((m-i)%2==1){
    			res.append(removeCharAt(sb,n));
    		}else{
    			if (sb.charAt(n)<sb.charAt(n-1)){
    				res.append(removeCharAt(sb,n));
    			}else{
    				res.append(removeCharAt(sb,n-1));
    			}
    		}
    	}
    	return res.toString();
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        try {
            eq(0,(new MiddleCode()).encode("word"),"ordw");
            eq(1,(new MiddleCode()).encode("aaaaa"),"aaaaa");
            eq(2,(new MiddleCode()).encode("abacaba"),"caabbaa");
            eq(3,(new MiddleCode()).encode("shjegr"),"ejghrs");
            eq(4,(new MiddleCode()).encode("adafaaaadafawafwfasdaa"),"afawadafawafaafsadadaa");
        } catch( Exception exx) {
            System.err.println(exx);
            exx.printStackTrace(System.err);
        }
    }

// END CUT HERE
}
