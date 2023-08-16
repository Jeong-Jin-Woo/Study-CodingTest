import java.util.*;
public class 문자열재정렬{
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		String s = in.next();
		ArrayList<Character> arr = new ArrayList<>();
		
		int sum = 0;
		for(int i=0; i<s.length(); i++) {
			if(s.charAt(i) > '0' && s.charAt(i) <'9'){
				sum += Integer.valueOf(s.charAt(i) - '0');
			}
			else {
				arr.add(s.charAt(i));
			}
		}
		Collections.sort(arr);
		String answer = "";
		for(int i=0; i<arr.size(); i++)
			answer += arr.get(i);
		answer += sum + "";
		System.out.println(answer);
	}
}