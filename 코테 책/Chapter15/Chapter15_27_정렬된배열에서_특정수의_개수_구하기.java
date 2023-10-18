import java.util.*;
public class Chapter15_27_정렬된배열에서_특정수의_개수_구하기 {
	static int n, x;
	
	public static int binary_search(int arr[], int r, int l) {
		int right = rightSearch(r, 0, arr.length-1, arr); 
		int left =  leftSearch(l, 0, arr.length-1, arr);
		return right - left;
	}
	
	public static int rightSearch(int target, int start, int end, int[] arr) {
		while(start <= end) {
			int mid = (start + end)/2;
			if(arr[mid] > target) end = mid - 1;
			else start = mid + 1;
		}
		return end;
	}
	public static int leftSearch(int target, int start, int end, int[] arr) {
		while(start <= end) {
			int mid = (start + end)/2;
			if(arr[mid] >= target) end = mid - 1;
			else start = mid + 1;
		}
		return end;
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		x = in.nextInt();

		int arr[] = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = in.nextInt();
		}
		
		int cnt = binary_search(arr, x, x);
		
		if(cnt == 0)
			System.out.println("-1");
		else
			System.out.println(cnt);
			
	}
}