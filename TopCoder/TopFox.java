// BEGIN CUT HERE
// PROBLEM STATEMENT
// Fox Ciel is planning to register on TopFox. Her family name is familyName and her given name is givenName.

She will choose a TopFox handle according to the following rule. Let s be a non-empty prefix of her family name and let t be a non-empty prefix of her given name. Now Fox Ciel may choose the concatenation of s and t as her handle.

For example, suppose Fox Ciel's family name is "fox" and her given name is "ciel". She may choose the handle "foxciel", "fc", or "foxc". She may not choose "ox", "ciel", or "jiro".

You are told Fox Ciel's family name and given name. Return the number of possible handles Fox Ciel may choose.

DEFINITION
Class:TopFox
Method:possibleHandles
Parameters:String, String
Returns:int
Method signature:int possibleHandles(String familyName, String givenName)


CONSTRAINTS
-familyName will contain between 2 and 10 characters, inclusive.
-Each character in familyName will be a lowercase English letter, i.e., 'a'-'z'.
-givenName will contain between 2 and 10 characters, inclusive.
-Each character in givenName will be a lowercase English letter, i.e., 'a'-'z'.


EXAMPLES

0)
"ab"
"cd"

Returns: 4

There are 4 possible handles: "a" + "c" = "ac", "a" + "cd" = "acd", "ab" + "c" = "abc" and "ab" + "cd" = "abcd".

1)
"abb"
"bbc"

Returns: 7

There are 7 possible handles: "ab", "abb", "abbc", "abbb", "abbbc", "abbbb", "abbbbc".

2)
"fox"
"ciel"

Returns: 12



3)
"abbbb"
"bbbbbbbc"

Returns: 16



4)
"abxy"
"xyxyxc"

Returns: 21



5)
"ababababab"
"bababababa"

Returns: 68



// END CUT HERE
import java.util.*;
public class TopFox {
    public int possibleHandles(String n, String m) {
        int res=0;

	  Set<String> s = new HashSet<String>();
        
        for (int i =1;i<n.length()+1;i++){
            String x = n.substring(0,i);
            
            for (int j =1;j<m.length()+1;j++){
                String y = m.substring(0,j);
            
                s.add(x+y);
            }
            
        }
        
        return s.size();
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        try {
            eq(0,(new TopFox()).possibleHandles("ab", "cd"),4);
            eq(1,(new TopFox()).possibleHandles("abb", "bbc"),7);
            eq(2,(new TopFox()).possibleHandles("fox", "ciel"),12);
            eq(3,(new TopFox()).possibleHandles("abbbb", "bbbbbbbc"),16);
            eq(4,(new TopFox()).possibleHandles("abxy", "xyxyxc"),21);
            eq(5,(new TopFox()).possibleHandles("ababababab", "bababababa"),68);
        } catch( Exception exx) {
            System.err.println(exx);
            exx.printStackTrace(System.err);
        }
    }

// END CUT HERE
}
