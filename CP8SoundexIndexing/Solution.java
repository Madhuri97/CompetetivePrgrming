import java.io.*;
import java.util.*;

public class Sol {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int[] c = new int[100];
        c['B'] = c['P'] = c['F'] = c['V'] = 1;
        c['C'] = c['S'] = c['K'] = c['G'] = c['J'] = c['Q'] = c['X'] = c['Z'] = 2;
        c['D'] = c['T'] = 3; 
        c['L'] = 4;
        c['M'] = c['N'] = 5;
        c['R'] = 6;
        String s = "AEIOUWHY";
        while(scan.hasNextLine()) {
            char[] name = scan.nextLine().toCharArray();
            String b = String.valueOf(name[0]);
            int size = 0;
            for(int i = 1; i < name.length; ++i) {
                if(s.contains(String.valueOf(name[i]))) {
                    continue;
                } if(c[name[i]] == c[name[i-1]]) {
                    continue;
                }
                b = b + c[name[i]];
                ++size;
                if(size == 3) {
                    break;
                }
            }
            for(int j = b.length(); j < 4; ++j) {
                b = b + '0';
            }
            System.out.print("" + String.valueOf(name) + ";");
                System.out.println(b);
        }
        scan.close();
    }
}