import java.util.*;

class Position {
	int x;
	int y;
	int dist;

	Position(int x, int y, int dist) {
		this.x = x;
		this.y = y;
		this.dist = dist;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getDist() {
		return dist;
	}
}

public class Main {
	static final int INF = (int) -1e9;
	static int n;
	static int[][] map;
	static int dx[] = { -1, 0, 1, 0 };
	static int dy[] = { 0, -1, 0, 1 };

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		map = new int[n][n];
		Queue<Position> pos = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = in.nextInt();
				if (map[i][j] == 9) {
					pos.offer(new Position(i, j, 2));
					map[i][j] = 0;
				}
			}
		}
		int size = 2;
		int time = 0;
		int ate = 0;
		while (true) {
			ArrayList<Position> fish = new ArrayList<>();
			int[][] dist = new int[n][n];
			while (!pos.isEmpty()) {
				Position now = pos.poll();
				int x = now.getX();
				int y = now.getY();
				for (int i = 0; i < 4; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];
					if (nx >= 0 && ny >= 0 && nx < n && ny < n && map[nx][ny] <= size && dist[nx][ny] == 0) {
						dist[nx][ny] = dist[x][y] + 1;
						pos.offer(new Position(nx, ny, dist[nx][ny]));
						if (map[nx][ny] != 0 && map[nx][ny] < size)
							fish.add(new Position(nx, ny, dist[nx][ny]));
					}
				}
			}
			if (fish.size() == 0) {
				System.out.println(time);
				return;
			} else {
				Position now = fish.get(0);
				for (int i = 1; i < fish.size(); i++) {
					if (now.getDist() > fish.get(i).getDist()) {
						now = fish.get(i);
					} else if (now.getDist() == fish.get(i).getDist()) {
						if (now.getX() > fish.get(i).getX())
							now = fish.get(i);
						else if (now.getX() == fish.get(i).getX())
							if (now.getY() > fish.get(i).getY())
								now = fish.get(i);
					}
				}
				time += now.getDist();
				ate += 1;
				map[now.getX()][now.getY()] = 0;
				if (size == ate) {
					size += 1;
					ate = 0;
				}
				pos.add(new Position(now.getX(), now.getY(), 0));
			}
		}

	}
}