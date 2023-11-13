import java.util.*;
public class Main{
	static int n,k;
	static int[] arr;
	static boolean[] visit;
	static HashSet<String> has = new HashSet<>();
	static void dfs(int count, String str) {
		if(count == k) {
			has.add(str);
			return;
		}
		for(int i=0; i<n; i++) {
			if(!visit[i]){
				visit[i] = true;
				dfs(count+1, arr[i] + str);
				visit[i] = false;
			}
		}
	}
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		k = in.nextInt();
		arr = new int[n];
		visit = new boolean[n];
		for(int i=0; i<n; i++) {
			arr[i] = in.nextInt();
		}
		dfs(0, "");
		System.out.println(has.size());
	}
}
