import java.util.*;
public class Επ»η{
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] d = new int[16];
		int[] t = new int[n];
		int[] p = new int[n];
		
		for(int i=0; i<n; i++) {
			t[i] = in.nextInt();
			p[i] = in.nextInt();
		}
		
		int max = 0;
		for(int i=n-1; i>=0; i--) {
			int time = t[i] + i;
			if(time <= n) {
				d[i] = Math.max(max, d[time] + p[i]);
				max = d[i];
			}
//			else d[i] = max;
		}
		System.out.println(max);
	}
}