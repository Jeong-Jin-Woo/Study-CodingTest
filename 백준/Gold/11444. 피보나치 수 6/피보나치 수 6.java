import java.util.*;
public class Main{
	static final int MOD = 1_000_000_007;
	static long[][] mat(long[][] a, long[][] b) {
        long[][] arr = new long[2][2];
        arr[0][0] = (a[0][0]*b[0][0]%MOD + a[0][1]*b[1][0]%MOD)%MOD;
        arr[1][0] = (a[0][0]*b[0][1]%MOD + a[0][1]*b[1][1]%MOD)%MOD;
        arr[0][1] = (a[1][0]*b[0][0]%MOD + a[1][1]*b[1][0]%MOD)%MOD;
        arr[1][1] = (a[1][0]*b[0][1]%MOD + a[1][1]*b[1][1]%MOD)%MOD;
        return arr;
    }
	static long[][] search(long n) {
		if(n == 1) {
			long[][] arr = {{1,1},{1,0}};
			return arr;
		}
		long[][] tmp = search(n/2);
		if(n%2==1) {
			return mat(mat(tmp, tmp), search(1));
		}else {
			return mat(tmp, tmp);
		}
	}
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		long n = in.nextLong();
		System.out.println(search(n)[0][1]);
	}
}
