import java.util.ArrayList;
import java.util.List;

public class AlternateColors {
    public static String getColor(long r, long g, long b, long k){
        long[] rgb = new long[3];
        List<Integer> remainList = new ArrayList<>();
        rgb[0] = r;
        rgb[1] = g;
        rgb[2] = b;
        int count = 0;
        long remainder = k%3;
        k = k/3;
        if(k < Math.min(Math.min(r, g), b)){
            r-=k;
            g-=k;
            b-=k;
            if(remainder == 0){
                return "BLUE";
            }else{
                if(remainder == 1){
                    return "RED";
                }else{
                    return "GREEN";
                }
            }
        }else{
                long min = Math.min(Math.min(r, g), b);
                rgb[0]-=min;
                rgb[1]-=min;
                rgb[2]-=min;
                k = (k - min)*3 + remainder;
                if(k == 0) return "BLUE";
                for(int i = 0; i<3; i++){
                    if(rgb[i] > 0){
                        count++;
                        remainList.add(i);
                    }
                }
                if(count == 1){
                    if(remainList.get(0) == 0) return "RED";
                    if(remainList.get(0) == 1) return "GREEN";
                    if(remainList.get(0) == 2) return "BLUE";
                }else if(count == 2){
                    remainder = k%2;
                    k = k/2;
                    int left1 = remainList.get(0);
                    int left2 = remainList.get(1);
                    if((k < Math.min(rgb[left1],rgb[left2]) && remainder == 0) || (k == Math.min(rgb[left1],rgb[left2]) && remainder == 0)){
                        if(left2 == 1) return "GREEN";
                        if(left2 == 2) return "BLUE";
                    }
                    if(k < Math.min(rgb[left1],rgb[left2]) && remainder == 1 ){
                        if(left1 == 0) return "RED";
                        if(left1 == 1) return "GREEN";
                    }
                    if(k == Math.min(rgb[left1],rgb[left2]) && remainder == 1){
                        if(rgb[left1] - k == 0){
                            if(left2 == 1) return "GREEN";
                            if(left2 == 2) return "BLUE";
                        }else{
                            if(left1 == 0) return "RED";
                            if(left1 == 1) return "GREEN";
                        }
                    }
                    if(k > Math.min(rgb[left1],rgb[left2])){
                        rgb[left1]-=k;
                        rgb[left2]-=k;
                        if(rgb[left1] <= 0){
                            if(left2 == 0) return "RED";
                            if(left2 == 1) return "GREEN";
                            if(left2 == 2) return "BLUE";
                        }else{
                            if(left1 == 0) return "RED";
                            if(left1 == 1) return "GREEN";
                            if(left1 == 2) return "BLUE";
                        }
                    }
                }else{
                    return "BLUE";
                }
        }
        return "";
    }
}


