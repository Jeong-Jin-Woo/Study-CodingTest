import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int test = 1; test <= T; test++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            long K = Long.parseLong(st.nextToken());

            long[] A = new long[N];
            long[] F = new long[N];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                A[i] = Long.parseLong(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                F[i] = Long.parseLong(st.nextToken());
            }

            long answer = minTime(N, K, A, F);
            System.out.println("#" + test + " " + answer);
        }
    }

    public static long minTime(int N, long K, long[] A, long[] F) {
        // 능력치를 오름차순으로 정렬
        Arrays.sort(A);
        // 난이도를 내림차순으로 정렬
        Arrays.sort(F);
        reverseArray(F);

        long left = 0;
        long right = (long) 1e12; // 가능한 최대 시간 설정
        long answer = right;

        while (left <= right) {
            long mid = (left + right) / 2;
            long cnt = 0;

            for (int i = 0; i < N; i++) {
                // 먹는 시간 계산
                long eatTime = mid / F[i];
                // 먹는 시간이 능력치보다 크면 트레이닝 횟수 증가
                if (A[i] > eatTime) {
                    cnt += (A[i] - eatTime);
                }
            }

            // 트레이닝 횟수가 K보다 작거나 같으면 최소 시간 갱신
            if (cnt <= K) {
                answer = Math.min(answer, mid);
                right = mid - 1;
            } else { // 트레이닝 횟수가 K보다 크면 시간을 늘려야 함
                left = mid + 1;
            }
        }

        return answer;
    }

    // 배열을 뒤집는 함수
    public static void reverseArray(long[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            long temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
