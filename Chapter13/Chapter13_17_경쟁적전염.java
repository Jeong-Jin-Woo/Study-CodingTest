import java.util.*;
class Virus implements Comparable<Virus>{
	int x;
	int y;
	int num;
	int sec;
	Virus(int x, int y, int num, int sec){
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
	public int compareTo(Virus other) {
		return Integer.compare(num, other.getNum());
	}
}
public class Chapter13_17_°æÀïÀûÀü¿° {
	static int n, k;
	static int arr[][] = new int[201][201];
	static ArrayList<Virus> graph = new ArrayList<>();
	static int dx[] = {0, 0, 1, -1};
	static int dy[] = {-1, 1, 0 , 0};
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		k = in.nextInt();
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				int a = in.nextInt();
				arr[i][j] = a;
				if(arr[i][j] != 0)
					graph.add(new Virus(i,j,a,0));
			}
		}

		int s = in.nextInt();
		int x = in.nextInt();
		int y = in.nextInt();
		
		Collections.sort(graph);
		
		Queue<Virus> q = new LinkedList<>();
		for(int i=0; i<graph.size(); i++)
			q.offer(graph.get(i));
		
		while(!q.isEmpty()) {
			Virus v = q.poll();
			int vX = v.getX();
			int vY = v.getY();
			int vNum = v.getNum();
			int vSec = v.getSec();
			if(s==vSec) break;
			for(int i=0; i<4; i++) {
				int nx = vX + dx[i];
				int ny = vY + dy[i];
				if(nx>=0 && ny>=0 && nx <n && ny<n) {
					if(arr[nx][ny] == 0) {
						arr[nx][ny] = vNum;
						q.offer(new Virus(nx, ny, vNum, vSec+1));
					}
				}
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
		System.out.println(arr[x-1][y-1]);
	}
}
/*
//dfs¾µ½Ã ÃÖ¾ÇÀÎ°æ¿ì ºñÈ¿À²ÀûÀÎ ½ÇÇà¼Óµµ -> bfs
import java.util.*;
public class Chapter13_17_°æÀïÀûÀü¿° {
	static int n, k;
	static int arr[][] = new int[201][201];
	static int barr[][] = new int[201][201];
	static int dx[] = {0, 0, 1, -1};
	static int dy[] = {-1, 1, 0 , 0};
	public static void dfs(int y, int x, int num) {
		for(int i=0; i<4; i++) {
			int nx = dx[i] + x;
			int ny = dy[i] + y;
			if(nx >= 0 && ny >= 0 && nx < n && ny <n) {
				if(barr[y][x]==num) {
					if(arr[ny][nx] == 0) {
						arr[ny][nx] = num;
						dfs(ny,nx,num);
					}
				}
			}
			
		}
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		k = in.nextInt();

		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				int a = in.nextInt();
				arr[i][j] = a;
				barr[i][j] = arr[i][j];
			}
		}

		int s = in.nextInt();
		int x = in.nextInt();
		int y = in.nextInt();
		
		for(int i=0; i<s; i++) {
			for(int j=1; j<=k; j++)
				for(int a=0; a<n; a++) {
					for(int b=0; b<n; b++) {
						dfs(a,b,j);
					}
				}
			for(int a=0;a<n; a++) {
				for(int b=0; b<n; b++)
					barr[a][b] = arr[a][b];
			}
		}
		System.out.println(arr[x-1][y-1]);
	}
}
*/