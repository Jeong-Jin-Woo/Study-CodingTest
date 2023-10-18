import java.util.*;
public class Chapter13_19_연산자끼워넣기 {
	static int n;
	static ArrayList<Integer> arr = new ArrayList<>();
	static int[] sign = new int[4];
	static int max = (int)-1e9;
	static int min = (int)1e9;
	public static void dfs(int i, int num) {
		if(i == n) {
			max = Math.max(max, num);
			min = Math.min(min, num);
		}
		else {
			if(sign[0] > 0) { // +
				sign[0]--;
				dfs(i+1, num + arr.get(i));
				sign[0]++;
			}
			if(sign[1] > 0) { // -
				sign[1]--;
				dfs(i+1, num - arr.get(i));
				sign[1]++;
			}
			if(sign[2] > 0) { // *
				sign[2]--;
				dfs(i+1, num * arr.get(i));
				sign[2]++;
			}
			if(sign[3] > 0) { // /
				sign[3]--;
				dfs(i+1, num / arr.get(i));
				sign[3]++;
			}
		}
		
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		for(int i=0; i<n; i++) {
			int a = in.nextInt();
			arr.add(a);
		}
		for(int i=0; i<4; i++) {
			sign[i] = in.nextInt();
		}
		dfs(1, arr.get(0));
		
		System.out.println(max);
		System.out.println(min);
	}
}