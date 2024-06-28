import java.util.Arrays;

public class KokoBananas{

    public static void main(String args[]){
        int[] hands = {13,75,24,55};
        int K = 140;
        System.out.println(lastHand(hands, K));
    }

    public static int lastHand(int[] hands, int K){
        int max;
        int index = 0;
        while(K > 0){
            index = 0;
            // System.out.println(Arrays.toString(hands));
            int[] check = new int[hands.length];
            for(int i = 0; i < hands.length; i++){
                check[i] = hands[i];
            }
            Arrays.sort(check);
            max = check[check.length-1];
            for(int i = 0; i < hands.length; i++){
                if(hands[i] == max){
                    max = hands[i];
                    index = i;
                    hands[i] = hands[i]-1;
                    break;
                }
            }
            K--;
        }
        return index;
    }
}