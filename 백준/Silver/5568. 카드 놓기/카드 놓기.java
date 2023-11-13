import java.util.*;
public class Main{
	static int n,k;
	static int[] arr;
	static int[] set;
	static boolean[] visit;
	static ArrayList<String> has = new ArrayList<>();
	static void dfs(int count, int size) {
		if(count == size) {
			String str = "";
			for(int i=0; i<size; i++) {
				str += String.valueOf(set[i]);
			}
			if(!has.contains(str))
				has.add(str);
			return;
		}
		for(int i=0; i<n; i++) {
			if(!visit[i]){
				visit[i] = true;
				set[count] = arr[i];
				dfs(count+1, size);
				set[count] = 0;
				visit[i] = false;
			}
		}
	}
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		k = in.nextInt();
		arr = new int[n];
		set = new int[n];
		visit = new boolean[n];
		for(int i=0; i<n; i++) {
			arr[i] = in.nextInt();
		}
		dfs(0, k);
		System.out.println(has.size());
	}
}
