import java.util.*;
public class Chapter15_28_고정점찾기 {
	public static int search(int[] arr, int start, int end) {
		while(start <= end) {
			int mid = (start + end) / 2;
			if(arr[mid] == mid) return mid;
			else if(arr[mid] > mid) end = mid - 1;
			else start = mid + 1;
		}
		return -1;
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int arr[] = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = in.nextInt();
		}
		
		System.out.println(search(arr, 0, arr.length-1));
	}
}