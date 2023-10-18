import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = s.length();
        for(int i=1; i<=s.length()/2 + 1; i++){
            int cnt = 1;
            String sp = s.substring(0,i);
            String comp = "";
            for(int j=i; j<s.length(); j+=i){
                String sub = "";
                for(int k=j; k<j+i; k++){
                    if(k < s.length())
                        sub += s.charAt(k);
                }
                if(sp.equals(sub)) cnt++;
                else{
                    comp += (cnt>=2) ? cnt + sp : sp;
                    sub = "";
                    for(int k=j; k<j+i; k++){
                        if(k < s.length())
                            sub += s.charAt(k);
                    }
                    sp = sub;
                    cnt = 1;
                }
            }
            comp += (cnt>=2) ? cnt + sp : sp;
            answer = Math.min(answer, comp.length());
        }
        return answer;
    }
}