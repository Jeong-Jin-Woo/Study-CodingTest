import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = 100;
        int map[][] = new int[n+1][n+1];
        for(int test=1; test<=10; test++) {
        	int t = in.nextInt();
        	int right = 0; // 오른쪽 사선 대각선
        	int left = 0; // 왼쪽 사선 대각선
        	for(int i=0; i<n; i++) {
        		for(int j=0; j<n; j++) {
        			map[i][j] = in.nextInt();
        			if(i == j) {
        				right += map[i][j];
        			}
        			if(n-i-1 == j) {
        				left += map[i][j];
        			}
        		}
        	}
        	int answer = 0;
        	
        	int dp[][] = new int[n+1][n+1];
        	for(int i=0; i<n; i++)
        		dp[i][0] = map[i][0];
        	for(int i=0; i<n+1; i++) {
        		for(int j=1; j<n+1; j++) {
        			dp[i][j] = map[i][j] + dp[i][j-1];
        		}
        	}
        	//세로
        	for(int i=0; i<n; i++) {
        		answer = Math.max(answer, dp[i][n]);
        	}
        	
        	//가로
        	dp = new int[n+1][n+1];
        	for(int i=0; i<n; i++)
        		dp[0][i] = map[0][i];
        	for(int i=1; i<n+1; i++) {
        		for(int j=0; j<n+1; j++) {
        			dp[i][j] = map[i][j] + dp[i-1][j];
        		}
        	}
        	for(int i=0; i<n; i++) {
        		answer = Math.max(answer, dp[n][i]);
        	}
        	answer = Math.max(answer, Math.max(right, left));
        	System.out.println("#"+t + " " + answer);
        	
        }
    }
}
