import java.util.*;
public class Chapter11_4_만들수없는금액 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] arr = new int[n];
		int sum = 0;
		for(int i=0; i<n; i++) {
			arr[i]  = in.nextInt();
			sum += arr[i];
		}
		
		//1 1 2 3 9
		Arrays.sort(arr);

		int target = 1;
		
		for(int i=0; i<n; i++) {
			if(target < arr[i]) break;
			target = arr[i] + target;
		}
		
		System.out.println(target);
	}

}