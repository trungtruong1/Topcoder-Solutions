import java.util.*;

public class UnsealTheSafe {
    public static void main(String[] args) {
        System.out.println(countPasswords(25));
    }

    static long variations;

    public static long countPasswords(int N) {
        // initialize possible next buttons for all buttons
        HashMap<Integer, long[]> waysToPut = new HashMap<Integer, long[]>();
        waysToPut.put(1, new long[] { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 });
        for (int i = 2; i <= N; i++) {
            waysToPut.put(i, new long[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 });
            waysToPut.get(i)[1] = waysToPut.get(i - 1)[2] + waysToPut.get(i - 1)[4];
            waysToPut.get(i)[2] = waysToPut.get(i - 1)[1] + waysToPut.get(i - 1)[3] + waysToPut.get(i - 1)[5];
            waysToPut.get(i)[3] = waysToPut.get(i - 1)[2] + waysToPut.get(i - 1)[6];
            waysToPut.get(i)[4] = waysToPut.get(i - 1)[1] + waysToPut.get(i - 1)[5] + waysToPut.get(i - 1)[7];
            waysToPut.get(i)[5] = waysToPut.get(i - 1)[2] + waysToPut.get(i - 1)[4] + waysToPut.get(i - 1)[6] + waysToPut.get(i - 1)[8];
            waysToPut.get(i)[6] = waysToPut.get(i - 1)[3] + waysToPut.get(i - 1)[5] + waysToPut.get(i - 1)[9];
            waysToPut.get(i)[7] = waysToPut.get(i - 1)[4] + waysToPut.get(i - 1)[8] + waysToPut.get(i - 1)[0];
            waysToPut.get(i)[8] = waysToPut.get(i - 1)[5] + waysToPut.get(i - 1)[7] + waysToPut.get(i - 1)[9];
            waysToPut.get(i)[9] = waysToPut.get(i - 1)[6] + waysToPut.get(i - 1)[8];
            waysToPut.get(i)[0] = waysToPut.get(i - 1)[7];
        }
        long result = 0;
        for(int i = 0; i <=9; i++){
            result+=waysToPut.get(N)[i];
        }
        return result;
    }
}