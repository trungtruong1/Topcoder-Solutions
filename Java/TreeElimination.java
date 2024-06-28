import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TreeElimination {
    private Map<Integer, List<Integer>> tree;

    public TreeElimination(int[] treeArray) {
        tree = new HashMap<>();
        for (int i = 0; i < treeArray.length; i++) {
            int parentIndex = treeArray[i];
            tree.putIfAbsent(parentIndex, new ArrayList<>());
            tree.get(parentIndex).add(i);
        }
    }

    public void eliminateNode(int nodeToEliminate) {
        // Find the parent of the node to be eliminated
        int parentIndex = -1;
        for (Map.Entry<Integer, List<Integer>> entry : tree.entrySet()) {
            if (entry.getValue().contains(nodeToEliminate)) {
                parentIndex = entry.getKey();
                break;
            }
        }

        // Remove the node from its parent's child list
        tree.get(parentIndex).remove(Integer.valueOf(nodeToEliminate));

        // Recursively eliminate children
        eliminateNodesRecursively(nodeToEliminate);
    }
    
    private void eliminateNodesRecursively(int nodeToEliminate) {
        tree.remove(nodeToEliminate);   //Eliminate the current node
        // Eliminate all the children of the current node
        if (tree.containsKey(nodeToEliminate)) {
            for (int child : tree.get(nodeToEliminate)) {
                eliminateNodesRecursively(child);
            }
        }
    }

    public int countLeaves() {
        return countLeavesRecursively(-1);
    }

    private int countLeavesRecursively(int parentIndex) {
        int leafCount = 0;
        if (!tree.containsKey(parentIndex)) {
            return 1; // Base case: It's a leaf node
        }

        for (int childIndex : tree.get(parentIndex)) {
            leafCount += countLeavesRecursively(childIndex);
        }
        return leafCount;
    }

    public void printTree() {
        printTreeRecursively(-1, 0);
    }

    private void printTreeRecursively(int parentIndex, int depth) {
        if (!tree.containsKey(parentIndex)) {
            return;
        }

        for (int childIndex : tree.get(parentIndex)) {
            for (int i = 0; i < depth; i++) {
                System.out.print("  ");
            }
            System.out.println(childIndex + " (" + parentIndex + ")");
            printTreeRecursively(childIndex, depth + 1);
        }
    }

    public static void main(String[] args) {
        int[] treeArray = {-1, 0, 0, 1, 2, 2, 3, 4, 4, 6, 6};  // Example input tree
        TreeElimination tree = new TreeElimination(treeArray);
        tree.printTree();
        
        int nodeToEliminate = 3; // Example node to eliminate
        tree.eliminateNode(nodeToEliminate);
        
        System.out.println("\nModified Tree:");
        tree.printTree();
        
        System.out.println("\nNumber of Leaves Left: " + tree.countLeaves());
    }
} 