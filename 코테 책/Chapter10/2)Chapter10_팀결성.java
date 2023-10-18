import java.util.*;
public class Chapter10_2_ÆÀ°á¼º {
	static int v,e;
	static int[] root = new int[100001];
	
	public static int find(int r) {
		if(root[r] == r) {
			return r;
		}
		else {
			root[r] = find(root[r]);
			return root[r];
		}
	}
	public static void root(int a, int b) {
		a = find(a);
		b = find(b);
		if(a < b) root[b] = a;
		else root[a] = b;
	}
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		v = in.nextInt();
		e = in.nextInt();
		
		for(int i=1; i<=v; i++) {
			root[i] = i;
		}
		
		for(int i=1; i<=e; i++) {
			int chk = in.nextInt();
			int a = in.nextInt();
			int b = in.nextInt();
			
			if(chk == 1) {
				if(find(a) == find(b)) System.out.println("YES");
				else System.out.println("NO");
			}
			else {
				root(a,b);
			}
		}
		
	}
}