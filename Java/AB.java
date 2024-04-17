public class AB {
    public static String createString(int N, int K){
        for(int no_B = 0; no_B < N; no_B++){
            char[] a = new char[N];
            for(int i = 0; i < no_B; i++){
            	a[i] = 'B';
            }
            for(int i = no_B; i < N; i++){
            	a[i] = 'A';
            }
            int curr = 0;
            while(true){
                if(curr == K){
                	return new String(a);
                }
                int pos = -99;
                for(int i = 0; i < N-1; i++){
                    if(a[i] == 'B' && a[i+1] == 'A'){
                    	pos = i;
                        break;
                    }
                }
                if(pos == -99){
                	break;
                }
                curr+=1;
                a[pos] = 'A';
                a[pos+1] = 'B';
            }
        }
        return "";
    }
}