import java.util.*;
class Node{
	public int num;
	public int a;
	public int b;
	public int c;
	public int d;
	public int sum;
	Node(int num, int a, int b, int c, int d, int sum){
		this.num=num;
		this.a=a;
		this.b=b;
		this.c=c;
		this.d=d;
		this.sum=sum;
	}
}
public class Main {
	static int n;
	static int goalA, goalB, goalC, goalD;
	static ArrayList<Node> node = new ArrayList<>();
	static ArrayList<Integer> answer = new ArrayList<>();
	static boolean visit[];
	static int min = (int)1e9;
	static void dfs(int start, int a, int b, int c, int d, int cost) {
		if(a >= goalA && b >= goalB && c >= goalC && d >= goalD && cost < min) {
			min = cost;
			answer.clear();
			for(int i=0; i<n; i++) {
				if(visit[i]) {
					answer.add(i);
				}
			}
		}
		for(int i=start; i<n; i++) {
			if(!visit[i]) {
				visit[i] = true;
				dfs(i, a+node.get(i).a, b+node.get(i).b, c+node.get(i).c, d+node.get(i).d, cost+node.get(i).sum);
				visit[i] = false;
			}
		}
	}
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		goalA = in.nextInt();
		goalB = in.nextInt();
		goalC = in.nextInt();
		goalD = in.nextInt();
		visit = new boolean[n];
		for(int i=1; i<=n; i++) {
			int a = in.nextInt();
			int b = in.nextInt();
			int c = in.nextInt();
			int d = in.nextInt();
			int cost = in.nextInt();
			node.add(new Node(i, a,b,c,d, cost));
		}
		dfs(0, 0, 0, 0, 0, 0);
		Collections.sort(answer);
		System.out.println(min == (int)1e9 ? -1 : min);
		for(int i=0; i<answer.size(); i++) {
			System.out.print(answer.get(i)+1 + " ");
		}
	}
}