import java.util.*;
class Position{
	public char c;
	public int op;
	Position(char c){
		this.c=c;
		if(c=='*' || c=='/') {
			this.op=2;
		}
		else if(c=='(') {
			this.op=0;
		}
		else if(c=='+' || c=='-') {
			this.op=1;
		}
	}
}
public class Main{
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		String infix = in.next();
		Stack<Position> st = new Stack<>();
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<infix.length(); i++) {
			if(infix.charAt(i) >= 'A' && infix.charAt(i) <= 'Z') {
				sb.append(infix.charAt(i));
			}
			else {
				int x;
				if(infix.charAt(i) == '+' || infix.charAt(i) == '-') x = 1;
				else if(infix.charAt(i) == '*' || infix.charAt(i) == '/') x = 2;
				else x = 3;
				if(infix.charAt(i) == ')') {
					while(st.peek().c !='(') {
						Position now = st.pop();
						sb.append(now.c);
					}
					st.pop();
					continue;
				}
				while(!st.isEmpty() && st.peek().op >= x) {
					Position now = st.pop();
					sb.append(now.c);
				}
				st.push(new Position(infix.charAt(i)));
//						for(int s=0; s<st.size(); s++) {
//							System.out.print(st.get(s).c);
//						}
//						System.out.println();
			}
		}
		while(!st.isEmpty()) {
			sb.append(st.pop().c);
		}
		System.out.println(sb);
	}
}
