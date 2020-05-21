import java.io.*;
import java.util.*;

import java.util.Scanner;
public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int ti = input.nextInt();
        int N = 0;
        int T = 0;
        double max = 0;
        int mj = 0;
        int tmp = 0;
        double temp = 0;
        for (int i = 0; i < ti; i++) {
            T = 0;
            N = input.nextInt();
            int[] t = new int[N];
            double[] f = new double[N];
            double[] ans = new double[N];
            int[] sol = new int[N];
            boolean[] flag = new boolean[N];
            for (int j = 0; j < N; j++) {
                t[j] = input.nextInt();
                f[j] = input.nextInt();
                ans[j] = f[j] / t[j];
                sol[j] = j + 1;
            }
            for (int k = 0; k < N - 1; k++) {
                max = 0;
                mj = k;
                for (int j = 0; j < N - 1 - k; j++) {
                    if (ans[j] < ans[j + 1]) {
                        temp = ans[j];
                        ans[j] = ans[j + 1];
                        ans[j + 1] = temp;
                        tmp = sol[j];
                        sol[j] = sol[j + 1];
                        sol[j + 1] = tmp;
                    }
                }
            }
            System.out.print(sol[0]);
            for (int k = 1; k < N; k++) {
                System.out.print(" " + sol[k]);
            }
            System.out.println();
            if (i != ti - 1) {
                System.out.println();
            }
        }
    }
}