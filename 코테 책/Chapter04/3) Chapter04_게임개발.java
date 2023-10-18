import java.util.*;
public class Chapter04_���Ӱ��� {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int direction[][] = {{-1,0},{0,-1},{1,0},{0,1}}; //��, ��, ��, ��
		
		int n = in.nextInt(); // ����
		int m = in.nextInt(); // ����
		
		int[] player = new int[3]; //�÷��̾� ��ġ�� �ٶ󺸴� ����
		for(int i=0; i<3; i++) {
			player[i] = in.nextInt();
		}
				
		//����, �ٴ� ������ �Է�
		int[][] ground = new int[n][m];
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				ground[i][j] = in.nextInt();
			}
		}
		int visit[][] = ground;
		visit[player[1]][player[0]] = 1;
		int answer = 1;
		int go = 0;
		
		while(true) {
			player[2]++;
			player[2] %= 4;
			int x = player[1] + direction[player[2]][1];
			int y = player[0] + direction[player[2]][0];
			
			if(visit[y][x] == 0 && ground[y][x] == 0) {
				player[1] = x;
				player[0] = y;
				visit[y][x] = 1;
				answer++;
				go  = 0;
				continue;
			}
			else
				go++;
			
			if(go == 4) {
				x = player[1] - direction[player[2]][1];
				y = player[0] - direction[player[2]][0];
				go = 0;
				if(ground[y][x] == 0) {
					player[1] = x;
					player[0] = y;
				}
				else break;
			}
			
			
		}
		System.out.println(answer);
	}
}
