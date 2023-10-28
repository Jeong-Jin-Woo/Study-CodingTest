import java.util.*;
public class Main{
	static String[] arr = {"c=", "c-" ,"dz=", "d-" , "lj","nj","s=","z="};
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		String str = in.next();
		for(int i=0; i<arr.length; i++) {
			str = str.replace(arr[i],"1");
		}
		System.out.println(str.length());
	}
}
