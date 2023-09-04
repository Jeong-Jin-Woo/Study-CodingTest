import java.util.*;
public class 카드정렬하기{
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int answer = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		for(int i=0; i<n; i++) {
			pq.offer(in.nextInt());
		}
		
		while(pq.size() != 1) {
			int a = pq.poll();
			int b = pq.poll();
			
			answer += a + b;
			pq.offer(a+b);
		}
		System.out.println(answer);
	}
}