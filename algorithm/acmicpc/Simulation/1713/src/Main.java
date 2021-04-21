import java.util.*;
import java.io.*;
public class Main {
    static int N,K;
    static int arr[], check[];
    static ArrayList<Integer> list = new ArrayList<>();

    static void sol(){
        for(int i=0;i<K;i++){
            if(list.size() < N){
                int flag = 0;
                for(int j=0;j<list.size();j++){
                    if(list.get(j) == arr[i]) flag = 1;
                }
                if(flag == 0) list.add(arr[i]);
                check[arr[i]]++;
            }
            else{
                int min = Integer.MAX_VALUE;
                int idx = -1;
                for(int j=0;j<list.size();j++){
                    if(check[list.get(j)] < min){
                        idx = j;
                        min = check[list.get(j)];
                    }
                }
                if(idx !=-1) {
                    int flag = 0;
                    for(int j=0;j<list.size();j++){
                        if(list.get(j) == arr[i]) flag = 1;
                    }
                    if(flag == 0){
                        list.add(arr[i]);
                        check[list.get(idx)] = 0;
                        list.remove(idx);
                    }
                    check[arr[i]]++;
                }
            }

        }
        int temp[] = new int[list.size()];
        for(int i=0;i< list.size();i++){
           temp[i] = list.get(i);
        }
        Arrays.sort(temp);

        for(int i=0;i< list.size();i++){
            System.out.print(temp[i] + " ");
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        arr = new int[K];
        check = new int[10001];
        st = new StringTokenizer(br.readLine());
        for(int i =0; i<K;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        sol();
    }
}
