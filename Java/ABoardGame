import java.util.*; 

public class ABoardGame{
    public static String whoWins(String[] board){
    	int N = board.length/2;
        Map <Character, Integer> result = new HashMap<Character, Integer>();
        result.put('A',0);
        result.put('B',0);
        result.put('.',0);
        for(int i = 1; i <= N; i++){
        	int first = N-i;
            int last = N+i-1;
            for(int j = first; j <= last; j++){
            	update(board, result, j, first);
                update(board, result, j, last);
            }
            for(int k = first+1; k <= last-1; k++){
            	update(board, result, first, k);
                update(board, result, last, k);
            }
            if(result.get('A') > result.get('B')){
            	return "Alice";
            }
            else if(result.get('A') < result.get('B')){
            	return "Bob";
            }
        }
        return "Draw";
    }
    
    public static void update(String[] board, Map <Character, Integer> result, int i, int j){
    	char ch;
        ch = board[i].charAt(j);
        result.put(ch, result.get(ch) + 1);
    }
}