import java.util.*;
public class Solution {
	static final int INF = (int)1e9;
	static int n;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int test=1; test<=T; test++) {
        	n = in.nextInt();
        	int[] arr = new int[n*2];
        	for(int i=0; i<n*2; i++) {
        		arr[i] = in.nextInt();
        	}
        	int answer[] = new int[n];
        	for(int i=n*2-1, index = 0; i>= 0; i--) {
        		int set = arr[i];
        		for(int j=i-1; j>=0; j--) {
        			if(arr[j] == 0) break;
	        		if(set / 4 * 3 == arr[j]) {
	        			answer[index++] = arr[j];
	        			arr[j] = 0;
	        			Arrays.sort(arr);
	        			break;
	        		}
        		}
        	}
        	Arrays.sort(answer);
        	System.out.print("#" + test + " ");
        	for(int i=0; i<n; i++) {
        		System.out.print(answer[i] + " ");
        	}
        	System.out.println();
        }
    }
}
