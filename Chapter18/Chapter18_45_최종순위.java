import java.util.*;
public class Chapter18_45_최종순위 {
	static int n, m;
	static int[] indegree = new int[501];
	static boolean[][] graph = new boolean[501][501];
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		Arrays.fill(indegree, 0);
		for(int i=0; i<501; i++) {
			Arrays.fill(graph[i], false);
		}
		n = in.nextInt();
		ArrayList<Integer> arr = new ArrayList<>();
		for(int i=0; i<n; i++) {
			int a = in.nextInt();
			arr.add(a);
		}
		
		for(int i=0; i<n; i++) {
			for(int j=i+1; j<n; j++) {
				graph[arr.get(i)][arr.get(j)] = true;
				indegree[arr.get(j)] += 1;
			}
		}
		
		m = in.nextInt();
		for(int i=0; i<m; i++) {
			int a = in.nextInt();
			int b = in.nextInt();
			if(graph[a][b]) {
				graph[a][b] = false;
				graph[b][a] = true;
				indegree[a] += 1;
				indegree[b] -= 1;
			}
			else {
				graph[a][b] = true;
				graph[b][a] = false;
				indegree[a] -= 1;
				indegree[b] += 1;
			}
		}
		Queue<Integer> q = new LinkedList<>();
		ArrayList<Integer> answer = new ArrayList<>();
		for(int i=1; i<=arr.size(); i++) {
			if(indegree[i] == 0) {
				q.offer(i);
			}
		}
		boolean cycle = false;
		boolean certain = true;
		
		for(int i=0; i<n; i++) {
			if(q.isEmpty()) {
				cycle = true;
				break;
			}
			if(q.size() >= 2) {
				certain = false;
				break;
			}
			int now = q.poll();
			answer.add(now);
			for(int j=1; j<=n; j++) {
				if(graph[now][j]) {
					indegree[j] -= 1;
					if(indegree[j] == 0)
						q.offer(j);
				}
			}
		}
		if(cycle) System.out.println("IMPOSSIBLE");
		else if(!certain) System.out.println("?");
		else {
			for(int i=0; i<answer.size(); i++) {
				System.out.print(answer.get(i)+" ");
			}
		}
		
//		for(int i=0; i<n; i++) {
//			for(int j=0; j<n; j++) {
//				System.out.print(graph[arr.get(i)][arr.get(j)]+" ");
//			}
//			System.out.println();
//		}		
//		for(int i=0; i<n; i++) {
//			System.out.println(arr.get(i)+" : " +indegree[arr.get(i)]+" ");
//		}
	}
}