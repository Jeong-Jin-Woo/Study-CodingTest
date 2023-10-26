import java.util.*;
class Position{
	public int x;
	public int y;
	Position(int x, int y){
		this.x=x;
		this.y=y;
	}
}
public class Main {
	static final int INF = (int)1e9;
	static int n,m;
	static int dp[];
//	static ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
//	static void dfs(int index, int start, int count, boolean visit[]) {
//		if(start == 1) {
//			dp[index] = count;
//			return;
//		}
//		visit[start] = true;
//		for(int i=0; i< arr.get(start).size(); i++) {
//			if(!visit[arr.get(start).get(i)]) {
//				visit[arr.get(start).get(i)] = true;
//				dfs(index, arr.get(start).get(i), count+1, visit);
//			}
//		}
//	}
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		m = in.nextInt();
		dp = new int[n+1];
//		for(int i=0; i<=n; i++)
//			arr.add(new ArrayList<Integer>());
		Arrays.fill(dp, INF);
//		for(int i=0; i<m; i++) {
//			int a = in.nextInt();
//			int b = in.nextInt();
//			arr.get(a).add(b);
//			arr.get(b).add(a);
//		}
//		dp[1] = 0;
//		for(int i=2; i<=n; i++) {
//			boolean[] visit = new boolean[n+1];
//			dfs(i, i, 0, visit);
//		}
		ArrayList<Position> arr= new ArrayList<>();
		dp[1] = 0;
		for(int i=0; i<m; i++) {
			int a = in.nextInt();
			int b = in.nextInt();
			dp[a] = Math.min( dp[b] + 1 , dp[a]);
			dp[b] = Math.min( dp[a] + 1 , dp[b]);
			arr.add(new Position(a,b));
		}
		int q = in.nextInt();
		for(int i=0; i<q; i++) {
			int a = in.nextInt();
			int b = in.nextInt();
			dp[a] = Math.min( dp[b] + 1 , dp[a]);
			dp[b] = Math.min( dp[a] + 1 , dp[b]); 
			arr.add(new Position(a,b));
			for(int s=0; s<arr.size(); s++) {
				a = arr.get(s).x;
				b = arr.get(s).y;
				dp[a] = Math.min( dp[b] + 1 , dp[a]);
				dp[b] = Math.min( dp[a] + 1 , dp[b]); 
			}
			for(int s=1; s<=n; s++)
				if(dp[s] == INF)
					System.out.print("-1 ");
				else
					System.out.print(dp[s] + " ");
			System.out.println();
		}
		
	}
}