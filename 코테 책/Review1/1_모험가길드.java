import java.util.*;
public class 모험가길드 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int arr[] = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = in.nextInt();
		}
		Arrays.sort(arr);
		
		int answer = 0;
		int count = 0;
		for(int i=0; i<n; i++) {
			count += 1;
			if(count >= arr[i]) {
				answer += 1;
				count = 0;
			}
		}
		
		System.out.println(answer);
	}
}