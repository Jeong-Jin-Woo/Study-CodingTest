import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
class Node implements Comparable<Node>{
	int g;
	int price;
	Node(int g, int price){
		this.g=g;
		this.price=price;
	}
	public int getG() {
		return g;
	}
	public int getPrice() {
		return price;
	}
	@Override
	public int compareTo(Node other) {
		if(g == other.g) {
			return Integer.compare(price, other.price);
		}
		return Integer.compare(g, other.g);
	}
}
class Position implements Comparable<Position>{
	public int price;
	Position(int price){
		this.price=price;
	}
	@Override
	public int compareTo(Position other) {
		return Integer.compare(other.price, price);
	}
}
public class Main{
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
		ArrayList<Node> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

			arr.add(new Node(a,b));
        }
        
		Integer[] weight = new Integer[k];
		for (int i = 0; i < k; i++) {
			weight[i] = Integer.parseInt(br.readLine());
        }
		Collections.sort(arr);// 2 10
		Arrays.sort(weight);
		
//		4 5
//		4 9
//		4 10
//		8 5
//		8 55
//		8 55
//		9 5
//		9 15
//		11 54
//		14 20
//
//		4 -> 4 10
//		5 -> 4 9
//		10 -> 8 55
//		15 -> 8 55
//		20 -> 11 54
//		answer = 183
		
		long answer = 0;
		PriorityQueue<Position> pq = new PriorityQueue<>();
		for(int i=0, j=0; i<k; i++) {
			while(j < n && weight[i] >= arr.get(j).getG()) {
				pq.offer(new Position(arr.get(j).getPrice()));
				j += 1;
			}
			if(!pq.isEmpty()) {
				answer += pq.poll().price;
			}
		}
		
		System.out.println(answer);
	}
}