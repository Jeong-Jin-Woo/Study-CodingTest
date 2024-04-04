import java.util.*;

public class Main {
	static char map[][] = new char[3][3];
	static boolean xCheck(int x, int o) {
		boolean ret = false;
		for(int i=0; i<3; i++) {
			if(map[i][1] == map[i][0] && map[i][1] == map[i][2] && map[i][1] == 'X') ret = true;
		}
		for(int i=0; i<3; i++) {
			if(map[0][i] == map[1][i] && map[1][i] == map[2][i] && map[0][i] == 'X')  ret = true;
		}
		if(map[0][0] == map[1][1] && map[1][1] == map[2][2]&& map[0][0] == 'X') ret = true;
		if(map[0][2] == map[1][1] && map[1][1] == map[2][0]&& map[0][2] == 'X')  ret = true;
		return ret;
	}
	static boolean oCheck(int x, int o) {
		boolean ret = false;
		for(int i=0; i<3; i++) {
			if(map[i][1] == map[i][0] && map[i][1] == map[i][2] && map[i][1] == 'O')  ret = true;
		}
		for(int i=0; i<3; i++) {
			if(map[0][i] == map[1][i] && map[1][i] == map[2][i] && map[0][i] == 'O')  ret = true;
		}
		if(map[0][0] == map[1][1] && map[1][1] == map[2][2]&& map[0][0] == 'O')  ret = true;
		if(map[0][2] == map[1][1] && map[1][1] == map[2][0]&& map[0][2] == 'O') ret = true;
		return ret;
	}
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		while(true) {
			String str = in.next();
			map = new char[3][3];
			int countX = 0;
			int countO = 0;
			if(str.equals("end")) break;
			else {
				for(int i=0; i<str.length(); i++) {
					map[i/3][i%3] = str.charAt(i);
					if(map[i/3][i%3] == 'X') {
						countX += 1;
					}
					else if(map[i/3][i%3]  =='O') {
						countO += 1;
					}
				}
			}
			boolean Xcheck = xCheck(countX, countO);
			boolean Ocheck = oCheck(countX, countO);
			if(Xcheck && !Ocheck && countX == countO + 1) {
				sb.append("valid\n");
			}
			else if(!Xcheck && Ocheck && countX == countO) {
				sb.append("valid\n");
			}
			else if(!Xcheck && !Ocheck && countX == 5 && countO == 4) {
				sb.append("valid\n");
			}
			else {
				sb.append("invalid\n");
			}
//			for(int i=0; i<3; i++) {
//				for(int j=0; j<3; j++) {
//					System.out.print(map[i][j]+ " ");
//				}System.out.println();
//			}System.out.println();
		}
		System.out.println(sb);
	}
}
