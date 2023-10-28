class Solution {
    public String solution(String s) {
        String[] str = s.split(" ");
        int max = (int)-1e9;
        int min = (int)1e9;
        for(int i=0; i<str.length; i++){
            max = Math.max(max, Integer.valueOf(str[i]));
            min = Math.min(min, Integer.valueOf(str[i]));
        }
        String answer = min+" "+max;
        return answer;
    }
}