import java.util.*;
public class Main{
	static int n, k;
	static int[] arr;
	static boolean[] visit;
	static int answer = 0;
	static void dfs(int count, int weight) {
		if(count == n) {
			answer +=1;
			return;
		}
		for(int i=0; i<n; i++) {
			if(!visit[i] && weight >= 500) {
				visit[i] = true;
				dfs(count+1, weight + arr[i] - k);
				visit[i] = false;
			}
		}
	}
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		n=in.nextInt();
		k=in.nextInt();
		arr = new int[n];
		visit = new boolean[n];
		for(int i=0; i<n; i++) {
			arr[i] = in.nextInt();
		}
		Arrays.sort(arr);
		dfs(0, 500);
		System.out.println(answer);
	}	
}