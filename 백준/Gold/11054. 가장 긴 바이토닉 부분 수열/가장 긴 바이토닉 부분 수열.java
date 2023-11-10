import java.util.*;
public class Main{
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] arr = new int[n+1];
		int[] up = new int[n+1];
		int[] down = new int[n+1];
		for(int i=1; i<=n; i++) {
			arr[i] = in.nextInt();
		}
		for(int i=1; i<=n; i++) {
			for(int j=i; j<=n; j++) {
				if(arr[i] < arr[j]) {
					up[j] = Math.max(up[j], up[i] + 1);
				}
			}
		}
		for(int i=n; i>=0; i--) {
			for(int j=i; j>=0; j--) {
				if(arr[i] < arr[j]) {
					down[j] = Math.max(down[j], down[i] + 1);
				}
			}
		}
		int answer = 0;
		for(int i=1; i<=n; i++) {
			answer = Math.max(up[i] + down[i] + 1, answer);
		}
		System.out.println(answer);
	}
}
