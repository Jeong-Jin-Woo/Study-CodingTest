import java.util.*;
class Position implements Comparable<Position>{
	public int x;
	Position(int x){
		this.x=x;
	}
	@Override
	public int compareTo(Position other) {
		if(Math.abs(x) == Math.abs(other.x)) {
			return Integer.compare(x, other.x);
		}
		return Integer.compare(Math.abs(x), Math.abs(other.x));
	}
}
public class Main{
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		PriorityQueue<Position> pq = new PriorityQueue<>();
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<n; i++) {
			int x = in.nextInt();
			if(x != 0) {
				pq.offer(new Position(x));
			}
			else {
				if(pq.isEmpty()) {
					sb.append(0 + "\n");
				}
				else {
					sb.append(pq.poll().x + "\n");
				}
			}
		}
		System.out.println(sb);
	}
}
