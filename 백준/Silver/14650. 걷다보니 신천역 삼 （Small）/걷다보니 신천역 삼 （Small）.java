import java.util.*;
public class Main {
	static int answer = 0, n;
	static int[] arr = {0, 1, 2};
//	static HashSet<String> set = new HashSet<>();
	static void dfs(int count, String str) {
		if(count == n) {
			long sum = Integer.parseInt(str);
			if(sum > 0 && sum % 3 == 0 && sum/(Math.pow(10,n-1)) >= 1) {
				answer+=1;
//				set.add(str);
			}
			return;
		}
		for(int i=0; i<3; i++) {
			dfs(count + 1, str + arr[i]);
		}
	}
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		dfs(0,"");
//		System.out.println(set);
		System.out.println(answer);
	}
}