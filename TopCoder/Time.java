import java.util.*;
public class Time {
    public String whatTime(int seconds) {
        int hours = seconds/3600;
	seconds = seconds%3600;
	int mins = seconds/60;
	seconds = seconds%60;
        return hours+":"+mins+":"+seconds;
    }

}


// Powered by FileEdit
// Powered by CodeProcessor
