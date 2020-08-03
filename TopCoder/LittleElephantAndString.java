// BEGIN CUT HERE
// PROBLEM STATEMENT
// 
Little Elephant from the Zoo of Lviv likes strings.




You are given a String A and a String B of the same length. In one turn Little Elephant can choose any character of A and move it to the beginning of the string (i.e., before the first character of A). Return the minimal number of turns needed to transform A into B. If it's impossible, return -1 instead.


DEFINITION
Class:LittleElephantAndString
Method:getNumber
Parameters:String, String
Returns:int
Method signature:int getNumber(String A, String B)


CONSTRAINTS
-A will contain between 1 and 50 characters, inclusive.
-B will contain between 1 and 50 characters, inclusive.
-A and B will be of the same length.
-A and B will consist of uppercase letters ('A'-'Z') only.


EXAMPLES

0)
"ABC"
"CBA"

Returns: 2

The optimal solution is to make two turns. On the first turn, choose character 'B' and obtain string "BAC". On the second turn, choose character 'C' and obtain "CBA".

1)
"A"
"B"

Returns: -1

In this case, it's impossible to transform A into B.

2)
"AAABBB"
"BBBAAA"

Returns: 3



3)
"ABCDEFGHIJKLMNOPQRSTUVWXYZ"
"ZYXWVUTSRQPONMLKJIHGFEDCBA"

Returns: 25



4)
"A"
"A"

Returns: 0



5)
"DCABA"
"DACBA"

Returns: 2



// END CUT HERE
import java.util.*;
public class LittleElephantAndString {
    public int getNumber(String A, String B) {
        int n = A.length();
    	int i =n-1;
    	int j =n-1;
    	
    	int com =0;
    	
    	while(i>=0 &&j>=0){
    		if (A.charAt(i)==B.charAt(j)){
    			com++;
    			i--;
    			j--;
    		}else{
    			i--;
    	}
    }
    	int res = n-com;
    	char[] a = A.toCharArray();
    	char[] b = B.toCharArray();
    	Arrays.sort(a);
    	Arrays.sort(b);
    	
    	return Arrays.equals(a,b)? res: -1;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        try {
            eq(0,(new LittleElephantAndString()).getNumber("ABC", "CBA"),2);
            eq(1,(new LittleElephantAndString()).getNumber("A", "B"),-1);
            eq(2,(new LittleElephantAndString()).getNumber("AAABBB", "BBBAAA"),3);
            eq(3,(new LittleElephantAndString()).getNumber("ABCDEFGHIJKLMNOPQRSTUVWXYZ", "ZYXWVUTSRQPONMLKJIHGFEDCBA"),25);
            eq(4,(new LittleElephantAndString()).getNumber("A", "A"),0);
            eq(5,(new LittleElephantAndString()).getNumber("DCABA", "DACBA"),2);
        } catch( Exception exx) {
            System.err.println(exx);
            exx.printStackTrace(System.err);
        }
    }

// END CUT HERE
}
