import java.util.*;
public class Chapter10_0_서로소집합알고리즘_최적화 {
	static int n,m;
	static int root[] = new int[10];
	
	public static void insert(int x, int y) {
		x = root(x);
		y = root(y);
		if(x > y) root[x] = y;
		else root[y] = x;
	}
	public static int root(int r) {
		if(r != root[r]) {
			root[r] = root(root[r]);
			return root[r];
		}
		else {
			return r;
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
		
		//원소가 속한 집합
		for(int i =1; i<=n; i++) {
			System.out.print(root(i)+" ");
		}
		
		System.out.println();
		
		//부모테이블
		for(int i=1; i<=n; i++)
			System.out.print(root[i]+" ");
		
	}
}