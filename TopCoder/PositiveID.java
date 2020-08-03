// BEGIN CUT HERE
// PROBLEM STATEMENT
// You are investigating a robbery, and you are sure the robbery was committed by one of the suspects you have information on.  Each element of suspects will contain a number of characteristics of that suspect in a comma separated list.  For example, suppose we had the following list of suspects:


suspect 0: "blond,tall,skinny"
suspect 1: "short,skinny,blond,tattooed"
suspect 2: "scarred,bald"


You may assume that if a characteristic is not on the list for a suspect then that characteristic does not apply - so in this case we can be sure that suspect 0 is not "tattooed" or "bald" or anything else other than what's listed.  Therefore, if we knew that the culprit was "tattooed", we would know for sure that suspect 1 is the guilty party.  However, if we knew that the culprit was "skinny" and "blond" we would still be unsure whether suspect 0 or suspect 1 was the robber.

Return the maximum number of facts we could know such that the facts:

Are all consistent with at least one of the suspects.
Do not uniquely identify the culprit.


In the example above, the value is 2.  We could know that the suspect is "skinny" and "blond" - but if we knew anything more than that about the culprit then we would be able to identify the culprit uniquely (or the facts would no longer be consistent with any of the suspects).

DEFINITION
Class:PositiveID
Method:maximumFacts
Parameters:String[]
Returns:int
Method signature:int maximumFacts(String[] suspects)


CONSTRAINTS
-suspects will contain between 1 and 50 elements, inclusive.
-Each element of suspects will contain between 1 and 50 characters, inclusive.
-Elements of suspects will contain only lowercase letters ('a'-'z') and commas (',').
-Each element of suspects will not have a comma (',') as the first or last character.
-Each element of suspects will not contain two adjacent commas.
-Each element of suspects will not contain the same characteristic more than once.


EXAMPLES

0)
{"blond,tall,skinny",
"short,skinny,blond,tattooed",
"scarred,bald"}

Returns: 2

The example from the problem statement.

1)
{"gigantic,fluorescent,loud,male"}

Returns: 0

There's only one subject, and he should be easy to find.  We cannot know any facts without being able to make a positive ID.

2)
{"medium,average,nondescript",
"medium,average,nondescript"}

Returns: 3

There's no way to tell these two apart - so we could know all 3 facts without being able to make an ID.

3)
{"big,tall,loud,happy,male,scarred,tattooed,dirty",
"short,male,beard,quiet,happy,tanned,handsome",
"female,pretty,blond,quiet",
"somnambulistic",
"happy,tiny,stout,male,tanned,beard,blond"}

Returns: 4



// END CUT HERE
import java.util.*;
public class PositiveID {
    public int maximumFacts(String[] suspects) {
        int res;
        return res;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        try {
            eq(0,(new PositiveID()).maximumFacts(new String[] {"blond,tall,skinny",
               "short,skinny,blond,tattooed",
               "scarred,bald"}),2);
            eq(1,(new PositiveID()).maximumFacts(new String[] {"gigantic,fluorescent,loud,male"}),0);
            eq(2,(new PositiveID()).maximumFacts(new String[] {"medium,average,nondescript",
               "medium,average,nondescript"}),3);
            eq(3,(new PositiveID()).maximumFacts(new String[] {"big,tall,loud,happy,male,scarred,tattooed,dirty",
               "short,male,beard,quiet,happy,tanned,handsome",
               "female,pretty,blond,quiet",
               "somnambulistic",
               "happy,tiny,stout,male,tanned,beard,blond"}),4);
        } catch( Exception exx) {
            System.err.println(exx);
            exx.printStackTrace(System.err);
        }
    }

// END CUT HERE
}
