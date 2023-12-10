import java.util.*;
public class Main{
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		int c = in.nextInt();
		while(c-- != 0) {
			String p = in.next();	// 문제에서 p에 해당하는 명령어
			int n = in.nextInt();
			String tmp = in.next();
			tmp = tmp.replace("[","").replace("]", "");
			String[] x = tmp.split(",");
			Deque<String> dq = new LinkedList<>();
			for(int i=0; i<n; i++) {
				dq.add(x[i]);
			}
			boolean chk = true;
			boolean check = false;
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<p.length(); i++) {
				if(p.charAt(i) == 'R') {
					check = !check;
				}
				else {
					if(dq.size() == 0) {
						chk = false;
						break;
					}
					if(check) {
						dq.pollLast();
					}
					else {
						dq.pollFirst();
					}
				}
			}
			if(!chk) {
				sb.append("error");
				System.out.println(sb);
				continue;
			}
			
			sb.append("[");
			while(!dq.isEmpty()) {
				sb.append(check ? dq.pollLast() : dq.pollFirst());
				if(dq.size()!=0)
					sb.append(",");
			}
			sb.append("]");
			
			System.out.println(sb);
		}
	}
}
