import java.util.*;
public class 볼링공고르기 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int[] arr = new int[n];
		int[] kg = new int[m];
		
		for(int i=0; i<n; i++) {
			arr[i] = in.nextInt();
			kg[arr[i]-1]++;
		}
		
		int answer = 0;
		for(int i=0; i<m; i++) {
			for(int j=i+1; j<m; j++) {
				answer += kg[i] * kg[j];
			}
		}
		System.out.println(answer);
	}
}

//import java.util.*;
//public class 볼링공고르기 {
//	public static void main(String[] args) {
//		Scanner in = new Scanner(System.in);
//		int n = in.nextInt();
//		int m = in.nextInt();
//		int[] arr = new int[n];
//		
//		for(int i=0; i<n; i++) {
//			arr[i] = in.nextInt();
//		}
//		Arrays.sort(arr);
//		
//		int answer = 0;
//		for(int i=0; i<n; i++) {
//			for(int j=i+1; j<n; j++) {
//				if(arr[i] != arr[j]) {
//					answer++;
//				}
//			}
//		}
//		System.out.println(answer);
//	}
//}