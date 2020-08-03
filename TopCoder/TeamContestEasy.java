// BEGIN CUT HERE
// PROBLEM STATEMENT
// Your university is holding a programming competition and your team is going to compete.

There are 3*N students in the university. They are numbered from 0 to 3*N-1. Each student has a certain strength which is a positive number that characterizes his/her programming skills. You are given a int[] strength. The strength of student i is equal to strength[i].

Your team will consist of students 0, 1 and 2. Other 3*N-3 students will form N-1 more teams so that each team has exactly 3 members. The exact composition of other teams is not known yet. Each team has a strength that is calculated as follows: if it consists of members with strengths X, Y and Z, then the team's strength is equal to X + Y + Z - min{X, Y, Z}, i.e., the strength of a team is the total strength of its two strongest members.

You are interested how your team will rank by strength among the other teams. Formally, the rank of your team is defined as 1 + (the number of other teams that have a strictly greater strength than the strength of your team).

Return the maximum possible rank that your team may have after all students split into teams.


DEFINITION
Class:TeamContestEasy
Method:worstRank
Parameters:int[]
Returns:int
Method signature:int worstRank(int[] strength)


CONSTRAINTS
-strength will contain between 3 and 48 elements, inclusive.
-The number of elements in strength will be divisible by 3.
-Each element of strength will be between 1 and 1,000,000, inclusive.


EXAMPLES

0)
{5, 7, 3, 5, 7, 3, 5, 7, 3}

Returns: 2

The strength of your team is 5 + 7 + 3 - min{5, 7, 3} = 12. It is possible that one of the other teams will be stronger than your team. For example, if it consists of students with strengths 5, 7 and 7, then its strength will be 14. However, it is not possible that both other teams will be stronger than your team.

1)
{5, 7, 3}

Returns: 1

Just your team. No rivals.

2)
{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}

Returns: 1

All teams (including yours) will have the same strength: 2.


3)
{2,2,1,1,3,1,3,2,1,3,1,2,1,2,1}


Returns: 4



4)
{45,72,10,42,67,51,33,21,8,51,17,72}


Returns: 3



5)
{570466,958327,816467,17,403,953808,734850,5824,917784,921731,161921,1734,823437,3218,81,932681,2704,981643,1232,475,873323,6558,45660,1813,4714,224,
32301,28081,6728,17055,561,15146,842613,5559,1860,783,989,2811,20664,112531,1933,866794,805528,53821,2465,137385,39,2007}

Returns: 6



6)
{610297,849870,523999,6557,976530,731458,7404,795100,147040,110947,159692,40785,4949,2903,1688,37278,620703,28156,16823,1159,12132,971379,5916,1159,988589,
12215,133,1490,911360,920059,544070,40249,514852,852,745070,1105,715897,714696,589133,698317,5683,631612,16453,101000,764881,101,2053,754661}

Returns: 10



// END CUT HERE
import java.util.*;
public class TeamContestEasy {
	public int worstRank(int[] n) {
		int[] t = new int[(n.length)/3];

		for (int i=0;i<t.length;i++){
			int a = n[i];
			int b = n[i+1];
			int c = n[i+2];
			int min= 0;
			int sum = a+b+c;
			if (min>a) min = a;
			if (min>b) min = b;
			if (min>c) min = c;
			t[i] = sum-min;

		}

		int cnt =0;
		for (int i =1;i<t.length;i++){
			if (t[0]<t[i]) cnt ++;
		}
		if (cnt==0) cnt =1;
	return cnt;

	}
	public static void main(String[] args) {
		TeamContestEasy temp = new TeamContestEasy();

		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		String[] ss = s.split(",");
		int[] strength = new int[ss.length];

		for (int i =0;i<ss.length;i++){
			strength[i]= Integer.parseInt(ss[i]);
		}
		System.out.println(temp.worstRank(strength));
	}
}
