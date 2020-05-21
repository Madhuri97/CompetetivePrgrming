import java.util.Scanner;

public class Solution{ 
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while(s.hasNext()) {
            int H = s.nextInt();
            double U = s.nextDouble();
            int D = s.nextInt();
            double F = s.nextDouble();
            if(H == 0) {
                break;
            }
            F = U * (F/100);
            double currHt = 0.0;
            int days = 0;
            while(true) {
                days++;
                currHt += U;
                if(currHt > H) {
                    System.out.println("success on day " + days);
                    break;
                }
                currHt -= D;
                if(currHt < 0) {
                    System.out.println("failure on day " + days);
                    break;
                }
                U = U - F;
            }
        }
        s.close();
    }
}