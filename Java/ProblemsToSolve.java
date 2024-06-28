public class ProblemsToSolve{
    // public static void main(String[] args){
    //     int[] pleasantness = {6, 2, 6, 2, 6, 3, 3, 3, 7};
    //     int variety = 4;
    //     System.out.println(minNumber(pleasantness, variety));
    // }

    static int minProbs;
    public static int minNumber(int[] pleasantness, int variety){
        minProbs = Integer.MAX_VALUE;
        recursiveLoop(pleasantness, variety, 0, pleasantness[0], pleasantness[0], 1);
        if(minProbs == Integer.MAX_VALUE) return pleasantness.length;
        else return minProbs;
    }
    
    public static void recursiveLoop(int[] pleasantness, int variety, int next_index, int max, int min, int solved){
        if(next_index < pleasantness.length){
            if(pleasantness[next_index] < min){
                min = pleasantness[next_index];
            }
            if(pleasantness[next_index] > max){
                max = pleasantness[next_index];
            }
            if(Math.abs(pleasantness[next_index] - max) == variety || Math.abs(pleasantness[next_index] - min) == variety){
                if(solved < minProbs){
                    minProbs = solved;
                }
            }
            //jump to n+1
            recursiveLoop(pleasantness, variety, next_index+1, max, min, solved+1);
            //jump to n+2
            recursiveLoop(pleasantness, variety, next_index+2, max, min, solved+1);
        }
    }
    
}
