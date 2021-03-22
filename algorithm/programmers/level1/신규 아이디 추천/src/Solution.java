import java.lang.String;
public class Solution {
    public String solution(String new_id) {

        StringBuffer str = new StringBuffer();

        //1
        new_id = new_id.toLowerCase();
        str.append(new_id);
        //2
        for(int i=0;i<str.length();i++){
            char temp = str.charAt(i);
            if(temp >= 'a' && temp <= 'z') continue;
            if(temp >= '0' && temp <= '9') continue;
            if(temp == '-' || temp == '_' || temp == '.') continue;
            str.deleteCharAt(i--);
        }
        //3
        for(int i=0;i<str.length() - 1;i++){ //2
            char temp = str.charAt(i);
            if(temp == '.') {
                for (int j=i; j<str.length();j++){
                    if(str.charAt(j) == '.') str.deleteCharAt(j--);
                    else break;
                }
            }
        }

        //4
        if (str.length() > 0) {
            if (str.charAt(0) == '.') str.deleteCharAt(0);
            if (str.length() >0 && str.charAt(str.length() - 1) == '.') str.deleteCharAt(str.length() - 1);
        }
        //5
        if (str.length() == 0) str.append("a");

        //6
        if (str.length() >= 15){
            str.delete(14, str.length());
            if (str.charAt(str.length() - 1) == '.') str.deleteCharAt(str.length() - 1);
        }
        //7
        int temp = str.length();
        while(str.length() <= 2){
             str.append(str.charAt(temp - 1));
        }
        String answer = str.toString();
        return answer;
    }
}
