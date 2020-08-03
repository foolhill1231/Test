// BEGIN CUT HERE
// PROBLEM STATEMENT
// Fox Ciel received a string as a birthday present. However, the string was too long for her, so she decided to make it shorter by erasing some characters.


The erasing process will look as follows:

Find the smallest i such that the i-th character and the (i+1)-th character of the string are same.
If there is no such i, end the process.
Remove the i-th and the (i+1)-th character of the string, and repeat from 1.



For example, if she receives "cieeilll", she will change the string as follows: "cieeilll" -> "ciilll" -> "clll" -> "cl". You are given a String s. Return the string she will get after she erases characters as described above.

DEFINITION
Class:ErasingCharacters
Method:simulate
Parameters:String
Returns:String
Method signature:String simulate(String s)


CONSTRAINTS
-s will contain between 1 and 50 characters, inclusive.
-Each character in s will be a lowercase letter ('a'-'z').


EXAMPLES

0)
"cieeilll"

Returns: "cl"

This is the example from the statement.

1)
"topcoder"

Returns: "topcoder"

She won't erase any characters at all.

2)
"abcdefghijklmnopqrstuvwxyyxwvutsrqponmlkjihgfedcba"

Returns: ""



3)
"bacaabaccbaaccabbcabbacabcbba"

Returns: "bacbaca"



4)
"eel"

Returns: "l"



// END CUT HERE
import java.util.*;
public class ErasingCharacters {
    public String simulate(String s) {
        
    	while(true){
    		boolean flg = false;
    		
    		for (int i=0;i<s.length()-1;i++){
    			if (s.charAt(i)==s.charAt(i+1)){
    				String s1 = s.substring(0,i);
    				String s2 = s.substring(i+2);
    				s = s1+s2;
    				flg = true;
    				break;
    			}
    			
    		}
    		if (!flg) break;;
    	}
        return s;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        try {
            eq(0,(new ErasingCharacters()).simulate("cieeilll"),"cl");
            eq(1,(new ErasingCharacters()).simulate("topcoder"),"topcoder");
            eq(2,(new ErasingCharacters()).simulate("abcdefghijklmnopqrstuvwxyyxwvutsrqponmlkjihgfedcba"),"");
            eq(3,(new ErasingCharacters()).simulate("bacaabaccbaaccabbcabbacabcbba"),"bacbaca");
            eq(4,(new ErasingCharacters()).simulate("eel"),"l");
        } catch( Exception exx) {
            System.err.println(exx);
            exx.printStackTrace(System.err);
        }
    }

// END CUT HERE
}
