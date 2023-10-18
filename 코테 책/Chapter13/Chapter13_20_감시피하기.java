import java.util.*;
public class Chapter13_20_감시피하기 {
	static int n;
	static int r = 0;
	static int[][] map = new int[6][6];
	static int[][] tmap = new int[6][6];
	static String chk = "NO";
	
	public static boolean check() {
	    for(int i=0; i<n; i++) {
	        for(int j=0; j<n; j++) {
	            if(map[i][j] == 1) {
	                int x = i;
	                int y = j;
	                
	                while(x >= 0 && map[x][y] != 3) {
	                    if(map[x][y] == 2) return false;
	                    x--;
	                }
	                x = i;
	                
	                while(x < n && map[x][y] != 3) {
	                    if(map[x][y] == 2) return false;
	                    x++;
	                }
	                x = i;
	                
	                while(y >= 0 && map[x][y] != 3) {
	                    if(map[x][y] == 2) return false;
	                    y--;
	                }
	                y = j;
	                
	                while(y < n && map[x][y] != 3) {
	                    if(map[x][y] == 2) return false;
	                    y++;
	                }
	                y = j;
	            }
//	    		System.out.print(map[i][j]);
	        }
//			System.out.println();
	    }
	    return true; // 모든 위치를 확인하고 감시 가능한 경우라면 true 반환
	}

	public static void dfs(int rock, int cnt) {
		if(rock == 3) {	
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					tmap[i][j] = map[i][j];
				}
			}
			if(check()) {
				chk = "YES";
			}
			return;
		}
		for(int i=cnt; i<n*n; i++) {
			int x = i / n;
			int y = i % n;
			if(map[x][y] == 0) {
				map[x][y] = 3;
				rock++;
				dfs(rock, cnt+1);
				map[x][y] = 0;
				rock--;
			}
		}
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				String a = in.next();
				if(a.equals("T")) {
					map[i][j] = 1;
				}
				else if(a.equals("S")) {
					map[i][j] = 2;
				}
				else {
					map[i][j] = 0;
				}
			}
		}
		
		dfs(0, 0);

//		for(int i=0; i<n; i++) {
//			for(int j=0; j<n; j++) {
//				System.out.print(tmap[i][j]);
//			}System.out.println();
//		}
		System.out.println(chk);
	}
}