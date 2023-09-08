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
public class ¹Ì·ÎÅ½»ö{
	static int dx[] = {0,0,-1,1};
	static int dy[] = {-1,1,0,0};
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int[][] map = new int[n+2][m+2];
		for(int i=1; i<=n; i++) {
			String line = in.next();
			for(int j=1; j<=line.length(); j++) {
				map[i][j] = Integer.valueOf(line.charAt(j-1) - '0');
			}
		}
		ArrayList<Position> visit = new ArrayList<>();
		Queue<Position> pos = new LinkedList<>();
		pos.offer(new Position(1,1));
		visit.add(new Position(1,1));
		int[][] vmap = new int[n+2][m+2];
		vmap[1][1] = 1;
		
		while(!pos.isEmpty()) {
			Position now = pos.poll();
			int x = now.getX();
			int y = now.getY();
			for(int i=0; i<4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				boolean chk = false;
				for(int a=0; a<visit.size(); a++) {
					if(visit.get(a).getX() == nx && visit.get(a).getY() == ny) {
						chk = true;
						break;
					}
				}
				if(map[nx][ny] == 1 && !chk) {
					vmap[nx][ny] += vmap[x][y] + 1;
					visit.add(new Position(nx, ny));
					pos.offer(new Position(nx, ny));
				}
			}
		}
		System.out.println(vmap[n][m]);
		
	}
}
