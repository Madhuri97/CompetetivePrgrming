import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int n[] = new int[15];
        boolean first = true;
        
        while (in.hasNextInt()) {
            int N = in.nextInt();
            
            if (N == 0) {
                break;
            }
            
            if (first) {
                first = false;
            } else {
                System.out.println();
            }
            
            for (int i = 0; i < N; i++) {
                n[i] = in.nextInt();
            }
            
            Arrays.sort(n, 0, N);
            int numbs[] = new int[N];
            System.arraycopy(n, 0, numbs, 0, N);
            
            for (int i = 0; i < N/2; i++) {
                int t = n[i];
                n[i] = n[N-i-1];
                n[N-i-1] = t;
            }    
            
            for (int m = (1 << N)-1; m >= 0; m--) {
                if (Integer.bitCount(m) == 6) {
                    StringBuilder sb = new StringBuilder();
                    for (int i = N-1; i >= 0; i--) {
                        if (((1 << i) & m) != 0) {
                            sb.append(n[i]).append(' ');
                        }
                    }
                    System.out.println(sb.toString().trim());
                }
            }
        }
    }
}