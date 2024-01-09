import java.util.*;

class Node {
	public int index;
	public int dist;

	Node(int index, int dist) {
		this.index = index;
		this.dist = dist;
	}
}

public class Main {
	static int n, m, w;
	static final int INF = (int) 1e9;
	static int[] visit;
	static ArrayList<ArrayList<Node>> node = new ArrayList<>();

	static boolean bellman(int start) {
		boolean chk = false;
		Arrays.fill(visit, INF);
		visit[start] = 0;
		for (int i = 1; i < n; i++) {
			chk = false;
			for (int j = 1; j <= n; j++) {
				for(Node now : node.get(j)) {
					if (visit[j] != INF && visit[now.index] > visit[j] + now.dist) {
						visit[now.index] = visit[j] + now.dist;
						chk = true;
					}
				}
			}
			if (!chk) break;
		}
		if(chk) {
			for(int i=1; i<=n; i++) {
				for(Node now : node.get(i)) {
					if(visit[i] != INF && visit[now.index] > visit[i] + now.dist) {
						return true;
					}
				}
			}
		}
		return false;
	}

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		StringBuilder sb = new StringBuilder();
		while (T-- != 0) {
			n = in.nextInt();
			m = in.nextInt();
			w = in.nextInt();
			visit = new int[n + 1];
			for (int i = 0; i <= n; i++) {
				node.add(new ArrayList<>());
			}
			for (int i = 0; i < m; i++) {
				int a = in.nextInt();
				int b = in.nextInt();
				int c = in.nextInt();
				node.get(a).add(new Node(b, c));
				node.get(b).add(new Node(a, c));
			}
			for (int i = 0; i < w; i++) {
				int a = in.nextInt();
				int b = in.nextInt();
				int c = in.nextInt();
				node.get(a).add(new Node(b, -c));
			}
			boolean chk = false;
			for (int i = 1; i <= n; i++) {
				if (bellman(i)) {
					chk = true;
					sb.append("YES\n");
					break;
				}
			}
			if(!chk)
				sb.append("NO\n");
			node.clear();
		}
		System.out.println(sb);
	}
}