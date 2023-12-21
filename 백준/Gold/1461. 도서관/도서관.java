import java.util.*;

class Position implements Comparable<Position> {
	public int x;

	Position(int x) {
		this.x = x;
	}

	public int compareTo(Position other) {
		return Integer.compare(other.x, x);
	}
}

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		PriorityQueue<Position> positive = new PriorityQueue<>();
		PriorityQueue<Position> negative = new PriorityQueue<>();
		int max = 0;
		for (int i = 0; i < n; i++) {
			int a = in.nextInt();
			if (a > 0)
				positive.offer(new Position(a));
			else
				negative.offer(new Position(Math.abs(a)));
			max = Math.max(max, Math.abs(a));
		}
		int answer = 0;

		while (!positive.isEmpty()) {
			answer += Math.abs(positive.poll().x) * 2;
			for (int i = 0; i < m - 1; i++) {
				if (positive.isEmpty())
					break;
				positive.poll();
			}
		}
		while (!negative.isEmpty()) {
			answer += Math.abs(negative.poll().x) * 2;
			for (int i = 0; i < m - 1; i++) {
				if (negative.isEmpty())
					break;
				negative.poll();
			}
		}
		System.out.println(answer - max);
	}
}