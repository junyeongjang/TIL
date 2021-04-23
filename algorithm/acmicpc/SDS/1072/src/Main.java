import java.util.*;
import java.io.*;
public class Main {
    static long X,Y;
    public static void main(String[] args) throws  IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        X = Long.parseLong(st.nextToken());
        Y = Long.parseLong(st.nextToken());
       long Z = Y * 100 / X;
        if(Z>=99){
            System.out.println(-1);
            return ;
        }
        long low = 0, high = 1000000000;

        long result = -1;

        while (low <= high) {
            long mid = (low + high) / 2;
            long tempZ = 100 * (Y + mid) / (X + mid);
            if (Z >= tempZ) {
                result = mid + 1;
                low = mid + 1;
            }
            else
                high = mid - 1;
        }
        System.out.println(result);
    }
}
