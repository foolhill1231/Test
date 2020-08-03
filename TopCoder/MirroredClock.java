// BEGIN CUT HERE
// PROBLEM STATEMENT
// You are sitting in front of a mirror and looking at the image of a clock located behind you. You want to know what time it is. The clock is a traditional clock with a 12-hour board (without numbers written on it), a minute and an hour hand (the hour hand is shorter, so that you can distuniguish them). You are given a String time denoting the time as it is seen in the mirror. The time will be formatted as "HH:MM" (quotes for clarity), where HH is the two digit hour and MM is the two digit minute. The hour will be between 00 and 11, inclusive, where 00 represents 12 o' clock. Return a String in the same format denoting the actual time. See examples for further clarification.

DEFINITION
Class:MirroredClock
Method:whatTimeIsIt
Parameters:String
Returns:String
Method signature:String whatTimeIsIt(String time)


CONSTRAINTS
-time will be formatted as "HH:MM" (quotes for clarity), where HH is a two digit integer between 00 and 11, inclusive, and MM is a two digit integer between 00 and 59, inclusive.


EXAMPLES

0)
"10:00"

Returns: "02:00"



1)
"01:15"

Returns: "10:45"



2)
"03:40"

Returns: "08:20"



3)
"00:00"

Returns: "00:00"

Although it doesn't happen often, sometimes we can see the actual time right in the mirror.

4)
"11:53"

Returns: "00:07"



// END CUT HERE
import java.util.*;
public class MirroredClock {
    public String whatTimeIsIt(String time) {
        String res;
        return res;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        try {
            eq(0,(new MirroredClock()).whatTimeIsIt("10:00"),"02:00");
            eq(1,(new MirroredClock()).whatTimeIsIt("01:15"),"10:45");
            eq(2,(new MirroredClock()).whatTimeIsIt("03:40"),"08:20");
            eq(3,(new MirroredClock()).whatTimeIsIt("00:00"),"00:00");
            eq(4,(new MirroredClock()).whatTimeIsIt("11:53"),"00:07");
        } catch( Exception exx) {
            System.err.println(exx);
            exx.printStackTrace(System.err);
        }
    }

// END CUT HERE
}
