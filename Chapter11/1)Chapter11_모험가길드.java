import java.util.*;
public class Chapter_1_모험가길드 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		Integer arr[] = new Integer[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = in.nextInt();
		}
		
		Collections.sort(Arrays.asList(arr), Collections.reverseOrder());
		
		int answer = 0;
		for(int i=0; i<n; i++) {
			i += arr[i]-1;
			answer++;
		}
		System.out.println(answer);
	}

}