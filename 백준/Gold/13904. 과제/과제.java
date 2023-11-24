import java.util.*;
class Position implements Comparable<Position>{
	public int d;
	public int w;
	Position(int d, int w){
		this.d=d;
		this.w=w;
	}
	@Override
	public int compareTo(Position other) {
		if(other.d == d) {
			return Integer.compare(other.w, w);
		}
		return Integer.compare(other.d, d);
	}
}
public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		PriorityQueue<Position> pq = new PriorityQueue<>();
		int max = 0;
		for(int i=0; i<n; i++) {
			int a = in.nextInt();
			int b =  in.nextInt();
			pq.offer(new Position(a, b));
			max = Math.max(a, max);
		}
		int d = max;
		int answer = 0;
		while(!pq.isEmpty()) {
			Position now = pq.poll();
			if(now.d <= 0) break;
			if(d == now.d) {
				answer += now.w;
			}
			else if(d > now.d){
				pq.offer(new Position(now.d, now.w));
				d-=1;
				continue;
			}
			else {
				pq.offer(new Position(now.d-1, now.w));
				continue;
			}
			d -= 1;
		}
		System.out.println(answer);
		
	}
}
