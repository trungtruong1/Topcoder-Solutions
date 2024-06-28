import java.util.Arrays;

public class TaliluluCoffee {
   public static int maxTip(int[] tips) {
      int[] maxTips = new int[tips.length];

      maxTips[0] = Arrays.stream(tips).max().getAsInt();
   
      for (int i = 1; i < tips.length; i++) {
         int tip = tips[i] - i;
         maxTips[i] = Math.max(maxTips[i - 1], tip > 0 ? maxTips[i - 1] + tip : maxTips[i - 1]);
      }
      return maxTips[tips.length - 1];
   }

   public static void main(String[] args){
      int[] customerValues = {1, 1, 1, 1, 2};  
      int maxTipAmount = maxTip(customerValues);  
      System.out.println("Maximum tip amount = " + maxTipAmount);
   }
}