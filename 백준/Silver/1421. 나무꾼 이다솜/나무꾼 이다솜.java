import java.util.*;
public class Main{
	static int n;
	static long c,w;
	static int[] arr;
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		n=in.nextInt();
		c=in.nextInt();
		w=in.nextInt();
		arr=new int[n];
		long max = -(int)1e9; // 가장 큰 이익
		for(int i=0; i<n; i++) {
			arr[i] =in.nextInt();
			max = Math.max(arr[i], max);
		}
		Arrays.sort(arr);
		for(int i=1; i<=arr[arr.length-1]; i++) {
			long sum = 0;
			int l = i; //나무 길이
			long k = 0; //나무 한 세트 개수
			long count = 0; //자르는 회수
			for(int j=0; j<arr.length; j++) {
				if(arr[j] >= i) {
					k = arr[j]/l;
					if(arr[j] % i == 0) {
						count = arr[j]/l-1;
					}
					else
						count = arr[j]/l;
					if(l*k*w - count*c > 0) {
						sum += l*k*w - count*c;
					}
				}
			}
			max = Math.max(max, sum);
		}
		System.out.println(max);
	}
}
