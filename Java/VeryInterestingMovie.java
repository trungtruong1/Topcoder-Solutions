public class VeryInterestingMovie {

    public static void main(String[] args) {
        String[] seats = {"YYYYYYN","YYYYNYY","NYYYNYY","NYYYYYN","YYYYYYN","NYYNYNY","YYYYYYY"};
        System.out.println(maximumPupils(seats));
    }

    public static int maximumPupils(String[] seats) {
        int result = 0;
        
        for (int i = 0; i < seats.length; i++) {
            int canSit = 0;  
            for (int j = 0; j < seats[i].length(); j++) {
                if (seats[i].charAt(j) == 'Y') {
                    canSit++;
                    j++; //skip next one
                }
            }
            result += canSit; 
        }
        
        return result;
    }
}