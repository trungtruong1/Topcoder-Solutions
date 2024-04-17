public class ABBADiv1{
    public String canObtain(String initial, String target){
        System.out.println("This is " + initial + " and " + target + " LMAO ");
        if(target.equals(initial)){
        	return "Possible";
        }
        if(target.length() <= initial.length()){
            return "Impossible";
        };
        if(target.charAt(0) == 'A' && reverse(target).charAt(0) == 'A'){
            return canObtain(initial, target.substring(0, target.length() - 1));
        };
        if(target.charAt(0) == 'B' && reverse(target).charAt(0) == 'B'){
            return canObtain(initial, reverse(target.substring(1, target.length())));
        };
        if(target.charAt(0) == 'B' && reverse(target).charAt(0) == 'A'){
            String result1 = canObtain(initial, target.substring(0, target.length() - 1));
            String result2 = canObtain(initial, reverse(target.substring(1, target.length())));
            if(result1.equals("Possible") || result2.equals("Possible")){
                return "Possible";
            }
            else{
                return "Impossible";
            }
        };
        return "Impossible";
        
    }
    
    public String reverse(String text){
    	String rev = "";
        char ch;
        for(int i = 0; i<text.length(); i++){
        	ch = text.charAt(i);
            rev = ch+rev;
        }
        return rev;
    }
}