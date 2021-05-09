package kakao;
import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        StringBuffer sb = new StringBuffer();
        StringBuffer temp = new StringBuffer();
        sb.append(s);
        sb.append("tttttttttttttttttttt");
        for(int i=0;i<s.length();i++){
            if(sb.charAt(i) >= '0' && sb.charAt(i) <= '9'){
                temp.append(sb.charAt(i));
            }
            else if(sb.substring(i, i+4).equals("zero")){ //1
                temp.append(0);
                i+=3;
            }
            else if(sb.substring(i, i+3).equals("one")){ //1
                temp.append(1);
                i+=2;
            }
            else if(sb.substring(i, i+3).equals("two")){ //1
                temp.append(2);
                i+=2;
            }
            else if(sb.substring(i, i+5).equals("three")){ //1
                temp.append(3);
                i+=4;
            }
            else if(sb.substring(i, i+4).equals("four")){ //1
                temp.append(4);
                i+=3;
            }
            else if(sb.substring(i, i+4).equals("five")){ //1
                temp.append(5);
                i+=3;
            }
            else if(sb.substring(i, i+3).equals("six")){ //1
                temp.append(6);
                i+=2;
            }
            else if(sb.substring(i, i+5).equals("seven")){ //1
                temp.append(7);
                i+=4;
            }
            else if(sb.substring(i, i+5).equals("eight")){ //1
                temp.append(8);
                i+=4;
            }
            else if(sb.substring(i, i+4).equals("nine")){ //1
                temp.append(9);
                i+=3;
            }

        }
        answer = Integer.parseInt(temp.toString());
        return answer;
    }
}