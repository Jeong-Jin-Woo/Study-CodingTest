import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int test=1; test<=T; test++) {
        	String str = in.next();
        	boolean chk = true;
        	int mid = str.length()/2;
        	for(int i=0; i<str.length()/2; i++) {
        		if(str.charAt(i) != str.charAt(str.length()-i-1)) {
        			chk = false;
        		}
        	}
        	for(int i=0; i<mid/2; i++) {
        		if(str.charAt(i) != str.charAt(mid-i-1)) {
        			chk = false;
        		}
        	}
        	System.out.println("#" + test + " " +(chk ? "YES" : "NO"));
        }
    }
}
