public class ThrowTheBall {
    public static int timesThrown(int N, int M, int L) {
        int count = 0;
        int[ ] record = new int[N];
        record[0] = 1;
        int current_holder = 0;
        while(record[current_holder] != M){
            if (record[current_holder]%2 == 0){ //even
                if(current_holder+L <= N-1){
                    current_holder = current_holder+L;
                }
                else{
                    current_holder = (current_holder+L)%N;
                }
                record[current_holder]+=1;
                count+=1;
            }
            else{ //odd
                if(current_holder-L >= 0){
                    current_holder = current_holder-L;
                }
                else{
                    current_holder = current_holder-L+N;
                }
                record[current_holder]+=1;
                count+=1;
            }
        }
        return count;
    }
}


