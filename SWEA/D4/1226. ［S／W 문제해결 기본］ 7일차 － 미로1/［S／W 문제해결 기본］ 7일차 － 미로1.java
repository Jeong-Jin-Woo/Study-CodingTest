import java.util.*;
class Position{
	public int x,y;
	Position(int x, int y){
		this.x=x;
		this.y=y;
	}
}
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int dx[] = {0,0,-1,1};
        int dy[] = {-1,1,0,0};
        for(int test=1; test<=10; test++) {
        	int t = in.nextInt();
        	int n = 16;
        	int[][] map = new int[n][n];
        	boolean[][] visit= new boolean[n][n];
        	Position des = null;
        	for(int i =0; i<n; i++) {
        		String str = in.next();
        		for(int j=0; j<n; j++) {
        			map[i][j] = str.charAt(j)-'0';
        			if(map[i][j] == 3) {
        				des = new Position(i, j);
        			}
        		}
        	}
        	Queue<Position> pos = new LinkedList<>();
        	pos.offer(new Position(1,1));
        	visit[1][1] = true;
        	while(!pos.isEmpty()) {
        		Position now = pos.poll();
        		for(int i=0; i<4; i++) {
        			int x = dx[i] + now.x;
        			int y = dy[i] + now.y;
        			if(!visit[x][y] && map[x][y] != 1) {
        				visit[x][y] = true;
        				pos.offer(new Position(x, y));
        			}
        		}
        	}
        	int answer = 1;
        	if(!visit[des.x][des.y]) {
        		answer = 0;
        	}
        	System.out.println("#" + t + " " + answer);
        }
    }
}
