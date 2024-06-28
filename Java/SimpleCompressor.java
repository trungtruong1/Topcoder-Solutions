public class SimpleCompressor {
    public static void main(String[] args) {
        System.out.println(uncompress("C[2[3AB]]C"));
    }

    public static String uncompress(String data) {
        StringBuilder substring = new StringBuilder();
        int i = 0;
        boolean openBracketFound = false;
        while (i < data.length()) {
            if(data.charAt(i) == '['){
                openBracketFound = true;
            }
            if (Character.isDigit(data.charAt(i)) && openBracketFound) {
                int count = 0;
                int index_start = i;
                int index_end = index_start;
                for(int j = index_start+1; j < data.length(); j++){
                    if(Character.isDigit(data.charAt(j))){
                        index_end+=1;
                    }
                    else{
                        break;
                    }
                }
                if(index_end == index_start){
                    count = data.charAt(index_start) - '0';
                }else{
                    count = Integer.parseInt(data.substring(index_start, index_end+1));
                }

                int bracket = 1; //found 1 open bracket
                int j = i + 1; //start with next index after i
                while (bracket > 0) {
                    if (data.charAt(j) == '[') {
                        bracket++;
                    } else if (data.charAt(j) == ']') {
                        bracket--;
                    }
                    j++;
                }
                j--; 
    
                String str = data.substring(i+1, j); // str is "3AB"
                str = uncompress(str); // Recursively call uncompress on str
    
                for (int k = 0; k < count; k++) {
                    substring.append(str); // Append str count times to sbstring
                }
    
                i = j + 1; 
            } else {
                if(data.charAt(i) != '['){
                    substring.append(data.charAt(i)); 
                }
                i++;
            }
        }
        return substring.toString();
    }

}