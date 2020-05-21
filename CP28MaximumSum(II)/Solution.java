import java.io.*;
import java.util.*;
public class Solution {

    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        while(true)
        {
            int n = scan.nextInt();
            if(n == 0)
                break;
            ArrayList<Integer> array = new ArrayList<Integer>(n);
            while(n-- > 0)
            {
                int num = scan.nextInt();
                if(num==0)
                    continue;
                array.add(num);
            }
            if(array.size()==0)
                sb.append("0\n");
            else
            {
                for(int i = 0; i < array.size() - 1; i++)
                    sb.append(array.get(i)).append(" ");
                sb.append(array.get(array.size()-1)).append("\n");
            }
        }
        
        System.out.print(sb);
    }
}