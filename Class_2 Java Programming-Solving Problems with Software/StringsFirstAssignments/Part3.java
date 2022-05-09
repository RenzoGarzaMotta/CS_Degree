
/**
 * Write a description of Part3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part3 {
    public static boolean twoOccurrences(String stringa, String stringb){
        int count = 0;
        int index = 0;
        do{
            index = stringb.indexOf(stringa, index);
            if(index != -1){
                count++;
            }
        }while(index != -1);
        if(count >= 2){
            return true;
        }else{
            return false;
        }
    }
}
