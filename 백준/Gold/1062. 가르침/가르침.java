import java.util.*;

public class Main {
	static int n, k;
	static boolean[] alpha = new boolean[26];
	static String[] arr;
	static int answer = 0;

	static void dfs(int start, int count) {
		if (count == k) {
			int sum = 0;
			for (int i = 0; i < n; i++) {
				boolean chk = true;
				for (int j = 0; j < arr[i].length(); j++)
					if (!alpha[arr[i].charAt(j) - 'a']) {
						chk = false;
						break;
					}
				if (chk)
					sum += 1;
			}
			answer = Math.max(answer, sum);
			return;
		}
		for (int i = start; i < 26; i++) {
			if (!alpha[i]) {
				alpha[i] = true;
				dfs(i, count + 1);
				alpha[i] = false;
			}
		}
	}

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		k = in.nextInt();
		arr = new String[n];
		for (int i = 0; i < n; i++) {
			String str = in.next();
			arr[i] = str.substring(4, str.length() - 4);
		}
		if (k < 5) {
			System.out.println(0);
			return;
		}
		if (k == 26) {
			System.out.println(n);
			return;
		}
		k -= 5;
		alpha['a' - 'a'] = true;
		alpha['n' - 'a'] = true;
		alpha['t' - 'a'] = true;
		alpha['i' - 'a'] = true;
		alpha['c' - 'a'] = true;
		dfs(0, 0);
		System.out.println(answer);
	}
}
