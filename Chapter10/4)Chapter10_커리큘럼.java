import java.util.*;
public class Chapter10_4_Ä¿¸®Å§·³ {
	static int v;
	static int[] root = new int[501];
	static int[] times = new int[501];
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
	
	public static void course() {
		int result[] = new int[501];
		
		for(int i=1; i<=v; i++) {
			result[i] = times[i];
		}
		Queue<Integer> q = new LinkedList<>();
		for(int i=1; i<=v; i++) {
			if(root[i]==0)
				q.offer(i);
		}
		while(!q.isEmpty()) {
			int now = q.poll();
			for(int i=0; i<graph.get(now).size(); i++) {
				result[graph.get(now).get(i)] = Math.max(result[graph.get(now).get(i)], result[now] + times[graph.get(now).get(i)]);
				root[graph.get(now).get(i)]--;
				if(root[graph.get(now).get(i)] == 0) {
					q.offer(graph.get(now).get(i));
				}
			}
		}
		for(int i=1; i<=v; i++) {
			System.out.println(result[i]);
		}
	}
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		v = in.nextInt();
		
		for(int i=0; i<=v; i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		for(int i=1; i<=v; i++) {
			int time = in.nextInt();
			times[i] = time;
			while(true) {
				int pre = in.nextInt();
				if(pre == -1) {
					break;
				}
				root[i] +=1;
				graph.get(pre).add(i);
			}
		}
		
		course();
		
	}	
}