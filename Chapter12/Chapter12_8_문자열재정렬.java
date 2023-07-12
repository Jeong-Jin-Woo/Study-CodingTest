import java.util.*;
public class Chapter12_8_문자열재정렬 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = in.next();
		ArrayList<Character> result = new ArrayList<Character>();
		int value = 0;
		
		for(int i=0; i<s.length(); i++) {
			if(s.charAt(i) >= 'A' && s.charAt(i) <= 'Z')
				result.add(s.charAt(i));
			else
				value += s.charAt(i) - '0';
		}

		Collections.sort(result);
		
		for(int i=0; i<result.size(); i++)
			System.out.print(result.get(i));
		if(value!=0)
			System.out.print(value);
	}
}