import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(b.readLine());
        for(int i = 0; i < n; i++) {
            int m = Integer.parseInt(b.readLine());
            int [] mny = new int[m];
            StringTokenizer st = new StringTokenizer(b.readLine());
            int cs = 0;
            int indCnt = 1;
            for(int j = 0; j < m; j++) {
                mny[j] = Integer.parseInt(st.nextToken());
                // System.out.println(mny[j]);
                if(j > 0) {
                    if(cs >= mny[j]) {
                        cs -= mny[j - 1];
                        cs += mny[j];
                    } else {
                        cs += mny[j];
                        indCnt++;
                    }
                } else {
                    cs = mny[j];
                }
            } 
            System.out.println(indCnt);
        }
        
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    }
}