import java.util.HashSet;

public class CastleGuards {
    public static void main(String[] args) {
        String[] castle = {"."};
        System.out.println(missing(castle));
    }

    public static int missing(String[] castle){
        int cols = castle[0].length();
        int rows = castle.length;
        HashSet<Integer> row_nums = new HashSet<>();
        HashSet<Integer> col_nums = new HashSet<>();
        for(int i = 0; i < rows; i++){
            row_nums.add(i);
        }
        for(int i = 0; i < cols; i++){
            col_nums.add(i);
        }
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                char current = castle[i].charAt(j);
                if(current == 'X'){
                    row_nums.remove(i);
                    col_nums.remove(j);
                }
            }
        }
        if(row_nums.size() > col_nums.size()){
            return row_nums.size();
        }
        else{
            return col_nums.size();
        }
    }
}
