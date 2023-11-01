import java.util.*;
public class Main{
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i=0; i<n; i++) {
			pq.offer(in.nextInt());
		}
		int answer = 0;
		while(pq.size() > 1) {
			int nowA = pq.poll();
			int nowB = pq.poll();
			int sum = nowA + nowB;
			answer += sum;
			pq.offer(sum);
		}
		System.out.println(answer);
	}
}
