import java.util.*;
public class Chapter11_2_곱하기혹은더하기 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String S = in.next();
		int answer = Integer.valueOf(S.charAt(0) - '0');
		for(int i=1; i<S.length(); i++) {
			answer = Math.max(Integer.valueOf(S.charAt(i) - '0') + answer , Integer.valueOf(S.charAt(i) - '0') * answer);
		}
		System.out.println(answer);
	}

}