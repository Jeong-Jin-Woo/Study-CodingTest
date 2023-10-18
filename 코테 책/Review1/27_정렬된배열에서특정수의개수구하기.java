import java.util.*;
public class 정렬된배열에서특정수의개수구하기{
	static int n,x;
	public static int leftSearch(int start, int end, int[] arr, int target) {
		while(start < end) {
			int mid = (start + end)/2;
			if(target <= arr[mid]) end = mid;
			else start = mid + 1;
		}
		return end;
	}
	public static int rightSearch(int start, int end, int[] arr, int target) {
		while(start < end) {
			int mid = (start + end)/2;
			if(target < arr[mid]) end = mid;
			else start = mid + 1;
		}
		return end;
	}
	public static int binarySearch(int[] arr, int leftX, int rightX) {
		leftX = leftSearch(0, arr.length, arr, leftX);
		rightX = rightSearch(0, arr.length, arr, rightX);
		return rightX-leftX;
	}
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		x = in.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = in.nextInt();
		}
		int answer = binarySearch(arr, x, x);
		if(answer > 0) 
			System.out.println(binarySearch(arr, x, x));
		else
			System.out.println("-1");
	}
}