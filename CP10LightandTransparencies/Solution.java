import java.util.*;

class Point{
    double x;
    double y;
    Point(double xCor, double yCor){
        this.x = xCor;
        this.y = yCor;
    }
}

class LineSegment{
    Point p1;
    Point p2;
    double r;
    LineSegment(Point pOne, Point pTwo, double rCoef){
        this.p1 = pOne;
        this.p2 = pTwo;
        this.r = rCoef;
    }
}
public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int tc = Integer.parseInt(scan.nextLine());

        while(tc-- > 0){
            scan.nextLine();
            int lineSegments = Integer.parseInt(scan.nextLine());
            System.out.println(lineSegments*2+1);
            // lineSegments = s;
            if(lineSegments == 0) {
                System.out.println("-inf +inf");
                break;
            }
            LineSegment[] ls = new LineSegment[lineSegments];
            Point[] points = new Point[2*lineSegments];
            int i = 0;
            int p = 0;
            String res = "";
            while(lineSegments-- > 0){
                String[] inp = scan.nextLine().split(" ");
                Point p1 = new Point(Double.parseDouble(inp[0]), Double.parseDouble(inp[1]));
                Point p2 = new Point(Double.parseDouble(inp[2]), Double.parseDouble(inp[3]));
                ls[i++] = new LineSegment(p1,p2,Double.parseDouble(inp[4]));
                points[p++] = p1;
                points[p++] = p2; 
            }
            Arrays.sort(points, new Comparator<Point>(){
                public int compare(Point p1, Point p2){
                    if(p1.x < p2.x){
                        return -1;
                    }else if(p1.x == p2.x){
                        return 0;
                    }
                    return 1;
                }
            });
            int c = 2;
            for(int j = 0; j < points.length-1; j += 1)
                c++;
            // System.out.println(2*s+1);
            System.out.printf("-inf %.3f",points[0].x);
            System.out.printf(" 1.000\n");
            for(int j = 0; j < points.length-1; j += 1){
                double trans = getTrans(points[j], points[j+1], ls);
                System.out.printf("%.3f",points[j].x);
                System.out.printf(" %.3f",points[j+1].x);
                System.out.printf(" %.3f\n", trans); 
            }
            System.out.printf("%.3f",points[points.length-1].x);
            System.out.printf(" +inf 1.000\n");
        }
   }

    public static double getTrans(Point p1, Point p2, LineSegment[] ls){
        double res = 1.0;
        for(int i = 0; i < ls.length;i++){
            if((p1.x >= ls[i].p1.x && p2.x <= ls[i].p2.x) || (p1.x >= ls[i].p2.x && p2.x <= ls[i].p1.x)){
                res *= ls[i].r;
            }
        }
        // System.out.println(ls.length);
        return res;
    } 
}