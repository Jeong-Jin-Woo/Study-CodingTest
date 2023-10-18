import java.util.*;
public class 만들수없는금액 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int arr[] = new int[n];
		
		int total = 0;
		for(int i=0; i<n; i++) {
			arr[i] = in.nextInt();
			total += arr[i];
		}
		
		Arrays.sort(arr);
		int answer = 1;
		for(int i=0; i < n; i++) {
			if(answer < arr[i]) break;
			answer += arr[i];
		}
		System.out.println(answer);
	}
}