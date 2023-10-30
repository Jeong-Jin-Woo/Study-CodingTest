import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int n, s, d;
	static ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
	static boolean[] visit;
	static int[] node;
	static int answer = 0;

	static int dfs(int start, int count) {
//		for(int i=0; i<arr.get(start).size(); i++) {
//			int pos = arr.get(start).get(i);
//			if(pos != count) {
//				node[start] = Math.max(node[start], dfs(pos, start) + 1);
//			}
//		}
		for (int nextNode : arr.get(start)) {
			if (nextNode != count) {
				node[start] = Math.max(node[start], dfs(nextNode, start) + 1);
			}
		}
		if (start != s && node[start] >= d) {
			answer += 1;
		}

		return node[start];
	}

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		visit = new boolean[n + 1];
		node = new int[n + 1];
		for (int i = 0; i <= n; i++) {
			arr.add(new ArrayList<Integer>());
		}
		for (int i = 1; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr.get(a).add(b);
			arr.get(b).add(a);
		}
		visit[s] = true;
		dfs(s, -1);

		System.out.println(answer * 2);
	}
}
