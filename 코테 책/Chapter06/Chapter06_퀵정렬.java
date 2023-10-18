import java.util.*;
public class Chapter06_ÄüÁ¤·Ä {
	
	static void quickSort(int[] arr, int start, int num) {
		if(start >= num) return;
		
		int pivot = start;
		int left = start+1;
		int right = num;
		
		for(int i=0; left <= right; i++) {
			if(arr[pivot] < arr[left] && arr[pivot] > arr[right]) {
				int tmp = arr[left];
				arr[left] = arr[right];
				arr[right] = tmp;
			}
			if(arr[pivot] < arr[left] || arr[pivot] > arr[right]) {
				if(arr[pivot] < arr[left]) {
					right--;
					continue;
				}
				if(arr[pivot] > arr[right]) {
					left++;
					continue;
				}
			}
			left++;
			right--;
		}
        

		if(left > right) {
			int tmp = arr[right];
			arr[right] = arr[pivot];
			arr[pivot] = tmp;
		}
		
		quickSort(arr, start , right - 1);
		quickSort(arr, left, num);
	}
	
	public static void main(String[] args) {
        int n = 10;
        int[] arr = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};

        quickSort(arr, 0, n - 1);

        for(int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
	}

}
