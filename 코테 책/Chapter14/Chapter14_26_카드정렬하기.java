import java.util.*;
public class Chapter14_26_카드정렬하기 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		for(int i=0; i<n; i++) {
			int num = in.nextInt();
			pq.offer(num);
		}
		
		int answer = 0;
		while(pq.size() != 1) {
			int num1 = pq.poll();
			int num2 = pq.poll();
			
			answer += num1 + num2;
			
			pq.offer(num1+num2);
		}
		System.out.println(answer);
	}
}