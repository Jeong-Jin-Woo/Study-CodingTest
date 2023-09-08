import java.util.*;
public class 바이러스{
	static int[][] arr = new int[100][100];
	static boolean[] chk = new boolean[100];
	static int n, m, count = 0;
	
	public static int dfs(int start) {
		chk[start] = true;
		for(int i=1; i<=n; i++) {
			if(arr[start][i] == 1 && !chk[i]) {
				count++;
				dfs(i);
			}
		}
		return count;
	}
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		m = in.nextInt();
		for(int i=1; i<=m; i++) {
			int a = in.nextInt();
			int b = in.nextInt();
			arr[a][b] = 1;
			arr[b][a] = 1;
		}
		System.out.println(dfs(1));
	}
}

/*

//BFS
import java.util.*;
public class 바이러스{
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
		for(int i=0; i<=n; i++) {
			arr.add(new ArrayList<Integer>());
		}
		
		for(int i=1; i<=m; i++) {
			int a = in.nextInt();
			int b = in.nextInt();
			arr.get(a).add(b);
			arr.get(b).add(a);
		}
		ArrayList<Integer> visit = new ArrayList<>();
		Queue<Integer> q = new LinkedList<>();
		int answer = 0;
		visit.add(1);
		for(int i=0; i<arr.get(1).size(); i++) {
			q.offer(arr.get(1).get(i));
			visit.add(arr.get(1).get(i));
			answer+=1;
		}
		while(!q.isEmpty()) {
			int x = q.poll();
			for(int i=0; i<arr.get(x).size(); i++) {
				int num = arr.get(x).get(i);
				boolean chk = false;
				for(int s=0; s<visit.size(); s++) {
					if(visit.get(s) == num) {
						chk = true;
						break;
					}
				}
				if(!chk) {
					answer += 1;
					q.offer(num);
					visit.add(num);
				}
			}
		}
		System.out.println(answer);
	}
}

*/