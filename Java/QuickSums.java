public class QuickSums{
    private static int result;
    public static void main(String args[]){
        String numbers = "0123456789";
        int sum = 45;
        System.out.println(minSums(numbers, sum));
    }
    
    public static int minSums(String numbers, int sum){
        result = Integer.MAX_VALUE;
        int cur_sum = 0;
        int additions = 0;
        recursiveLoop(numbers, sum, cur_sum, additions);
        if(result == Integer.MAX_VALUE){
            return -1;
        }else{
            return result;
        }
    }

    public static void recursiveLoop(String numbers, int sum, int cur_sum, int additions){
        if(allZero(numbers) == false){
            while(numbers.charAt(0) == '0'){
                numbers = numbers.substring(1,numbers.length());
            }
        }else{
            numbers = "0";
        }        
        int cur_sum1 = Integer.parseInt(numbers.substring(0, 1));
        int cur_sum2 = 0 ;
        if(numbers.length() >= 2){
            cur_sum2 = Integer.parseInt(numbers.substring(0, 2));
        }
        //case 1 seperate
        String remain1 = numbers.substring(1,numbers.length()); 
        int newsum1 = cur_sum+cur_sum1;
        if(remain1.length() != 0){
            recursiveLoop(remain1, sum, newsum1, additions+1);
        }

        //case 2 combine
        int newsum2 = 0;         
        if(numbers.length() == 2){
            newsum2 = cur_sum+cur_sum2;
        }
        if(numbers.length() > 2){
            String remain2 = numbers.substring(2,numbers.length()); 
            newsum2 = cur_sum+cur_sum2;
            if(remain2.length() != 0){
                remain2 = numbers.substring(2,numbers.length()); 
                newsum2 = cur_sum+cur_sum2;
                recursiveLoop(remain2, sum, newsum2, additions+1);
            }
        }
        if(newsum1 == sum  && numbers.length() == 1){
            if(additions < result){
                result = additions;
            }
        }        
        if(newsum2 == sum  && numbers.length() == 2){
            if(additions < result){
                result = additions;
            }
        }
    }

    public static boolean allZero(String num){
        boolean answer = true;
        for(int i = 0; i<num.length(); i++){
            if(num.charAt(i) != '0'){
                answer = false;
                break;
            }
        }
        if(num.isEmpty()){
            return false;
        }
        return answer;
    }
}

