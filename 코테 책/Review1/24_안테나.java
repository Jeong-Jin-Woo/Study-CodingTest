import java.util.*;
public class ���׳�{
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		ArrayList<Integer> arr = new ArrayList<>();
		for(int i=0; i<n; i++) {
			arr.add(in.nextInt());
		}
		Collections.sort(arr);
		System.out.println(arr.get(n-1)/2);
	}
}