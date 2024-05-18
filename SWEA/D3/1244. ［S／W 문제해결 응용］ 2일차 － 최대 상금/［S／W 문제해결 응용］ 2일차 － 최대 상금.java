import java.util.*;
public class Solution {
	static int n, k;
	static char[] arr;
	static int max = 0;
	static void dfs(int count, int sum) {
		if(count == k) {
			String str = "";
			for(int i=0; i<n; i++) {
				str += arr[i];
			}
			max = Math.max(max, Integer.valueOf(str));
			return;
		}
		for(int i=0; i<n; i++) {
			for(int j=i+1; j<n; j++) {
				change(i, j);
				dfs(count + 1, i + 1);
				change(i, j);
			}
		}
	}
	static void change(int before, int after) {
		char v = arr[before];
		arr[before] = arr[after];
		arr[after] = v;
	}
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
    	int T = in.nextInt();
        for(int test=1; test<=T; test++) {
        	String str = in.next();
        	k = in.nextInt();
        	n = str.length();
        	
        	arr = new char[n];
        	max = 0;
        	for(int i=0; i<n; i++) {
        		arr[i] = str.charAt(i);
        	}
        	if(n < k) k = n;
        	dfs(0, 0);
        	
		System.out.println("#"+test + " " + max);
        }
    }
}
