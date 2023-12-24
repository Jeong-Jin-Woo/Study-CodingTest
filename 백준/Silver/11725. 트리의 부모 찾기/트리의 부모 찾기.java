import java.util.*;
public class Main{
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		ArrayList<ArrayList<Integer>> node = new ArrayList<>();
		for(int i=0; i<=n; i++) {
			node.add(new ArrayList<>());
		}
		for(int i=0; i<n-1; i++) {
			int a = in.nextInt();
			int b = in.nextInt();
			node.get(a).add(b);
			node.get(b).add(a);
		}
		int[] arr = new int[n+1];
		Queue<Integer> q = new LinkedList<>();
		q.offer(1);
		while(!q.isEmpty()) {
			int now = q.poll();
			for(int i=0; i<node.get(now).size(); i++) {
				if(arr[node.get(now).get(i)] == 0) {
					arr[node.get(now).get(i)] = now;
					q.offer(node.get(now).get(i));
				}
			}
		}
		for(int i=2; i<=n; i++) {
			System.out.println(arr[i]);
		}
		
	}
}
