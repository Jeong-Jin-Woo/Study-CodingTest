import java.util.*;
public class Main{
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int arr[] = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = in.nextInt();
		}
		Arrays.sort(arr);
		int sum = 1;
		for(int i=0; i<n; i++) {
			if(sum < arr[i]) {
				break;
			}
			sum += arr[i];
		}
		System.out.println(sum);
	}
}