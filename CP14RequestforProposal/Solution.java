import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception{
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String str;
        int testCase=1;
        
        while ((str=br.readLine())!=null && !str.equals("0 0")) {
            StringTokenizer st=new StringTokenizer(str);
            int n=Integer.parseInt(st.nextToken());
            int p=Integer.parseInt(st.nextToken());
            
            for (int i=0;i<n;i++) 
            {
                br.readLine();
            }
            
            String name="";
            int count=0;
            double price=0.0;
            
            for (int i=0;i<p;i++) 
            {
                String currentName=br.readLine();
                st=new StringTokenizer(br.readLine());
                double currentPrice=Double.parseDouble(st.nextToken());
                int currentCount=Integer.parseInt(st.nextToken());
                
                for (int i2=0;i2<currentCount;i2++) 
                {
                    br.readLine();
                }
                
                if (currentCount>count || (currentCount==count && price>currentPrice)) {
                    name=currentName;
                    count=currentCount;
                    price=currentPrice;
                }
            }
            
            if (testCase > 1) {
                System.out.println();
            }
            
            System.out.println("RFP #"+(testCase++)+"\n"+name);
        }
    }
}