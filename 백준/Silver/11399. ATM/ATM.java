import java.util.*;
public class Main{
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = in.nextInt();
		}
		Arrays.sort(arr);
		int answer = 0;
		for(int i=0; i<n; i++) {
			int sum = 0;
			for(int j=0; j<=i; j++) {
				sum += arr[j];
			}
			answer += sum;
		}
		System.out.println(answer);
	}
}