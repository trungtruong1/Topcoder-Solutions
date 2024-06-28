import java.util.*;

public class ChangingString {
    public static int distance(String A, String B, int K){
        Vector<Integer> disList = new Vector<Integer>();
        int stringLen = A.length();
        char one;
        char two;
        int oneVal;
        int twoVal;
        for(int i = 0; i < stringLen; i++){
            one = A.charAt(i);
            two = B.charAt(i);
            oneVal = one;
            twoVal = two;
            disList.add(Math.abs(oneVal - twoVal));
        }
        Collections.sort(disList);
        int result = 0;
        for(int i = disList.size()-1; i >= disList.size()-K; i--){
            if(disList.get(i) != 0){
                disList.set(i,0);
            }else{
                disList.set(i,1);
            }
        }
        for(int i = 0; i < disList.size(); i++){
            result+=disList.get(i);
        }
        return result;
    }
}
