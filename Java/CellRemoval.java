import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class CellRemoval {

    public static void main(String[] args) {
        int[] parent = {26,2,32,36,40,19,43,24,30,13,21,14,24,21,19,4,30,10,44,12,7,32,17,43,
            35,18,7,36,10,16,5,38,35,4,13,-1,16,26,1,12,2,5,18,40,1,17,38,44,14};
        int deletedCell = 24;
        System.out.println(cellsLeft(parent, deletedCell));
    }

    public static int cellsLeft(int[] parent, int deletedCell) {
        Map<Integer, Vector<Integer>> tree = new HashMap<>();

        for (int i = 0; i < parent.length; i++) {
            if (parent[i] == -1) {
                continue;
            }
            if (!tree.containsKey(parent[i])) {
                tree.put(parent[i], new Vector<Integer>());
            }
            tree.get(parent[i]).add(i);
            if (!tree.containsKey(i)) {
                tree.put(i, new Vector<Integer>());
            }
        }
        
        tree = deleteNode(tree, deletedCell);

        int result = 0;
        for (Vector<Integer> children : tree.values()) {
            if (children.size() == 0) {
                result++;
            }
        }
        return result;
    }

    public static Map<Integer, Vector<Integer>> deleteNode(Map<Integer, Vector<Integer>> tree, int deletedCell) {
        if (tree.containsKey(deletedCell)) {
            for(int i = 0; i < tree.get(deletedCell).size(); i++){
                tree = deleteNode(tree, tree.get(deletedCell).get(i));
            }
            tree.remove(deletedCell);
        }
        return tree;
    }
}
