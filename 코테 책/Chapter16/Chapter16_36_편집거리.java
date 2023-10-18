import java.util.*;
public class Chapter16_36_편집거리 {
	static String str1;
	static String str2;
	public static int editText(String s1, String s2) {
		int n = s1.length();
		int m = s2.length();
		int d[][] = new int[n+1][m+1];
		
		for(int i=1; i<=n; i++) {
			d[i][0] = i;
		}
		for(int i=1; i<=m; i++) {
			d[0][i] = i;
		}
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=m; j++) {
				if(s1.charAt(i-1) == s2.charAt(j-1)) d[i][j] = d[i-1][j-1];
				else {
					d[i][j] = 1 + Math.min(d[i][j-1], Math.min(d[i-1][j-1], d[i-1][j]));
				}
			}
		}	
		return d[n][m];
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		str1 = in.next();
		str2 = in.next();
		
		System.out.println(editText(str1, str2));
	}
}