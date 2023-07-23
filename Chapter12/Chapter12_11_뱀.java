import java.util.*;
class Node{
	int time;
	char loc;
	Node(int time, char loc){
		this.time = time;
		this.loc = loc;
	}
	public int getTime() {
		return time;
	}
	public char getLoc() {
		return loc;
	}
}
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
public class Chapter12_11_뱀 {
	//우, 하, 좌, 상
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static int n,k,l;
	static ArrayList<Node> arr = new ArrayList<>();
	static int[][] map = new int[101][101];
    public static int turn(int direction, char c) {
        if (c == 'L') direction = (direction == 0)? 3 : direction - 1;
        else direction = (direction + 1) % 4;
        return direction;
    }
    
	public static int simulation() {
		int x = 1, y = 1;
		map[x][y] = 2;
		int count = 0;
		int direction = 0;
		int index = 0;
		Queue<Position> q = new LinkedList<>();
		q.offer(new Position(x,y));
		while(true) {
			int nx = x + dx[direction];
			int ny = y + dy[direction];
			
			if(nx > n || ny > n || nx < 0 || ny < 0 || map[nx][ny] == 2) {
				count++;
				break;
			}
			else {
				if(map[nx][ny] == 1) { //사과
					map[nx][ny] = 2;
					q.offer(new Position(nx,ny));
				}
				if(map[nx][ny] == 0) {
					map[nx][ny] = 2;
					q.offer(new Position(nx,ny));
					Position p = q.poll();
					int px = p.getX();
					int py = p.getY();
					map[px][py] = 0;
				}
				count++;
			}
			
			x = nx;
			y = ny;
			if(index < l && arr.get(index).getTime() == count) {
				direction = turn(direction, arr.get(index).getLoc());
				index++;
			}
		}
		
		return count;
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		
		k = in.nextInt();
        // 맵 정보(사과 있는 곳은 1로 표시)
        for (int i = 0; i < k; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            map[a][b] = 1;
        }

        // 방향 회전 정보 입력
        l = in.nextInt();
        for (int i = 0; i < l; i++) {
            int a = in.nextInt();
            char c = in.next().charAt(0);
            arr.add(new Node(a, c));
        }
        
		System.out.println(simulation());
	}
}