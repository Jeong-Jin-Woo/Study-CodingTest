import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int c = in.nextInt();
		while (c-- != 0) {
			int n = in.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = in.nextInt();
			}
			long answer = 0;
			long num = 0;
			for (int i = n - 1; i >= 0; i--) {
				num = arr[i];
				for (int j = i; j >= 0; j--) {
					if (num < arr[j]) {
						i += 1;
						break;
					}
					answer += num - arr[j];
					i -= 1;
				}
			}
			System.out.println(answer);
		}
	}
	
	
}
