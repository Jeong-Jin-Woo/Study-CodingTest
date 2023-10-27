import java.util.*;
public class Main{
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int count[] = new int[10];
		int n = in.nextInt();
		if(n == 0) {
			System.out.println(1);
			return;
		}
		while(n!=0) {
			int di = n % 10;
			n /= 10;
			count[di] -= 1;
		}
		if((count[9] + count[6])% 2 == 0)
			count[9] = count[6] = (count[6] + count[9]) /2;
		else
			count[9] = count[6] = (count[6] + count[9])/2 -1;
			
//		for(int i=1; i<=9; i++)
//			System.out.println(i + " " + count[i]);
		int answer  = 0;
		for(int i=0; i<=9; i++)
			answer = Math.min(count[i], answer);
		System.out.println(Math.abs(answer));
	}
}
