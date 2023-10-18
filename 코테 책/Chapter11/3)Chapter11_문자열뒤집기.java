import java.util.*;
public class Chapter11_3_문자열뒤집기 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = in.next();
		
		char[] number = {'0', '1'};
		int count0 = 0;
		int count1 = 0;
	
		for(int i=1; i<s.length(); i++) {
			if(s.charAt(i-1) != s.charAt(i)) {
				if(s.charAt(i-1) == number[0]) count0++;
				else if(s.charAt(i-1) == number[1]) count1++;
			}
		}
		System.out.println(Math.min(count0, count1));
	}

}