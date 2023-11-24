import java.util.*;
public class Main{
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		Integer[] alpha = new Integer[26];
		Arrays.fill(alpha, 0);
		String str[] = new String[n];
		for(int i=0; i<n; i++) {
			str[i] = in.next();
		}
		for(int size=0; size<n; size++) {
			for(int i=str[size].length()-1, j=1; i>=0; i--, j*=10) {
				alpha[str[size].charAt(i) - 'A'] += j;
			}
		}
		Arrays.sort(alpha, Collections.reverseOrder());
		int answer = 0;
		for(int i=0, j=9; i<26; i++) {
			if(alpha[i] != 0) {
				answer += alpha[i] * j;
				j = j > 0 ? j - 1 : 0;
			}
		}
		System.out.println(answer);
	}
}
