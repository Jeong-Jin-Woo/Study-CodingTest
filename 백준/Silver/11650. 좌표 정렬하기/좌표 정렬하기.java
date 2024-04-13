import java.util.*;
class Node implements Comparable<Node>{
	public int x;
	public int y;
	Node(int x, int y){
		this.x=x;
		this.y=y;
	}
	public int compareTo(Node other) {
		if(x == other.x) {
			return Integer.compare(y, other.y);
		}
		return Integer.compare(x, other.x);
	}
}
public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		ArrayList<Node> node = new ArrayList<>();
		int n = in.nextInt();
		for(int i=0; i<n; i++) {
			int a = in.nextInt();
			int b = in.nextInt();
			node.add(new Node(a,b));
		}
		Collections.sort(node);
		for(int i=0; i<n; i++) {
			System.out.println(node.get(i).x + " " + node.get(i).y);
		}
	}
}
