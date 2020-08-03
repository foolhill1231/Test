// BEGIN CUT HERE
// PROBLEM STATEMENT
// The Primal Grez are ferocious creatures. They constantly fight each other. When a Grez wins a battle against another Grez, the winner captures the loser's essence, thus becoming stronger. More formally:
The power level of each Grez is a positive integer.
A Grez can only defeat creatures that have a strictly smaller power level.
When a Grez of power level X defeats a Grez of power level Y, the first Grez's power level is increased to X + Y/2. Note that Y/2 represents integer division, i.e., the fractional part is discarded. For example, for Y=3 we have Y/2 = 1.

Your goal is to help a Grez that currently has power level equal to int initialLevel battle against a set of other Grez. For each i, Grez number i (0-based index) has a power level equal to grezPower[i]. Your Grez can challenge the other creatures in any order.

You are given the int initialLevel and the int[] grezPower. Return the maximum number of creatures your Grez can defeat, one after another.


DEFINITION
Class:PrimalUnlicensedCreatures
Method:maxWins
Parameters:int, int[]
Returns:int
Method signature:int maxWins(int initialLevel, int[] grezPower)


CONSTRAINTS
-initialLevel will be between 1 and 1000, inclusive.
-grezPower will contain between 1 and 50 elements, inclusive.
-Each element of grezPower will be between 1 and 1000, inclusive.


EXAMPLES

0)
31
{10, 20, 30}

Returns: 3

It is possible to defeat all the available opponents. For example:
Defeat the creature with power level 30. Your creature's power level becomes 31 + 15 = 46.
Defeat the creature with power level 10. Your creature's power level becomes 46 + 5 = 51.
Defeat the creature with power level 20. Your creature's power level becomes 51 + 10 = 61.




1)
20
{24, 5, 6, 38}

Returns: 3

It is best to defeat creatures 1 and 2 before facing creature 0. Your creature's power level will be 25 when facing
creature 0. It is not possible to defeat creature 3.

2)
20
{3, 3, 3, 3, 3, 1, 25 }

Returns: 6

It is possible to defeat the 6 weakest creatures. After that your creature's power level will be 25, which is not strong enough to defeat another level 25 creature.

3)
4
{3, 13, 6, 4, 9}

Returns: 5



4)
7
{7, 8, 9, 10}

Returns: 0

All the available opponents are too strong for your creature to defeat.

// END CUT HERE
import java.util.*;
public class PrimalUnlicensedCreatures {
    public int maxWins(int initialLevel, int[] grezPower) {
        int res=0;
	boolean[] flg = new boolean[grezPower.length];

		while(true){
			boolean f = false;
			
			for (int i =0;i<grezPower.length;i++){
				if (!(flg[i])&& initialLevel > grezPower[i]){
					initialLevel += grezPower[i]/2;
					flg[i] = true;
					res ++;
					f = true;
				}
			}
			if (f){
				f = false;
			}else{break;}
			
		}
        return res;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        try {
            eq(0,(new PrimalUnlicensedCreatures()).maxWins(31, new int[] {10, 20, 30}),3);
            eq(1,(new PrimalUnlicensedCreatures()).maxWins(20, new int[] {24, 5, 6, 38}),3);
            eq(2,(new PrimalUnlicensedCreatures()).maxWins(20, new int[] {3, 3, 3, 3, 3, 1, 25 }),6);
            eq(3,(new PrimalUnlicensedCreatures()).maxWins(4, new int[] {3, 13, 6, 4, 9}),5);
            eq(4,(new PrimalUnlicensedCreatures()).maxWins(7, new int[] {7, 8, 9, 10}),0);
        } catch( Exception exx) {
            System.err.println(exx);
            exx.printStackTrace(System.err);
        }
    }

// END CUT HERE
}
