import java.util.*;
public class Chapter04_3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int answer = 0;
		for(int i=0 ;i<n; i++) {
			int min_value = 10001;
			for(int j=0; j<m; j++) {
				int min = sc.nextInt();
				min_value = Math.min(min_value, min);
			}
			answer = Math.max(min_value, answer);
		}
		
		System.out.println(answer);
	}

}
