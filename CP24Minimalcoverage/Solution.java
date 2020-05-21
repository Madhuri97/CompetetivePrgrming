import java.io.*;
import java.util.*;

class Solution {
    
    public static void main (String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < tc; i++) {
            br.readLine();
            int M = Integer.parseInt(br.readLine());
            ArrayList<int[]> segments = new ArrayList<>();
            String str;
           
            while (!(str = br.readLine()).equals("0 0")) {
                StringTokenizer st = new StringTokenizer(str);
                int[] ints = new int[] {
                    Integer.parseInt(st.nextToken()), 
                    Integer.parseInt(st.nextToken())
                };
                segments.add(ints);
            }
            
            Collections.sort(segments, (a,b) -> {
                if (a[0] == b[0]) 
                    return a[1] - b[1];
                return a[0] - b[0];
            });
            
            ArrayList<int[]> result = new ArrayList<>();
            int end = 0;
            int index = 0;
            
            while (index < segments.size() && end < M) {
                ArrayList<int[]> f_segments = new ArrayList<>();
                
                for (index = 0; index < segments.size(); index++) {
                    int[] curr = segments.get(index);
                    if (curr[0] <= end) 
                        f_segments.add(curr);
                    else if (curr[1] >= end) 
                        break;
                }
                if (f_segments.size() > 0) {    
                    Collections.sort(f_segments, (a,b) -> {
                        if (a[1] == b[1]) 
                            return b[0] - a[0];
                        return a[1] - b[1];
                    });
                    int[] seg_selected = f_segments.get(f_segments.size() - 1);
                    result.add(seg_selected);
                    end = Math.min(seg_selected[1], M);
                } 
            }
            
            if (i > 0) 
                System.out.println();
            if (end != M) 
                System.out.println("0");
            else {
                System.out.println(result.size());
                for (int[] j : result)
                    System.out.println(j[0] + " " + j[1]);
            }
        }
    }

}