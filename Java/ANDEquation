public class ANDEquation{
    public static int restoreY(int[] A){
        int Y;
        int ANDResult;
        for(int i = 0; i<A.length; i++){
            ANDResult = -1;
            Y = A[i];
            for(int j = 0; j<A.length; j++){
                if(j != i){
                	ANDResult = ANDResult & A[j];
                }
            }
            if(ANDResult == Y){
            	return Y;
            }
        }
        return -1;
    }
}