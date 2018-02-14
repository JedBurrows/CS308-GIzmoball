package Model;

public class L_Measurement {
    private int box_size;
    public L_Measurement(int board_width){
        box_size = board_width/20;
    }

    public int convertToSize(int l){
        return box_size*l;
    }

    public int convertToL(int length){
        int l = (length / box_size);
        return l;
    }
}
