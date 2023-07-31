import java.util.*;
public class Chapter13_20_감시피하기 {
	static int n;
	static int[][] map = new int[6][6];
	static int[][] tmap = new int[6][6];
	static String chk = "NO";
	static int cntStudent=0;
	
	public static boolean check() {
		int cnt = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(map[i][j] == 1) {
					for(int di = i; di >=0; di--) { //상
						if(map[di][j] == 3) break;
						tmap[di][j] = 1;
					}
					for(int di = i; di < n; di++) { //하
						if(map[di][j] == 3) break;
						tmap[di][j] = 1;
					}

					for(int di = j; di >=0; di--) { //좌
						if(map[i][di] == 3) break;
						tmap[i][di] = 1;
					}

					for(int di = j; di < n; di++) { //우
						if(map[i][di] == 3) break;
						tmap[i][di] = 1;
					}
				}
				
//				System.out.print(tmap[i][j]);
			}
//			System.out.println();
		}
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(tmap[i][j] == 2)
					cnt++;
			}
		}
				if(cnt == cntStudent) 
					return true;
		return false;
	}
	public static void dfs(int rock, int r) {
		r++;
		if(r > n) {
			chk = "NO";
			return;
		}
		if(rock == 3) {	
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					tmap[i][j] = map[i][j];
				}
			}
			if(check()) {
				chk = "YES";
				return;
			}
		}
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(map[i][j] == 0) {
					map[i][j] = 3;
					rock++;
					dfs(rock, r);
					map[i][j] = 0;
					rock--;
				}
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
					cntStudent++;
				}
				else {
					map[i][j] = 0;
				}
				tmap[i][j] = map[i][j];
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