import java.util.Arrays;

public class ArrayRotation {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};//2,3,4,1
        //System.out.println(Arrays.toString(leftRotateOnce(arr)));
        System.out.println(Arrays.toString(leftRotateNTimes(arr,2)));
    }

    public static int[] leftRotateOnce(int[] arr){
        int temp = arr[0];
        for(int i=0;i<arr.length-1;i++){
            arr[i] = arr[i+1];
        }
        arr[arr.length-1] = temp;
        return arr;
    }

    public static int[] leftRotateNTimes(int[] arr, int n){
        //{1,2,3,4,5}
        //{3,4,5,1,2}
        int[] temp = new int[n];
        for(int i=0;i<n;i++){
            temp[i] = arr[i];
        }
        System.out.println(Arrays.toString(temp));
        for(int i=0;i<arr.length-n;i++){
            arr[i] = arr[i+n];
        }
        System.out.println(Arrays.toString(arr));
        int j=0;
        for(int i=arr.length-n;i<arr.length;i++){
            arr[i] = temp[j++];
        }
        return arr;
    }
}
