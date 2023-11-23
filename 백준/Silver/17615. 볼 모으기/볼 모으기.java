import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		String str = in.next();
		int min = (int) 1e9;
		int answer = 0;
		for (int i = 0; i < n; i++) { //왼쪽 파랑
			if(str.charAt(i) == 'B') {
				continue;
			}
			else {
				for(int j=i; j<n; j++) {
					if(str.charAt(j) == 'B')
						answer += 1;
				}
				break;
			}
		}
		min = Math.min(answer, min);
		answer = 0;
		for (int i = 0; i < n; i++) { //왼쪽 빨강
			if(str.charAt(i) == 'R') {
				continue;
			}
			else {
				for(int j=i; j<n; j++) {
					if(str.charAt(j) == 'R')
						answer += 1;
				}
				break;
			}
		}
		min = Math.min(answer, min);
		answer = 0;
		for (int i = n - 1; i >= 0; i--) { //오른쪽 파랑
			if(str.charAt(i) == 'B') {
				continue;
			}
			else {
				for(int j=i; j>=0; j--) {
					if(str.charAt(j) == 'B')
						answer += 1;
				}
				break;
			}
		}
		min = Math.min(answer, min);
		answer = 0;
		for (int i = n - 1; i >= 0; i--) { //오른쪽 빨강
			if(str.charAt(i) == 'R') {
				continue;
			}
			else {
				for(int j=i; j>=0; j--) {
					if(str.charAt(j) == 'R')
						answer += 1;
				}
				break;
			}
		}
		min = Math.min(answer, min);
		answer = 0;
		System.out.println(min);
	}
}
