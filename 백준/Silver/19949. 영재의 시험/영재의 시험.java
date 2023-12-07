import java.util.*;

public class Main {
	static int answer[] = new int[10];
	static int ans = 0;
	static void dfs(String str) {
		if(str.length() == 10) {
			int count = 0;
//			System.out.println(str);
			for(int i=0; i<10; i++) {
				if(str.charAt(i) - '0' == answer[i]) count += 1;
				if(count >= 5) {
					ans += 1;
					break;
				}
			}
			return;
		}
		for(int i=1; i<=5; i++) {
			int size = str.length();
			if(size >= 2) {
				char a = str.charAt(size-2);
				char b = str.charAt(size-1);
				if(a == b && b == i + '0') continue;
				else {
					dfs(str+i);
				}
			}
			else {
				dfs(str+i);
			}
		}
	}
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		for(int i=0; i<10; i++) {
			answer[i] = in.nextInt();
		}
		dfs("");
		System.out.println(ans);
	}
}