package org.javaalgorithminterview.ch7_array;

import java.util.ArrayDeque;
import java.util.Deque;

public class P8_2_Trapping_Rain_Water {

    /**
     * 1. Utilize iteration
     * 2. Append each element of the Array to a stack
     * 3. If the last element of the stack is smaller than the element at the pointer, calculate the amount of water
     */
    public int trap(int[] height) {
        int volume = 0;

        Deque<Integer> stack = new ArrayDeque();

        for (int i = 0; i < height.length; i++) {

            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {

                int floorIdx = stack.pop();

                if (stack.isEmpty()) {
                    break;
                }

                // calculate the length of volume
                int L = i - stack.peek() - 1;

                // calculate the height of volume
                int H = Math.min(height[i], height[stack.peek()]) - height[floorIdx];

                // calculate the volume
                volume += L * H;
            }
            stack.push(i);
        }

        return volume;
    }
}
