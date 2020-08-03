import java.util.*;
public class MicrowaveSelling {
    public int mostAttractivePrice(int minPrice, int maxPrice) {
        int res = minPrice;
    	int max = 0;
	    int count, tmp;

    	for(int i=minPrice; i<=maxPrice; i++){
        	count = 0; tmp = i;
		 while(tmp % 10 == 9) {
            		count++;
            		tmp /= 10;
        	}

        	if(max <= count) { max = count; res = i; }
	}

        return res;
    }

}


// Powered by FileEdit
// Powered by CodeProcessor
