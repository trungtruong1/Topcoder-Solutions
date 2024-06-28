public class PrefixFreeSets{
    public static void main(String args[]){
        String[] words =   	{"nxdxzgvi", //dung
        "vsflbhabd",        //dung
        "ulcwmmsehytc",  //dung
        "occaipvscg", //dung
        "whxookowwrjreosnxwbmogphzyd", //aothat  
        "k",  //dung
        "whxookowwrjreosnxwbmogp",  //aothat
        "a",  
        "glxwwy",  
        "whxookowwrjreosnxwbmogphzydddnvalpspbvx",   
        "whxookowwrjreosnxwbmogphzydddnvalpspbvxaxwapjcteuz"}
        ;
        System.out.println(maxElements(words));
    }

    public static int maxElements(String[] words){
        for(int i = 0; i < words.length; i++){
            if(words[i] == "7"){
                continue;
            }else{
                // System.out.println(words[i]);
                String checking = words[i];
                for(int j = 0; j < words.length; j++){
                    if(i != j){
                        if(words[j].startsWith(checking)){
                            // System.out.println("dis");
                            words[i] = "7";
                            break;
                        }
                    }
                }
            }
        }
        // System.out.println(Arrays.toString(words));
        int result = 0;
        for(int i = 0; i < words.length; i++){
            if(words[i] == "7"){
                continue;
            }
            result+=1;
        }
        return result;
    }
}