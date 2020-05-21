import java.io.*;
import java.util.*;
 
class Solution 
{
    public static final boolean DEBUG = false;
    public static final int N = 21;
    public StringTokenizer tokenizer;
    public PrintWriter cout;
    public BufferedReader cin;
    String s;
    long n;
    long[] f;
    
    public void init() throws IOException
    {
        
        if (DEBUG) {
            cin = new BufferedReader(new FileReader("d:\\OJ\\uva_in.txt"));
        } else {
            cin = new BufferedReader(new InputStreamReader(System.in));
        }
        
        cout = new PrintWriter(new OutputStreamWriter(System.out));
        tokenizer = new StringTokenizer("");
        
        f = new long[N];
        f[0] = 0;
        f[1] = 1;
        
        for (int i = 2; i < N; i++) f[i] = i * f[i - 1];        
    }
    
    public String next() throws IOException
    {
       
        while (!tokenizer.hasMoreTokens()) {
            String s = cin.readLine();
            if (s == null) return null;
            tokenizer = new StringTokenizer(s);
        }
        
        return tokenizer.nextToken();
    }
    
    public void input() throws IOException
    {
        s = next();
        if (s == null) return;
        n = Long.parseLong(next());
    }
    
    public void solve()
    {
        char[] tmp = s.toCharArray();
        Arrays.sort(tmp);
        
        s = new String(tmp);
        int len = s.length();
        boolean[] vis = new boolean[len];
        n++;
        
        StringBuilder ans = new StringBuilder(s);
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                while (vis[j]) {
                    j++;
                }
                
                if (i == len - 1) {    
                    ans.setCharAt(i, s.charAt(j));
                    vis[j] = true;
                    break;
                }
                
                if (n - f[len - 1 - i] <= 0) {
                    ans.setCharAt(i, s.charAt(j));
                    vis[j] = true;
                    break;
                } else {
                    n -= f[len - 1 - i];
                }
            }
        }
        
        cout.println(ans.toString());
        cout.flush();
    }
    
    public static void main(String[] args) throws IOException
    {
        Solution solver = new Solution();
        solver.init();
        int t = Integer.parseInt(solver.next());
        
        while (t-- > 0) {
            solver.input();
            solver.solve();
        }    
        
    }
}