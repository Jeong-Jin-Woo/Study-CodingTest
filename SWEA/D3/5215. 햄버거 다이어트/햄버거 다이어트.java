import java.util.*;

public class Solution {
	static int N, L;
	static int[] score, cal;
	static boolean[] visit;
	static int answer = 0;
	static void dfs(int start, int sum, int happy) {
		if(sum > L) {
			return;
		}
		answer = Math.max(answer, happy);
		for(int i=start; i<N; i++) {
			if(!visit[i]) {
				visit[i] = true;
				dfs(i, sum + cal[i],  happy + score[i]);
				visit[i] = false;
			}
		}
	}
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        int cnt = 0;
        while(cnt++ != T) {
        	answer = 0;
	        N = in.nextInt();
	        L = in.nextInt();
	        score = new int[N];
	        cal = new int[N];
	        visit = new boolean[N];
	        for(int i=0; i<N; i++) {
	        	score[i] = in.nextInt();
	        	cal[i] = in.nextInt();
	        }
	        dfs(0, 0, 0);
	        System.out.println("#"+cnt + " " +answer);
        }
    }
}
