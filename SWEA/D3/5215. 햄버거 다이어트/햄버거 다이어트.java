import java.util.*;

public class Solution {
	static int N, L;
	static int[] score, cal;
	static int answer = 0;
	static void dfs(int count, int sum, int happy) {
		if(count == N) {
			answer = Math.max(answer, happy);
			return;
		}
		if(sum+cal[count] <= L) {
			dfs(count + 1, sum + cal[count], happy + score[count]);
		}
		dfs(count + 1, sum, happy);
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
	        for(int i=0; i<N; i++) {
	        	score[i] = in.nextInt();
	        	cal[i] = in.nextInt();
	        }
	        dfs(0, 0, 0);
	        System.out.println("#"+cnt + " " +answer);
        }
    }
}
