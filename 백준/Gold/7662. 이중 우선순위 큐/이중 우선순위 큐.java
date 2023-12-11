import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int c = in.nextInt();
		while (c-- != 0) {
			int n = in.nextInt();
			TreeMap<Integer, Integer> treemap = new TreeMap<>();
			for (int i = 0; i < n; i++) {
				char op = in.next().charAt(0);
				int set = in.nextInt();
				if (op == 'I') {
					treemap.put(set, treemap.getOrDefault(set, 0) + 1);
				} else {
					if (treemap.size() == 0) continue;
					if (set == 1) { // 최대값 삭제
							int num = treemap.lastKey();
							if(treemap.get(num) == 1) {
								treemap.remove(num);
							}
							else {
								treemap.put(num, treemap.get(num) - 1);
							}
					} else { // 최소값 삭제
							int num = treemap.firstKey();
							if(treemap.get(num) == 1) {
								treemap.remove(num);
							}
							else {
								treemap.put(num, treemap.get(num) - 1);
							}
					}
				}
			}
			if (treemap.size() != 0) {
				System.out.println(treemap.lastKey() + " " + treemap.firstKey());
			} else {
				System.out.println("EMPTY");
			}
		}
	}
}
