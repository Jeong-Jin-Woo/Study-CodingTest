import java.util.*;
public class ���ϱ�Ȥ�����ϱ� {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String num = in.next();

		int answer = num.charAt(0) - '0';
		for(int i=1; i<num.length(); i++) {
			answer = Math.max(answer + (num.charAt(i)-'0'), answer * (num.charAt(i)-'0'));
		}
		System.out.println(answer);
	}
}