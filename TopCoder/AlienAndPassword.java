// BEGIN CUT HERE
// PROBLEM STATEMENT
// 
Alien Fred wants to destroy the Earth, but he forgot the password that activates the planet destroyer.




You are given a String S.
Fred remembers that the correct password can be obtained from S by erasing exactly one character.




Return the number of different passwords Fred needs to try.


DEFINITION
Class:AlienAndPassword
Method:getNumber
Parameters:String
Returns:int
Method signature:int getNumber(String S)


CONSTRAINTS
-S will contain between 1 and 50 characters, inclusive.
-Each character in S will be an uppercase English letter ('A'-'Z').


EXAMPLES

0)
"A"

Returns: 1

In this case, the only password Fred needs to try is an empty string.

1)
"ABA"

Returns: 3

The following three passwords are possible in this case: "BA", "AA", "AB".

2)
"AABACCCCABAA"

Returns: 7



3)
"AGAAGAHHHHFTQLLAPUURQQRRRUFJJSBSZVJZZZ"

Returns: 26



4)
"ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ"

Returns: 1

Regardless of which character we erase, we will always obtain the same string. Thus there is only one possible password: the string that consists of 49 'Z's.

// END CUT HERE
import java.util.*;
public class AlienAndPassword {
    public int getNumber(String S) {
        List<String> list = new ArrayList<String>();
    	
    	
    	
    	for (int i=0;i<S.length();i++){
    		StringBuilder sb = new StringBuilder(S);
    		StringBuilder sb2 = sb.deleteCharAt(i);
    		String ss = sb2.toString();
    		if (!(list.contains(ss))){
    			list.add(ss);	
    		}
    	}
    	return list.size();
        
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        try {
            eq(0,(new AlienAndPassword()).getNumber("A"),1);
            eq(1,(new AlienAndPassword()).getNumber("ABA"),3);
            eq(2,(new AlienAndPassword()).getNumber("AABACCCCABAA"),7);
            eq(3,(new AlienAndPassword()).getNumber("AGAAGAHHHHFTQLLAPUURQQRRRUFJJSBSZVJZZZ"),26);
            eq(4,(new AlienAndPassword()).getNumber("ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ"),1);
        } catch( Exception exx) {
            System.err.println(exx);
            exx.printStackTrace(System.err);
        }
    }

// END CUT HERE
}
