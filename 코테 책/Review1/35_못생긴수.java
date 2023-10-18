import java.util.*;
public class 못생긴수{
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] d = new int[1001];
		
		int i2 = 0, i3 = 0, i5 = 0;
		int next2 = 2, next3 = 3, next5 = 5;
		d[1] = 1;
		for(int i=1; i<n; i++) {
			d[i] = Math.min(next2, Math.min(next5, next3));
			if(d[i] == next2) {
				i2 += 1;
				next2 = d[i2] * 2;
			}
			if(d[i] == next3) {
				i3 += 1;
				next3 = d[i3] * 3;
			}
			if(d[i] == next5) {
				i5 += 1;
				next5 = d[i5] * 5;
			}
		}
		System.out.println(d[n-1]);
	}
}