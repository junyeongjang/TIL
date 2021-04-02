import java.util.*;
import java.util.*;
import java.io.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        for(int i=0;i<s.length();i++){
            String temp ="";
            for(int j=0;j<s.length();j++) {
                s.substring(j, j +i);
                for(int k=j; k<s.length();k++){

                }
            }
        }
        return answer;
    }
}


class Main
{
    public static void main(String args[])
    {
        long P, N;
        long res = 0;
        ArrayList<Long> arr = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        P = sc.nextLong();
        N = sc.nextLong();
        for(int i=0;i<N;i++){
            long num = sc.nextLong();
            arr.add(num);
        }
        for(int i=0;i<N;i++){
            res += arr.get(i) * P;
        }
        System.out.print(res % 1000000007);
    }
}