import java.util.*;
public class Chapter08_�Ǻ���ġ_���Ҿ� {
	static long[] d = new long[100];
	public static void main(String args[]) {
	
		int n = 10;
		d[1] = 1;
		d[2] = 2;
		
		for(int i=3; i<=n; i++) {
			d[i] = d[i-1] + d[i-2];
		}
		
		System.out.println(d[n]);
	}
}

