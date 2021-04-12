import java.util.Scanner;

public class Main {
    static int ans;
    static int n;
    static boolean visited1[] = new boolean[100];
    static boolean visited2[] = new boolean[100];
    static boolean visited3[] = new boolean[100];
    static void dfs(int depth){
        if (depth == n){
            ans++;
            return;
        }
        for(int i=0;i<n;i++){
            if(visited1[i] || visited2[depth + i] || visited3[depth - i  + n - 1]) continue;
            visited1[i] = true;
            visited2[depth + i] = true;
            visited3[depth - i  + n - 1] = true;
            dfs(depth+ 1);
            visited1[i] = false;
            visited2[depth + i] = false;
            visited3[depth - i  + n - 1] = false;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        dfs(0);
        System.out.println(ans);
    }
}
