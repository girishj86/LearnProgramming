import java.util.Scanner;

public class Leaders {
    public static void main(String[] args) {
        int[] arr = {3,4,10,6,9,5,8,2};
        printLeaders(arr);
        Scanner sc = new Scanner(System.in);
    }

    public static void printLeaders(int[] arr){
        int n = arr.length, cur_leader = arr[n-1];
        System.out.println(cur_leader);
        for(int i=n-2;i>0;i--){
            if(arr[i]>cur_leader){
                System.out.println(arr[i]);
                cur_leader = arr[i];
            }
        }
    }

}
