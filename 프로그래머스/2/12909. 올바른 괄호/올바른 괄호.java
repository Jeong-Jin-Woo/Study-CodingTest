import java.util.*;
class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> st = new Stack<>();
        for(int i=0; i<s.length(); i++){
            st.push(s.charAt(i));
        }
        int count = 0;
        while(!st.isEmpty()){
            Character now = st.pop();
            if(now==')') count += 1;
            else count -= 1;
            
            if(count < 0) {
                answer = false;
                break;
            }
        }
        if(count != 0) answer = false;
        return answer;
    }
}