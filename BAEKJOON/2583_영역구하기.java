import java.util.*;
public class 영역구하기{
	static int n, m, k;
	static int area = 1;
	static int[][] map = new int[100][100];
	static int[][] vmap = new int[100][100];
	public static boolean dfs(int x, int y) {
		if(x < 0 || y <0 || x >= n || y >= m) {
			return false;
		}
		if(map[x][y] == 1) {
			map[x][y] = 0;
			vmap[x][y] = area;
			dfs(x-1,y);
			dfs(x+1,y);
			dfs(x,y-1);
			dfs(x,y+1);
			return true;
		}
		return false;
	}
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		m = in.nextInt();
		n = in.nextInt();
		k = in.nextInt();
		for(int i=0; i<map.length; i++) {
			Arrays.fill(map[i], 1);
		}
		for(int i=0; i<k; i++) {
			int x = in.nextInt();
			int y = in.nextInt();
			int a = in.nextInt();
			int b = in.nextInt();
			for(int j=x; j<a; j++) {
				for(int k = y; k<b; k++) {
					map[j][k] = 0;
				}
			}
		}
		int count = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(dfs(i,j)) {
					count++;
					area++;
				}
			}
		}
		area -= 1;
		int[] answer = new int[area];
		for(int a=1; a<=area; a++) {
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					if(vmap[i][j] == a) {
						answer[a-1]++;
					}
				}
			}
		}
		Arrays.sort(answer);
		System.out.println(count);
		for(int i=0; i<area; i++) {
			System.out.print(answer[i]+" ");
		}
	}
}