import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
        while(tc-->0)
        {
            int n = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
            int[] p = new int[n];
            StringTokenizer st= new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++)
                p[i] = Integer.parseInt(st.nextToken());
            Arrays.sort(p);
            int max = 0;
            for(int i = n - 3; i>= 0; i -= 3)
                max += p[i];
            sb.append(max+"\n");            
        }
        System.out.print(sb);
    }
}