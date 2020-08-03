// BEGIN CUT HERE
// PROBLEM STATEMENT
// One day, Fox Ciel looked at the words "tokyo" and "kyoto" and noticed an unusual property:
We can split "tokyo" into "to"+"kyo", and then swap those two parts to obtain "kyo"+"to" = "kyoto".


Formally, let S and T be two different strings.
We call the pair (S,T) interesting if there are two non-empty strings A and B such that S = A+B and T = B+A.
For example, according to this definition, if S="tokyo" and T="kyoto", then the pair (S,T) is interesting, because we can find A="to" and B="kyo".


You are given a String[] words.
Return the number of interesting pairs we can find among the elements of words.
Only count each pair once.
E.g., ("tokyo","kyoto") and ("kyoto","tokyo") is the same interesting pair.

DEFINITION
Class:FoxAndWord
Method:howManyPairs
Parameters:String[]
Returns:int
Method signature:int howManyPairs(String[] words)


CONSTRAINTS
-words will contain between 2 and 50 elements, inclusive.
-Each element of words will contain between 1 and 50 characters, inclusive.
-Each character in each element of words will be a lowercase letter ('a'-'z').
-All the elements in words will be pairwise distinct.


EXAMPLES

0)
{"tokyo", "kyoto"}

Returns: 1

As mentioned in the problem statement, ("tokyo", "kyoto") is an interesting pair.

1)
{"aaaaa", "bbbbb"}

Returns: 0

("aaaaa", "bbbbb") is not an interesting pair.

2)
{"ababab","bababa","aaabbb"}

Returns: 1

There is one interesting pair: ("ababab","bababa").
Note that for this interesting pair there is more than one way to choose the strings A and B.

3)
{"eel", "ele", "lee"}

Returns: 3



4)
{"aaa", "aab", "aba", "abb", "baa", "bab", "bba", "bbb"}

Returns: 6



5)
{"top","coder"}

Returns: 0

Different elements of words may have different lengths.


// END CUT HERE
import java.util.*;
public class FoxAndWord {
    public int howManyPairs(String[] words) {
        int res=0;
    	
    	
    	for (int i=0;i<words.length;i++){
    		boolean[] check = new boolean[words.length];
    		for (int j=1;j<words[i].length();j++){
    			
    			
    			StringBuilder sb = new StringBuilder(words[i]);
    			String s = sb.substring(0,j);
    			sb.delete(0,j);
    			sb.append(s);
    			System.out.println(sb);
    			for (int k=i+1;k<words.length;k++){
    				String ss = sb.toString();
    				if (!(check[k])&& ss.equals(words[k])) {
    				
    					res++;
						check[k] = true;
    				}
    			}
 
    		}
    	}
    	
    	
        return res;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        try {
            eq(0,(new FoxAndWord()).howManyPairs(new String[] {"tokyo", "kyoto"}),1);
            eq(1,(new FoxAndWord()).howManyPairs(new String[] {"aaaaa", "bbbbb"}),0);
            eq(2,(new FoxAndWord()).howManyPairs(new String[] {"ababab","bababa","aaabbb"}),1);
            eq(3,(new FoxAndWord()).howManyPairs(new String[] {"eel", "ele", "lee"}),3);
            eq(4,(new FoxAndWord()).howManyPairs(new String[] {"aaa", "aab", "aba", "abb", "baa", "bab", "bba", "bbb"}),6);
            eq(5,(new FoxAndWord()).howManyPairs(new String[] {"top","coder"}),0);
        } catch( Exception exx) {
            System.err.println(exx);
            exx.printStackTrace(System.err);
        }
    }

// END CUT HERE
}
