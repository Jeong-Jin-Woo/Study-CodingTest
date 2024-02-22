import java.util.*;
class Node implements Comparable<Node>{
	public int index;
	public int time;
	Node(int index, int time){
		this.index=index;
		this.time=time;
	}
	@Override
	public int compareTo(Node other) {
		return Integer.compare(time, other.time);
	}
}
public class Main{
	static int indegree[];
	static ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
	static int n;
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		indegree = new int[n+1];
		Node node[] = new Node[n+1];
		for(int i=0; i<=n; i++) {
			arr.add(new ArrayList<>());
		}
		for(int i=1; i<=n; i++) {
			int time = in.nextInt();
			node[i] = new Node(i, time);
			while(true) {
				int set = in.nextInt();
				if(set == -1) break;
				arr.get(set).add(i);
				indegree[i] += 1;
			}
		}
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		for(int i=1; i<=n; i++) {
			if(indegree[i] == 0)
				pq.offer(node[i]);
		}
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			int index = now.index;
			for(int i=0; i<arr.get(index).size(); i++) {
				int get = arr.get(index).get(i);
				indegree[get] -= 1;
				if(indegree[get] == 0) {
					node[get].time += node[index].time;
					pq.offer(new Node(get, node[get].time));
				}
			}
		}
		for(int i=1; i<=n; i++) {
			System.out.println(node[i].time);
		}
	}
}