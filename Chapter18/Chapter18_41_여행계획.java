import java.util.*;
public class Chapter18_41_ø©«‡∞Ë»π {
	static int[] root = new int[501];
	static int[][] map = new int[501][501];
	public static int find(int r) {
		if(root[r] == r) return r;
		else {
			return root[r] = find(root[r]);
		}
	}
	public static void root(int a, int b) {
		a = find(a);
		b = find(b);
		if(a<b) root[b] = a;
		else root[a] = b;
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		
		for(int i=1; i<=n; i++)
			root[i] = i;
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				int a = in.nextInt();
				if(a == 1) {
					root(i+1,j+1);
				}
			}
		}
		
		int[] arr = new int[m];
		for(int i=0; i<m; i++) {
			arr[i] = in.nextInt();
		}
		
		int answer = find(arr[0]);
		for(int i=1; i<m; i++) {
			if(answer != find(arr[i])) {
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");
			
		
	}
}