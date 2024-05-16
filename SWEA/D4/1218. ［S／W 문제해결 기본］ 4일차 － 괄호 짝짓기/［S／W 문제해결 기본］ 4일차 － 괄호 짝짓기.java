import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        for(int test=1; test<=10; test++) {
        	int n = in.nextInt();
        	String str = in.next();
        	Stack<Character> st = new Stack<>();
        	boolean chk = true;
        	for(int i=0; i<n; i++) {
        		char now = str.charAt(i);
        		if(now == '[' || now == '{' || now == '(' || now =='<') {
        			st.push(now);
        		}
        		if(now == ']') {
        			if(!st.isEmpty()) {
        				if(st.peek() == '[') st.pop();
        				else st.push(now);
        			}
        			else {
        				st.push(now);
        			}
        		}
        		if(now == '}') {
        			if(!st.isEmpty()) {
        				if(st.peek() == '{') st.pop();
        				else st.push(now);
        			}
        			else {
        				st.push(now);
        			}
        		}
        		if(now == ')') {
        			if(!st.isEmpty()) {
        				if(st.peek() == '(') st.pop();
        				else st.push(now);
        			}
        			else {
        				st.push(now);
        			}
        		}
        		if(now == '>') {
        			if(!st.isEmpty()) {
        				if(st.peek() == '<') st.pop();
        				else st.push(now);
        			}
        			else {
        				st.push(now);
        			}
        		}
        	}
        	if(!st.isEmpty()) chk = false;
    		System.out.println("#"+test + " " + (chk ? 1 : 0));
        }
    }
}
