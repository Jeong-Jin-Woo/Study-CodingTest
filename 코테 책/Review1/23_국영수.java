import java.util.*;
class Node implements Comparable<Node>{
	int k;
	int e;
	int m;
	String name;
	Node(String name, int k, int e, int m){
		this.name = name;
		this.k = k;
		this.e = e;
		this.m = m;
	}
	public String getName() {
		return name;
	}
	@Override
	public int compareTo(Node other) {
		if(k == other.k && e == other.e && m == other.m) {
			return name.compareTo(other.name);
		}
		if(k == other.k && e == other.e) {
			return Integer.compare(other.m, m);
		}
		if(k == other.k) {
			return Integer.compare(e, other.e);
		}
		return Integer.compare(other.k, k);
	}
}
public class ±¹¿µ¼ö{
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		ArrayList<Node> arr = new ArrayList<>();
		for(int i=0; i<n; i++) {
			String name = in.next();
			int k = in.nextInt();
			int e = in.nextInt();
			int m = in.nextInt();
			arr.add(new Node(name, k, e, m));
		}
		Collections.sort(arr);
		
		for(int i=0; i<n; i++)
			System.out.println(arr.get(i).getName());
	}
}