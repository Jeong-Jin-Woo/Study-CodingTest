import java.util.*;
public class Á¤¼ö»ï°¢Çü{
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int d[][] = new int[n][n];
		int arr[][] = new int[n][n];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<=i; j++) {
				arr[i][j] = in.nextInt();
			}
		}
		
		for(int i=0; i<n; i++) {
			d[n-1][i] = arr[n-1][i];
		}
		
		for(int i=n-2; i>=0; i--) {
			for(int j=0; j<=i; j++) {
				d[i][j] += Math.max(d[i+1][j] + arr[i][j], d[i+1][j+1] + arr[i][j]);
			}
		}
		System.out.println(d[0][0]);
	}
}