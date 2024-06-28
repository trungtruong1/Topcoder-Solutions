import java.util.Arrays;
import java.math.BigInteger;

public class MatchNumbersEasy{
    public static void main(String[] args) {
        int[] array = {6,7,8};
        System.out.println(maxNumber(array, 21));
    }

    public static BigInteger result;
    public static String maxNumber(int[] matches, int n) {
        result = BigInteger.valueOf(-1);
        //reverse array + get numbers list 
        int[] numbers = new int[matches.length];
        int[] reversed_matches = new int[matches.length];
        int num = 0;
        for(int i = matches.length-1; i>=0; i--){
            numbers[num] = i;
            reversed_matches[num] = matches[i];
            num++;
        }

        System.out.println(Arrays.toString(reversed_matches));
        System.out.println(Arrays.toString(numbers));
        //start tabulation
        BigInteger[][] tab = new BigInteger[reversed_matches.length+1][n+1]; 
        for(int i = 0; i <= reversed_matches.length; i++){ 
            for(int j = 0; j <= n; j++){
                if(j == 0 || i == 0){
                    tab[i][j] = BigInteger.valueOf(0);
                }
                else if(reversed_matches[i-1] > j){
                    tab[i][j] = tab[i-1][j];
                }else{
                    BigInteger comparand =  new BigInteger(String.valueOf(tab[i][j-reversed_matches[i-1]]) + String.valueOf(numbers[i-1]));
                    if(tab[i-1][j].compareTo(comparand) >= 0){
                        tab[i][j] = tab[i-1][j];
                    }else{
                        tab[i][j] = comparand;
                    }
                    if(tab[i][j].compareTo(result) == 1){
                        result = tab[i][j];
                    }
                }
            }
        }
        return String.valueOf(result);
    }
}