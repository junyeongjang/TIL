import java.util.*;
import java.io.*;
public class Main  {
    static int num1, num2;
    static int arr1[], arr2[];

    static void sol(){
        Arrays.sort(arr1);
        for(int i=0;i<num2;i++){
            if(Arrays.binarySearch(arr1, arr2[i]) >= 0) System.out.println(1);
            else System.out.println(0);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        num1 = Integer.parseInt(st.nextToken());
        arr1 = new int[num1];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<num1;i++){
            arr1[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        num2 = Integer.parseInt(st.nextToken());
        arr2 = new int[num2];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<num2;i++){
            arr2[i] = Integer.parseInt(st.nextToken());
        }
        sol();
    }
}
