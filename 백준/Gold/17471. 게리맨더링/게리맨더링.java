import java.util.*;
public class Main{
	static ArrayList<ArrayList<Integer>> node = new ArrayList<>();
	static int[] num;
	static boolean[] check;
	static int n;
	static final int INF = (int) 1e9;
	static int answer = INF;
	static boolean chk(ArrayList<Integer> list) {
		boolean[] visit = new boolean[n+1];
		Arrays.fill(visit, true);
		for(int i=0; i<list.size(); i++) {
			visit[list.get(i)] = false;
		}
		Queue<Integer> q = new LinkedList<>();
		q.offer(list.get(0));
		visit[list.get(0)] = true;
		while(!q.isEmpty()) {
			int now = q.poll();
			for(int i=0; i<node.get(now).size(); i++) {
				int nx = node.get(now).get(i);
				if(!visit[nx]) {
					visit[nx] = true;
					q.offer(nx);
				}
			}
		}
		for(int i=0; i<list.size(); i++) {
			if(!visit[list.get(i)]) {
				return false;
			}
		}
		return true;
	}
	static void dfs(int index) {
		if(n-1 == index) {
			ArrayList<Integer> arr1 = new ArrayList<>();
			ArrayList<Integer> arr2 = new ArrayList<>();
			for(int i=0; i<n; i++) {
				if(check[i])
					arr1.add(i+1);
				else {
					arr2.add(i+1);
				}
			}
			if(arr1.size() == 0 || arr2.size() == 0) return;
			if(chk(arr1) && chk(arr2)) {
				int a = 0;
				for(int i=0; i<arr1.size(); i++) {
					a += num[arr1.get(i)-1];
				}
				int b = 0;
				for(int i=0; i<arr2.size(); i++) {
					b += num[arr2.get(i)-1];
				}
				answer = Math.min(answer, Math.abs(a-b));
			}
		}
		if(index < n) {
			check[index] = true;
			dfs(index+1);
			check[index] = false;
			dfs(index+1);
		}
	}
    public static void main(String[] args) {
    	Scanner in = new Scanner(System.in);
    	n = in.nextInt();
    	num = new int[n];
    	check = new boolean[n];
    	for(int i=0; i<=n; i++) {
    		node.add(new ArrayList<Integer>());
    	}
    	for(int i=0; i<n; i++) {
    		num[i] = in.nextInt();
    	}
    	for(int i=1; i<=n; i++) {
    		int size = in.nextInt();
    		for(int j=0; j<size; j++) {
    			int a = in.nextInt();
    			node.get(i).add(a);
    		}
    	}
    	dfs(0);
    	System.out.println(answer == INF ? -1 : answer);
    }
}

