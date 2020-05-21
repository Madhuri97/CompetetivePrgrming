import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    
    public static void main (String [] abc) throws IOException  {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int testCaseCount=Integer.parseInt(br.readLine());
        for (int testCase=0;testCase<testCaseCount;testCase++) {
            
            int n=Integer.parseInt(br.readLine());
            int ratPop=Integer.parseInt(br.readLine());
            
            int [][] ratCount=new int [1025][1025];
            int minx=1024;
            int maxx=0;
            int miny=1024;
            int maxy=0;
            
            for (int i=0;i<ratPop;i++) {
                StringTokenizer st=new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int count=Integer.parseInt(st.nextToken());
                
                for (int tempx=Math.max(0,x-n);tempx<=Math.min(ratCount.length-1, x+n);tempx++) {
                    for (int tempy=Math.max(0,y-n);tempy<=Math.min(ratCount[tempx].length-1, y+n);tempy++) {
                        ratCount[tempx][tempy]+=count;
                    }
                }
                
                minx=Math.min(minx, Math.max(0,x-n));
                maxx=Math.max(maxx, Math.min(ratCount.length-1, x+n));
                miny=Math.min(miny, Math.max(0,y-n));
                maxy=Math.max(maxy, Math.min(ratCount.length-1, y+n));
            }
            
            int [] bestCase=new int [3];
            for (int x=minx;x<=maxx;x++) {
                for (int y=miny;y<=maxy;y++) {
                    if (ratCount[x][y]>bestCase[2]) {
                        bestCase[0]=x;
                        bestCase[1]=y;
                        bestCase[2]=ratCount[x][y];
                    }
                }
            }
            
            System.out.println(bestCase[0]+" "+bestCase[1]+" "+bestCase[2]);
        }
    }
    
}