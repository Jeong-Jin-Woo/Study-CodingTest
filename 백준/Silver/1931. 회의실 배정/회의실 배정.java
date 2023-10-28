import java.util.*;
class Node implements Comparable<Node>{
	int start;
	int end;
	Node(int start, int end){
		this.start = start;
		this.end = end;
	}
	public int getS() {
		return start;
	}
	public int getE() {
		return end;
	}
	@Override
	public int compareTo(Node other) {
		if(end == other.end) {
			return Integer.compare(start, other.start);
		}
		return Integer.compare(end, other.end);
	}
}
public class Main{
	static ArrayList<Node> arr = new ArrayList<>();
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		for(int i=0; i<n; i++) {
			int a = in.nextInt();
			int b = in.nextInt();
			arr.add(new Node(a,b));
		}
		Collections.sort(arr);
		int max = 0;
		int pre = 0;
		for(int i=0; i<arr.size(); i++) {
			if(pre <= arr.get(i).getS()) {
				pre = arr.get(i).getE();
				max += 1;
			}
		}
		System.out.println(max);
	}
}
