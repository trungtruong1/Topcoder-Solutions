public class BigBurger{
    public static void main(String args[]){
        int[] arrival = {2,10,12};
        int[] service = {15,1,15};

        System.out.println(maxWait(arrival, service));
    }

    public static int maxWait(int[] arrival, int[] service){
        int queueLen = arrival.length;
        int maxWaited = 0;
        int wait;
        int currentTime = arrival[0] + service[0];
        for(int i = 1; i < queueLen; i++){
            if(currentTime > arrival[i]){
                wait = currentTime-arrival[i];
                if(wait > maxWaited){
                    maxWaited = wait;
                }
            }else{
                wait = 0;
                currentTime = arrival[i];
            }
            currentTime += service[i];
        }
        return maxWaited;
    }
}