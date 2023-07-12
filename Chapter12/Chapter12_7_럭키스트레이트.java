import java.util.*;
public class Chapter12_7_럭키스트레이트 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String n = in.next();
		int num = 0;
		for(int i=0; i<n.length()/2; i++) {
			num += n.charAt(i) - '0';
		}
		for(int i=n.length()/2; i<n.length(); i++) {
			num -= n.charAt(i) - '0';
		}
		
		if(num == 0) System.out.println("LUCKY");
		else System.out.println("LUCKY");
	}
}
/*
int num = n;
int count=0;
while(n>0) {
	count++;
	n/=10;
}

int left =0, right =0;
for(int i=0; i<count/2; i++) {
	right += num%10;
	num/=10;
}
for(int i=0; i<count/2; i++) {
	left += num%10;
	num/=10;
}

if(left == right) System.out.println("LUCKY");
else System.out.println("READY");
*/