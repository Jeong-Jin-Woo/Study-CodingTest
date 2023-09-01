import java.util.*;
class Position{
	int x;
	int y;
	Position(int x, int y){
		this.x = x;
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
}
public class 감시피하기 {
	static ArrayList<Position> tc = new ArrayList<>();
	static char[][] map = new char[6][6];
	static char[][] bmap = new char[6][6];
	static int n, stu;
	static boolean chk = false;
	
	public static boolean chk(char[][] map) {
		int cnt = 0;
		for(int i=0; i<tc.size(); i++) {
			int x = tc.get(i).getX();
			int y = tc.get(i).getY();
			for(int j=x; j>=0; j--) {
				if(map[y][j] == 'O') break;
				map[y][j] = 'T';
			}
			for(int j=x; j<n; j++) {
				if(map[y][j] == 'O') break;
				map[y][j] = 'T';
			}
			for(int j=y; j>=0; j--) {
				if(map[j][x] == 'O') break;
				map[j][x] = 'T';
			}
			for(int j=y; j<n; j++) {
				if(map[j][x] == 'O') break;
				map[j][x] = 'T';
			}
		}
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(map[i][j] == 'S')
					cnt++;
			}
		}
		if(cnt == stu) return true;
		return false;
	}
	public static void dfs(int start) {
		if(start == 3) {
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					bmap[i][j] = map[i][j];
				}
			}
			if(chk(bmap) && !chk) chk = true;
			return;
		}
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(map[i][j] == 'X') {
					start+=1;
					map[i][j] = 'O';
					dfs(start);
					start-=1;
					map[i][j] = 'X';
				}
			}
		}
	}
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				map[i][j] = in.next().charAt(0);
				if(map[i][j] == 'T')
					tc.add(new Position(j,i));
				if(map[i][j] == 'S')
					stu++;
			}
		}
		dfs(0);
		
		if(chk) System.out.println("YES");
		else System.out.println("NO");
	}
}