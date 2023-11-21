import java.util.*;
public class Main{
	static final int INF = (int)1e9;
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		String[] n = in.next().split("\\-");
		int sum = INF;
		for(int i=0; i<n.length; i++) {
			int tmp = 0;
			String[] s = n[i].split("\\+");
			for(int j=0; j<s.length; j++)
				tmp += Integer.valueOf(s[j]);
			if(sum == INF) {
				sum = tmp;
			}
			else {
				sum -= tmp;
			}
		}
		System.out.println(sum);
	}
}
