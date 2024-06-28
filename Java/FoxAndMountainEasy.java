public class FoxAndMountainEasy {
  public static void main(String[] args) {
    int n = 4;
    int h0 = 0;
    int hn = 4;
    String history = "DDU";
    System.out.println(possible(n, h0, hn, history));
  }

  public static String possible(int n, int h0, int hn, String history) {
    int delta = h0;
    int k = 0;

    for (int i = 0; i < history.length(); i++) {
      delta += (history.charAt(i) == 'U') ? 1 : -1;
      if (delta < 0) {
        delta++;
        System.out.println(delta);
        k++;
      }
    }

    System.out.println(delta);
    k = k + history.length();
    k = n - k;
    hn = Math.abs(hn - delta);

    return (k < 0 || hn > k + 1 || hn % 2 != k % 2)
        ? "NO"
        : "YES";
  }
}