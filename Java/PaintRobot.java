import java.util.ArrayList;
import java.util.List;

public class PaintRobot{
    public static void main(String[] args){
        int L[] = {10, 20, 50};
        int R[] = {20, 50, 100};
        System.out.println(countColourings(100, L, R));
    }   
    
    public static int countColourings(int M, int[] L, int[] R){
        int[] allBalls= new int[M]; 
        List<Integer> listChanged = new ArrayList<>();
        int start;
        int end;
        for(int i = 1; i <= L.length; i++){
            start = L[i-1];
            end = R[i-1];
            for(int j = start-1; j < end; j++){
                allBalls[j] = i;
            }
        }
        // for(int z = 0; z < allBalls.length; z++){
        //     System.out.println(allBalls[z]);
        // }
        for(int k = 0; k < M; k++){
            if(allBalls[k] == 0){
                continue;
            }
            if(allBalls[k] != 0 && !listChanged.contains(allBalls[k])){
                listChanged.add(allBalls[k]);
            }
        }
        Double changed_len = Double.valueOf(0);
        changed_len = Math.pow(Double.valueOf(2), Double.valueOf(listChanged.size()));
        return changed_len.intValue();
    }
}
