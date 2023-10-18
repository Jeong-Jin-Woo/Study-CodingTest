import java.util.*;
public class Chapter08_2_1로만들기 {
	static long[] d = new long[30001];
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
	
		for(int i=2; i<=num; i++) {
			d[i] = d[i-1] + 1;
			if(i % 2 == 0) {
				d[i] = Math.min(d[i], d[i/2]+1);
			}
			if(i % 3 == 0) {
				d[i] = Math.min(d[i], d[i/3]+1);
			}
			if(i % 5 == 0) {
				d[i] = Math.min(d[i], d[i/5]+1);
			}
		}
		System.out.println(d[num]);
	}
}

