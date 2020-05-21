import java.util.Scanner;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String country[] = new String[n];
        Set<String> set = new HashSet<String>();
        for(int i = 0; i < n; i++) {
            country[i] = sc.next(); 
            set.add(country[i]); 
            String No = sc.nextLine(); 
        }
        Arrays.sort(country);
        String st[] = set.toArray(new String[set.size()]);
        Arrays.sort(st);
        for(int i = 0; i < st.length; i++) {
            int count = 0;
            for(int j = 0; j < n; j++) {
                if(st[i].equals(country[j])) count++;
            }
            System.out.println(st[i] + " " + count);    
        }
    }
}
