import java.util.*;
public class Chapter08_3_개미전사 {
	static long[] d = new long[100];
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int store[] = new int[n];
		for(int i=0; i<n; i++) {
			store[i] = in.nextInt();
		}
		
		d[0] = store[0];
		d[1] = Math.max(store[0], store[1]);
		for(int i=2; i<n; i++) {
			d[i] = Math.max(d[i-1], d[i-2] + store[i]);
		}
		
		System.out.println(d[n-1]);
	}
}
