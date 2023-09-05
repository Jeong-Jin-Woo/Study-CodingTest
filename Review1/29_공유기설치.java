import java.util.*;
public class �����⼳ġ{
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int c = in.nextInt();
		ArrayList<Integer> arr = new ArrayList<>();
		
		for(int i=0; i<n; i++) {
			arr.add(in.nextInt());
		}
		Collections.sort(arr);
		
		int answer = 0;
		int start = 1;
		int end = arr.get(n-1) - arr.get(0);
		while(start <= end) {
			int mid = (start + end)/2;
			int value = arr.get(0);
			int cnt=1;
			for(int i=1; i<n; i++) {
				if(arr.get(i) >= mid + value) {
					value = arr.get(i);
					cnt += 1;
				}
			}
			if(c > cnt) {
				end = mid - 1;
			}
			else {
				start = mid + 1;
				answer = mid;
			}
		}
		
	}
}