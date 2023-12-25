import java.util.*;
public class Main{
	static boolean visit[];
	static void dfs(int n, int m, int[] arr, int[] set, int count) {
		if(count == m) {
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<m; i++) {
				sb.append(set[i] + " ");
			}
			sb.append("\n");
			System.out.print(sb);
			return;
		}
		int before = 0;
		for(int i=0; i<n; i++) {
			if(!visit[i] && before != arr[i]) {
				visit[i] = true;
				set[count] = arr[i];
				before = arr[i];
				dfs(n, m, arr, set, count+1);
				visit[i] = false;
			}
		}
	}
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int[] arr = new int[n];
		int[] set = new int[n];
		visit = new boolean[n];
		for(int i=0; i<n; i++) {
			arr[i] = in.nextInt();
		}
		Arrays.sort(arr);
		dfs(n, m, arr, set, 0);
	}
}
