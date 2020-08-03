import java.util.*;
public class InterestingNumber {
    public String isInteresting(String x) {
    	
    	boolean interesting = true;
    	
    	for (char i = '0' ;i<= '9'; ++i){
    		interesting &= interesting(x,i,i-'0');
    	}
    	return interesting ? "Interesting" : "Not interesting";
    }
	
	private static boolean interesting(String x, char c, int n){
    		int cnt =0;
    		int f = -1;
    		int next = -1;
    		
    		for (int i=x.length();i-- >0;){
    			if (x.charAt(i) == c){
    				cnt++;
    				if (next == -1){
    					next =i;
    				}else{
    					f =i;
    				}
    			}
    		}
		
		if (cnt ==2){
			return (next-f-1) == n;
		}else{
			return cnt ==0;
		}
	}
    	
}

// Powered by FileEdit
// Powered by CodeProcessor
