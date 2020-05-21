import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception{
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line;
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        st = new StringTokenizer(input.readLine());
        int noOfTests = Integer.parseInt(st.nextToken());
        int noOfAnts = 0;
        int currentPos = 0;
        int length = 0;
        int minTime;
        int maxTime;

        st = new StringTokenizer(input.readLine());
        while (st.hasMoreTokens()) {   
            if (st.hasMoreTokens()) { length = Integer.parseInt(st.nextToken()); }
            else { 
                st = new StringTokenizer(input.readLine()); 
                length = Integer.parseInt(st.nextToken());
            }
            if (st.hasMoreTokens()) { noOfAnts = Integer.parseInt(st.nextToken()); }
                        else { 
                st = new StringTokenizer(input.readLine()); 
                noOfAnts = Integer.parseInt(st.nextToken());
            }
            minTime = Integer.MIN_VALUE;
            maxTime = Integer.MIN_VALUE;
            
            if (!st.hasMoreTokens()) {
                st = new StringTokenizer(input.readLine());
            }
            while (noOfAnts > 0) {
                while (st.hasMoreTokens()) {
                    currentPos = Integer.parseInt(st.nextToken());    
                    minTime = Math.max(minTime, Math.min(currentPos, length - currentPos));
                    maxTime = Math.max(maxTime, Math.max(currentPos, length - currentPos));
                    noOfAnts --;
                    if (noOfAnts == 0) {
                        break;
                    }    
                }
                if (noOfAnts > 0 || !st.hasMoreTokens()) {
                    if ((line = input.readLine()) != null) {
                        st = new StringTokenizer(line);
                    }
                }
            }
            sb.append(minTime + " " + maxTime + "\n");
        }
        System.out.print(sb);
    }
}