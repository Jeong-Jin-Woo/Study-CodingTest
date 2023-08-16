import java.util.*;
public class 럭키스트레이트{
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		ArrayList<Integer> arr = new ArrayList<>();
		
		while(n>0) {
			arr.add(n%10);
			n/=10;
		}

		int left = 0;
		int right = 0;
		for(int i=0; i<arr.size()/2; i++) {
			left+=arr.get(i);
		}
		for(int i=arr.size()/2; i<arr.size(); i++) {
			right += arr.get(i);
		}
		
		if(right == left)
			System.out.println("LUCKY");
		else
			System.out.println("READY");
	}
}