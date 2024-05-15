import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
    	int n = in.nextInt();
    	String[] arr = new String[n+1];
    	for(int i=1; i<=n; i++) {
    		arr[i] = String.valueOf(i);
    	}
    	for(int i=1; i<=n; i++) {
    		int count = 0;
    		for(int j=0; j<arr[i].length(); j++) {
    			if(arr[i].charAt(j) =='3' || arr[i].charAt(j) == '6' || arr[i].charAt(j) == '9') {
    				count += 1;
    			}
    		}
    		if(count != 0) {
    			while(count -- != 0) {
    				System.out.print("-");
    			}
    		}
    		else {
    			System.out.print(arr[i]);
    		}
			System.out.print(" ");
    	}
    }
}
