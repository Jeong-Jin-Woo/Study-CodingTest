import java.util.*;
class Node implements Comparable<Node>{
	int x;
	int y;
	int dist;
	Node(int x, int y, int dist){
		this.x = x;
		this.y = y;
		this.dist = dist;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getDist() {
		return dist;
	}
	public void setDist(int x) {
		dist += x;
	}
	public int compareTo(Node other) {
		return Integer.compare(this.dist, other.getDist());
	}
}
class House{
	int x;
	int y;
	int dist;
	House(int x, int y, int dist){
		this.x = x;
		this.y = y;
		this.dist = dist;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getDist() {
		return dist;
	}
	public void setDist(int x) {
		dist = Math.min(dist, x);
	}
}
public class Chapter12_13_치킨배달 {
	static final int INF = (int)1e9;
	public static int getDistance(int a, int b, int c, int d) {
		int x = (c - a) > 0 ? c-a : a-c;
		int y = (d - b) > 0 ? d-b : b-d;
		
		return x+y;
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		
		ArrayList<House> house = new ArrayList<>();
		ArrayList<Node> chicken = new ArrayList<>();
		
		int[][] arr = new int[n][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				arr[i][j] = in.nextInt();
				if(arr[i][j] == 1) {
					house.add(new House(i+1,j+1,INF));
				}
				if(arr[i][j] == 2){
					chicken.add(new Node(i+1,j+1,0));
				}
			}
		}
		
		for(int i=0; i<chicken.size(); i++) {
			for(int j=0; j<house.size(); j++) {
				chicken.get(i).setDist(getDistance(house.get(j).getX(),house.get(j).getY(), chicken.get(i).getX(), chicken.get(i).getY()));
			}
		}
		Collections.sort(chicken);
		while(chicken.size()!=m)
			chicken.remove(chicken.size()-1);
		
		for(int i=0; i<house.size(); i++) {
			for(int j=0; j<chicken.size(); j++) {
				house.get(i).setDist(getDistance(house.get(i).getX(),house.get(i).getY(), chicken.get(j).getX(), chicken.get(j).getY()));
			}
		}
		System.out.println("CHICKEN");
		for(int i=0; i<chicken.size(); i++) {
			System.out.println(chicken.get(i).getX()+" "+chicken.get(i).getY()+" "+chicken.get(i).getDist()+" ");
		}
		System.out.println("HOUSE");
		for(int i=0; i<house.size(); i++)
			System.out.println(house.get(i).getX() +" " + house.get(i).getY()+" "+house.get(i).getDist());

		System.out.println("ANSWER");
		int answer = 0;
		for(int i=0; i<house.size(); i++)
			answer += house.get(i).getDist();
		System.out.println(answer);
	}
}