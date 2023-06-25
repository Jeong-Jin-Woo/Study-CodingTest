import java.util.*;
public class Chapter06_4_두배열의원소교체 {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		
		Integer[] A = new Integer[n];
		Integer[] B = new Integer[n];
		for(int i=0; i<n; i++) 
			A[i] = in.nextInt();
		for(int i=0; i<n; i++)
			B[i] = in.nextInt();
		
		Collections.sort(Arrays.asList(A));
		Collections.sort(Arrays.asList(B));
		Collections.reverse(Arrays.asList(B));
		
		for(int i=0; i<k; i++) {
			if(A[i] < B[i]) {
				int tmp = A[i];
				A[i] = B[i];
				B[i] = A[i];
				
			}
		}
		int answer = 0;
		for(int i=0; i<n; i++)
			answer += A[i];
		System.out.println(answer);
	}

}
