public class Inchworm{
    public static int lunchtime(int l, int n, int d) {
        int count = 0;
        int travel = 0;
        while (travel <= l) {
            if (travel%d == 0){
                count+=1;
            }
            travel+=n;
        }
        return count;
    }
}
