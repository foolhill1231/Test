// BEGIN CUT HERE
// PROBLEM STATEMENT
// The boys in the yard are going to play soccer. There are N+2 boys, two of which have been chosen as captains. Now they want to divide the other N children into two teams. For convenience, we number the boys who are not captains from 1 to N.

The division into teams works as follows. Initially, the first captain chooses one person for his team. Then, the second captain chooses one boy from those who are left. Then the first captain chooses again, and so on. The process continues until there are no more boys left.

You are given int[]s preference1 and preference2, each containing N elements. preference1[0] is the number of the boy whom the first captain regards to be the best player, preference1[1] is the next best player according to the first captain, and so on. preference2 describes the second captain's assessment in the same fashion. The captains pick the players greedily, i.e., each of them always chooses the boy whom he considers to be the strongest between the children not yet chosen.

Return a String consisting of N characters. Character i in the returned string must be '1' if the boy i+1 will be assigned to the first captain's team and '2' otherwise.

DEFINITION
Class:TeamsSelection
Method:simulate
Parameters:int[], int[]
Returns:String
Method signature:String simulate(int[] preference1, int[] preference2)


CONSTRAINTS
-preference1 will contain N elements, where N is between 2 and 50, inclusive.
-Elements of preference1 will contain each of the numbers from 1 to N exactly once.
-preference2 will contain N elements.
-Elements of preference2 will contain each of the numbers from 1 to N exactly once.


EXAMPLES

0)
{1, 2, 3, 4}
{1, 2, 3, 4}

Returns: "1212"

There are 4 boys to be divided between the two captains. Both captains believe that boy 1 plays best, then come boy 2 and boy 3, and boy 4 plays worst. Thus, the first captain will choose boy 1, the second captain will choose boy 2, since boy 1 is already assigned to a team, then the first captain will choose boy 3 and in the end the second captain will take boy 4.

1)
{3, 2, 1}
{1, 3, 2}

Returns: "211"

The first captain will choose boy 3, the second captain will choose boy 1 and then the first captain will choose boy 2. Note that when there is an odd number of children, the first team ends up one man larger.

2)
{6, 1, 5, 2, 3, 4}
{1, 6, 3, 4, 5, 2}

Returns: "212211"



3)
{8, 7, 1, 2, 4, 5, 6, 3, 9}
{7, 2, 4, 8, 1, 5, 9, 6, 3}

Returns: "121121212"



// END CUT HERE
import java.util.*;
public class TeamsSelection {
    public String simulate(int[] p1, int[] p2) {
        String res="";
	
	int n=p1.length;
	int c =1;
	int[] d = new int[n+1];

	while(c<=n){
		if(c%2==1){
			for(int i=0;i<n;i++){
				if(d[p1[i]]==0){
					d[p1[i]]=1;
					break;
				}
			}
		}else{
			for(int i=0;i<n;i++){
				if(d[p2[i]]==0){
					d[p2[i]]=2;
					break;
				
				}
			}
		}
		c++;
	}
	for(int i=1;i<=n;i++){
		if(d[i]!=0) res+=d[i];
	}
        return res;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        try {
            eq(0,(new TeamsSelection()).simulate(new int[] {1, 2, 3, 4}, new int[] {1, 2, 3, 4}),"1212");
            eq(1,(new TeamsSelection()).simulate(new int[] {3, 2, 1}, new int[] {1, 3, 2}),"211");
            eq(2,(new TeamsSelection()).simulate(new int[] {6, 1, 5, 2, 3, 4}, new int[] {1, 6, 3, 4, 5, 2}),"212211");
            eq(3,(new TeamsSelection()).simulate(new int[] {8, 7, 1, 2, 4, 5, 6, 3, 9}, new int[] {7, 2, 4, 8, 1, 5, 9, 6, 3}),"121121212");
        } catch( Exception exx) {
            System.err.println(exx);
            exx.printStackTrace(System.err);
        }
    }

// END CUT HERE
}
