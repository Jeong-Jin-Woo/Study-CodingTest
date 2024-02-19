import java.util.*;
public class Main {
	static ArrayList<ArrayList<Integer>> small = new ArrayList<>();
	static ArrayList<ArrayList<Integer>> big = new ArrayList<>();
	static int n, m;
	static int answer = 0;
	static boolean[] visit;
	static void dfs_small(int start) {
		if(!visit[start]) {
			visit[start] = true;
			for(int i=0; i<small.get(start).size(); i++) {
				dfs_small(small.get(start).get(i));
			}
		}
	}
	static void dfs_big(int start) {
		if(!visit[start]) {
			visit[start] = true;
			for(int i=0; i<big.get(start).size(); i++) {
				dfs_big(big.get(start).get(i));
			}
		}
	}
	static boolean chk() {
		for(int i=1; i<=n; i++) {
			if(!visit[i]) return false;
		}
		return true;
	}
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		m = in.nextInt();
		for(int i=0; i<=n; i++) {
			small.add(new ArrayList<>());
			big.add(new ArrayList<>());
		}
		for(int i=0; i<m; i++) {
			int a = in.nextInt();
			int b = in.nextInt();
			big.get(a).add(b);
			small.get(b).add(a);
		}
		for(int i=1; i<=n; i++) {
			visit = new boolean[n+1];
			dfs_small(i);
			visit[i] = false;
			dfs_big(i);
//			System.out.print(i + " : ");
//			for(int j=1; j<=n; j++) {
//				System.out.print(visit[j] + " ");
//			}System.out.println();
			if(chk()) {
				answer += 1;
			}
		}
		System.out.println(answer);
		
	}
}