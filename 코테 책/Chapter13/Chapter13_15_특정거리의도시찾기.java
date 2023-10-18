import java.util.*;
public class Chapter13_15_특정거리의도시찾기 {
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
	static int[] d = new int[300001];
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int k = in.nextInt();
		int x = in.nextInt();
		
		for(int i=0; i<=n; i++) {
			graph.add(new ArrayList<Integer>());
			d[i] = -1;
		}
		for(int i=0; i<m; i++) {
			int a = in.nextInt();
			int b = in.nextInt();
			graph.get(a).add(b);
		}
		
		Queue<Integer> q =new LinkedList<Integer>();
		d[x] = 0;
		q.offer(x);
		while(!q.isEmpty()) {
			int now = q.poll();
			for(int i=0; i<graph.get(now).size(); i++) {
				if(d[graph.get(now).get(i)] == -1) {
					d[graph.get(now).get(i)] = d[now] + 1;
					q.offer(graph.get(now).get(i));
				}
			}
		}
		boolean check = false;
		for(int i=1; i<=n; i++) {
			if(d[i] ==k) {
				System.out.println(i);
				check = true;
			}
		}
		if(!check) System.out.println(-1);
	}
}