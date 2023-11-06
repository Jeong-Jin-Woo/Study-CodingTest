import java.util.*;
public class Main{
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		int b = in.nextInt();
		int count = 1;
		while(b!=a) {
			if(b < a) {
				System.out.println(-1);
				return;
			}
			if(b % 2 == 0) {
				b /= 2;
			}
			else if(b % 10 == 1){
				b /= 10;
			}
			else {
				System.out.println(-1);
				return;
			}
			count += 1;
		}
		System.out.println(count);
	}
}