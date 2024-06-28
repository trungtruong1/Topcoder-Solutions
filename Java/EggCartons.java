public class EggCartons{
    // public static void main(String[] args){
    //     System.out.println(minCartons(4));
    // }

    static int minCartons;
    public static int minCartons(int n){
        minCartons = Integer.MAX_VALUE;
        recursiveLoop(0, n, 0);
        if(minCartons == Integer.MAX_VALUE) return -1;
        else return minCartons;
    }

    public static void recursiveLoop(int total_egg, int goal, int cartons_bought){
        if(total_egg < goal){
            //buy 6-egg
            recursiveLoop(total_egg+6, goal, cartons_bought+1);
    
            //buy 8-egg
            recursiveLoop(total_egg+8, goal, cartons_bought+1);
        }
        if(total_egg == goal){
            if(cartons_bought < minCartons){
                minCartons = cartons_bought;
            }
        }
    }
}
