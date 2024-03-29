import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main{
	static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String args[]) throws NumberFormatException, IOException {
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> max = new PriorityQueue<>((o1, o2) -> o2 - o1);
		PriorityQueue<Integer> min = new PriorityQueue<>();
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<n; i++) {
			int now = Integer.parseInt(br.readLine());
			if(max.size() == min.size()) {
				max.offer(now);
			}
			else {
				min.offer(now);
			}
			
			if(!max.isEmpty() && !min.isEmpty()) {
				if(max.peek() > min.peek()) {
					int tmp = max.poll();
					max.offer(min.poll());
					min.offer(tmp);
				}
			}
			sb.append(max.peek() +"\n");
		}
		System.out.println(sb);
	}
}