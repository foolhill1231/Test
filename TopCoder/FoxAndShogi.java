// BEGIN CUT HERE
// PROBLEM STATEMENT
// Fox Ciel is going to play Shogi with her friend Jiro.
Before they start, Jiro showed her a puzzle with some pawns on the board.


You are given a String[] board that describes Jiro's board.
Character j of element i of board represents the cell (i,j) of the board:
'U' is a cell with a pawn that may move upwards, 'D' a cell with a pawn that may move downwards, and '.' is an empty cell.


Jiro showed Ciel this board and gave her the following question:
You are allowed to make as many valid moves as you wish, including zero.
In each move you may either take a 'U' pawn and move it one cell upwards, or take a 'D' pawn and move it one cell downwards.
Of course, both types of moves are only valid if the destination cell is currently empty.
Pawns are not allowed to move out of bounds.
How many different configurations can you create?


Return the number of different configurations that are reachable from the one described by board, modulo 1,000,000,007.

DEFINITION
Class:FoxAndShogi
Method:differentOutcomes
Parameters:String[]
Returns:int
Method signature:int differentOutcomes(String[] board)


CONSTRAINTS
-n will be between 2 and 50, inclusive.
-board will contain exactly n elements.
-Each element in board will contain exactly n characters.
-Each character in board will be one of 'U', 'D' or '.'.


EXAMPLES

0)
{".D.",
 "...",
 "..."}
 

Returns: 3

Ciel can move the pawn 0, 1, or 2 steps downwards.

1)
{".D.",
 "...",
 ".U."}
 

Returns: 3

There are three different outcomes: Either we do not move any of the pawns, or we move the top one downwards, or the bottom one upwards.

2)
{"DDDDD",
 ".....",
 ".....",
 ".....",
 "....."}


Returns: 3125

The answer is 5^5. Note that we are only counting each configuration once, even if there are multiple ways of reaching it.

3)
{"DDDDD",
 "U....",
 ".U...",
 "..U..",
 "...U."}


Returns: 900



4)
{"....D..",
 "U....D.",
 "D.D.U.D",
 "U.U...D",
 "....U..",
 "D.U...D",
 "U.U...."}


Returns: 2268



5)
{"DDDDDDDDDD",
 "..........",
 "..........",
 "..........",
 "..........",
 "..........",
 "..........",
 "..........",
 "..........",
 ".........."}


Returns: 999999937

The answer is 10^10 mod 1,000,000,007.


6)
{"..",
 ".."}

Returns: 1



// END CUT HERE
import java.util.*;
public class FoxAndShogi {
    public int differentOutcomes(String[] board) {
        int res;
        return res;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        try {
            eq(0,(new FoxAndShogi()).differentOutcomes(new String[] {".D.",
                "...",
                "..."}
                ),3);
            eq(1,(new FoxAndShogi()).differentOutcomes(new String[] {".D.",
                "...",
                ".U."}
                ),3);
            eq(2,(new FoxAndShogi()).differentOutcomes(new String[] {"DDDDD",
                ".....",
                ".....",
                ".....",
                "....."}
               ),3125);
            eq(3,(new FoxAndShogi()).differentOutcomes(new String[] {"DDDDD",
                "U....",
                ".U...",
                "..U..",
                "...U."}
               ),900);
            eq(4,(new FoxAndShogi()).differentOutcomes(new String[] {"....D..",
                "U....D.",
                "D.D.U.D",
                "U.U...D",
                "....U..",
                "D.U...D",
                "U.U...."}
               ),2268);
            eq(5,(new FoxAndShogi()).differentOutcomes(new String[] {"DDDDDDDDDD",
                "..........",
                "..........",
                "..........",
                "..........",
                "..........",
                "..........",
                "..........",
                "..........",
                ".........."}
               ),999999937);
            eq(6,(new FoxAndShogi()).differentOutcomes(new String[] {"..",
                ".."}),1);
        } catch( Exception exx) {
            System.err.println(exx);
            exx.printStackTrace(System.err);
        }
    }

// END CUT HERE
}
