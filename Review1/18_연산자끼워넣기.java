import java.util.*;
public class 연산자끼워넣기 {
	static int n, sum, minus, div, mult;
	static int[] arr = new int[100];
	static int max = -(int)1e9;
	static int min = (int)1e9;
	public static void dfs(int i, int now) {
		if(i == n) {
			min = Math.min(min, now);
			max = Math.max(max, now);
		}
		else {
			if(sum > 0) {
				sum-=1;
				dfs(i+1, now + arr[i]);
				sum+=1;
			}
			if(minus > 0) {
				minus-=1;
				dfs(i+1, now - arr[i]);
				minus+=1;
			}
			if(div > 0) {
				div-=1;
				dfs(i+1, now / arr[i]);
				div+=1;
			}
			if(mult > 0) {
				mult-=1;
				dfs(i+1, now * arr[i]);
				mult+=1;
			}
		}
		System.out.println(sum + " " + minus+ " " + div+ " " + mult);
	}
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		for(int i=0; i<n; i++) {
			arr[i] = in.nextInt();
		}
		sum = in.nextInt();
		minus = in.nextInt();
		mult = in.nextInt();
		div = in.nextInt();
		
		dfs(1, arr[0]);
		System.out.println(max);
		System.out.println(min);
	}
}