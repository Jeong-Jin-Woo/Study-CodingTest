import java.util.*;
public class Main {
	static int n;
	static long arr[];
	static long answer = 0;
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		arr = new long[n];
		for(int i=0; i<n; i++) {
			arr[i] = in.nextInt();
		}
		Arrays.sort(arr);
		int index = 0;
		int start = 0;
		int end = n-1;
		while(index != n) {
			if(start == index) {
				start += 1;
			}
			if(end == index) {
				end -= 1;
			}
			if(start >= end) {
				index += 1;
				start = 0;
				end = n-1;
				continue;
			}
			if(arr[index] == arr[start] + arr[end]) {
				answer += 1;
				index += 1;
				start = 0;
				end = n-1;
			}
			else if(arr[index] < arr[start] + arr[end]){
				end -= 1;
			}
			else {
				start += 1;
				end = n-1;
			}
		}
		System.out.println(answer);

	}
}
