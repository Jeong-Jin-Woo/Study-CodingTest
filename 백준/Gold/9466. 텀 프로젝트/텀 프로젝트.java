import java.util.*;
public class Main{
	static int n, answer;
	static boolean visit[], done[];
	static int arr[];
	static void dfs(int now) {
		if(done[now]) return;
		if(visit[now]) {
			answer += 1;
			done[now] = true;
		}
		visit[now] = true;
		dfs(arr[now]);
		done[now] = true;
		visit[now] = false;
	}
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		while(T-- != 0) {
			answer = 0;
			n = in.nextInt();
			arr = new int[n+1];
			visit = new boolean[n+1];
			done = new boolean[n+1];
			for(int i=1; i<=n; i++) {
				arr[i] = in.nextInt();
			}
			for(int i=1; i<=n; i++) {
				if(!done[i]) {
					dfs(i);
				}
			}
//			for(int i=1; i<=n; i++) {
//				if(!visit[i])
//					answer += 1;
//				
//	//			System.out.println(visit[i]);
//			}
			System.out.println(n - answer);
		}
	}
}