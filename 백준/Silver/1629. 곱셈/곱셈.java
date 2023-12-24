import java.util.*;
public class Main{
	public static long pow(int a, int b, int c) {
		if(b == 0) {
			return 1;
		}
		long sum = pow(a, b/2, c);
		if(b % 2 ==0) {
			return sum * sum % c;
		}
		else {
			return (sum*sum%c) * a % c; 
		}
	}
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		int b = in.nextInt();
		int c = in.nextInt();
		
		long sum = pow(a, b, c);
		System.out.println(sum);
	}
}