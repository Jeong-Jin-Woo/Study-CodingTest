import java.util.*;
public class Main{
	static int n;
	static int answer = 0;

	static void dfs(int index, int num, int sign, int sum, String str) {
		if (index == n) {
			sum += num * sign;
			if (sum == 0)
				System.out.println(str);
			return;
		}
		dfs(index + 1, (num * 10) + (index + 1), sign, sum, str + " " + String.valueOf(index + 1));
		dfs(index + 1, index + 1, 1, sum + num * sign, str + "+" + String.valueOf(index + 1));
		dfs(index + 1, index + 1, -1, sum + num * sign, str + "-" + String.valueOf(index + 1));
	}
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int c = in.nextInt();
		while(c-- != 0) {
			n = in.nextInt();
			dfs(1, 1, 1, 0, "1");
			System.out.println();
		}
	}	
}