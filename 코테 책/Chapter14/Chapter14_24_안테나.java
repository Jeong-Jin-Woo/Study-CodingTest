import java.util.*;
public class Chapter14_24_¾ÈÅ×³ª {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		ArrayList<Integer> arr = new ArrayList<>();
		for(int i=0; i<n; i++) {
			int a = in.nextInt();
			arr.add(a);
		}
		
		Collections.sort(arr);
		System.out.println(arr.get(n/2-1));
	}
}