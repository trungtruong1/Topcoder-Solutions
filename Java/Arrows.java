public class Arrows {
    public static void main(String[] args){
        System.out.println(longestArrow("--=->--=----<-=-<-"));
    }   
    public static int longestArrow(String s){
        int longest_single=-1;
        int longest_double=-1;
        boolean arrow=false;
        for(int i= 0; i < s.length(); i++){
            if(s.charAt(i) == '<' || s.charAt(i) == '>') arrow = true;
            int index_start_single=-1;
            int index_end_single=-1;
            int index_start_double=-1;
            int index_end_double=-1;
            if(s.charAt(i) == '-'){
                index_start_single = i;
                int j = i;
                while(j < s.length()){
                    if(s.charAt(j) == '-'){
                        index_end_single=j;
                    }else{
                        break;
                    } 
                    j++;
                }
            }
            if(s.charAt(i) == '='){
                index_start_double = i;
                int j = i;
                while(j < s.length()){
                    if(s.charAt(j) == '='){
                        index_end_double=j;
                    }else{
                        break;
                    } 
                    j++;
                }
            }
            if(index_end_single-index_start_single+2 > longest_single && index_start_single != -1){
                if(index_start_single-1 >= 0){
                    if(s.charAt(index_start_single-1) == '<'){
                        longest_single = index_end_single-index_start_single+2;
                    }
                }
                if(index_end_single+1 < s.length()){
                    if(s.charAt(index_end_single+1) == '>'){
                            longest_single = index_end_single-index_start_single+2;
                    }
                }
            }
            if(index_end_double-index_start_double+2 > longest_double && index_start_double != -1){
                if(index_start_double-1 >= 0){
                    if(s.charAt(index_start_double-1) == '<'){
                        longest_double = index_end_double-index_start_double+2;
                    }
                }
                if(index_end_double+1 < s.length()){
                    if(s.charAt(index_end_double+1) == '>'){
                        longest_double = index_end_double-index_start_double+2;
                    }
                } 
            }
        }
        if(!arrow) return -1;
        if(longest_single > longest_double){
            if(longest_single == -1 && arrow) return 1;
            return longest_single;
        }else{
            if(longest_double == -1 && arrow) return 1;
            return longest_double;
        }
    }
}
