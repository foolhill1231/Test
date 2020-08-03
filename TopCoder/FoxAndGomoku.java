// BEGIN CUT HERE
// PROBLEM STATEMENT
// Fox Ciel is going to play Gomoku with her friend Fox Jiro.
Ciel plays better, so before they start she allowed Jiro to put some of his pieces on the board.


You are given a String[] board that represents a square board.
The character board[i][j] represents the cell with coordinates (i,j).
Each of those characters is either '.' (representing an empty cell) or 'o' (representing a cell with Jiro's piece).


Of course, Ciel does not want Jiro to win the game before she has a chance to play.
Thus she now has to check the board and determine whether there are five consecutive tokens somewhere on the board.


Determine whether there are 5 consecutive cells (horizontally, vertically, or diagonally) that contain Jiro's tokens.
Return "found" (quotes for clarity) if there are five such cells anywhere on the board.
Otherwise, return "not found".

DEFINITION
Class:FoxAndGomoku
Method:win
Parameters:String[]
Returns:String
Method signature:String win(String[] board)


CONSTRAINTS
-n will be between 5 and 15, inclusive.
-board will contain exactly n elements.
-Each element in board will contain exactly n characters.
-Each character in board will be 'o' or '.'.


EXAMPLES

0)
{"....o.",
 "...o..",
 "..o...",
 ".o....",
 "o.....",
 "......"}

Returns: "found"

There is five continue pieces diagonally.

1)
{"oooo.",
 ".oooo",
 "oooo.",
 ".oooo",
 "....."}
 

Returns: "not found"

There is no five-in-a-row on this board.

2)
{"oooo.",
 ".oooo",
 "oooo.",
 ".oooo",
 "....o"}
 

Returns: "found"

Five consecutive tokens can be found in the following cells: (0,0), (1,1), (2,2), (3,3), and (4,4).

3)
{"o.....",
 ".o....",
 "..o...",
 "...o..",
 "....o.",
 "......"}

Returns: "found"



4)
{"o....",
 "o.o..",
 "o.o.o",
 "o.o..",
 "o...."}

Returns: "found"



5)
{"..........",
 "..........",
 "..oooooo..",
 "..o.......",
 "..o.......",
 "..oooooo..",
 ".......o..",
 ".......o..",
 "..oooooo..",
 ".........."}
 


Returns: "found"



6)
{"..........",
 "..........",
 "..oooo.o..",
 "..o.......",
 "..o.......",
 "..o.oooo..",
 ".......o..",
 ".......o..",
 "..oooo.o..",
 ".........."}


Returns: "not found"



7)
{"ooooo",
 "ooooo",
 "ooooo",
 "ooooo",
 "ooooo"}

Returns: "found"



8)
{".....",
 ".....",
 ".....",
 ".....",
 "....."}

Returns: "not found"



// END CUT HERE
import java.util.*;
public class FoxAndGomoku {
    public String win(String[] board) {
       

	for (String str:board)
		for (int i =0;i<str.length()-4;i++)
			if (str.substring(i,i+5).equals("ooooo"))
				return "found";

	for (int i =0;i<board.length;i++)
		for (int j=0;j<board.length-4;j++)
			if (board[i].charAt(j)=='o' && board[i+1].charAt(j)=='o' && board[i+2].charAt(j)=='o' && board[i+3].charAt(j)=='o' && board[i+4].charAt(j) =='o')
		return "found";

	for (int i =0;i<board.length;i++)
		for (int j=0;j<board.length-4;j++)
			if (board[i].charAt(j)=='o' && board[i+1].charAt(j+1)=='o' && board[i+2].charAt(j+2)=='o' && board[i+3].charAt(j+3)=='o' && board[i+4].charAt(j+4) =='o')
		return "found";
	

        for (int i =4;i<board.length;i++)
		for (int j=0;j<board.length-4;j++)
			if (board[i].charAt(j)=='o' && board[i-1].charAt(j)=='o' && board[i-2].charAt(j+2)=='o' && board[i-3].charAt(j+3)=='o' && board[i-4].charAt(j+4) =='o')
		return "found";


        return "not found";
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        try {
            eq(0,(new FoxAndGomoku()).win(new String[] {"....o.",
                "...o..",
                "..o...",
                ".o....",
                "o.....",
                "......"}),"found");
            eq(1,(new FoxAndGomoku()).win(new String[] {"oooo.",
                ".oooo",
                "oooo.",
                ".oooo",
                "....."}
                ),"not found");
            eq(2,(new FoxAndGomoku()).win(new String[] {"oooo.",
                ".oooo",
                "oooo.",
                ".oooo",
                "....o"}
                ),"found");
            eq(3,(new FoxAndGomoku()).win(new String[] {"o.....",
                ".o....",
                "..o...",
                "...o..",
                "....o.",
                "......"}),"found");
            eq(4,(new FoxAndGomoku()).win(new String[] {"o....",
                "o.o..",
                "o.o.o",
                "o.o..",
                "o...."}),"found");
            eq(5,(new FoxAndGomoku()).win(new String[] {"..........",
                "..........",
                "..oooooo..",
                "..o.......",
                "..o.......",
                "..oooooo..",
                ".......o..",
                ".......o..",
                "..oooooo..",
                ".........."}
                
               ),"found");
            eq(6,(new FoxAndGomoku()).win(new String[] {"..........",
                "..........",
                "..oooo.o..",
                "..o.......",
                "..o.......",
                "..o.oooo..",
                ".......o..",
                ".......o..",
                "..oooo.o..",
                ".........."}
               ),"not found");
            eq(7,(new FoxAndGomoku()).win(new String[] {"ooooo",
                "ooooo",
                "ooooo",
                "ooooo",
                "ooooo"}),"found");
            eq(8,(new FoxAndGomoku()).win(new String[] {".....",
                ".....",
                ".....",
                ".....",
                "....."}),"not found");
        } catch( Exception exx) {
            System.err.println(exx);
            exx.printStackTrace(System.err);
        }
    }

// END CUT HERE
}
