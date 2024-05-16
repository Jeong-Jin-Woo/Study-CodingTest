import java.util.*;
public class Solution {
	static int[] map;
	static int n, answer;
	static void dfs(int count) {
		if(count == n) {
			answer += 1;
			return;
		}
		for(int i=0; i<n; i++) {
			map[count] = i;
			if(possible(count)) 
				dfs(count + 1);
		}
	}
	static boolean possible(int x) {
		for(int i=0; i<x; i++) {
			if(map[i] == map[x]) return false;
			if(Math.abs(map[x] - map[i]) == Math.abs(x-i)) return false;
		}
		return true;
	}
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
    	int T = in.nextInt();
        for(int test=1; test<=T; test++) {
        	n = in.nextInt();
        	map = new int[n];
        	answer = 0;
        	dfs(0);
        	System.out.println("#" + test + " " + answer);
        }
    }
}
