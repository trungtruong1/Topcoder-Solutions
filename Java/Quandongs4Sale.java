import java.util.Arrays;

public class Quandongs4Sale {
    public static void main(String[] args){
        int[] quandongs = {24,92,38,0,79,45};
        System.out.println(makePunnets(quandongs));
    }   
    
    public static int makePunnets(int[] quandongs){
        int result = 0;
        int punnets = quandongs.length;
        Arrays.sort(quandongs);
        for(int i = 0; i < quandongs.length; i++){
            int currentPeaches = quandongs[i]*punnets;
            if(currentPeaches > result){
                result = currentPeaches;
            }
            punnets-=1;
        }
        System.out.println(Arrays.toString(quandongs));
        return result;
    }
}
