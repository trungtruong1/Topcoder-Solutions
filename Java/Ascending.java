public class Ascending{
    public static void main(String[] args){
        int[] flights = {5,11,9,13,8,30,14};
        System.out.println(steps(flights, 3));

    }
    public static int steps(int[] flights, int stairsPerStride){
        int strides = 0;
        for(int i = 0; i < flights.length; i++){
            strides+= flights[i]/stairsPerStride; 
            if(flights[i] % stairsPerStride != 0){
                strides+=1;
            }
            if(i+1 < flights.length){
                strides+=2;
            }
        }
        return strides;
    }
}
