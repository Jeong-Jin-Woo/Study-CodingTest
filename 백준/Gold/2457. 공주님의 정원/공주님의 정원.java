import java.util.*;
class Position implements Comparable<Position>{
	public int start;
	public int end;
	Position(int start, int end){
		this.start = start;
		this.end = end;
	}
	@Override
	public int compareTo(Position other) {
		if(start == other.start) {
			return Integer.compare(other.end, end);
		}
		return Integer.compare(start, other.start);
	}
}
public class Main {
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		ArrayList<Position> pos = new ArrayList<>();
		for(int i=0; i<n; i++) {
			int a = in.nextInt();
			int b = in.nextInt();
			int c = in.nextInt();
			int d = in.nextInt();
			
			int start = a*100 + b;
			int end = c*100+d;
			pos.add(new Position(start, end));
		}
		Collections.sort(pos);
		int start = 301;
		int end = 1201;
		int index = 0;
		int max = 0;
		int answer = 0;
		while(start < end) {
			boolean chk = false;
			for(int i=index; i<n; i++) {
				if(pos.get(i).start > start) break;
				if(pos.get(i).end > max) {
					chk = true;
					max = pos.get(i).end;
					index = i + 1;
				}
			}
			if(chk) {
				answer += 1;
				start = max;
			}
			else {
				break;
			}
		}
		System.out.println(max < end ? 0 : answer);
	}
}