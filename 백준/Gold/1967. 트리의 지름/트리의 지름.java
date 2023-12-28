import java.util.*;
class Node{
	public int index;
	public int dist;
	Node(int index, int dist){
		this.index=index;
		this.dist=dist;
	}
}
public class Main{
	static ArrayList<ArrayList<Node>> node = new ArrayList<>();
	static boolean[] visit;
	static int n;
	static int answer = 0;
	static void dfs(int start, int sum) {
		for(int i=0; i<node.get(start).size(); i++) {
			int index = node.get(start).get(i).index;
			int dist = node.get(start).get(i).dist;
			if(!visit[index]) {
				visit[index] = true;
				dfs(index, sum + dist);
				visit[index] = false;
			}
			answer = Math.max(answer, sum);
		}
	}
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		for(int i=0; i<=n; i++) {
			node.add(new ArrayList<>());
		}
		for(int i=0; i<n-1; i++) {
			int a= in.nextInt();
			int b = in.nextInt();
			int c = in.nextInt();
			node.get(a).add(new Node(b,c));
			node.get(b).add(new Node(a,c));
		}
		for(int i=1; i<=n; i++) {
			visit = new boolean[n+1];
			if(node.get(i).size() == 1) {
				visit[i] = true;
				dfs(i, 0);
				visit[i] = false;
			}
		}
		System.out.print(answer);
	}
}
