//my solution
import java.util.*;
class Food implements Comparable<Food>{
	int x;
	int y;
	int dist;
	Food(int x, int y, int dist){
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
	public void addDist(int dist) {
		this.dist += dist;
	}
	@Override
	public int compareTo(Food other) {
		return Integer.compare(dist, other.dist);
	}
}
class Home {
	int x;
	int y;
	Home(int x, int y){
		this.x = x;
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
}
public class 치킨배달{
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		ArrayList<Food> food = new ArrayList<>();
		ArrayList<Home> home = new ArrayList<>();
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				int type = in.nextInt();
				if(type == 1) {
					home.add(new Home(i+1,j+1));
				}
				if(type == 2) {
					food.add(new Food(i+1,j+1,0));
				}
			}
		}
		for(int i=0; i<food.size(); i++) {
			for(int j=0; j<home.size(); j++) {
				int dist = Math.abs(home.get(j).getX() - food.get(i).getX()) + Math.abs(home.get(j).getY() - food.get(i).getY());
				food.get(i).addDist(dist);
			}
		}
		Collections.sort(food);
		
		while(food.size() > m) {
			food.remove(food.size()-1);
		}
		
		int answer = 0;
		for(int i=0; i<home.size(); i++) {
			int total = (int)1e9;
			for(int j=0; j<food.size(); j++) {
				int dist = Math.abs(home.get(i).getX() - food.get(j).getX()) + Math.abs(home.get(i).getY() - food.get(j).getY());
				total = Math.min(total, dist);
			}
			answer += total;
		}
		System.out.println(answer);
	}
}