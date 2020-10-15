import java.util.Arrays;

import static java.lang.Integer.min;
import static sun.swing.MenuItemLayoutHelper.max;

public class TrappingRainWater {
    public static void main(String[] args) {
        int[] blocks = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trapMaxRainWater(blocks));

    }
    public static int trapMaxRainWater(int[] blocks){
        int n = blocks.length;
        int leftMax = blocks[0], rightMax = blocks[n-1];
        int[] left = new int[n];
        int[] right = new int[n];
        for(int i=0;i<n;i++){
            left[i] = max(leftMax,blocks[i]);
            leftMax = left[i];
        }
        for(int i=n-1;i>=0;i--){
            right[i] = max(rightMax,blocks[i]);
            rightMax = right[i];
        }
        int maxWater = 0;
        for(int i=0;i<n;i++){
            int minLeftRight = min(left[i],right[i]);
            maxWater = maxWater + minLeftRight-blocks[i];
        }
        return maxWater;
    }
}
