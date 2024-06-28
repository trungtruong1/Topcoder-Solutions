public class ColorfulRabbits {
    public static void main(String[] args) {
        int[] replies = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        System.out.println(getMinimum(replies));
    }
    
    public static int getMinimum(int[] replies){
        if(replies.length == 1) return replies[0]+1;
        int result = 0;
        int maxForOneColor;
        int encounteredSoFar;
        int checkingOn;
        for(int i = 0; i < replies.length; i++){
            if(replies[i] == -1) continue;
            maxForOneColor = replies[i] + 1;
            encounteredSoFar = 1;
            checkingOn = replies[i];
            replies[i] = -1;
            for(int j = i + 1; j < replies.length; j++){
                if(encounteredSoFar == maxForOneColor){
                    break;
                }
                if(replies[j] == checkingOn){
                    encounteredSoFar +=1;
                    replies[j] = -1;
                }
                if(encounteredSoFar == maxForOneColor){
                    break;
                }
            }
            result += maxForOneColor;
        }
        return result;
    }
    
}
