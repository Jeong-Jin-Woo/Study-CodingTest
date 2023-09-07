import java.util.*;
public class 편집거리{
	public static int solution(String str1, String str2){
		int n = str1.length();
		int m = str2.length();
		int[][] d = new int[n+1][m+1];
		
		for(int i=1; i<=n; i++) {
			d[i][0] = i;
		}
		for(int i=1; i<=m; i++) {
			d[0][i] = i;
		}
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=m; j++) {
				if(str1.charAt(i-1) == str2.charAt(j-1)) d[i][j] = d[i-1][j-1];
				else {
					d[i][j] = 1 + Math.min(d[i][j-1], Math.min(d[i-1][j-1], d[i-1][j]));
					
				}
			}
		}
		return d[n][m];
	}
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		String str1 = in.next();
		String str2 = in.next();
		
		System.out.println(solution(str1, str2));
	}
}