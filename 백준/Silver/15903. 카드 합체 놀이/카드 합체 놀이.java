import java.util.*;
public class Main{
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		PriorityQueue<Long> pq = new PriorityQueue<>();
		for(int i=0; i<n; i++) {
			long num = in.nextInt();
			pq.offer(num);
		}
		for(int i=0; i<m; i++) {
			long a = pq.poll();
			long b = pq.poll();
			long sum = a+b;
			pq.offer(sum);
			pq.offer(sum);
		}
		long answer = 0;
		while(!pq.isEmpty()) {
			long now = pq.poll();
			answer += now;
		}
		System.out.println(answer);
	}
}
