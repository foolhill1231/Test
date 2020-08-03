// BEGIN CUT HERE
// PROBLEM STATEMENT
// Manao is the coach of a soccer team. There are N boys numbered from 0 to N-1 on the team. Each of them has some level of soccer skill. Manao would like to divide the boys into two teams for today's training. The division should satisfy the following conditions:

Each boy is assigned to a team.
The total skill of first team is strictly greater than the total skill of the second team.
For each player P in the first team: if we were to move P into the second team, the total skill of the first team would become strictly smaller than the total skill of the second team.

The total skill of a team is the sum of skills of the boys on that team.

You are given a int[] skill containing N elements. The i-th element in skill is the skill of boy i. Manao is interested in the number of ways to perform such a division into teams. Please compute and return this number.

DEFINITION
Class:YetAnotherTwoTeamsProblem
Method:count
Parameters:int[]
Returns:long
Method signature:long count(int[] skill)


CONSTRAINTS
-skill will contain between 2 and 50 elements, inclusive.
-Each element of skill will be between 1 and 60,000, inclusive.


EXAMPLES

0)
{5, 4, 7, 6}

Returns: 2

The two possible divisions are:

Boys 0 and 2 against boys 1 and 3.
Boys 2 and 3 against boys 0 and 1.


1)
{1, 1, 1, 1, 1}

Returns: 10

Manao can put any three boys on the first team.

2)
{1, 2, 3, 5, 10}

Returns: 5

The possible choices of the first team are:

Boys 0 and 4.
Boys 1 and 4.
Boys 2 and 4.
Boys 3 and 4.
Boys 0, 1, 2 and 3.


3)
{1, 2, 3, 4, 10}

Returns: 0



4)
{999, 999, 999, 1000, 1000, 1001, 999, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000,
 1000, 1000, 1000, 999, 1000, 512, 511, 1001, 1001, 1001, 1001, 1001, 1000}

Returns: 17672631900



// END CUT HERE
import java.util.*;
public class YetAnotherTwoTeamsProblem {
    public long count(int[] skill) {
        long res;
	int sum =0;
	for (int i=0;i<skill.length();i++){
		sum+=skill[i];
	}
	
        return res;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        try {
            eq(0,(new YetAnotherTwoTeamsProblem()).count(new int[] {5, 4, 7, 6}),2L);
            eq(1,(new YetAnotherTwoTeamsProblem()).count(new int[] {1, 1, 1, 1, 1}),10L);
            eq(2,(new YetAnotherTwoTeamsProblem()).count(new int[] {1, 2, 3, 5, 10}),5L);
            eq(3,(new YetAnotherTwoTeamsProblem()).count(new int[] {1, 2, 3, 4, 10}),0L);
            eq(4,(new YetAnotherTwoTeamsProblem()).count(new int[] {999, 999, 999, 1000, 1000, 1001, 999, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000,
                1000, 1000, 1000, 999, 1000, 512, 511, 1001, 1001, 1001, 1001, 1001, 1000}),17672631900L);
        } catch( Exception exx) {
            System.err.println(exx);
            exx.printStackTrace(System.err);
        }
    }

// END CUT HERE
}
