import java.util.*;
public class Main{
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		String[] arr= new String[n];
		int[] alpha = new int[26];
		for(int i=0; i<n; i++) {
			arr[i] = in.next();
		}
		for(int i=0; i<n; i++) {
			for(int j=0; j<arr[i].length(); j++) {
//				System.out.println(arr[i].charAt(j));
				alpha[arr[i].charAt(j)-'A'] += Math.pow(10, arr[i].length()-j-1);
			}
		}
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		for(int i=0; i<alpha.length; i++) {
			pq.offer(alpha[i]);
		}
		int answer = 0;
		int max = 9;
		while(!pq.isEmpty()) {
			answer += pq.poll() * max--;
		}
		System.out.println(answer);
		
	}
}
