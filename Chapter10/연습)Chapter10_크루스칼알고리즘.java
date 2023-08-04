import java.util.*;
class Node implements Comparable<Node>{
	int a;
	int b;
	int dist;
	Node(int a, int b, int dist){
		this.a = a;
		this.b = b;
		this.dist = dist;
	}
	public int getA() {
		return a;
	}
	public int getB() {
		return b;
	}
	public int getDist() {
		return dist;
	}
	@Override
	public int compareTo(Node other) {
		return Integer.compare(dist, other.getDist());
	}
}
public class Chapter10_0_크루스칼알고리즘 {
	static int v,e;
	static int[] root = new int[10000];
	static ArrayList<Node> node = new ArrayList<>();
	public static int find(int r) {
		if(r == root[r]) {
			return r;
		}
		else {
			root[r] = find(root[r]);
			return root[r];
		}
	}
	public static void root(int a, int b) {
		a = find(a);
		b = find(b);
		if(a < b) root[b] = a;
		else root[a] = b;
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		v = in.nextInt();
		e = in.nextInt();
		
		for(int i=1; i<=v; i++) {
			root[i] = i;
		}
		for(int i=1; i<=e; i++) {
			int a = in.nextInt();
			int b = in.nextInt();
			int c = in.nextInt();
			node.add(new Node(a,b,c));
		}
		Collections.sort(node);
		
		int answer = 0;
		for(int i=0; i<node.size(); i++) {
			boolean chk = true;
			if(find(node.get(i).getA()) == find(node.get(i).getB())){
				chk = false;
			}
			if(chk) {
				root(node.get(i).getA(), node.get(i).getB());
				answer += node.get(i).getDist();
			}
		}
		System.out.println(answer);
		
	}
}