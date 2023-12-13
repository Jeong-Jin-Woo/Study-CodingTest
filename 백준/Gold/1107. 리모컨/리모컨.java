import java.util.*;
public class Main{
	static int[] dx = {-1,1};
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		boolean[] arr = new boolean[10];
		for(int i=0; i<m; i++) {
			int s = in.nextInt();
			arr[s] = true;
		}
		
		int min = Math.abs(n-100);
		for(int i=0; i<1000000; i++) {
			String str = String.valueOf(i);
			boolean chk = false;
			for(int s=0; s<str.length(); s++) {
				if(arr[str.charAt(s) - '0']) {
					chk = true;
					break;
				}
			}
			if(chk) continue;
			min = Math.min(min, Math.abs(n-i)+str.length());
		}
		System.out.println(min);
	}
}
