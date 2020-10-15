import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ArrayProblem {


    public static void main(String[] args) {
        int a[] = {5, 7, 99, 3, 4, 45, 24};
        //3,4,5,7,24,45,99
        int b[] = {7, 3,45,24};
        //3,7,24,45
        findMissingNumbers(a,b);
    }

    public static void findMissingNumbers(int[] a, int[] b){
        Arrays.sort(a);
        Arrays.sort(b);
        int sizeA = a.length;
        int sizeB = b.length;
        int size = (sizeA>sizeB)?sizeA:sizeB;
        int i = 0, j = 0;
        for(i=0,j=0; i<size;){
            if(j>=sizeB){
                break;
            }
            if(a[i] == b[j]){
                i++;j++;
            }
            else{
                System.out.println(a[i]);
                i++;
            }
        }
        while(i<sizeA){
            System.out.println(a[i++]);

        }
    }
}
