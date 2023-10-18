import java.util.*;
class Node implements Comparable<Node>{
	private int index;
	private int value;
	
	public int getValue() {
		return value;
	}
	public int getIndex() {
		return index;
	}
	Node(int index, int value){
		this.index = index;
		this.value = value;
	}
	@Override
	public int compareTo(Node other) {
		if(value < other.value)
			return -1;
		return 1;
	}
}
public class Chapter09_���ͽ�Ʈ��_�켱���� {
	static final int INF = 999999999;
	public static int n,m,start;
	public static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
	public static int[] d = new int[100001];
	
	public static void dijkstra(int start) {
		PriorityQueue<Node> q = new PriorityQueue<>();
		q.offer(new Node(start, 0));
		d[start] = 0;
		while(!q.isEmpty()) {
			Node node = q.poll();
			int distance = node.getValue();
			int index = node.getIndex();
			
			if(d[index] < distance) continue;
			
			for(int i=0; i<graph.get(index).size(); i++) {
				int cost = d[index] + graph.get(index).get(i).getValue();
				if(cost < d[graph.get(index).get(i).getIndex()]) {
					d[graph.get(index).get(i).getIndex()] = cost;
					q.offer(new Node(graph.get(index).get(i).getIndex() ,cost));
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        start = sc.nextInt();
		
        for(int i=0; i<=n; i++) {
        	graph.add(new ArrayList<Node>());
        }
        
        for(int i=0; i<m; i++) {
        	int a = sc.nextInt();
        	int b = sc.nextInt();
        	int c = sc.nextInt();
        	graph.get(a).add(new Node(b,c));
        }
        
        Arrays.fill(d, INF);
        
        dijkstra(start);
        

        // ��� ���� ���� ���� �ִ� �Ÿ��� ���
        for (int i = 1; i <= n; i++) {
            // ������ �� ���� ���, ����(INFINITY)�̶�� ���
            if (d[i] == INF) {
                System.out.println("INFINITY");
            }
            // ������ �� �ִ� ��� �Ÿ��� ���
            else {
                System.out.println(d[i]);
            }
        }
	}

}
