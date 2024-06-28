public class HouseBuilding {
    public static void main(String args[]) {
        String[] area = { "54454",
                "61551" };
        System.out.println(getMinimum(area));
    }

    public static int getMinimum(String[] area) {
        int result = Integer.MAX_VALUE;
        for (int i = 1; i <= 9; i++) {
            int pairFirst = i - 1;
            int pairSecond = i;
            int modsForThisPair = 0;
            // brute force
            for (String s : area) {
                for (int j = 0; j < s.length(); j++) { // through each char
                    int currentChar = s.charAt(j) - '0';
                    int modToMake = Math.min(Math.abs(currentChar - pairFirst), Math.abs(currentChar - pairSecond));
                    // if(pairSecond == 2){
                    // System.out.println(modToMake);
                    // }
                    modsForThisPair += modToMake;
                }
            }
            // if(pairSecond == 2){
            // System.out.println(modsForThisPair);
            // }
            if (modsForThisPair < result) {
                result = modsForThisPair;
            }
        }
        return result;
    }
}