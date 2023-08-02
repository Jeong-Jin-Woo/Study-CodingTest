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
public class Chapter13_21_인구이동 {
	static int n,l,r;
	static int totalcount = 0;
	static int[][] map = new int[51][51];
	static int[][] union = new int[51][51];
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	public static void process(int x, int y, int index) {
		ArrayList<Position> u = new ArrayList<>();
		u.add(new Position(x,y));
		Queue<Position> q = new LinkedList<>();
		q.offer(new Position(x,y));
		union[x][y] = index;
		int sum = map[x][y];
		int count = 1;
		while(!q.isEmpty()) {
			Position p = q.poll();
			int px = p.getX();
			int py = p.getY();
			for(int i=0; i<4; i++) {
				int nx = px + dx[i];
				int ny = py + dy[i];
				if(nx >= 0 && ny >= 0 && nx < n && ny < n && union[nx][ny] == -1) {
					int gap =  Math.abs(map[nx][ny] - map[px][py]);
					if(l <= gap && r >= gap) {
						union[nx][ny] = index;
						sum += map[nx][ny];
						count++;
						q.offer(new Position(nx,ny));
						u.add(new Position(nx,ny));
					}
				}
			}
		}
		for(int i=0; i<u.size(); i++) {
			map[u.get(i).getX()][u.get(i).getY()] = sum / count;
		}
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		l = in.nextInt();
		r = in.nextInt();
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				map[i][j] = in.nextInt();
			}
		}
		while(true) {
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					union[i][j] = -1;
				}
			}

			int index=0;
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(union[i][j] == -1) {
						process(i,j,index);
						index++;
					}
					
				}
			}
			
			if(index == n*n)
				break;
			totalcount++;
		}
		System.out.println(totalcount);
	}
	
}

/* dfs
import java.util.*;

class Nation implements Comparable<Nation> {
    int x;
    int y;
    int dif;

    Nation(int x, int y, int dif) {
        this.x = x;
        this.y = y;
        this.dif = dif;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getDif() {
        return dif;
    }

    @Override
    public int compareTo(Nation other) {
        return Integer.compare(this.dif, other.dif);
    }
}

public class Chapter13_21_인구이동 {
    static int[][] map = new int[51][51];
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int l = in.nextInt();
        int r = in.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = in.nextInt();
            }
        }

        int count = 0;
        while (true) {
            boolean moved = false;
            boolean[][] visited = new boolean[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j]) {
                        ArrayList<Nation> graph = new ArrayList<>();
                        dfs(i, j, n, l, r, visited, graph);

                        if (graph.size() > 1) {
                            int totalPopulation = 0;
                            for (Nation nation : graph) {
                                totalPopulation += map[nation.getX()][nation.getY()];
                            }

                            int avgPopulation = totalPopulation / graph.size();
                            for (Nation nation : graph) {
                                map[nation.getX()][nation.getY()] = avgPopulation;
                            }

                            moved = true;
                        }
                    }
                }
            }

            if (!moved) {
                break;
            }

            count++;
        }

        System.out.println(count);
    }

    private static void dfs(int x, int y, int n, int l, int r, boolean[][] visited, ArrayList<Nation> graph) {
        visited[x][y] = true;
        graph.add(new Nation(x, y, map[x][y]));

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[nx][ny]) {
                int diff = Math.abs(map[x][y] - map[nx][ny]);
                if (diff >= l && diff <= r) {
                    dfs(nx, ny, n, l, r, visited, graph);
                }
            }
        }
    }
}
*/