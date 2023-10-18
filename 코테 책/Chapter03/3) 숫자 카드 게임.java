import java.util.*;
public class Chapter03_2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n=sc.nextInt();
		int m=sc.nextInt();
		int k=sc.nextInt();
		int arr[] = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		
		int first = arr[n-1];
		int second = arr[n-2];
		
		int num1 = (m/(k+1)) * k;
		int num2 = m / (k+1);
		int spare = m - num1 - num2;

		int answer = 0;
		answer += first * spare;
		answer += first * num1;
		answer += second * num2;
		
		System.out.println(answer);
	}

}
