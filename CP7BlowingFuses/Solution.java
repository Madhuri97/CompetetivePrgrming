import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while(s.hasNext()) {
        int n = s.nextInt();
        int m = s.nextInt();
        int c = s.nextInt();
        int f = 1;
        while (n != 0 && m != 0 && c != 0) {
            int cons[] = new int[n];
            boolean state[] = new boolean[n];

            for (int i = 0; i < n; i++) {
                cons[i] = s.nextInt();
            }
            int sum = 0;
            int max = 0;
            boolean blown = false;
            for (int i = 0; i < m; i++) {
                int dev = s.nextInt() - 1;
                if (!blown) {
                    state[dev] = !state[dev];
                    sum += cons[dev] * (state[dev] ? 1 : -1);
                    if (sum > max) {
                        max = sum;
                        if (max > c) {
                            blown = true;
                        }
                    }
                }
            }
            System.out.println("Sequence " + f++);
            if (blown) {
                System.out.println("Fuse was blown.");
            } else {
                System.out.println("Fuse was not blown.");
                System.out.println("Maximal power consumption was "
                        + max + " amperes.");
            }
            System.out.println();
            n = s.nextInt();
            m = s.nextInt();
            c = s.nextInt();
        }
    }
}
}