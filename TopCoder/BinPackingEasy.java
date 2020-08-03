// BEGIN CUT HERE
// PROBLEM STATEMENT
// Fox Ciel has some items. The weight of the i-th (0-based) item is item[i]. She wants to put all items into bins.


The capacity of each bin is 300. She can put an arbitrary number of items into a single bin, but the total weight of items in a bin must be less than or equal to 300.


You are given the int[] item. It is known that the weight of each item is between 101 and 300, inclusive. Return the minimal number of bins required to store all items.

DEFINITION
Class:BinPackingEasy
Method:minBins
Parameters:int[]
Returns:int
Method signature:int minBins(int[] item)


CONSTRAINTS
-item will contain between 1 and 50 elements, inclusive.
-Each element of item will be between 101 and 300, inclusive.


EXAMPLES

0)
{150, 150, 150, 150, 150}

Returns: 3

You have five items and each bin can hold at most two of them. You need at least three bins.

1)
{130, 140, 150, 160}

Returns: 2

For example, you can distribute the items in the following way:

Bin 1: 130, 150
Bin 2: 140, 160



2)
{101, 101, 101, 101, 101, 101, 101, 101, 101}

Returns: 5



3)
{101, 200, 101, 101, 101, 101, 200, 101, 200}

Returns: 6



4)
{123, 145, 167, 213, 245, 267, 289, 132, 154, 176, 198}

Returns: 8



// END CUT HERE
import java.util.*;
public class BinPackingEasy {
    public int minBins(int[] item) {
        
    	int res=0;
    	
    	int[] bot = new int[50];
    	
    	Arrays.sort(item);
    	
    	for (int i= item.length-1;i>=0;i--){
    		int j =0;
    		
    		while(bot[j]+item[i] >300) j++;
    		
    		bot[j] += item[i];
    		if (j>= res) res++;
    		
    	}
    		
    		
    		return res;
    	
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        try {
            eq(0,(new BinPackingEasy()).minBins(new int[] {150, 150, 150, 150, 150}),3);
            eq(1,(new BinPackingEasy()).minBins(new int[] {130, 140, 150, 160}),2);
            eq(2,(new BinPackingEasy()).minBins(new int[] {101, 101, 101, 101, 101, 101, 101, 101, 101}),5);
            eq(3,(new BinPackingEasy()).minBins(new int[] {101, 200, 101, 101, 101, 101, 200, 101, 200}),6);
            eq(4,(new BinPackingEasy()).minBins(new int[] {123, 145, 167, 213, 245, 267, 289, 132, 154, 176, 198}),8);
        } catch( Exception exx) {
            System.err.println(exx);
            exx.printStackTrace(System.err);
        }
    }

// END CUT HERE
}
