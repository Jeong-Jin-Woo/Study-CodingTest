import java.util.*;
public class Solution {
	static char arr[];
	static boolean[] visit;
	static int n;
	static int min = (int)1e9;
	static void dfs() {
		String a = "0";
		String b = "0";
		for(int i=0; i<n; i++) {
			if(visit[i]) {
				a += arr[i];
			}
			else {
				b += arr[i];
			}
		}
		min = Math.min(min, Integer.valueOf(a) + Integer.valueOf(b));
		for(int i=0; i<n; i++) {
			if(!visit[i]) {
				visit[i] = true;
				dfs();
			}
		}
	}
	public static void main(String args[]) throws Exception {
		Scanner in = new Scanner(System.in);
		int T;
		T = in.nextInt();
		for (int test = 1; test <= T; test++) {
			String str = in.next();
			n = str.length();
			arr = new char[n];
			visit = new boolean[n];
			for(int i=0; i<str.length(); i++) {
				arr[i] = str.charAt(i);
			}
			min = (int)1e9;
			dfs();
			System.out.println("#" + test + " " + min);
		}
	}
}
