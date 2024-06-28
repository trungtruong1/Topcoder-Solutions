import java.util.LinkedList;
import java.util.Queue;

public class MagicSpell {
    public static void main(String[] args) {
        String spell = "ABACADA";
        System.out.println(fixTheSpell(spell));
    }

    public static String fixTheSpell(String spell) {
        if(spell.length() == 1) return spell;
        StringBuilder str = new StringBuilder(spell);
        Queue<Integer> one = new LinkedList<Integer>();
        Queue<Integer> two = new LinkedList<Integer>();
        for (int i = 0; i < spell.length(); i++) {
            if(spell.charAt(i) == 'A' || spell.charAt(i) == 'Z'){
                one.add(i);
            }
        }
        for (int i = spell.length()-1; i >= 0; i--) {
            if(spell.charAt(i) == 'A' || spell.charAt(i) == 'Z'){
                two.add(i);
            }
        }
        if(one.size() == 0 || two.size() == 1) return spell;
        int index1 = one.poll();
        int index2 = two.poll();
        while(index1 <= index2){
            str.setCharAt(index1, spell.charAt(index2));
            str.setCharAt(index2, spell.charAt(index1));
            // System.out.println(index1 + " " + index2 + " " + str);
            index1 = one.poll();
            index2 = two.poll();
        }
        return str.toString();
    }
}
