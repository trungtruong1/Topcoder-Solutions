public class TimeTravellingCellar {
    
    public static void main(String[] args) {
        int[] profit = {1000,500,250,125};
        int[] decay = {64,32,16,8};
        System.out.println(determineProfit(profit, decay));
    }

    public static int determineProfit(int[] profit, int[] decay){
        int result = 0;
        for(int i = 0; i < profit.length; i++){
            for(int j = 0; j < profit.length; j++){
                if(j != i){
                    int possible = profit[i] - decay[j];
                    if(possible > result){
                        result = possible;
                    }
                }
            }
        }
        return result;
    }
}
