import java.util.*;
public class Chapter16_32_Á¤¼ö»ï°¢Çü {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int arr[][] = new int[n][n];
		int d[][] = new int[n][n];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<=i; j++) {
				arr[i][j] = in.nextInt();
				d[i][j] = arr[i][j];
			}
		}
		
		for(int i=0; i<n-1; i++) {
			for(int j=0; j<=i; j++) {
				d[i+1][j] = Math.max(d[i+1][j], arr[i+1][j] + d[i][j]);
				d[i+1][j+1] = Math.max(d[i+1][j+1], arr[i+1][j+1] + d[i][j]);
				
			}
		}
		
		int answer = 0;
		for(int i=0; i<n; i++) {
			answer = Math.max(answer, d[n-1][i]);
		}
		System.out.println(answer);
		
//		for(int i=0; i<n; i++) {
//			for(int j=0; j<n; j++) {
//				System.out.print(d[i][j]+" ");
//			}
//			System.out.println();
//		}
		
	}
}