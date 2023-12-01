import java.util.*;

public class Main {
	static int answer = 0;
	static void search(int start, int end, int target, int n) {
		while(start <= end) {
			int mid = (start + end)/2;
			int count = 0;
			for(int i=1; i<=n; i++) {
				count += Math.min(mid/i, n);
			}
			if(count >= target) {
				end = mid - 1;
				answer = mid;
			}
			else {
				start = mid + 1;
			}
		}
	}
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		search(1, k, k, n);
		System.out.println(answer);
	}
}
