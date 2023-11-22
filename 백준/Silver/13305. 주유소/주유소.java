import java.util.*;
public class Main{
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] km = new int[n-1];
		int[] node = new int[n];
		for(int i=0; i<n-1; i++) {
			km[i] = in.nextInt();
		}
		int min = (int)1e9;
		for(int i=0; i<n; i++) {
			node[i] = in.nextInt();
		}
		long answer = 0;
		for(int i=0; i<n-1; i++) {
			int count = 0;
			long sum = 0;
			for(int j=i; j<n-1; j++) {
				if(node[i] > node[j]) {
					break;
				}
				count += 1;
				sum += km[j];
			}
			answer += node[i] * sum;
			i += count-1;
		}
		System.out.println(answer);
	}
}
