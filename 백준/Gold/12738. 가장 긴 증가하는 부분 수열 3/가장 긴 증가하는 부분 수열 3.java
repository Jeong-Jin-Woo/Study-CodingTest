import java.util.*;
public class Main{
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] arr = new int[n];
		int[] LIS = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = in.nextInt();
		}
		LIS[0] = arr[0];
		int size = 1;
		for(int i=1; i<n; i++) {
			int key = arr[i];
			if(LIS[size-1] < key) {
				LIS[size] = key;
				size += 1;
			}
			else {
				int start = 0;
				int end = size;
				while(start < end) {
					int mid = (start + end)/2;
					if(LIS[mid] < key) {
						start = mid + 1;
					}
					else {
						end = mid;
					}
				}
				LIS[start] = key;
			}
		}
		System.out.println(size);
//		for(int i=0; i<n; i++) {
//			System.out.print(LIS[i] + " ");
//		}
	}
}
