import java.util.*;
public class AlienAndGame {
    public int getNumber(String[] board) {
        int res=1;
    	
    	int n = board.length;
    	int m= board[0].length();
    	
    	for (int i=0;i<n;i++){
    		for (int j=0;j<m;j++){
    			for (int k =1;i+k<=n&&j+k<= m;k++){
    				boolean flg = true;
    				
    				for ( int p =0;p< k && flg; p++){
    					for ( int q =0;q <k-1 && flg ; q++){
    						if (i+p>=n)
    						continue;
    						if (j+q>=m)
    						continue;
    						
    						flg = board[i+p].charAt(j+q)== board[i+p].charAt(j+q+1);
    						
    					}
    					if (flg) res = Math.max(res,k);
    				}
    			}
    		}
    	}
        return res*res;
    }

}


// Powered by FileEdit
// Powered by CodeProcessor
