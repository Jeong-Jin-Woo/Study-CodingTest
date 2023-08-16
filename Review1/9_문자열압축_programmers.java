import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = s.length();
        for(int step=1; step<s.length()/2+1; step++){
            String comp = "";
            String pre = s.substring(0,step);
            int count = 1;
            for(int j=step; j<s.length(); j+=step){
                String cmp = "";
                for(int i=j; i<step+j; i++){
                    if(i < s.length()) cmp += s.charAt(i);
                }
                if(pre.equals(cmp)) count++;
                else{
                    if(count >= 2)
                        comp += count + pre;
                    else {
                        comp += pre;
                    }
                    pre = cmp;
                    count = 1;
                }
            }
            comp += (count >=2) ? count + pre : pre;
            answer = Math.min(comp.length(), answer);
            // System.out.println(comp);
        }
        return answer;
    }
}