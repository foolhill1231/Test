// BEGIN CUT HERE
// PROBLEM STATEMENT
// You are very happy because you advanced to the next round of a very important programming contest.
You want your best friend to know how happy you are.
Therefore, you are going to send him a lot of smile emoticons.
You are given an int smiles: the exact number of emoticons you want to send.

You have already typed one emoticon into the chat.
Then, you realized that typing is slow.
Instead, you will produce the remaining emoticons using copy and paste.

You can only do two different operations:

Copy all the emoticons you currently have into the clipboard.
Paste all emoticons from the clipboard.

Each operation takes precisely one second.
Copying replaces the old content of the clipboard.
Pasting does not empty the clipboard.
Note that you are not allowed to copy just a part of the emoticons you already have.

Return the smallest number of seconds in which you can turn the one initial emoticon into smiles emoticons.

DEFINITION
Class:EmoticonsDiv2
Method:printSmiles
Parameters:int
Returns:int
Method signature:int printSmiles(int smiles)


CONSTRAINTS
-smiles will be between 2 and 1000, inclusive.


EXAMPLES

0)
2

Returns: 2

First use copy, then use paste. The first operation copies one emoticon into the clipboard, the second operation pastes it into the message, so now you have two emoticons and you are done.

1)
6

Returns: 5


Copy. This puts one emoticon into the clipboard.
Paste. You now have 2 emoticons in the message.
Copy. The clipboard now contains 2 emoticons.
Paste. You now have 4 emoticons in the message.
Paste. You now have 6 emoticons in the message and you are done.


2)
11

Returns: 11



3)
16

Returns: 8



4)
1000

Returns: 21



// END CUT HERE
import java.util.*;
public class EmoticonsDiv2 {
	
	static boolean isPrimeNum( int x ) {
        if( x == 2 ) return true;
        if( x < 2 || x % 2 == 0 ) return false;
        for( int n = 3; n <= Math.sqrt((double)x); n += 2 )
            if( x % n == 0 ) return false;
        return true;
    }
	
	
    public int printSmiles(int smiles) {
        
    	
    	if (isPrimeNum(smiles)) return smiles;
    	int cnt=0;
    	
    	int[] P = {2,3,5,7,11,13,17,19,23,29,31,37,41,47,53};
    	
    	int i =0;
    	while(true){
    		
    		
    		if (smiles%P[i]==0){
    				cnt+=P[i];
    			smiles /=P[i];
    		}else if (!(isPrimeNum(smiles))&&i<14) {
    			i++;
    		}else{
    			break;
    		}
    		
    		if (smiles==1) return cnt;
    	}
    	
    	
    	return cnt+smiles;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        try {
            eq(0,(new EmoticonsDiv2()).printSmiles(2),2);
            eq(1,(new EmoticonsDiv2()).printSmiles(6),5);
            eq(2,(new EmoticonsDiv2()).printSmiles(11),11);
            eq(3,(new EmoticonsDiv2()).printSmiles(16),8);
            eq(4,(new EmoticonsDiv2()).printSmiles(1000),21);
        } catch( Exception exx) {
            System.err.println(exx);
            exx.printStackTrace(System.err);
        }
    }

// END CUT HERE
}
