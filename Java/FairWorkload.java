public class FairWorkload {
    public static void main(String[] args) {
        int[] nums = {10, 20, 30, 40, 50, 60, 70, 80, 90};
        int parts = 3;
        int result = getMostWork(nums, parts);
        System.out.print(result);
    }

    public static int getMostWork(int[] folders, int workers) {
        for (int i = 0; true; i++) {
            System.out.println(i);
            if (could(folders, workers, i)) {
                return i;
            }
        }
    }

    public static boolean could(int[] folders, int workers, int max) {
        int cur = 0;
        for (int i = 0; i < folders.length; i++) {
            cur += folders[i];
            if (cur > max) {
                cur = folders[i];
                workers--;
            }
            if (cur > max) {
                return false;
            }
        }
        return workers > 0;
    }
}