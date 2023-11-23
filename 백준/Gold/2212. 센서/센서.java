import java.util.*;
public class Main{
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = in.nextInt();
		}
		Arrays.sort(arr);
		Integer[] diff = new Integer[n-1];
		for(int i=0; i<n-1; i++) {
			diff[i] = arr[i+1] - arr[i];
		}
		Arrays.sort(diff, Collections.reverseOrder());
		int answer = 0;
		for(int i=k-1; i<n-1; i++) {
			answer += diff[i];
		}
		System.out.println(answer);
	}
}