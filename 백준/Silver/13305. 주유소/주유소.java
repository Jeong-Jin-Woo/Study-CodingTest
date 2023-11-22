import java.util.*;
public class Main{
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] km = new int[n-1];
		int[] node = new int[n];
		int sum = 0;
		for(int i=0; i<n-1; i++) {
			km[i] = in.nextInt();
			sum += km[i];
		}
		int min = (int)1e9;
		for(int i=0; i<n; i++) {
			node[i] = in.nextInt();
			if(i != n-1)
				min = Math.min(min, node[i]);
		}
		int answer = 0;
		for(int i=0; i<n-1; i++) {
			if(min == node[i]) {
				answer += node[i] * sum;
				break;
			}
			answer += node[i] * km[i];
			sum -= km[i];
		}
		System.out.println(answer);
	}
}
