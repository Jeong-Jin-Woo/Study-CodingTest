import java.util.*;
class Position {
	public int x, y;
	Position(int x, int y){
		this.x=x;
		this.y=y;
	}
}
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
    	int T = in.nextInt();
    	int dx[] = {0,0,1,-1};
    	int dy[] = {-1,1,0,0};
        for(int test=1; test<=T; test++) {
        	int n = in.nextInt();
        	int[][] map = new int[n][n];
        	boolean[][] visit = new boolean[n][n];
        	for(int i=0; i<n; i++) {
        		String str = in.next();
        		for(int j=0; j<n; j++) {
        			map[i][j] = str.charAt(j)-'0';
        		}
        	}
        	Queue<Position> q = new LinkedList<>();
        	int x = n/2;
        	int y = n/2;
        	q.offer(new Position(x, y));
        	visit[x][y] = true;
        	int answer = map[x][y];
        	for(int a=0;a<n/2;a++) {
        		int len = q.size();
        		for(int b=0;b<len;b++) {
        		Position now = q.poll();
        		x = now.x;
        		y = now.y;
        		for(int i=0; i<4; i++) {
        			int nx = x + dx[i];
        			int ny = y + dy[i];
        			if(nx >= 0 && ny >= 0 && nx < n && ny < n && !visit[nx][ny]) {
        				visit[nx][ny] = true;
        				answer += map[nx][ny];
    					q.offer(new Position(nx, ny));
        			}
        		}
        		}
        	}
        	System.out.println("#"+test+ " " + answer);
        }
    }
}
