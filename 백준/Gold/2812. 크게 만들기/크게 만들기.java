import java.util.*;
public class Main{
	static int n, k;
	static Stack<Integer> s = new Stack<>(); 
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		k = in.nextInt();
		int arr[] = new int[n];
		String str = in.next();
		for(int i=0; i<n; i++) {
			arr[i] = str.charAt(i) - '0';
		}
		int count = 0;
		for(int i=0; i<n; i++) {
			while(!s.isEmpty() && arr[i] > s.peek() && count < k) {
				s.pop();
				count += 1;
			}
			s.push(arr[i]);
		}
		while(count < k) {
			s.pop();
			count += 1;
		}
		StringBuilder answer = new StringBuilder();
		while(!s.isEmpty()) {
			answer.append(s.pop());
		}
		System.out.println(answer.reverse());
	}
}
