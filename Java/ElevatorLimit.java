import java.util.Arrays;

public class ElevatorLimit {
    public static void main(String[] args) {
        int[] enter = {2, 2, 2};
        int[] exit = {0,0,0};
        int physicalLimit = 4;
        System.out.println(Arrays.toString(getRange(enter, exit, physicalLimit)));
    }

    public static int[] getRange(int[] enter, int[] exit, int physicalLimit) {
        int start = 0;
        int biggest = 0;
        int smallest = Integer.MAX_VALUE;
        int len = enter.length;
        for (int i = 0; i < len; i++) {
            start -= exit[i];
            if(start < 0 && Math.abs(start) > physicalLimit){
                return new int[]{};
            }
            if (start < smallest)
                smallest = start;
            start += enter[i];
            if(start > physicalLimit){
                return new int[]{};
            }
            if (start > biggest)
                biggest = start;
        }
        // System.out.println(smallest);
        // System.out.println(biggest);
        if (smallest < 0)
            smallest = Math.abs(smallest);
        if (biggest > physicalLimit)
            biggest = physicalLimit - (biggest - physicalLimit);
        if (biggest <= physicalLimit)
            biggest = physicalLimit - biggest;
        if(smallest > biggest || biggest > physicalLimit) return new int[]{};
        return new int[] { smallest, biggest };
    }
}
