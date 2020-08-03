// BEGIN CUT HERE
// PROBLEM STATEMENT
// A sequence of integers a[0], a[1], ..., a[N-1], where N >= 3, is called an arithmetic progression if the difference between any two successive terms in the sequence is a constant. More precisely, it is an arithmetic progression if a[i] - a[i-1] = a[i+1] - a[i] for every integer i such that 0 < i < N-1.  


Sasha and Pasha are students sharing the same room. Once, when Pasha had left the room, Sasha was in a good mood. So he took a piece of chalk and wrote an arithmetic progression on the blackboard. The progression consisted of at least 4 elements, all of which were positive integers. Then Sasha went to class, and Pasha came back.


Pasha is a very nice person, but there's one problem with him -- he's frightened of even numbers! So, when he returned, he decided to make all the numbers on the board odd. He did this by repeatedly finding an arbitrary even number X, erasing it, and writing X/2 in its place. He continued to perform this step until no even numbers remained.


Your task is to help Sasha restore the initial progression. You will be given a int[] seq, where the i-th element is the i-th number in the sequence written on the blackboard after Pasha's actions. Return an int[] whose i-th element is the i-th number in a sequence that Sasha could have originally written on the blackboard. The constraints will ensure that at least one such sequence exists. If there are several such sequences, choose the one among them whose int[] representation is lexicographically smallest.

DEFINITION
Class:AfraidOfEven
Method:restoreProgression
Parameters:int[]
Returns:int[]
Method signature:int[] restoreProgression(int[] seq)


NOTES
-The lexicographically smaller of two different int[]s containing the same number of elements is the one with a smaller number at the first position where they differ.
-It is guaranteed that all elements of the resulting int[] will fit into a 32-bit signed integer data type.


CONSTRAINTS
-seq will contain between 4 and 50 elements, inclusive.
-Each element of seq will be between 1 and 1000, inclusive.
-Each element of seq will be odd.
-There will exist at least one arithmetic progression from which Pasha would produce exactly the sequence described by seq.


EXAMPLES

0)
{1, 1, 3, 1, 5}

Returns: {1, 2, 3, 4, 5 }

If the progression written by Pasha was {1, 2, 3, 4, 5}, then Sasha would divide 2 by 2 once and 4 by 2 twice to produce exactly {1, 1, 3, 1, 5}. Note that Pasha could have written other progressions, e.g., {2, 4, 6, 8, 10}, but {1, 2, 3, 4, 5} has the lexicographically smallest int[] representation.

1)
{9, 7, 5, 3, 1}

Returns: {9, 7, 5, 3, 1 }

It is possible that all terms in the original progression were odd. In this case Pasha wouldn't perform any replacements.


Note that an arithmetic progression doesn't have to be an increasing sequence.

2)
{999, 999, 999, 999}

Returns: {999, 999, 999, 999 }

A sequence where all terms are the same is also an arithmetic progression.

3)
{7, 47, 5, 113, 73, 179, 53}

Returns: {14, 47, 80, 113, 146, 179, 212 }



4)
{749, 999, 125, 1}

Returns: {1498, 999, 500, 1 }

Some elements of the original progression could be greater than 1000.


// END CUT HERE
import java.util.*;
public class AfraidOfEven {
    public int[] restoreProgression(int[] seq) {
       
	int max =0;
	int cnt =0;

	for (int i = 0;i<seq.length;i++){
		if (seq[i]>max) {
			max= seq[i];
			cnt =i;
		}
	}

	int sa;

	if (cnt>1) sa=(seq[cnt]-seq[cnt-2])/2;
	else sa=(seq[cnt+2]-seq[cnt])/2;

	for(int i=0;i<seq.length;i++){
                     seq[i]=seq[cnt]+(i-cnt)*sa;
         }        
        
        return seq;
    }


// BEGIN CUT HERE
    public static void main(String[] args) {
        try {
            eq(0,(new AfraidOfEven()).restoreProgression(new int[] {1, 1, 3, 1, 5}),new int[] {1, 2, 3, 4, 5 });
            eq(1,(new AfraidOfEven()).restoreProgression(new int[] {9, 7, 5, 3, 1}),new int[] {9, 7, 5, 3, 1 });
            eq(2,(new AfraidOfEven()).restoreProgression(new int[] {999, 999, 999, 999}),new int[] {999, 999, 999, 999 });
            eq(3,(new AfraidOfEven()).restoreProgression(new int[] {7, 47, 5, 113, 73, 179, 53}),new int[] {14, 47, 80, 113, 146, 179, 212 });
            eq(4,(new AfraidOfEven()).restoreProgression(new int[] {749, 999, 125, 1}),new int[] {1498, 999, 500, 1 });
        } catch( Exception exx) {
            System.err.println(exx);
            exx.printStackTrace(System.err);
        }
    }

// END CUT HERE
}
