import java.util.ArrayList;

public class RGBStreet {
    public static void main(String[] args) {
        String[] houses = { "71 39 44", "32 83 55", "51 37 63", "89 29 100",
                "83 58 11", "65 13 15", "47 25 29", "60 66 19" };
        System.out.println(estimateCost(houses));
    }

    public static int estimateCost(String[] houses) {
        ArrayList<Integer> chosenSequence = new ArrayList<Integer>(); // Create an ArrayList object
        //HashMap<ArrayList<Integer>, Integer> memo = new HashMap<ArrayList<Integer>, Integer>();
        return recursiveLoop(houses, chosenSequence, 0, 0, 0);
    }

    public static int recursiveLoop(String[] houses, ArrayList<Integer> chosenSequence, int houseIndex, int total_cost,
            int prev_choice) {
        if (houseIndex == houses.length) {
            return total_cost;
        }
        String[] prices = houses[houseIndex].split("\\s+");
        ArrayList<Integer> sequence;
        int[] results = { Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE };
        for (int i = 1; i <= 3; i++) {
            sequence = new ArrayList<>(chosenSequence);
            if (i == prev_choice) {
                continue;
            }
            sequence.add(i);
            // if (memo.containsKey(sequence)) {
            //     results[i - 1] = memo.get(sequence);
            // }
            results[i - 1] = recursiveLoop(houses, sequence, houseIndex + 1,
                    total_cost + Integer.parseInt(prices[i - 1]), i);
            // if (!memo.containsKey(sequence)) {
            //     memo.put(sequence, results[i - 1]);
            // }
        }
        return Math.min(results[0], Math.min(results[1], results[2]));
    }
}
