public class RockStar {
    public static void main(String[] args) {
        int ff = 1;
        int fs = 1;
        int sf = 1;
        int ss = 1;
        System.out.println(getNumSongs(ff, fs, sf, ss));
    }

    public static int getNumSongs(int ff, int fs, int sf, int ss) {
        if (fs == 0 && ff == 0 && sf != 0 && ss != 0)
            return ss + 1;
        if (fs == 0 && ff == 0 && sf != 0 && ss == 0)
            return 1;
        if (fs == 0 && ff != 0)
            return ff;
        int numSongs = 0;
        if (ff > 0) {
            numSongs += ff;
        }
        if (fs > 0) {
            numSongs += 1;
            fs -= 1;
        }
        if (ss > 0) {
            numSongs += ss;
        }
        int canAdd;
        if (fs < sf) {
            canAdd = fs;
            fs-=fs;
            sf-=fs;
        } else {
            canAdd = sf;
            fs-=sf;
            sf-=sf;
        }
        if(sf >= 1) numSongs+=1;
        return numSongs + canAdd*2;
    }
}
