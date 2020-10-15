import java.util.Arrays;

public class FibonacciSeries {

    public static void main(String[] args) {
        //1,1,2,3,5,8,13
        printFibonacciSeries(7);
        System.out.println(Arrays.toString(arrayFibonacciSeries(7)));
        printFibonacciRecursive(7, 0, 1, 0);
    }

    public static void printFibonacciSeries(int n) {
        int f, prev = 1, prev_prev = 0;
        System.out.print(prev + " ");
        for (int i = 1; i < n; i++) {
            f = prev + prev_prev;
            prev_prev = prev;
            prev = f;
            System.out.print(f + " ");
        }
    }

    public static int[] arrayFibonacciSeries(int n) {
        int[] series = new int[n];
        int f, prev = 1, prev_prev = 0;
        series[0] = 1;
        series[1] = 1;
        for (int i = 2; i < n; i++) {
            series[i] = series[i - 1] + series[i - 2];
        }
        return series;
    }

    public static void printFibonacciRecursive(int n, int counter, int prev, int prev_prev) {
        if (counter == n - 1) return;
        if (counter == 1) System.out.println(prev);
        int f = prev + prev_prev;
        System.out.println(f);
        prev_prev = prev;
        prev = f;
        printFibonacciRecursive(n, ++counter, prev, prev_prev);
    }

}
