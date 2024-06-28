import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class ErdosNumber {

    public static void main(String[] args) {
        String[] publications = { "KLEITMAN LANDER", "ERDOS KLEITMAN" };

        System.out.println(Arrays.toString(calculateNumbers(publications)));

    }

    public static String[] calculateNumbers(String[] publications) {
        String target = "ERDOS";
        HashMap<String, Integer> erdosIndex = new HashMap<>();
        HashSet<String> checked = new HashSet<>();
        HashSet<String> allNames = new HashSet<>();
        Queue<String> namesToCheck = new LinkedList<>();
        erdosIndex.put(target, 0); // add Erdos

        for (int i = 0; i < publications.length; i++) {
            String[] names = publications[i].split(" ");
            for (String name : names) {
                allNames.add(name);
            }
            if (containsName(names, target)) {
                publications[i] = "7"; 
                for (String name : names) {
                    if (!name.equals(target)) {
                        namesToCheck.add(name);
                        erdosIndex.put(name, 1);
                    }
                }
            }
        }
        checked.add("ERDOS");

        while (!namesToCheck.isEmpty()) {
            target = namesToCheck.poll();
            checked.add(target);
            for (int i = 0; i < publications.length; i++) {
                if (!publications[i].equals("7")) {
                    String[] names = publications[i].split(" ");
                    if (containsName(names, target)) {
                        publications[i] = "7";
                        for (String name : names) {
                            if (!name.equals(target) || !checked.contains(name)) {
                                int index = erdosIndex.get(target);
                                namesToCheck.add(name);
                                if(erdosIndex.containsKey(name)){
                                    if(erdosIndex.get(name) < index+1){
                                        continue;
                                    }
                                }
                                erdosIndex.put(name, index + 1);
                            }
                        }
                    }
                }
            }
        }

        ArrayList<String> result = new ArrayList<String>();
        for (String name : allNames) {
            if (erdosIndex.containsKey(name)) {
                String toAdd = name + " " + erdosIndex.get(name);
                result.add(toAdd);
            } else {
                result.add(name);
            }
        }
        String[] finalResult = result.toArray(new String[0]);
        Arrays.sort(finalResult);
        return finalResult;

    }

    public static boolean containsName(String[] names, String target) {
        for (String name : names) {
            if (name.equals(target)) {
                return true;
            }
        }
        return false;
    }

}