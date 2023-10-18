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
		return Integer.compare(dist, other.dist);
	}
}
class Planet{
	int x;
	int y;
	int z;
	Planet(int x,int y, int z){
		this.x =x;
		this.y =y;
		this.z =z;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getZ() {
		return z;
	}
}
public class Chapter18_44_행성터널 {
	static int[] root = new int[100001];
	static ArrayList<Node> graph = new ArrayList<>();
	static ArrayList<Planet> p = new ArrayList<>();
	public static int find(int r) {
		if(root[r] == r) return r;
		return root[r] = find(root[r]);
	}
	public static void root(int a, int b) {
		a = find(a);
		b = find(b);
		if(a<b) root[b] = a;
		else root[a] = b;
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		
		for(int i=1; i<=n; i++) {
			root[i] = i;
		}
		
		for(int i=1; i<=n; i++) {
			int x = in.nextInt();
			int y = in.nextInt();
			int z = in.nextInt();
			p.add(new Planet(x,y,z));
		}
		
		for(int i=0; i<p.size(); i++) {
			for(int j=i; j<p.size(); j++) {
				if(j==i) continue;
				int dist = Math.min(Math.abs(p.get(i).getX()-p.get(j).getX()), Math.min(Math.abs(p.get(i).getY()-p.get(j).getY()), Math.abs(p.get(i).getZ()-p.get(j).getZ())));
				graph.add(new Node(i+1, j+1, dist));
			}
		}
		
		Collections.sort(graph);
		
		int answer = 0;
		for(int i=0; i<graph.size(); i++) {
			int a = graph.get(i).getA();
			int b = graph.get(i).getB();
			int dist = graph.get(i).getDist();
			if(find(a) != find(b)) {
				root(a, b);
				answer += dist; 
			}
		}
		System.out.println(answer);
		
	}
}