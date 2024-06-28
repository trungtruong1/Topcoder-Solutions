
public class MonstersValley2{
    public static int minimumPrice(int[] dread, int[] price){
        Double result = recursiveLoop(Double.valueOf(dread[0]), Double.valueOf(price[0]), 1, dread, price);
        int ret = result.intValue();
        return ret;
    }
    public static Double recursiveLoop(Double total_dread, Double amount_paid, int next, int[] dread, int[] price){
        Double result1 = Double.MAX_VALUE;
        Double result2 = Double.MAX_VALUE;

        //we bribe
        if(next < dread.length){
            double add_dread = Double.valueOf(dread[next]);
            double add_price = Double.valueOf(price[next]);
            result1 = recursiveLoop(Double.sum(total_dread,add_dread), Double.sum(amount_paid,add_price), next+1, dread, price);
            //we pass
            if(total_dread >= dread[next]){
                result2 = recursiveLoop(total_dread, amount_paid, next+1, dread, price);
            }
            if(result1 <= result2){
                return result1;
            }
            else{
                return result2;
            }
        }
        return amount_paid;
    }
}