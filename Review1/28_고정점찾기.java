import java.util.*;
public class 고정점찾기{
	public static int binarySearch(int[] arr, int start, int end) {
		while(start <= end) {
			int mid = (start+end)/2;
			if(mid == arr[mid]) return mid;
			else if(mid > arr[mid]) start = mid + 1;
			else end = mid - 1;
		}
		return -1;
	}
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = in.nextInt();
		}
		
		System.out.println(binarySearch(arr, 0, n));
	}
}