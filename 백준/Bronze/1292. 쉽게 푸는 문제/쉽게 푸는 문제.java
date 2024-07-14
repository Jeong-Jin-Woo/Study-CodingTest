import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();

		int cnt = 0;
		int sum = 0;
		for(int i=1; i<=1000; i++){
		    for(int j=1; j <=i; j++){
		          cnt += 1;
		          if (cnt >= n && cnt <= m)
		                  sum += i;
		    }
		}

		System.out.println(sum);
	
	}
}
