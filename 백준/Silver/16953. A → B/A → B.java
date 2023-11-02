import java.util.*;
public class Main{
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		int b = in.nextInt();
		int answer = 0;
		while(true) {
			if(a > b) {
				System.out.println(-1);
				break;
			}
			if(a == b) {
				System.out.println(answer + 1);
				break;
			}
			if(b % 10 == 1) {
				b /= 10;	
			}
			else if(b % 2 == 0) {
				b /= 2;
			}
			else {
				System.out.println(-1);
				break;
			}
			answer += 1;
		}
		
	}
}