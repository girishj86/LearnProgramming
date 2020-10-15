import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class MissingNumber {
    public static void main(String[] args) {
        int[] arr = {-47,1,4,49,-18,10,26,18,-11,-38,-24,36,44,-11,45,20,-16,28,17,-49,47,-48,-33,42,2,6,-49,30,36,-9,15,39,-6,-31,-10,-21,-19,-33,47,21,31,25,-41,-23,17,6,47,3,36,15,-44,33,-31,-26,-22,21,-18,-21,-47,-31,20,18,-42,-35,-10,-1,46,-27,-32,-5,-4,1,-29,5,29,38,14,-22,-9,0,43,-50,-16,14,-26};
        System.out.println(missingNumber(arr));
    }

    static int missingNumber(int arr[])
    {
        int i=1;
        //Arrays.sort(arr);
        Set<Integer> set = new TreeSet<Integer>();
        set.addAll(Arrays.stream(arr).boxed().collect(Collectors.toList()));
        System.out.println(Arrays.toString(arr));
        for(int num:set){
            if(num<=0){
                continue;
            }
            if(num>0 && num!=i){
                return i;
            } else {
                i++;
            }

        }
        return i;
    }
}
