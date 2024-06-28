public class ExerciseMachine {
    public static void main(String[] args) {
        String time = "00:28:00";
        System.out.println(getPercentages(time));
    }

    public static int getPercentages(String time) {
        String[] parts = time.split(":");
        float interval = 0;
        int seconds = Integer.valueOf(parts[0]) * 1800 + Integer.valueOf(parts[1]) * 60 + Integer.valueOf(parts[2]);
        for (float i = 1; i < 100; i++) {
            float percent = (i) / 100;
            interval = percent * seconds;
            if (interval % 1 == 0) {
                break;
            }
        }
        return seconds/Math.round(interval) - 1;
    }
}
