import java.util.*;
public class Main{
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		while(n-- != 0) {
			int num = in.nextInt();
			Stack<Integer> s = new Stack<>();
			int a = 0;
			int b = 1;
			while(num != 0) {
				a += b;
				if(a > num) {
					num -= b;
					s.push(b);
					a = 0;
					b = 1;
					continue;
				}
				b += a;
				if(b > num) {
					num -= a;
					s.push(a);
					a = 0;
					b = 1;
					continue;
				}
			}
			while(!s.isEmpty()) {
				System.out.print(s.pop() + " ");
			}
			System.out.println();
		}
	}
}
