// BEGIN CUT HERE
// PROBLEM STATEMENT
// Let X and Y be two strings of equal length, consisting of uppercase English letters only.
The two strings are called convertible if there is a permutation P of the English alphabet with the following property:
if each character c in the string X is replaced by the character P(c), we obtain the string Y.
(In other words, X and Y are convertible iff the following holds: whenever two letters of X are equal, the corresponding two letters of Y must be equal, and vice versa.)

For example, consider the string "ABCA".
We can choose to replace each 'A' by a 'F', each 'B' by a 'B', and each 'C' by a 'G', obtaining the string "FBGF".
Thus the strings "ABCA" and "FBGF" are convertible.
The strings "ABCA" and "EFGH" are not convertible, because the two 'A's in the first string must correspond to the same letter in the second string.
The strings "ABCA" and "EEEE" are not convertible, because different letters in the first string must correspond to different letters in the second string.

You are given two Strings A and B of the same length.
These strings only contain English letters from 'A' to 'I', inclusive.
(That is, only the first 9 letters of the alphabet are used.)

You want to change A and B into two strings that are convertible.
The only allowed change is to choose some indices (possibly none) and to remove the characters at those indices from each of the strings.
(I.e., the removed characters must be at the same positions in both strings. For example, it is not allowed to only remove character 0 of A and character 3 of B.)
For example, if A="ABAC", B="AHHA" and the chosen indices are 0 and 2, then the resulting strings will be "BC" and "HA".
Our goal is to choose as few indices as possible, given that after the erasing we want to obtain two convertible strings.
Compute and return the smallest possible number of chosen indices.


DEFINITION
Class:ConvertibleStrings
Method:leastRemovals
Parameters:String, String
Returns:int
Method signature:int leastRemovals(String A, String B)


CONSTRAINTS
-A will contain between 1 and 50 characters, inclusive.
-A and B will be of the same length.
-A will contain characters from 'A' to 'I' only.
-B will contain characters from 'A' to 'I' only.


EXAMPLES

0)
"DD"
"FF"

Returns: 0

The given strings are convertible without any removals. Any mapping with 'D' mapped to 'F' changes A to B.

1)
"AAAA"
"ABCD"

Returns: 3

We can choose any three indices.

2)
"AAIAIA"
"BCDBEE"

Returns: 3

One possible triple of indices is (1, 2, 5) (0-based indices).


3)
"ABACDCECDCDAAABBFBEHBDFDDHHD"
"GBGCDCECDCHAAIBBFHEBBDFHHHHE"

Returns: 9



// END CUT HERE
import java.util.*;
public class ConvertibleStrings {
    public int leastRemovals(String A, String B) {
        int res;
        return res;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        try {
            eq(0,(new ConvertibleStrings()).leastRemovals("DD", "FF"),0);
            eq(1,(new ConvertibleStrings()).leastRemovals("AAAA", "ABCD"),3);
            eq(2,(new ConvertibleStrings()).leastRemovals("AAIAIA", "BCDBEE"),3);
            eq(3,(new ConvertibleStrings()).leastRemovals("ABACDCECDCDAAABBFBEHBDFDDHHD", "GBGCDCECDCHAAIBBFHEBBDFHHHHE"),9);
        } catch( Exception exx) {
            System.err.println(exx);
            exx.printStackTrace(System.err);
        }
    }

// END CUT HERE
}
