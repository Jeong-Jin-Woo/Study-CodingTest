			import java.util.*;
			public class 안전영역{
				static int n;
				static boolean visit[][] = new boolean[100][100];
				public static boolean dfs(int x, int y) {
					if(x >= n || y >= n || x < 0 || y < 0) return false;
					if(visit[x][y] == true) {
						visit[x][y] = false;
						dfs(x-1,y);
						dfs(x+1,y);
						dfs(x,y-1);
						dfs(x,y+1);
						return true;
					}
					return false;
				}
				public static void main(String args[]) {
					Scanner in = new Scanner(System.in);
					n = in.nextInt();
					int[][] map = new int[n][n];
					int height = 0;
					for(int i=0; i<n; i++) {
						for(int j=0; j<n; j++) {
							map[i][j] = in.nextInt();
							height = Math.max(map[i][j], height);
						}
					}
					
					
					int max = 1;
					while(true) {
						if(height < 1) break;
						for(int i=0; i<n; i++)
							Arrays.fill(visit[i], false);
						
						for(int i=0; i<n; i++) {
							for(int j=0; j<n; j++) {
								if(map[i][j] > height) {
									visit[i][j] = true;
								}
							}
						}
						int sum = 0;
						for(int i=0; i<n; i++) {
							for(int j=0; j<n; j++) {
								if(dfs(i,j)) {
									sum++;
								}
							}
						}
						max = Math.max(max, sum);
						
						height-=1;
						
					}
					System.out.println(max);
				}
			}