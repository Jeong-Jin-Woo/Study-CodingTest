class Solution {
    public String solution(String s) {
        s = s.toLowerCase();
        String answer = "";
        answer += s.toUpperCase().charAt(0);
        for(int i=1; i<s.length(); i++){
            if(s.charAt(i-1) == ' '){ 
                answer += s.toUpperCase().charAt(i);
                continue;
            }
            answer += s.charAt(i);
        }
        return answer;
    }
}