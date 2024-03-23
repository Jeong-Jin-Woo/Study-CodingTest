import java.util.*;
class Position implements Comparable<Position>{
	public int x;
	public int time;
	public int cnt;
	Position(int x,int time, int cnt){
		this.x=x;
		this.time=time;
		this.cnt=cnt;
	}
	@Override
	public int compareTo(Position other) {
		return Integer.compare(time, other.time);
	}
}
public class Main{
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		PriorityQueue<Position> pq = new PriorityQueue<>();

		for(int i=1; i<=n; i++) {
			int time = in.nextInt();
			int cnt = in.nextInt();
			pq.offer(new Position(i, time, cnt));
		}
		int answer = 0;
		PriorityQueue<Integer> pq2 = new PriorityQueue<>();
		for(int i=1; i<=n; i++) {
			Position now = pq.poll();
			pq2.offer(now.cnt);
			if(now.time < pq2.size()) {
				pq2.poll();
			}
		}
		while(!pq2.isEmpty()) {
			answer += pq2.poll();
		}
		System.out.println(answer);
	}
}
