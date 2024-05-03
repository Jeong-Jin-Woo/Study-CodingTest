import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int test=1; test<=T; test++) {
        	int answer = (int)1e9;
        	int n = in.nextInt();
        	int k = in.nextInt();
        	int[] arr = new int[n];
        	for(int i=0; i<n; i++) {
        		arr[i] = in.nextInt();
        	}
        	Arrays.sort(arr);
        	for(int i=0; i<n-k+1; i++) {
        		answer = Math.min(answer, arr[i+k-1]-arr[i]);
        	}
	        System.out.println("#"+test + " " +answer);
        }
    }
}
