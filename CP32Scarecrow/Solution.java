import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception{
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        
        for (int testCase = 1; testCase <= tc; testCase++) {
            int n = Integer.parseInt(br.readLine());
            String str = br.readLine();
            int start = 0;
            int count = 0;
            
            for (int i = 0; i < n; i++) {
                if (i-start == 1) {
                    start = i + 2;
                    i++;
                    count++;
                } else {
                    if (str.charAt(i) == '#') {
                        start = i + 1;
                    }
                }
            }
            
            if (start == n - 1) {
                count++;
            }
            System.out.println("Case "+testCase+": "+count);
        }
    }
}