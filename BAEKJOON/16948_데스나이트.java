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
public class 데스나이트{
	static int dx[] = {-2, -2, 0, 0, 2, 2};
	static int dy[] = {-1, 1, -2, 2, -1, 1};
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int startX = in.nextInt();
		int startY = in.nextInt();
		int endX = in.nextInt();
		int endY = in.nextInt();

		int[][] map = new int[n][n];
		ArrayList<Position> visit = new ArrayList<>();
		Queue<Position> pos = new LinkedList<>();
		pos.offer(new Position(startX, startY));
		visit.add(new Position(startX, startY));
		map[startX][startY] = 0;
		
		while(!pos.isEmpty()) {
			Position now = pos.poll();
			int x = now.getX();
			int y = now.getY();
			for(int i=0; i<6; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				boolean chk = false;
				for(int s=0; s<visit.size(); s++) {
					if(visit.get(s).getX() == nx && visit.get(s).getY() == ny) {
						chk = true;
						break;
					}
				}
				if(!chk && nx >=0 && ny >= 0 && nx < n && ny < n) { 
					map[nx][ny] += map[x][y] + 1;// visit없애고 Math.min()
					visit.add(new Position(nx,ny));
					pos.offer(new Position(nx, ny));
				}
			}
			
		}
		if(map[endX][endY] != 0)
			System.out.println(map[endX][endY]);
		else
			System.out.println(-1);
		
	}
}
