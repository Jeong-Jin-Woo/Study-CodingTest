import java.util.*;
public class Chapter06_2_�������Ʒ��� {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		Integer arr[] = new Integer[n]; //int�� Integer�� ���� ����! (primitive type, wrapper class)
		for(int i=0; i<n; i++) {
			arr[i] = in.nextInt();
		}
		
		//Arrays.sort(arr, Collections.reverseOrder());
		
		Collections.sort(Arrays.asList(arr));
		Collections.reverse(Arrays.asList(arr));
		
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

}
