import java.util.*;

public class PaternityTest{
    // public static void main(String[] args){
    //     String child = "ABCD";
    //     String mother = "ABCX";
    //     String[] men = { "ABCY", "ASTD", "QBCD" };
    //     System.out.println(possibleFathers(child, mother, men));
    // }

    public static int[] possibleFathers(String child, String mother, String[] men){ 
        List<Integer> fatherList = new ArrayList<Integer>();
        List<Integer> indexes_mom = new ArrayList<Integer>();
        List<Integer> indexes_men = new ArrayList<Integer>();
        Set<Integer> set = new HashSet<Integer>();
        for(int k = 0; k < child.length(); k++){
            if(mother.charAt(k) == child.charAt(k)){
                indexes_mom.add(k); 
            }
        }
        for(int i = 0; i < men.length; i++){ 
            indexes_men.clear();
            set.clear();
            for(int j = 0; j < child.length(); j++){
                if(men[i].charAt(j) == child.charAt(j)){
                    indexes_men.add(j); 
                }
            }
            set.addAll(indexes_men);
            set.addAll(indexes_mom);
            if(set.size() == child.length() && indexes_men.size() >= child.length()/2){
                fatherList.add(i);
            }
        }
        int[] result = fatherList.stream().mapToInt(Integer::intValue).toArray();
        return result;
    }
}
