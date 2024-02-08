import java.util.*;
public class Main{
	static int n;
	static int dp[][];
	static int map[][];
	static int answer = 0;
	static void dfs(int rx, int ry, int direction) {
		if(rx==n-1 && ry == n-1) {
			answer += 1;
		}
		if(direction == 0) { // 가로
			if(rx >= 0 && ry+1 >= 0 && rx < n && ry+1 < n && map[rx][ry+1] != 1) {
				dfs(rx, ry+1, 0);
			}
			if(rx+1 >= 0 && ry+1 >= 0 && rx+1 < n && ry+1 < n &&  map[rx+1][ry] != 1 && map[rx][ry+1] != 1 && map[rx+1][ry+1] != 1) {
				dfs(rx+1, ry+1, 2);
			}
		}
		else if(direction == 1) { // 세로
			if(rx+1 >= 0 && ry >= 0 && rx+1 < n && ry < n && map[rx+1][ry] != 1) {
				dfs(rx+1, ry, 1);
			}
			if(rx+1 >= 0 && ry+1 >= 0 && rx+1 < n && ry+1 < n &&  map[rx+1][ry] != 1 && map[rx][ry+1] != 1 && map[rx+1][ry+1] != 1) {
				dfs(rx+1, ry+1, 2);
			}
		}
		else if(direction == 2) { // 대각선
			if(rx >= 0 && ry+1 >= 0 && rx < n && ry+1 < n && map[rx][ry+1] != 1) {
				dfs(rx, ry+1, 0);
			}

			if(rx+1 >= 0 && ry >= 0 && rx+1 < n && ry < n && map[rx+1][ry] != 1) {
				dfs(rx+1, ry, 1);
			}
			if(rx+1 >= 0 && ry+1 >= 0 && rx+1 < n && ry+1 < n &&  map[rx+1][ry] != 1 && map[rx][ry+1] != 1 && map[rx+1][ry+1] != 1) {
				dfs(rx+1, ry+1, 2);
			}
		}
	}
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		map = new int[n][n];
		dp = new int[n][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				map[i][j] = in.nextInt();
			}
		}
		
		dfs(0,1,0);
		System.out.println(answer);
	}
}
