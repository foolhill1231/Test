// BEGIN CUT HERE
// PROBLEM STATEMENT
// A kingdom has n citizens. Each one has some amount of money, a number of dollars denoted by a non-negative integer.

Citizens are numbered from 0 to n-1. Some citizens have friends. Their friendship network is described by a String[] called isFriend, such that if isFriend[i][j] == 'Y', the citizens numbered i and j are friends, and if isFriend[i][j] == 'N', these citizens are not friends.

The king decrees the following:

Each citizen's amount of money must be within d dollars of the amount of money belonging to any of his friends. In other words, a citizen with x dollars must not have any friends with less than x-d dollars or more than x+d dollars.

Given the number of citizens and their friendship network, what is the greatest possible money difference between any two people (not necessarily friends) in this kingdom? If there is a finite answer, return it. Otherwise, return -1.

DEFINITION
Class:Egalitarianism
Method:maxDifference
Parameters:String[], int
Returns:int
Method signature:int maxDifference(String[] isFriend, int d)


CONSTRAINTS
-n will be between 2 and 50, inclusive.
-d will be between 0 and 1,000, inclusive.
-isFriend will contain exactly n elements.
-Each element of isFriend will contain exactly n characters, each of which is either 'Y' or 'N'.
-For any i, isFriend[i][i] = 'N'.
-For any i and j, isFriend[i][j] = isFriend[j][i].


EXAMPLES

0)
{"NYN",
 "YNY",
 "NYN"}
10

Returns: 20

The kingdom has three citizens. Citizens 0 and 1 are friends. Also, citizens 1 and 2 are friends. The greatest possible money difference between any two citizens is $20, as in the following configuration: citizen 0 has $100; citizen 1 has $110; citizen 2 has $120.

1)
{"NN",
 "NN"}
1

Returns: -1

Since citizens 0 and 1 are not friends, there are no constraints between them.

2)
{"NNYNNN",
 "NNYNNN",
 "YYNYNN",
 "NNYNYY",
 "NNNYNN",
 "NNNYNN"}
1000

Returns: 3000



3)
{"NNYN",
 "NNNY",
 "YNNN",
 "NYNN"}
584

Returns: -1



4)
{"NYNYYYN",
 "YNNYYYN",
 "NNNNYNN",
 "YYNNYYN",
 "YYYYNNN",
 "YYNYNNY",
 "NNNNNYN"}
5

Returns: 20



5)
{"NYYNNNNYYYYNNNN",
 "YNNNYNNNNNNYYNN",
 "YNNYNYNNNNYNNNN",
 "NNYNNYNNNNNNNNN",
 "NYNNNNYNNYNNNNN",
 "NNYYNNYNNYNNNYN",
 "NNNNYYNNYNNNNNN",
 "YNNNNNNNNNYNNNN",
 "YNNNNNYNNNNNYNN",
 "YNNNYYNNNNNNNNY",
 "YNYNNNNYNNNNNNN",
 "NYNNNNNNNNNNNNY",
 "NYNNNNNNYNNNNYN",
 "NNNNNYNNNNNNYNN",
 "NNNNNNNNNYNYNNN"}

747

Returns: 2988



6)
{"NY",
 "YN"}
0

Returns: 0



// END CUT HERE
import java.util.*;
public class Egalitarianism {
    public int maxDifference(String[] isFriend, int d) {
	boolean[][] fs = new boolean[isFriend.length][isFriend[0].length()];
	for(int i=0;i<isFriend.length;i++){
		for(int j =0;j<isFriend[i].length();j++){

			if(isFriend[i].charAt(j)=='Y') fs[i][j]=true;
			else fs[i][j] = false;
		}
	}

	int max =0;
	for(int i=0;i<fs.length;i++){
		Map<Integer,Integer> se = new HashMap<Integer,Integer>();
		Queue<Integer> q = new LinkedList<Integer>();
		se.put(i,0);
		q.add(i);
		while(q.size()>0){

			int cur = q.poll();
			int de = se.get(cur);
			max = Math.max(max,de);

			for(int j =0;j<fs.length;j++){
				if(fs[cur][j] &&!se.containsKey(j)){
					q.add(j);
					se.put(j,de+1);
				}
			}
		}
		if (se.size()<fs.length) return -1;
	}
	if (max ==0) return -1;
	return max*d;
        
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        try {
            eq(0,(new Egalitarianism()).maxDifference(new String[] {"NYN",
                "YNY",
                "NYN"}, 10),20);
            eq(1,(new Egalitarianism()).maxDifference(new String[] {"NN",
                "NN"}, 1),-1);
            eq(2,(new Egalitarianism()).maxDifference(new String[] {"NNYNNN",
                "NNYNNN",
                "YYNYNN",
                "NNYNYY",
                "NNNYNN",
                "NNNYNN"}, 1000),3000);
            eq(3,(new Egalitarianism()).maxDifference(new String[] {"NNYN",
                "NNNY",
                "YNNN",
                "NYNN"}, 584),-1);
            eq(4,(new Egalitarianism()).maxDifference(new String[] {"NYNYYYN",
                "YNNYYYN",
                "NNNNYNN",
                "YYNNYYN",
                "YYYYNNN",
                "YYNYNNY",
                "NNNNNYN"}, 5),20);
            eq(5,(new Egalitarianism()).maxDifference(new String[] {"NYYNNNNYYYYNNNN",
                "YNNNYNNNNNNYYNN",
                "YNNYNYNNNNYNNNN",
                "NNYNNYNNNNNNNNN",
                "NYNNNNYNNYNNNNN",
                "NNYYNNYNNYNNNYN",
                "NNNNYYNNYNNNNNN",
                "YNNNNNNNNNYNNNN",
                "YNNNNNYNNNNNYNN",
                "YNNNYYNNNNNNNNY",
                "YNYNNNNYNNNNNNN",
                "NYNNNNNNNNNNNNY",
                "NYNNNNNNYNNNNYN",
                "NNNNNYNNNNNNYNN",
                "NNNNNNNNNYNYNNN"}
               , 747),2988);
            eq(6,(new Egalitarianism()).maxDifference(new String[] {"NY",
                "YN"}, 0),0);
        } catch( Exception exx) {
            System.err.println(exx);
            exx.printStackTrace(System.err);
        }
    }

// END CUT HERE
}
