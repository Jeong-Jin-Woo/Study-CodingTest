import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        int dx[] = {0,1,1};
        int dy[] = {0,1,-1};
        for(int test=1; test<=T; test++){
        	int n = in.nextInt();
        	int m = in.nextInt();
        	int[][] map = new int[n+m][n+m];
        	int[][] dp = new int[n][n];
        	for(int i=0; i<n; i++) {
        		for(int j=0; j<n; j++) {
        			map[i][j] = in.nextInt();
        		}
        	}
        	for(int i=0; i<n; i++) {
        		for(int j=0; j<n; j++) {
        			for(int k=0; k<m; k++) {
        				for(int l=0; l<m; l++) {
        					dp[i][j] += map[i+l][j+k];
        				}
        			}
        		}
        	}
        	int max = 0;
        	for(int i=0; i<n; i++) {
        		for(int j=0; j<n; j++) {
        			max = Math.max(max, dp[i][j]);
        		}
        	}
        	System.out.println("#" + test+ " " + max);
    	}
    }
}
