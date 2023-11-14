import java.util.*;
public class Main{
	static boolean isPrime(int v) {
		if(v < 2) return false;
		for(int i = 2; i <= Math.sqrt(v); i++) {
			if(v % i == 0) return false;
		}
		return true;
	}
	static void dfs(int start, int n) {
		if(n == 0) {
			System.out.println(start);
			return;
		}
		for(int i=1; i<10; i++) {
			if(isPrime(start*10+i)) {
				dfs(start * 10 + i, n -1);
			}
		}
	}
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		dfs(0, n);
	}
}