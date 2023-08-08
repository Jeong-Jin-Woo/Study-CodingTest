import java.util.*;
public class Chapter18_42_Å¾½Â±¸ {
	static int root[] = new int[100001];
	static int answer = 0;
	public static int find(int r) {
		if(root[r] == r) return r;
		else {
			return root[r] = find(root[r]);
		}
	}
	public static void  root(int a, int b) {
		a = find(a);
		b = find(b);
		if(a < b) root[b] = a;
		else root[a] = b;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int g = in.nextInt();
		int p = in.nextInt();
		for(int i=1; i<=g; i++) {
			root[i] = i;
		}
		
		for(int i=1; i<=p; i++) {
			int x = in.nextInt();
			int root = find(x);
			if(root == 0) break;
			else {
				root(root, root-1);
				answer++;
			}
		}
		
		System.out.println(answer);
	}
}