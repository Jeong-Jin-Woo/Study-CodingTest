import java.util.*;
public class Main{
	static int n,m;
	static ArrayList<ArrayList<Integer>> node = new ArrayList<>();
	static boolean[] visit;
	static int answer = 0;
	static void dfs(int start) {
		visit[start] = true;
		for(int i=0; i<node.get(start).size(); i++) {
			int e = node.get(start).get(i);
			if(!visit[e]) {
				dfs(e);
			}
		}
	}
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		m = in.nextInt();
		for(int i=0; i<=n; i++) {
			node.add(new ArrayList<Integer>());
		}
		visit = new boolean[n+1];
		if(m == 0) {
			System.out.println(n);
			return;
		}
		for(int i=0; i<m; i++) {
			int a = in.nextInt();
			int b = in.nextInt();
			node.get(a).add(b);
			node.get(b).add(a);
		}
		for(int i=1; i<=n; i++) {
			if(!visit[i]) {
				dfs(i);
				answer += 1;
			}
		}
		System.out.println(answer);
	}
}
