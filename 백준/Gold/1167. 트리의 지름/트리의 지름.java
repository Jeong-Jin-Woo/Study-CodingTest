import java.util.*;
class Node{
	public int index;
	public int dist;
	Node(int index, int dist){
		this.index=index;
		this.dist=dist;
	}
}
public class Main {
	static int n, answer = 0;
	static int far = 0;
	static ArrayList<ArrayList<Node>> node = new ArrayList<>();
	static boolean[] visit;
	public static void dfs(int start, int sum) {
		if(answer < sum) {
			answer = sum;
			far = start;
		}
		visit[start] = true;
		for(int i=0; i<node.get(start).size(); i++) {
			int dist = node.get(start).get(i).dist;
			int index = node.get(start).get(i).index;
			if(!visit[index]) {
				visit[index] = true;
				dfs(index, dist + sum);
			}
			answer = Math.max(answer, sum);
		}
	}
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		for(int i=0; i<=n; i++) {
			node.add(new ArrayList<>());
		}
		for(int i=1; i<=n; i++) {
			int index = in.nextInt();
			boolean chk = true;
			while(chk) {
				int a = in.nextInt();
				if(a == -1) break;
				int b = in.nextInt();
				node.get(index).add(new Node(a,b));
			}
		}
		
		visit = new boolean[n+1];
		dfs(1, 0);
		visit = new boolean[n+1];
		dfs(far, 0);
		System.out.println(answer);
	}
}
