import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner s = new Scanner(System.in);
        int count = 0;
        while(s.hasNext()) {
        String str = s.nextLine();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(c == '\"') {
                count++;
                if(count%2 != 0) {
                    System.out.print("``");
                } else {
                    System.out.print("''");
                }
            } else {
                System.out.print(str.charAt(i));
            }
        } 
        System.out.print("\n");
    }
    }
}