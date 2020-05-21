import java.util.*;

public class Solution {
    public static int collatz(int n) {
        int count = 0;
        count++;
        while (n > 1) {
            if (n % 2 == 0) {
                n = n / 2;
                count++;
            } else {
                n = (3 * n) + 1;
                count++;
            }
        } 
        return count;
    }

    public static int max(int c, int maxi) {
        if(c > maxi) {
            maxi = c;
        } 
        return maxi;
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner s = new Scanner(System.in);
        while(s.hasNext()) {
        int i = s.nextInt();
        int j = s.nextInt();
        int temp = 0;
        int flag = 0;
        if(i > j) {
            temp = i;
            i = j;
            j = temp;
            flag = 1;
        }
        int maxi = 0;
        int a = i;
        while(a <= j) { 
           maxi = max(collatz(a), maxi);
           a++;
        }
        if(flag == 1) {
        System.out.println(j + " " + i + " " + maxi);
        } else {
            System.out.println(i + " " + j + " " + maxi);
        }
        }
        s.close();
    }
}