// BEGIN CUT HERE
// PROBLEM STATEMENT
// Elly has a String S of uppercase letters and a magic device that can modify the string. The strength of the device is an int L.

The device does the following: The user enters a 0-based index i such that 0 <= i <= length(S)-L. The device then takes L letters of S, starting at index i, and puts these letters into alphabetical order.
Formally, the letters that get reordered are the letters S[i], S[i+1], and so on, until and including S[i+L-1].

For example, let S="TOPCODER" and let L=4. If the user chooses i=0, the selected substring will be "TOPC". These letters are rearranged into alphabetical order ("COPT") while the rest of the string remains unchanged ("....ODER"). Thus, the result would be the string "COPTODER". If the user were to choose i=2 instead, the resulting string would be "TOCDOPER". Here, "TO....ER" was left unchanged, and "PCOD" was changed into "CDOP".

Elly's magic device has a flaw: it can only be used once and then it self-destructs. You are given the String S and the int L described above. Return the lexicographically smallest string Elly can create by using the device exactly once.


DEFINITION
Class:EllysSubstringSorter
Method:getMin
Parameters:String, int
Returns:String
Method signature:String getMin(String S, int L)


NOTES
-A string S1 is lexicographically smaller than a string S2 if S1 contains a smaller character than S2 at the first index where they differ.


CONSTRAINTS
-L will be between 2 and 50, inclusive.
-S will contain between L and 50 characters, inclusive.
-Each character of S will be an uppercase letter of the English alphabet ('A'-'Z').


EXAMPLES

0)
"TOPCODER"
4

Returns: "COPTODER"

The best we can do here is to sort the first 4 characters of the string.

1)
"ESPRIT"
3

Returns: "EPRSIT"

The best solution is obtained by choosing i=1, i.e., by sorting the letters in the substring "SPR".

2)
"AAAAAAAAA"
2

Returns: "AAAAAAAAA"

Sometimes sorting doesn't do anything.

3)
"ABRACADABRA"
5

Returns: "AAABCRDABRA"



4)
"BAZINGA"
6

Returns: "ABGINZA"



5)
"AAAWDIUAOIWDESBEAIWODJAWDBPOAWDUISAWDOOPAWD"
21

Returns: "AAAAAABDDDEEIIIJOOSUWWWWDBPOAWDUISAWDOOPAWD"



// END CUT HERE
import java.util.*;
public class EllysSubstringSorter {
    public String getMin(String S, int L) {
        
    	
    	
    	char[] c = S.toCharArray();
    	
    	char min = c[0];
    	
    	
    	for (int i=0;i<c.length;i++){
    		if (min>=c[i]){
    			min = c[i];	
    		}
    	}
    	
    	int st =0;
    	
    	for (int i=0;i<c.length;i++){
    		if (c[i]== min){
    			st++;
    			
    		}else{
    			break;
    		}
    	}
    	
    	
    	
    	char[] cs = new char[L];
    	
    
    	
    	for (int k=0;k<L;k++){
    		cs[k]=c[st+k];	
    	}
    	Arrays.sort(cs);
    	
    	for (int k=0;k<L;k++){
    		c[st+k]=cs[k];
    	
    	}
    	
    	String res = new String(c);
        return res;
        
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        try {
            eq(0,(new EllysSubstringSorter()).getMin("TOPCODER", 4),"COPTODER");
            eq(1,(new EllysSubstringSorter()).getMin("ESPRIT", 3),"EPRSIT");
            eq(2,(new EllysSubstringSorter()).getMin("AAAAAAAAA", 2),"AAAAAAAAA");
            eq(3,(new EllysSubstringSorter()).getMin("ABRACADABRA", 5),"AAABCRDABRA");
            eq(4,(new EllysSubstringSorter()).getMin("BAZINGA", 6),"ABGINZA");
            eq(5,(new EllysSubstringSorter()).getMin("AAAWDIUAOIWDESBEAIWODJAWDBPOAWDUISAWDOOPAWD", 21),"AAAAAABDDDEEIIIJOOSUWWWWDBPOAWDUISAWDOOPAWD");
        } catch( Exception exx) {
            System.err.println(exx);
            exx.printStackTrace(System.err);
        }
    }

// END CUT HERE
}
