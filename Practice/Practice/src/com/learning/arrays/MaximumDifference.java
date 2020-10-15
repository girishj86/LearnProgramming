import static java.lang.Integer.max;
import static java.lang.Integer.min;

public class MaximumDifference {

    public static void main(String[] args) {
        int[] arr = {2,6,8,4,10,3,7};
        System.out.println(maxDiff(arr));
    }

    public static int maxDiff(int[] arr){
        int n = arr.length;
        int min = arr[0];
        int maxDiff = arr[1]-arr[0];
        for(int i=0;i<n;i++){
            maxDiff = max(maxDiff,arr[i]-min);
            min = min(min,arr[i]);
        }
        return maxDiff;
    }
}
