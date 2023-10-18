import java.util.*;
class Node implements Comparable<Node>{
	int x;
	int y;
	int num;
	int sec;
	Node(int x, int y, int num, int sec){
		this.x = x;
		this.y = y;
		this.num = num;
		this.sec = sec;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getNum() {
		return num;
	}
	public int getSec() {
		return sec;
	}
	@Override
	public int compareTo(Node other) {
		return Integer.compare(num, other.num);
	}
}
public class °æÀïÀûÀü¿° {
	static int n,k,s,a,b;
	static int map[][] = new int[200][200];
	static Queue<Node> q = new LinkedList<>();
	static ArrayList<Node> virus = new ArrayList<>(); // ³·Àº ¹ÙÀÌ·¯½ººÎÅÍ
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		k = in.nextInt();
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				map[i][j] = in.nextInt();
				if(map[i][j] != 0) {
					virus.add(new Node(i,j,map[i][j], 0));
				}
			}
		}
		s = in.nextInt();
		a = in.nextInt();
		b = in.nextInt();
		
		Collections.sort(virus);
		for(int i=0; i<virus.size(); i++) {
			q.offer(virus.get(i));
		}
		
		while(!q.isEmpty()) {
			Node now = q.poll();
			int x = now.getX();
			int y = now.getY();
			int num = now.getNum();
			int second = now.getSec();
			if(second == s) break;
			for(int i=0; i<4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx < n && ny < n && nx >= 0 && ny >= 0 && map[nx][ny] == 0) {
					map[nx][ny] = num;
					q.offer(new Node(nx,ny,num,second+1));
				}
			}
		}
		
		System.out.println(map[a-1][b-1]);
		
//		for(int i=0; i<n; i++) {
//			for(int j=0; j<n; j++) {
//				System.out.print(map[i][j]);
//			}
//			System.out.println();
//		}
		
	}
}