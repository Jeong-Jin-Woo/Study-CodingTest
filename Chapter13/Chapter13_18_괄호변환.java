import java.util.*;
class Solution {
    public int getIndex(String p){
        int count = 0;
        for(int i=0; i<p.length(); i++){
            if(p.charAt(i) == '(') count++;
            else count--;
            if(count == 0) return i;
        }
        return -1;
    }
    public boolean check(String str){
        boolean chk = false;
        Stack<Character> s = new Stack<>();
        s.push(str.charAt(0));
        for(int i=1; i<str.length(); i++){
            if((s.peek() == str.charAt(i)) || (s.peek() == ')' && str.charAt(i) == '(')){
                s.push(str.charAt(i));
            }
            else{
                s.pop();
            }
        }
        if(!s.isEmpty()) chk = false;
        else chk = true;
        return chk;
    }
    public String solution(String p) {
        String answer = "";
        if(p.equals("")) return answer;
        int index = getIndex(p);
        String u = p.substring(0,index+1);
        String v = p.substring(index+1);
        if(check(u)){
            answer += u + solution(v);
        }
        else{
            answer += "(";
            answer += solution(v);
            answer += ")";
            u = u.substring(1,u.length()-1);
            String tmp = "";
            for(int i=0; i<u.length(); i++){
                if(u.charAt(i) == ')') tmp += "(";
                else tmp += ")";
            }
            answer += tmp;
        }
        return answer;
    }
}