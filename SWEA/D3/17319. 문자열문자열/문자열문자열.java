import java.util.*;
public class Solution {
	public static void main(String args[]) throws Exception {
		Scanner in = new Scanner(System.in);
		int T;
		T = in.nextInt();
		for (int test = 1; test <= T; test++) {
			int n = in.nextInt();
			String str = in.next();
			
			boolean chk = true;
			if(n%2==0) {
				for(int i=0; i<n/2; i++) {
					if(str.charAt(i) != str.charAt(n/2+i)) chk = false;
				}
			}
			else chk = false;
			System.out.println("#" + test + " " + (chk ? "Yes" : "No"));
			
		}
	}
}
