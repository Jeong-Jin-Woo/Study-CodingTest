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
		this.x =x;
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
}

public class ¹ì{
	static int n,k,l;
	static ArrayList<Node> arr = new ArrayList<>();
	static int[][] map = new int[101][101];
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	public static int turn(int direction, char pos) {
		if(pos == 'L') direction = (direction == 0 ? 3 : direction--);
		else direction = (direction == 3 ? 0 : direction++);
		return direction;
	}
	public static int simulation() {
		int x = 1, y = 1;
		int count = 0;
		int direction = 0;
		int index = 0;
		Queue<Position> pos = new LinkedList<>();
		map[x][y] = 2;
		pos.offer(new Position(x,y));
		while(true) {
			int nx = x + dx[direction];
			int ny = y + dy[direction];
			if(nx > n  || ny > n || nx < 0 || ny < 0 || map[nx][ny] == 2) {
				count++;
				break;
			}
			else {
				if(map[nx][ny] == 1) {
					map[nx][ny] = 2;
					pos.offer(new Position(nx,ny));
				}
				if(map[nx][ny] == 0) {
					map[nx][ny] = 2;
					pos.offer(new Position(nx,ny));
					Position now = pos.poll();
					map[now.getX()][now.getY()] = 0;
				}
				count++;
			}
			
			x = nx;
			y = nx;
			if(index < l && arr.get(index).getTime() == count) {
				direction = turn(direction, arr.get(index).getLoc());
				index++;
			}
		}
		return count;
	}
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		k = in.nextInt();
		
		//»ç°ú
		for(int i=0; i<k; i++) {
			int a = in.nextInt();
			int b = in.nextInt();
			map[a][b] = 1;
		}
		
		l = in.nextInt();
		for(int i=0; i<l; i++) {
			int a= in.nextInt();
			char b= in.next().charAt(0);
			arr.add(new Node(a, b));
		}
		
		System.out.println(simulation());
		
	}
}