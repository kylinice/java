package offer;
import java.util.ArrayList;
public class offer_6_minNumberInRotateArray {
    public static int minNumberInRotateArray(int [] array) {
        int min = 0;
        if(array.length == 0)
            return min;
        for(int i=0;i<array.length-1;i++){
            if(array[i+1]<array[i]){
                min = array[i+1];
                break;
            }
        }
        return min;
    }
    public static void main(String[] args) {

    }
}
