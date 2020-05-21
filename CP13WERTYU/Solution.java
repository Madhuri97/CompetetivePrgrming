import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String Keybrd = "`1234567890-=QWERTYUIOP[]\\ASDFGHJKL;'ZXCVBNM,./";
        while(sc.hasNext()) {
            String str = sc.nextLine();
            int len = str.length();
            for(int i = 0; i < len; i++) {
                if(str.charAt(i) == '`') {
                    System.out.print("`");
                } else if(str.charAt(i) == ':') {
                    System.out.print(":");
                } else if(str.charAt(i) == ' ') {
                    System.out.print(" ");
                } else {
                    System.out.print(Keybrd.charAt(Keybrd.indexOf(str.charAt(i)) - 1));
                }
            }
            System.out.println();
        }
    }
}