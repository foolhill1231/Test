// BEGIN CUT HERE
// PROBLEM STATEMENT
// Marco recently learned about palindromic strings.
A palindromic string is a string that reads the same forwards and backwards.
For example, "radar" and "racecar" are palindromic strings.

Now Marco is excited about palindromic strings.
In particular, he likes strings that have a lot of palindromic substrings.
For example, he really likes the string "aaa" because it has 6 palindromic substrings: "a" occurs three times, "aa" occurs twice, and "aaa" occurs once.

Right now, Marco has a string S composed of lowercase letters.
You are to reconstruct S from the given String[]s S1 and S2 as follows:

Concatenate in order all elements of S1 to make a string A.
Concatenate in order all elements of S2 to make a string B.
Finally, concatenate A and B to get S.



Return the number of palindromic substrings in S.

DEFINITION
Class:PalindromicSubstringsDiv2
Method:count
Parameters:String[], String[]
Returns:int
Method signature:int count(String[] S1, String[] S2)


CONSTRAINTS
-S1 and S2 will each contain no more than 50 elements.
-Each element of S1 and S2 will contain no more than 50 characters.
-S will contain at least 1 character.
-S will contain only lowercase letters ('a' - 'z').


EXAMPLES

0)
{"a","a",""}
{"a"}

Returns: 6

This is the example given in the statement, "aaa".

1)
{"zaz"}
{}

Returns: 4



2)
{"top"}
{"coder"}

Returns: 8



3)
{}
{"daata"}

Returns: 7

There are five palindromic substrings of length 1, one of length 2 ("aa" starting at index 1), and one of length 3 ("ata" starting at index 2).

// END CUT HERE
import java.util.*;
public class PalindromicSubstringsDiv2 {
   
    	
    	Boolean rev(String s){
		int n=s.length();
		
		String ret="";
		for (int i=0;i<s.length();i++){
			ret = s.charAt(i)+ret;
		}
	
    		return (s.equals(ret));
		
	}
    public int count(String[] S1, String[] S2) {
    	StringBuilder sb = new StringBuilder();
    	
    	
    	for (int i=0;i<S1.length;i++){
    		sb.append(S1[i]);
    	}
    	for (int i=0;i<S2.length;i++){
    		sb.append(S2[i]);	
    	}
    	
    	int m = sb.length();
    	int cnt = m;
    	
    	
    	for (int i=2;i<=m;i++){
    		
    		for (int j=0;i+j<=m;j++){
    			
    			if (rev(sb.substring(j,i+j))) cnt ++;
    			
    		}
    	}
        return cnt;
        
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        try {
            eq(0,(new PalindromicSubstringsDiv2()).count(new String[] {"a","a",""}, new String[] {"a"}),6);
            eq(1,(new PalindromicSubstringsDiv2()).count(new String[] {"zaz"}, new String[] {}),4);
            eq(2,(new PalindromicSubstringsDiv2()).count(new String[] {"top"}, new String[] {"coder"}),8);
            eq(3,(new PalindromicSubstringsDiv2()).count(new String[] {}, new String[] {"daata"}),7);
        } catch( Exception exx) {
            System.err.println(exx);
            exx.printStackTrace(System.err);
        }
    }

// END CUT HERE
}
