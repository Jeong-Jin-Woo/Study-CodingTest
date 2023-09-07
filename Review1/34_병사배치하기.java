import java.util.*;
public class 병사배치하기{
	public static int solution(int[] arr) {
		int n = arr.length;
		int[] d = new int[n+1];
		Arrays.fill(d, 1);
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<i; j++) {
				if(arr[i] < arr[j]) {
					d[i] = Math.max(d[i], d[j] + 1);
				}
			}
		}
		return n - d[n-1];
	}
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = in.nextInt();
		}
		
		System.out.println(solution(arr));
	}
}