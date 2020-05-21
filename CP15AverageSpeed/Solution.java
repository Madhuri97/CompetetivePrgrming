import java.io.*;
import java.util.*;
import java.text.DecimalFormat;

public class Solution {
   
    static int hours;
    static int minuts;
    static int secnds;
    static double sumDist;
    static double speed;

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        StringTokenizer st = null;
        String strr = null;
        while(scan.hasNextLine()) {
            strr = scan.nextLine();
            st = new StringTokenizer(strr," ");
            if(st.countTokens()==2) {
                strr = st.nextToken();
                double tempspeed = Double.parseDouble(st.nextToken()) / 3600;
                st = new StringTokenizer(strr,":");
                process(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),-1);
                speed = tempspeed;
            }
            else {
                st = new StringTokenizer(st.nextToken(),":");
                process(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),1);
            }
        }
    }
    
    static int f = 0;
    
    static void process(int h,int m,int s,int flag) {
        int sumSecond = 0;
        sumSecond += (s-secnds);
        sumSecond += ((m-minuts)*60);
        sumSecond += ((h-hours)*3600);
        sumDist += (sumSecond * speed);
        if(flag==1) {
            if(f!=0) System.out.println();
            f++;
            display(h,m,s);
            StringBuffer sb = new StringBuffer("###.");
            for(int i=0; i< 2; i++)
            {
                sb.append("0");
            }
            DecimalFormat df2 = new DecimalFormat(sb.toString());
            StringBuffer result = new StringBuffer(df2.format(sumDist));
            if(result.indexOf(".")==0) {
                result.insert(0,"0");
            }
            System.out.print(result.toString());
            System.out.print(" km");
        }
        hours = h;
        minuts = m;
        secnds = s;
    }
    
    static void display(int h,int m,int s) {
        if(h< 10) System.out.print("0");
        System.out.print(h+":");
        if(m< 10) System.out.print("0");
        System.out.print(m+":");
        if(s< 10)
            System.out.print("0");
        System.out.print(s+" ");
    }
}