import java.util.*;

public class Main {
	static String B(String str) {
		Stack<Character> s = new Stack<>();
		String set = "";
		for(int i=0; i<str.length()-1; i++) {
			s.push(str.charAt(i));
		}
		while(!s.isEmpty()) {
			set += s.pop();
		}
		return set;
	}
	static String A(String str) {
		String set = "";
		for(int i=0; i<str.length()-1; i++) {
			set += str.charAt(i);
		}
		return set;
	}
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		String a = in.next();
		String b = in.next();
		int n = b.length()-1;
		for(int i = n; i>=a.length(); i--) {
			if(b.charAt(i) == 'B') {
				b = B(b);
			}
			else if(b.charAt(i) == 'A') {
				b = A(b);
			}
		}
		
		System.out.println(a.equals(b) ? 1 : 0);
	}
}
