import java.util.*;
public class Chapter11_5_볼링공고르기 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int arr[] = new int[n];
		
		for(int i=0; i<n; i++) {
			int x = in.nextInt();
			arr[x]++;
		}
		
		int answer = 0;
		for(int i=1; i<=m; i++) {
			n -= arr[i];
			answer += arr[i] * n;
		}
		System.out.println(answer);
	}
}