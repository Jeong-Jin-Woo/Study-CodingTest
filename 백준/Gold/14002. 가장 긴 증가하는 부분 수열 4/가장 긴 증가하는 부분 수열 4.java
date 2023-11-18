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
					dp[j+1] = Math.max(dp[j + 1] , dp[i+1] + 1);
				}
			}
			max = Math.max(dp[i+1], max);
		}
		System.out.println(max+1);
		Stack<Integer> s = new Stack<>();
		for(int i=n, j=max; i>=1; i--) {
			if(j == dp[i]) {
				s.push(arr[i-1]);
				j-=1;
			}
		}
		while(!s.isEmpty()) {
			System.out.print(s.pop() + " ");
		}
	}
}
