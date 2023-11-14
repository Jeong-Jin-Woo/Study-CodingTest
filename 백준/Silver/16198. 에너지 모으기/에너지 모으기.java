import java.util.*;

public class Main {
	static int n;
	static int answer = 0;

	static void dfs(int index, ArrayList<Integer> arr, int sum) {
		if (index <= 0 || index >= arr.size() - 1 || arr.size() == 2) {
			answer = Math.max(answer, sum);
			return;
		}
		for (int i = index; i < arr.size() - 1; i++) {
			int m = arr.get(i - 1) * arr.get(i + 1);
			int r = arr.remove(i);
//			for (int a = 0; a < arr.size(); a++) {
//				System.out.print(arr.get(a) + " ");
//			}
//			System.out.println(m + sum);
			dfs(index - 1, arr, m + sum);
			dfs(index, arr, m + sum);
			arr.add(i, r);
		}
	}

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		ArrayList<Integer> arr = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			int a = in.nextInt();
			arr.add(a);
		}
//		for(int i=0; i<arr.size(); i++) {
//			System.out.print(arr.get(i)+ " ");
//		}
		for (int i = 1; i < n - 1; i++)
			dfs(i, arr, 0);
		System.out.println(answer);
	}
}
