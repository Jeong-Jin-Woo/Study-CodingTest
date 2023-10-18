import java.util.*;
public class Chapter15_29_공유기설치 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int c = in.nextInt();
		ArrayList<Integer> arr = new ArrayList<>();
		
		for(int i=0; i<n; i++) {
			arr.add(in.nextInt());
		}
		
		Collections.sort(arr);
		
		int start = 1;
		int end = arr.get(n-1) - arr.get(0);
		int result = 0;
		
		while(start <= end) {
			int mid = (start + end) / 2;
			int value = arr.get(0);
			int count = 1;
			for(int i=1; i<n; i++) {
				if(arr.get(i) >= value + mid) {
					value = arr.get(i);
					count++;
				}
			}
			if(count >= c) {
				start = mid + 1;
				result = mid;
			}
			else {
				end = mid - 1;
			}
			
		}
		System.out.println(result);
		
	}
}