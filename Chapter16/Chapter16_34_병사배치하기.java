import java.util.*;
public class Chapter16_34_병사배치하기 {
	static int d[] = new int[2001];
	static ArrayList<Integer> arr = new ArrayList<Integer>();
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		
		for(int i=0; i<n; i++) {
			arr.add(in.nextInt());
		}
		//LIS
		Collections.reverse(arr);
		
		for(int i=0; i<n; i++)
			d[i] = 1;
		
		for(int i=1; i<n; i++) {
			for(int j = 0; j<i; j++) {
				if(arr.get(i) < arr.get(j))
					d[i] = Math.max(d[i], d[j] + 1);
			}
		}
		
		int answer = 0;
		for(int i=0; i<n; i++) {
			answer = Math.max(answer, d[i]);
		}
		System.out.println(n-answer);
		
	}
}