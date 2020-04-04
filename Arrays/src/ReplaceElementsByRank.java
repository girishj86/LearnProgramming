import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class ReplaceElementsByRank {
    public static void main(String[] args) {
        int[] numbers = {23,56,34,78,44,11,99,88};
        Arrays.stream(rankArray(numbers)).forEach(number-> System.out.print(number+" "));
    }

    static int[] rankArray(int[] numbers) {
        Map<Integer, Integer> map = new TreeMap<>();
        int[] result = new int[numbers.length];
        //add all numbers into sorted tree map
        //each number will be mapped to its index in sorted order
        for (int i = 0; i < numbers.length; i++) {
            map.put(numbers[i], i + 1);
        }
        int i = 1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            result[entry.getValue() - 1] = i;
            i++;
        }
        return result;
    }
}
