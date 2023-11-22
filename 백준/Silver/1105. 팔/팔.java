import java.util.*;
public class Main{
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		int b = in.nextInt();
		int[] A = new int[10];
		int[] B = new int[10];
		int set = 9;
		int s1 = 0;
		while(a != 0) {
			A[set--] = a % 10;
			a /= 10;
			s1 += 1;
		}
		set = 9;
		int s2 = 0;
		while(b != 0) {
			B[set--] = b%10;
			b/=10;
			s2 += 1;
		}
		int answer = 0;
		if(s1 == s2) {
			for(int i=0; i<10; i++) {
				if(A[i] == B[i]) {
					if(A[i] == 8 && B[i] == 8) {
						answer += 1;
					}
					else
						continue;
				}
				else
					break;
			}
		}
		System.out.println(answer);
	}
}
