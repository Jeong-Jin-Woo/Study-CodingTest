import java.util.*;
public class Chapter08_5_瓤啦利牢拳企备己 {
	static long[] d = new long[10001];
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int[] value = new int[n];
		for(int i=0; i<n; i++) {
			value[i] = in.nextInt();
		}
		Arrays.fill(d,10001);
		d[0] = 0;
		
		for(int i=0; i<n; i++) {
			for(int j=value[i]; j<=m; j++) {
				d[j] = Math.min(d[j], d[j - value[i]] + 1);
			}
		}
		
		if(d[m] == 10001)
			System.out.println("-1");
		else
			System.out.println(d[m]);
	}
}
