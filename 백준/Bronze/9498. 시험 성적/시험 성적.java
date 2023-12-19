import java.util.*;
public class Main {
 
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int A = in.nextInt();
		
		System.out.print((A>=90)?"A": (A>=80)? "B": (A>=70)? "C": (A>=60)? "D": "F");
	}
}