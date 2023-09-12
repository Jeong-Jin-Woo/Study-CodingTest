import java.util.*;
public class ¹ÌÄ£·Îº¿{
	static int n;
	static double[] percent = new double[4];
	static double total = 0;
	static int[][] map = new int[30][30];
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	public static void dfs(int x, int y, int num, double sum) {
		if(num == n) {
			total += sum;
			return;
		}
		map[x][y] = 1;
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx >= 0 && ny >= 0 && nx < 30 & ny < 30) {
				if(map[nx][ny] == 0) {
					map[nx][ny] = 1;
					dfs(nx, ny, num + 1, sum * percent[i]);
					map[nx][ny] = 0;
				}
			}
		}
	}
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt(); //ÃÑ È½¼ö´Â 4^n
		for(int i=0; i<4; i++) {
			percent[i] = in.nextInt() * 0.01;
		}
		dfs(15, 15, 0, 1);
		System.out.println(total);
	}
}