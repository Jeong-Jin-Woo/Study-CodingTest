import java.util.*;
public class Main{
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		final int INF = (int)1e9;
		int[] dp_max = new int[3];
		int[] dp_min = new int[3];
		int a = in.nextInt();
		int b = in.nextInt();
		int c = in.nextInt();
		dp_min[0] = dp_max[0] = a;
		dp_min[1] = dp_max[1] = b;
		dp_min[2] = dp_max[2] = c;
		int max = 0;
		int min = INF;
		for(int i=1; i<n; i++) {
			int x = in.nextInt();
			int y = in.nextInt();
			int z = in.nextInt();
			int maxA = Math.max(dp_max[0]+x, dp_max[1]+x);
			int maxB = Math.max(dp_max[1]+y, Math.max(dp_max[0]+y, dp_max[2]+y));
			int maxC = Math.max(dp_max[2]+z, dp_max[1]+z);
			dp_max[0] = maxA;
			dp_max[1] = maxB;
			dp_max[2] = maxC;
			

			int minA = Math.min(dp_min[0]+x, dp_min[1]+x);
			int minB = Math.min(dp_min[1]+y, Math.min(dp_min[0]+y, dp_min[2]+y));
			int minC = Math.min(dp_min[2]+z, dp_min[1]+z);
			dp_min[0] = minA;
			dp_min[1] = minB;
			dp_min[2] = minC;
		}
		for(int i=0; i<3; i++) {
			max	= Math.max(dp_max[i] , max);
			min	= Math.min(dp_min[i] , min);
		}
		System.out.println(max + " " + min);
	}
}