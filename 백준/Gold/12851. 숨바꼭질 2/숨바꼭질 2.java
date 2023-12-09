import java.util.*;
public class Main {
	static int[] dx = {2, 1, -1};
	static final int INF = (int) 1e9;
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int[] arr = new int[200001];
		Arrays.fill(arr, INF);
		Queue<Integer> pos = new LinkedList<>();
		arr[n] = 0;
		pos.offer(n);
		int count = 0;
		int leastTime = INF;
		while(!pos.isEmpty()) {
			int x = pos.poll();
			if(leastTime < arr[x]) break;
			
			if(x == k && arr[x] <= leastTime) {
				leastTime = arr[x];
				count++;
			}
			
			for(int i=0; i<3; i++) {
				int nx;
				if(i==0) {
					nx = x * dx[i];
				}
				else{
					nx = x + dx[i];
				}
				if(nx >= 0 && nx < 200001) {
					if(arr[nx] >= arr[x] + 1) {
						arr[nx] = arr[x] + 1;
						pos.offer(nx);
					}
				}
			}
		}
		System.out.println(leastTime);
		System.out.println(count);
	}
}
