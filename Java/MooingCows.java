import java.util.*;
import java.awt.Point;

public class MooingCows{
    public static int dissatisfaction(String[] farmland){
        int smallest_sound = Integer.MAX_VALUE;
        List<Point> list = new ArrayList<Point>();
        int lenFarmX = farmland.length;
        int lenFarmY = farmland[0].length();
        for(int i = 0; i < lenFarmX; i++){
            for(int j = 0; j < lenFarmY; j++){
                if(farmland[i].charAt(j) == 'C'){
                    list.add(new Point(i, j));
                }
            }
        }
        int current_sound;
        Point chosen_cow;
        Point next_cow;
        for(int i=0; i < list.size();i++){
            chosen_cow = list.get(i);
            current_sound = 0;
            for(int j=0; j < list.size();j++){
                next_cow = list.get(j);
                if(chosen_cow != next_cow){
                    current_sound+= (Math.pow((chosen_cow.getX()-next_cow.getX()),2) + Math.pow((chosen_cow.getY()-next_cow.getY()),2));
                }
            }
            if(current_sound < smallest_sound){
                smallest_sound = current_sound;
            }
        }
        return smallest_sound;
    }
}
