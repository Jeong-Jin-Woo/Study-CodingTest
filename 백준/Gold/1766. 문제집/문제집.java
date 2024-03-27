import java.util.*;
public class Main{
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int[] indegree = new int[n+1];
		ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
		for(int i=0; i<=n; i++) {
			arr.add(new ArrayList<>());
		}
		//indegree[1] = 0
		//indegree[2] = 0
		//indegree[3] = 1
		//indegree[4] = 1
		for(int i=1; i<=m; i++) {
			int a= in.nextInt();
			int b = in.nextInt();
			arr.get(a).add(b);
			indegree[b] += 1;
		}
		Queue<Integer> q = new LinkedList<>();
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i=1; i<=n; i++) {
			if(indegree[i] == 0) {
				pq.offer(i);
			}
		}
		StringBuilder sb = new StringBuilder();
		while(!pq.isEmpty()) {
			int now = pq.poll();
			sb.append(now + " ");
			for(int i=0; i<arr.get(now).size(); i++) {
				int set = arr.get(now).get(i);
				indegree[set] -= 1;
				if(indegree[set] == 0) {
					pq.offer(set);
				}
			}
		}
		System.out.println(sb);
	}
}
