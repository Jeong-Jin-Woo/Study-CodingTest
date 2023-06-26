import java.util.*;
public class Chapter07_3_¶±ººÀÌ¶±¸¸µé±â {
	public static int cutCake(Integer arr[], int target, int start, int end) {
		int least = 0;
		while(start <= end) {
			int sum = 0;
			int mid = (start+end)/2;
			for(int i=0; i<arr.length; i++) {
				if(arr[i] > mid)
					sum += arr[i] - mid;
			}
			if(sum < target)
				end = mid - 1;
			else {
				least = mid;
				start = mid + 1;
			}
		}
		return least;
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		
		Integer[] cake = new Integer[n];
		for(int i=0; i<n; i++)
			cake[i] = in.nextInt();
		
		Collections.sort(Arrays.asList(cake));
		System.out.println(cutCake(cake, m, 0, cake[n-1]));
	}
}
