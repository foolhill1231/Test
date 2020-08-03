import java.util.*;
public class TheShuttles {
    public int getLeastCost(int[] cnt, int baseCost, int seatCost) {
    	
    	int max=0;
    	
    	for (int i=0;i<cnt.length;i++){
    		max = Math.max(max,cnt[i]);
    	}
    	
    	int n=0;
    	int sum=0;
    	int min=Integer.MAX_VALUE;
    	
    	for (int i=1;i<=max;i++){
    		sum=0;
    		for (int j=0;j<cnt.length;j++){
    			n=cnt[j]/i;
    			if (cnt[j]%i>0) n++;
    			sum += n*(baseCost+seatCost*i);
    		}
    		min=Math.min(min,sum);
    	}
        return min;
    }
    

}


// Powered by FileEdit
// Powered by CodeProcessor
