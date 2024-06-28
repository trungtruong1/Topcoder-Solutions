import java.util.*;

public class ClubAdmission{
    public static void main(String[] args) {
        int[] card = {35, 25, 50, 84, 59, 49, 50, 43, 19, 26, 39, 21};
        System.out.println(bestSum(card));
    }

    public static int bestSum(int[] card){
        int result = 0;
        int diff = -1;
        for(int i = 0; i < card.length; i++){
            int big_num = transform(card[i]);
            if(big_num - card[i] > diff){
                diff = big_num - card[i];
            }
        }
        for(int i = 0; i < card.length; i++){
            result+=card[i];
        }
        result += diff;
        return result;
    }

    public static int getLen(int num){
        String a = Integer.toString(num);
        return a.length();
    }

    public static int transform(int num){
        String a = Integer.toString(num);
        if(a.length() == 1){
            return 9;
        }else{
            int index_need_change = 0;
            for(int i = 0; i < a.length(); i++){
                if(a.charAt(i) == '9'){
                    continue;
                }else{
                    index_need_change = i;
                    break;
                }
            }
            if(index_need_change == a.length()){
                return Integer.parseInt(a);
            }
            if(index_need_change == 0){
                a = a.substring(1,a.length());
                a = '9' + a;
                return Integer.parseInt(a);
            }else{
                a = a.substring(0, index_need_change) + '9' + a.substring(index_need_change+1, a.length());
                return Integer.parseInt(a);
            }
        }
    }
}
