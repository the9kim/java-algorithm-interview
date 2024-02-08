package org.javaalgorithminterview.ch7_array;

public class P8_1_Trapping_Rain_Water {

    /**
     * 1-1 if the height of right pillow is higher than the left pillow, calculate the water amount
     * 1-2 if there is no right pillow which is higher than the left pillow, caculate the water amount using the highest right pillow
     */
    public int trap(int[] height) {

        int sum = 0;
        int left = 0;

        while (left < height.length - 1) {
            if (height[left] > 0) {

                int right = left + 1;
                int maxRightHeight = 0;
                int maxRightIndex = 0;
                while (right < height.length) {
                    if (height[left] <= height[right]) {
                        sum += calculateWaterAmount(left, right, height);
                        left = right - 1;
                        break;
                    }

                    if (maxRightHeight <= height[right]) {
                        maxRightHeight = height[right];
                        maxRightIndex = right;
                    }
                    if (right == height.length - 1) {
                        sum += calculateWaterAmount(left, maxRightIndex, height);
                        left = maxRightIndex - 1;
                    }

                    right++;
                }
            }
            left++;
         }

        return sum;
    }

    /**
     * The solution the textbook suggests
     *
     * 1. Set two pointers(left and right)
     * 2. Compare the maximum heights on the both side and update the each of the maximum height
     * 3. if the height at each pointer is lower than the maximum height, add the amount of water
     */
    public int trap2(int[] height) {
        int amount = 0;

        int left = 0;
        int right = height.length - 1;

        int maxLeft = 0;
        int maxRight = 0;

        while (left < right) {
            maxLeft = Math.max(maxLeft , height[left]);
            maxRight = Math.max(maxRight, height[right]);

            if (maxLeft <= maxRight) {
                amount += maxLeft - height[left];
                left++;
            } else {
                amount += maxRight - height[right];
                right--;
            }
        }

        return amount;
    }

    /**
     * 1. Find two indices for a pair of Pillows.
     * 2. Calculate the amount of water in the two pillows
     * 3. Get the total amount of water
     */
    public int trap3(int[] height) {
        int sum = 0;

        int left = -1;
        int leftHeight = 0;

        int right = -1;
        int rightHeight = 0;

        for (int i = 0; i < height.length; i++) {

            // Find the right pillow
            if (leftHeight != 0 && height[i] >= leftHeight) {
                right = i;
                rightHeight = height[i];
            }

            // Calculate the water amount
            if (leftHeight != 0 && rightHeight != 0) {
                sum += calculateWaterAmount(left, right, height);
                left = -1;
                leftHeight = 0;
                right = -1;
                rightHeight = 0;
            }
            // Find the left Pillow
            if (leftHeight == 0 && height[i] >= 1) {
                left = i;
                leftHeight = height[left];
            }
        }

        return sum;
    }

    public int calculateWaterAmount(int left, int right, int[] height) {
        int amount = 0;

        int pillowMinHeight = Math.min(height[left], height[right]);

        for (int i = left + 1; i < right; i++) {
            amount += pillowMinHeight - height[i];
        }

        return amount;
    }

}
