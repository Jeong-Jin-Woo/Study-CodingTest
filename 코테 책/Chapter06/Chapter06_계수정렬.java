import java.util.*;
public class Chapter06_계수정렬 {
	public static void main(String[] args) {
		int arr[] = {7,5,9,0,3,1,6,2,9,1,4,8,0,5,2};
		int arr_f[] = new int[10];
		
		for(int i=0; i<arr.length; i++)
			arr_f[arr[i]]++;
		
		for(int i=0; i<arr_f.length; i++) {
			for(int j=0; j<arr_f[i]; j++) {
				System.out.print(i+" ");
			}
		}
	}

}
