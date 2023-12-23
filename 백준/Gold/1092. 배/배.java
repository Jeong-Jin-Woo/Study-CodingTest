import java.util.*;
public class Main{
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		Integer[] ship = new Integer[n];
		for(int i=0; i<n; i++) {
			ship[i] = in.nextInt();
		}
		int m = in.nextInt();
		ArrayList<Integer> thing = new ArrayList<>();
		for(int i=0; i<m; i++) {
			thing.add(in.nextInt());
		}
		Arrays.sort(ship, Collections.reverseOrder());
		Collections.sort(thing, Collections.reverseOrder());
		if(ship[0] < thing.get(0)) {
			System.out.println(-1);
			return;
		}
		int count = 0;
		int index = 0; //thing의 search_index
		while(!thing.isEmpty()) {
			int shipIndex = 0;
			for(int i=index; i<thing.size() && shipIndex < n; i++) {
				if(ship[shipIndex] < thing.get(i)) {
					shipIndex -= 1;
				}
				else {
					thing.remove(i);
					i-=1;
				}
				shipIndex += 1;
			}
			count += 1;
		}
		System.out.println(count);
	}
}
