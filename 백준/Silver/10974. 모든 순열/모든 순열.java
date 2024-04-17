import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static boolean visit[];
	static void dfs(int start, int n, int[] arr) {
		if(start == n) {
			for(int i=0; i<arr.length; i++) {
				System.out.print(arr[i] + " ");
			}System.out.println();
			return;
		}
		for(int i=0; i<n; i++) {
			if(!visit[i]) {
				visit[i] = true;
				arr[start] = i+1;
				dfs(start + 1, n, arr);
				arr[start] = 0;
				visit[i] = false;
			}
		}
	}
	public static void main(String args[]) throws IOException {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int arr[] = new int[n];
		visit = new boolean[n];
		dfs(0,n, arr);
	}
}
