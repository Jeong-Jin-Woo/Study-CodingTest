import java.util.*;
public class Main{
	static int n;
	static int[] arr;
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = in.nextInt();
		}
		Arrays.sort(arr);
		int answer=1;
		for(int i=0; i<n; i++) {
			if(answer < arr[i]) break;
			answer += arr[i];
		}
		System.out.println(answer);
	}
}
