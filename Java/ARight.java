public class ARight{
    public static String modify(String S, int K){
        int len = S.length();
        Character[] stringArray = new Character[len];
        int counter = 0;
        for(int i = 0; i < len; i++){
            if(stringArray[counter] == null && S.charAt(i) != 'a'){
                stringArray[counter] = S.charAt(i);
            	counter +=1;
            }else if(stringArray[counter] != null && S.charAt(i) != 'a'){
                int j = counter;
                while(stringArray[j] != null){
                    j+=1;
                }
                counter = j;
                stringArray[counter] = S.charAt(i);
            }else if(S.charAt(i) == 'a'){
                stringArray[i+K] = S.charAt(i);
            }
        }
        String str = "";
        for(int i = 0; i < len; i++){
        	str = str + stringArray[i];
        }
        return str;
    }
}