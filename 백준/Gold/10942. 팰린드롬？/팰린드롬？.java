import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int n;

	public static void main(String args[]) throws IOException {
        n = Integer.parseInt(br.readLine());
		int arr[] = new int[n + 1];
		boolean dp[][] = new boolean[n + 1][n + 1];
		
        StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i <= n; i++) {
			dp[i][i] = true;
		}
		
		// 연속된 숫자가 같으면 true
		for(int i=1; i<n; i++) {
			if(arr[i] == arr[i+1])
				dp[i][i+1] = true;
		}
		for (int i = n - 1; i >= 1; i--) {
			for (int j = i + 2; j <= n; j++) {
				if (arr[i] == arr[j] && dp[i + 1][j - 1]) {
					dp[i][j] = true;
				}
			}
		}
		StringBuilder sb = new StringBuilder();

		int m = Integer.parseInt(br.readLine());
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (dp[a][b])
				sb.append(1 + "\n");
			else
				sb.append(0 + "\n");
		}
		System.out.println(sb);
		
//		for(int i=1; i<=n; i++) {
//			for(int j=1; j<=n; j++) {
//				System.out.print(dp[i][j] + " ");
//			}System.out.println();
//		}
	}
}
