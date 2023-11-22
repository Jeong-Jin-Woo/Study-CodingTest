import java.util.*;

public class Main {
	static int n, m;
	static int[][] map, des;
	static boolean chg(int x, int y) {
		if(x + 3 > n || y + 3 > m) return false;
		for(int i=x; i<x + 3; i++) {
			for(int j=y; j<y + 3; j++) {
				map[i][j] = map[i][j] ^ 1;
			}
		}
		return true;
	}
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		m = in.nextInt();
		map = new int[n][m];
		des = new int[n][m];
		for(int i=0; i<n; i++) {
			String str = in.next();
			for(int j=0; j<m; j++) {
				map[i][j] = str.charAt(j)-'0';
			}
		}
		for(int i=0; i<n; i++) {
			String str = in.next();
			for(int j=0; j<m; j++) {
				des[i][j] = str.charAt(j)-'0';
			}
		}
		int answer = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(map[i][j] != des[i][j]) {
					if(chg(i, j))
						answer += 1;
				}
			}
		}
		int chk = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(map[i][j] == des[i][j])
					chk += 1;
			}
		}
		System.out.println(m*n == chk ? answer : -1);
	}
}
