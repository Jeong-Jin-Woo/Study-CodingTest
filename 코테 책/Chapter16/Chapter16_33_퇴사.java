import java.util.*;
public class Chapter16_33_��� {
	
	static int[] d = new int[16];
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] t = new int[n];
		int[] p = new int[n];
		for(int i=0; i<n; i++) {
			t[i] = in.nextInt();
			p[i] = in.nextInt();
		}
		int max = 0;
		for(int i= n-1; i>=0; i--) {
			int time = t[i] + i;
			if(time <= n) {
				d[i] = Math.max(max, d[time] + p[i]);
				max = d[i];
			}
			else
				d[i] = max;
		}
		System.out.println(max);
	}
	

}
/*
    static int n; // ��ü ��� ����
    static int[] t = new int[15]; // �� ����� �Ϸ��ϴµ� �ɸ��� �Ⱓ
    static int[] p = new int[15]; // �� ����� �Ϸ����� �� ���� �� �ִ� �ݾ�
    static int[] dp = new int[16]; // ���̳��� ���α׷����� ���� 1���� DP ���̺� �ʱ�ȭ
    static int maxValue;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            t[i] = sc.nextInt();
            p[i] = sc.nextInt();
        }

        // �迭�� �ڿ������� �Ųٷ� Ȯ��
        for (int i = n - 1; i >= 0; i--) {
            int time = t[i] + i;
            // ����� �Ⱓ �ȿ� ������ ���
            if (time <= n) {
                // ��ȭ�Ŀ� �°�, ��������� �ְ� ���� ���
                dp[i] = Math.max(p[i] + dp[time], maxValue);
                maxValue = dp[i];
            }
            // ����� �Ⱓ�� ����� ���
            else dp[i] = maxValue;
            System.out.print(dp[i]+ " ");
        }

        System.out.println(maxValue);
    }

*/