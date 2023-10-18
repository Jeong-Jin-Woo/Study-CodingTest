import java.util.*;
public class Chapter05_3_음료수얼려먹기{
	static int[][] tray = new int[1000][1000];
	static int n=0, m=0;
	public static boolean dfs(int x, int y) {
		if(x <= -1 || y <= -1 || x>=n || y >= m) {
			return false;
		}
		if(tray[x][y] == 0) {
			tray[x][y] = 1;
			dfs(x-1,y);
			dfs(x+1,y);
			dfs(x,y-1);
			dfs(x,y+1);
			return true;
		}
		return false;
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		m = in.nextInt();
		in.nextLine();
		
		for(int i=0; i<n; i++) {
			String str = in.nextLine();
			for(int j=0; j<m; j++) {
				tray[i][j] = str.charAt(j) - '0';
			}
		}
		
		int answer = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(dfs(i,j))
					answer++;
			}
		}
		System.out.println(answer);
	}
}
























/*
public class Chapter05_3_음료수얼려먹기 {
	static int m, n;
	static int tray[][] = new int[1000][1000];
	public static boolean dfs(int x, int y) {
		if(x<0 || y<0 || x>n-1 || y >m-1)
			return false;
		if(tray[x][y] == 0) {
			tray[x][y] = 1;//?
			dfs(x, y-1);
			dfs(x, y+1);
			dfs(x-1, y);
			dfs(x+1, y);
			return true;//?
		}
		return false;
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		m = in.nextInt();
		//in.nextLine();
		for(int i=0 ;i<n; i++) {
			//String str = in.nextLine();
			for(int j=0; j<m; j++) {
				//tray[i][j] = str.charAt(j) - '0';
				tray[i][j] = in.nextInt();
			}
		}
		int answer=0;
		for(int i=0;i<n;i++) {
			for(int j=0; j<m; j++) {
				if(dfs(i, j)==true)
					answer++;
			}
		}
		System.out.println(answer);
		
	}
}
*/