import java.util.*;
class Position{
	public int start;
	public int end;
	Position(int start, int end){
		this.start = start;
		this.end = end;
	}
}

class Node{
	public int x;
	public int count;
	Node(int x, int count){
		this.x = x;
		this.count = count;
	}
}

public class Main {
	static int[] dx = {1,2,3,4,5,6};
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int u = in.nextInt();
		int v = in.nextInt();
		int n = u + v;
		ArrayList<Position> pos = new ArrayList<>();
		int[] map = new int[101];
		for(int i=0; i<n; i++) {
			int a = in.nextInt();
			int b = in.nextInt();
			pos.add(new Position(a, b));
			
		}
		Queue<Node> node = new LinkedList<>();
		node.offer(new Node(1,0));
		while(!node.isEmpty()) {
			Node now = node.poll();
			int x = now.x;
			int count = now.count;
			for(int i=0; i<6; i++) {
				int nx = x + dx[i];
				if(nx < 1 || nx > 100) continue;
				if(map[nx] == 0) {
					boolean chk = false;
					for(int s=0;s<pos.size(); s++) {
						if(pos.get(s).start == nx) {
							map[nx] = map[x] + 1;
							nx = pos.get(s).end;
							if(map[nx] != 0) chk = true;
							break;
						}
					}
					if(chk) {
						node.offer(new Node(x, count));
						continue;
					}
					else {
						map[nx] = map[x] + 1;
						node.offer(new Node(nx, count+1));
					}
				}
			}
		}
//		for(int i=0; i<101;i++) {
//			System.out.println(i + " " + map[i]);
//		}
		System.out.println(map[100]);
	}
}
