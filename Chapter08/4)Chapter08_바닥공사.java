import java.util.*;
public class Chapter08_3_¹Ù´Ú°ø»ç {
	static long[] d = new long[1000];
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		
		d[1] = 1;
		d[2] = 3;
		for(int i=3; i<n; i++) {
			d[i] = (d[i-1] + d[i-2]*2)%796796;
		}
		System.out.println(d[n]);
	}
}
