import java.io.*;
import java.util.*;

public class Solution {
    public static long U, L, N, M;
    public static void main(String[] args) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        long i, max, val, M1, M2;
                String line = null;
        String[] split = null;
        while((line = reader.readLine()) != null) {
            
            split = line.split("\\s+");
            N = Long.valueOf(split[0]);
            L = Long.valueOf(split[1]);
            U = Long.valueOf(split[2]);
            
            M1 = getResult(L);
            M2 = getResult(U);
    
            if ((N^M1) > (N^M2)) {
                System.out.println(M1);
            } else {
                System.out.println(M2);
            }
        }
    }
    
    public static long getResult(long M) {
        for(long i = 32; i >= 0; i--) {
            if ((N & (1L << i)) != 0) {
                M &= ~(1L << i); 
                 if (M < L) {
                    M |= (1L << i);
                 }
            } else {
               M |= (1L << i);
               if (M > U) {
                    M &= ~(1L << i);
               }
            }
        }
        return M;
    }
}