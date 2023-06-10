import java.util.*;

public class Chapter04_왕실의나이트 {
	public static void main(String[] args) {
			Scanner in = new Scanner(System.in);
			String[] local = in.next().split("");
			int[] current = new int[2];
			
			int[][] move = {{2, 1},{2,-1},{1,-2},{1,2},{-2,-1},{-2,1},{-1,-2},{-1,2}};
			
			int answer = 0;
			
			for(int i=0; i<move.length; i++) {
				current[0] = Integer.valueOf(local[0].charAt(0)-'a') + 1;
				current[1] = Integer.valueOf(local[1]);
				for(int j=0; j<move[i].length; j++) {
					current[j] += move[i][j];
				}
				if(current[0] > 0 && current[1] > 0 && current[0] < 9 && current[1] < 9)
					answer++;
			}
			System.out.println("경우의 수 : " + answer);
	}

}
