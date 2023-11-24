import java.util.*;
public class Main{
    public static void main(String[] args) {
    	Scanner in = new Scanner(System.in);
    	int n = in.nextInt();
    	int[] arr = new int[n];
    	int count = 0;
    	for(int i=0; i<n; i++) {
    		arr[i] = in.nextInt();
    		if(arr[i] <= 0) count += 1;
    	}
    	Arrays.sort(arr);
    	
    	int answer = 0;
    	for(int i=1; i<count; i+=2) {
    		answer += arr[i-1] * arr[i];
    	}
    	if(count%2==1) answer += arr[count-1];
    	for(int i=n-1; i>=count+1; i-=2) {
    		int sum = arr[i-1] + arr[i];
    		int mul = arr[i-1] * arr[i];
    		if(sum < mul) {
    			answer += mul;
    		}
    		else {
    			answer += sum;
    		}
    	}
    	if((n-count)%2 == 1) answer += arr[count];
    	System.out.println(answer);
    }
}

