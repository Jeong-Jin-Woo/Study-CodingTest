class Solution {
    public long solution(int n) {
        long dp[] = new long[5001];
        long mod = 1_000_000_007;
        dp[0] = 1;
        dp[2] = 3;
        for(int i=4; i<=n; i+=2){
            dp[i] = (dp[i-2]*4 % mod - dp[i-4] %mod + mod) % mod;
        }
        long answer = dp[n];
        return answer;
    }
}