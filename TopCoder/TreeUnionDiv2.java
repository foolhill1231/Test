// BEGIN CUT HERE
// PROBLEM STATEMENT
// This problem statement contains superscripts and/or subscripts. These may not display properly outside the applet.

Manao is studying graph theory and simple cycles in particular. A simple cycle of length L ? 3 in graph G is a sequence of vertices (v0, v1, ..., vL-1) such that all v0, v1, ..., vL-1 are pairwise distinct and for each i=0..L-1, an edge between vi and v(i+1) mod L exists in G.

Manao is interested in graphs formed by connecting two trees. The connection process is as follows. Manao takes two trees composed of N vertices each. The vertices in each tree are labeled from 0 to N - 1. Then, he generates some permutation P of numbers from 0 to N - 1. Finally, the graph is formed by connecting vertex i of the first tree to vertex P[i] of the second tree, for each i from 0 to N - 1. To remove ambiguity, the vertices of the first tree within the graph are referred to as A0, A1, ..., AN-1 and the vertices of the second graph are referred to as B0, B1, ..., BN-1. Manao wants to know the maximum number of simple cycles of length K which the resulting graph could contain if he chooses P optimally.

You are given two String[]s, tree1 and tree2. Both contain N elements, each of them N characters long. The j-th character in the i-th element of tree1 is 'X' if vertices i and j in the first tree are connected and '-' otherwise. tree2 describes the second tree in the same fashion.

Compute and return the maximum possible number of simple cycles of length K in the graph formed by connecting the two given trees as described above. Two simple cycles are equal if one of them can be cyclically shifted, or reversed and cyclically shifted, to coincide with the second. According to this definition, (1, 2, 3, 4), (2, 3, 4, 1) and (3, 2, 1, 4) are all equal.

DEFINITION
Class:TreeUnionDiv2
Method:maximumCycles
Parameters:String[], String[], int
Returns:int
Method signature:int maximumCycles(String[] tree1, String[] tree2, int K)


CONSTRAINTS
-tree1 and tree2 will each contain N elements, where N is between 1 and 9, inclusive.
-Each element of tree1 and tree2 will be N characters long.
-Each element of tree1 and tree2 will consist of 'X' and '-' characters only.
-tree1[i][i] and tree2[i][i] will be '-' for each i between 0 and N-1.
-tree1[i][j] will be equal to tree1[j][i] for each i, j between 0 and N-1.
-tree2[i][j] will be equal to tree2[j][i] for each i, j between 0 and N-1.
-Both tree1 and tree2 will describe a graph which is a tree.
-K will be between 3 and 7, inclusive.


EXAMPLES

0)
{"-X",
 "X-"}

{"-X",
 "X-"}

4

Returns: 1

Manao has two trees with two vertices each. He can connect them in two ways:



Either way, the resulting graph is a single cycle of length 4.

1)
{"-X-",
 "X-X",
 "-X-"}

{"-X-",
 "X-X",
 "-X-"}

5

Returns: 2

These are the possible six graphs which can be obtained by connecting the two given trees:



Except for the two topmost graphs, all the graphs contain two cycles of length 5.

2)
{"-X-",
 "X-X",
 "-X-"}
{"-X-",
 "X-X",
 "-X-"}
3

Returns: 0

These are the same trees as in the previous example. You can see at the pictures that none of the obtained graphs contains a cycle of length 3.

3)
{"-X---",
 "X-XXX",
 "-X---",
 "-X---",
 "-X---"}

{"-X-X-",
 "X-X-X",
 "-X---",
 "X----",
 "-X---"}

6

Returns: 5

When the permutation P is {0, 3, 2, 1, 4}, the resulting graph contains the following five simple cycles of length 6:

A0, A1, A4, B4, B1, B0
A0, A1, A2, B2, B1, B0
A1, A2, B2, B1, B0, B3
A1, A2, B2, B1, B4, A4
A1, A4, B4, B1, B0, B3

The corresponding graph is the following:



4)
{"-XX------",
 "X------X-",
 "X--XX-X--",
 "--X--X---",
 "--X------",
 "---X----X",
 "--X------",
 "-X-------",
 "-----X---"}


{"-X-------",
 "X-X------",
 "-X-XX----",
 "--X---X--",
 "--X--X---",
 "----X--XX",
 "---X-----",
 "-----X---",
 "-----X---"}

7

Returns: 17



// END CUT HERE
import java.util.*;
public class TreeUnionDiv2 {
    public int maximumCycles(String[] tree1, String[] tree2, int K) {
        int res;
        return res;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        try {
            eq(0,(new TreeUnionDiv2()).maximumCycles(new String[] {"-X",
                "X-"}
               , new String[] {"-X",
                "X-"}
               , 4),1);
            eq(1,(new TreeUnionDiv2()).maximumCycles(new String[] {"-X-",
                "X-X",
                "-X-"}
               , new String[] {"-X-",
                "X-X",
                "-X-"}
               , 5),2);
            eq(2,(new TreeUnionDiv2()).maximumCycles(new String[] {"-X-",
                "X-X",
                "-X-"}, new String[] {"-X-",
                "X-X",
                "-X-"}, 3),0);
            eq(3,(new TreeUnionDiv2()).maximumCycles(new String[] {"-X---",
                "X-XXX",
                "-X---",
                "-X---",
                "-X---"}
               , new String[] {"-X-X-",
                "X-X-X",
                "-X---",
                "X----",
                "-X---"}
               , 6),5);
            eq(4,(new TreeUnionDiv2()).maximumCycles(new String[] {"-XX------",
                "X------X-",
                "X--XX-X--",
                "--X--X---",
                "--X------",
                "---X----X",
                "--X------",
                "-X-------",
                "-----X---"}
               
               , new String[] {"-X-------",
                "X-X------",
                "-X-XX----",
                "--X---X--",
                "--X--X---",
                "----X--XX",
                "---X-----",
                "-----X---",
                "-----X---"}
               , 7),17);
        } catch( Exception exx) {
            System.err.println(exx);
            exx.printStackTrace(System.err);
        }
    }

// END CUT HERE
}
