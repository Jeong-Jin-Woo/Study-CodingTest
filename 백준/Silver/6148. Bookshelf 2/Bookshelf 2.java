import java.util.*;
public class Main {
	static int n, size;
	static int arr[];
	static boolean visit[];
	static int answer = (int)1e9;
	static void dfs(int start, int count, int m) {
		if(m == count) {
			int sum = 0;
			for(int i=0; i<n; i++) {
				if(visit[i]) {
					sum += arr[i];
//					System.out.print(arr[i]+ " ");
				}
			}
//			System.out.println();
			if(sum - size >= 0) {
				answer = Math.min(sum - size, answer);
			}
			return;
		}
		for(int i=start; i<n; i++) {
			if(!visit[i]) {
				visit[i] = true;
				dfs(i, count + 1, m);
				visit[i] = false;
			}
		}
	}
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		size = in.nextInt();
		arr = new int[n];
		visit = new boolean[n];
		for(int i=0; i<n; i++) {
			arr[i] = in.nextInt();
		}
		Arrays.sort(arr);
		for(int i=0; i<=n; i++)
			dfs(0, 0 ,i);
		System.out.println(answer);
	}
}
