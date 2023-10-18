import java.util.*;
public class Chapter10_0_서로소집합알고리즘 {
	static int n,m;
	static int root[] = new int[10];
	
//	public static void insert(int x, int y) {
//		int big = Math.max(e[x], e[y]);
//		int small = Math.min(e[x], e[y]);
//		e[big] = small;
//	}
	
	public static void insert(int x, int y) {
		x = root(x);
		y = root(y);
		if(x > y) root[x] = y;
		else root[y] = x;
	}
	public static int root(int r) {
		if(r == root[r]) {
			return r;
		}
		else {
			return root(root[r]);
		}
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		m = in.nextInt();
		
		
		for(int i=1; i<=n; i++) {
			root[i] = i;
		}
		
		for(int i=0; i<m; i++) {
			int a = in.nextInt();
			int b = in.nextInt();
			insert(a,b);
		}
		
		for(int i =1; i<=n; i++) {
			System.out.print(root(i)+" ");
		}
		
		System.out.println();
		for(int i=1; i<=n; i++)
			System.out.print(root[i]+" ");
		
	}
}