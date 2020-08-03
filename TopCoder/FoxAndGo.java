// BEGIN CUT HERE
// PROBLEM STATEMENT
// Fox Ciel is teaching her friend Jiro to play Go.
Ciel has just placed some white and some black tokens onto a board.
She now wants Jiro to find the best possible move.
(This is defined more precisely below.)


You are given a String[] board.
Character j of element i of board represents the cell (i,j) of the board:
'o' is a cell with a white token, 'x' a cell with a black token, and '.' is an empty cell.
At least one cell on the board will be empty.


Jiro's move will consist of adding a single black token to the board.
The token must be placed onto an empty cell.
Once Jiro places the token, some white tokens will be removed from the board according to the rules described in the next paragraphs.


The white tokens on the board can be divided into connected components using the following rules:
If two white tokens lie in cells that share an edge, they belong to the same component.
Being in the same component is transitive: if X lies in the same component as Y and Y lies in the same component as Z, then X lies in the same component as Z.


Each component of white tokens is processed separately.
For each component of white tokens we check whether it is adjacent to an empty cell.
(That is, whether there are two cells that share an edge such that one of them is empty and the other contains a white token from the component we are processing.)
If there is such an empty cell, the component is safe and its tokens remain on the board.
If there is no such empty cell, the component is killed and all its tokens are removed from the board.


Jiro's score is the total number of white tokens removed from the board after he makes his move.
Return the maximal score he can get for the given board.


DEFINITION
Class:FoxAndGo
Method:maxKill
Parameters:String[]
Returns:int
Method signature:int maxKill(String[] board)


NOTES
-The position described by board does not have to be a valid Go position. In particular, there can already be components of white tokens that have no adjacent empty cell.
-Please ignore official Go rules. The rules described in the problem statement are slightly different. For example, in this problem the black tokens cannot be killed, and it is allowed to place the black token into any empty cell.


CONSTRAINTS
-n will be between 2 and 19, inclusive.
-board will contain exactly n elements.
-Each element in board will contain exactly n characters.
-Each character in board will be 'o', 'x' or '.'.
-There will be at least one '.' in board.


EXAMPLES

0)
{".....",
 "..x..",
 ".xox.",
 ".....",
 "....."}


Returns: 1

To kill the only white token, Jiro must place his black token into the cell (3,2). (Both indices are 0-based.)

1)
{"ooooo",
 "xxxxo",
 "xxxx.",
 "xxxx.",
 "ooooo"}


Returns: 6

By placing the token to the cell (2,4) Jiro kills 6 white tokens. The other possible move only kills 5 tokens.

2)
{".xoxo",
 "ooxox",
 "oooxx",
 "xoxox",
 "oxoox"}


Returns: 13

There is only one possible move. After Jiro makes it, all the white tokens are killed.

3)
{".......",
 ".......",
 ".......",
 "xxxx...",
 "ooox...",
 "ooox...",
 "ooox..."}


Returns: 9

Regardless of where Jiro moves, the 9 white tokens in the lower left corner will be killed.

4)
{".......",
 ".xxxxx.",
 ".xooox.",
 ".xo.ox.",
 ".xooox.",
 ".xxxxx.",
 "......."}


Returns: 8



5)
{"o.xox.o",
 "..xox..",
 "xxxoxxx",
 "ooo.ooo",
 "xxxoxxx",
 "..xox..",
 "o.xox.o"}


Returns: 12



6)
{".......",
 "..xx...",
 ".xooox.",
 ".oxxox.",
 ".oxxxo.",
 "...oo..",
 "......."}

Returns: 4



7)
{".ox....",
 "xxox...",
 "..xoox.",
 "..xoox.",
 "...xx..",
 ".......",
 "......."}
 

Returns: 5



8)
{"...................",
 "...................",
 "...o..........o....",
 "................x..",
 "...............x...",
 "...................",
 "...................",
 "...................",
 "...................",
 "...................",
 "...................",
 "...................",
 "...................",
 "...................",
 "................o..",
 "..x................",
 "...............x...",
 "...................",
 "..................."}


Returns: 0



// END CUT HERE
import java.util.*;
public class FoxAndGo {
    public int maxKill(String[] board) {
        int res;
        return res;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        try {
            eq(0,(new FoxAndGo()).maxKill(new String[] {".....",
                "..x..",
                ".xox.",
                ".....",
                "....."}
               ),1);
            eq(1,(new FoxAndGo()).maxKill(new String[] {"ooooo",
                "xxxxo",
                "xxxx.",
                "xxxx.",
                "ooooo"}
               ),6);
            eq(2,(new FoxAndGo()).maxKill(new String[] {".xoxo",
                "ooxox",
                "oooxx",
                "xoxox",
                "oxoox"}
               ),13);
            eq(3,(new FoxAndGo()).maxKill(new String[] {".......",
                ".......",
                ".......",
                "xxxx...",
                "ooox...",
                "ooox...",
                "ooox..."}
               ),9);
            eq(4,(new FoxAndGo()).maxKill(new String[] {".......",
                ".xxxxx.",
                ".xooox.",
                ".xo.ox.",
                ".xooox.",
                ".xxxxx.",
                "......."}
               ),8);
            eq(5,(new FoxAndGo()).maxKill(new String[] {"o.xox.o",
                "..xox..",
                "xxxoxxx",
                "ooo.ooo",
                "xxxoxxx",
                "..xox..",
                "o.xox.o"}
               ),12);
            eq(6,(new FoxAndGo()).maxKill(new String[] {".......",
                "..xx...",
                ".xooox.",
                ".oxxox.",
                ".oxxxo.",
                "...oo..",
                "......."}),4);
            eq(7,(new FoxAndGo()).maxKill(new String[] {".ox....",
                "xxox...",
                "..xoox.",
                "..xoox.",
                "...xx..",
                ".......",
                "......."}
                ),5);
            eq(8,(new FoxAndGo()).maxKill(new String[] {"...................",
                "...................",
                "...o..........o....",
                "................x..",
                "...............x...",
                "...................",
                "...................",
                "...................",
                "...................",
                "...................",
                "...................",
                "...................",
                "...................",
                "...................",
                "................o..",
                "..x................",
                "...............x...",
                "...................",
                "..................."}
               ),0);
        } catch( Exception exx) {
            System.err.println(exx);
            exx.printStackTrace(System.err);
        }
    }

// END CUT HERE
}
