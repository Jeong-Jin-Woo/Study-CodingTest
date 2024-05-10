import java.util.*;
class Solution {
    static boolean check(String str){
        boolean check = true;
        Stack<Character> st = new Stack<>();
        Stack<Character> set = new Stack<>();
        for(int i=0; i<str.length(); i++){
            st.push(str.charAt(i));
        }
        while(!st.isEmpty()){
            char c = st.pop();
            if(c == ')' || c == '}' || c == ']'){
                set.push(c);
            }
            if(c == '('){
                if(!set.isEmpty()){
                    if(set.peek() == ')')
                        set.pop();
                    else{
                        check = false;
                        break;
                    }
                }
                else{
                    check = false;
                    break;
                }
            }
            else if(c == '{'){
                if(!set.isEmpty()){
                    if(set.peek() == '}')
                        set.pop();
                    else{
                        check = false;
                        break;
                    }
                }
                else{
                    check = false;
                    break;
                }
            }
            else if(c == '['){
                if(!set.isEmpty()){
                    if(set.peek() == ']')
                        set.pop();
                    else{
                        check = false;
                        break;
                    }
                }
                else{
                    check = false;
                    break;
                }
            }
        }
        if(set.size() != 0) check = false;
        return check;
    }
    public int solution(String s) {
        int answer = 0;
        String save = s;
        Queue<Character> q = new LinkedList<>();
        for(int i=0; i<s.length(); i++){
            q.offer(s.charAt(i));
        }
        if(check(save)) answer += 1;
        String compare = "";
        for(int count=0; count < s.length()-1; count++){
            q.offer(q.poll());
            compare = "";
            while(!q.isEmpty()){
                compare += q.poll();
            }
            if(check(compare)) answer += 1;
            for(int i=0; i<compare.length(); i++){
                q.offer(compare.charAt(i));
            }
        }
        return answer;
    }
}