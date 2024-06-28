public class BlackAndWhiteSolitaire {
    public static void main(String[] args) {
        String cardFront = "BBBW";
        System.out.println(minimumTurns(cardFront));
    }

    public static int minIf(String cardFront, Character chosen) {
        int haveToFlip = 0;
        for (int i = 0; i < cardFront.length(); i++) {
            if (i % 2 == 0) { // Even indices
                if (cardFront.charAt(i) != chosen) {
                    haveToFlip++;
                }
            } else { // Odd indices
                if (cardFront.charAt(i) == chosen) {
                    haveToFlip++;
                }
            }
        }
        return haveToFlip;
    }

    public static int minimumTurns(String cardFront) {
        return Math.min(minIf(cardFront, 'W'), minIf(cardFront, 'B'));
    }

}