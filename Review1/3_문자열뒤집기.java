import java.util.*;
public class 문자열뒤집기 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = in.next();
		
		String str = s.charAt(0)+"";
		for(int i=1; i<s.length(); i++) {
			if(s.charAt(i-1) != s.charAt(i)) {
				str += s.charAt(i);
			}
		}
		
		int answer = 0;
		int count = 0;
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i)=='0') count++;
			else answer++;
		}
		answer = Math.min(answer, count);
		
		System.out.println(answer);
	}
}