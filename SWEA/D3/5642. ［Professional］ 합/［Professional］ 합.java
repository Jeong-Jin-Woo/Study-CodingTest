import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int test = 1; test <= T; test++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int arr[] = new int[n];
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			int dp[] = new int[n];
			int max = -1000;
			dp[0] = arr[0];
			for(int i=1; i<n; i++) {
				if(dp[i-1] < 0) {
					dp[i] = arr[i];
				}
				else {
					dp[i] = dp[i-1] + arr[i];
				}
			}
			for(int i=0; i<n; i++) {
				max = Math.max(max, dp[i]);
			}
			System.out.println("#"+test+ " " + max);
		}
	}
}
