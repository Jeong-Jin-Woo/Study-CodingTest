import java.util.*;
public class Main{
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int dp[] = new int[n+1];
		int arr[] = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = in.nextInt();
		}
		int max = 0;
		for(int i=0; i<n; i++) {
			for(int j=i; j<n; j++) {
				if(arr[i] < arr[j]) {
					dp[j] = Math.max(dp[j], dp[i] + 1);
				}
			}
		}
		for(int i=0; i<n; i++) {
			max = Math.max(max, dp[i]);
		}
		System.out.println(max + 1);
		Stack<Integer> st = new Stack<>();
		for(int i=n-1; i>=0; i--) {
			if(max == dp[i]) {
				st.push(arr[i]);
				max -= 1;
			}
		}
		while(!st.isEmpty()) {
			System.out.print(st.pop() + " ");
		}
	}
}
