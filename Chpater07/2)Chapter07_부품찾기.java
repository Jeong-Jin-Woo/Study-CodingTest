import java.util.*;
public class Chapter07_2_부품찾기 {
	public static String check(Integer arr[], int target, int start, int end) {
		//반복문
		while(start <= end) {
			int mid = (start+end)/2;
			if(arr[mid] == target)
				return "yes";
			else if(arr[mid] > target)
				end = mid - 1;
			else
				start = mid + 1;
		}
		return "no";
		/* 재귀
		if(start > end) return "no";
		int mid = (start+end)/2;
		if(arr[mid] == target) {
			return "yes";
		}
		else if(arr[mid] > target) {
			return check(arr, target, start, mid-1);
		}
		else {
			return check(arr, target, mid+1, end);
		}
		*/
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		Integer N[] = new Integer[n];
		for(int i=0; i<n; i++) {
			N[i] = in.nextInt();
		}
		Collections.sort(Arrays.asList(N));
		
		int m = in.nextInt();
		Integer M[] = new Integer[m];
		for(int i=0; i<m; i++) {
			M[i] = in.nextInt();
		}
		
		String answer[] = new String[m];
		for(int i=0; i<m; i++) {
			answer[i] = check(N, M[i], 0, n-1);
		}
		for(int i=0; i<m; i++)
			System.out.print(answer[i] + " ");
    }
	
}
