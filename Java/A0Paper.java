public class A0Paper{
    public static String canBuild(int[] A){
        for(int i=A.length-1; i > 0; i--){
            A[i-1] += A[i]/2;
        };
        if(A[0] >= 1){
        	return "Possible";
        }
        return "Impossible";
    };
};