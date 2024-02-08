package org.javaalgorithminterview.ch7_array;

import org.assertj.core.api.Assertions;
import org.javaalgorithminterview.ch7_array.P11_1_Product_of_Array_Except_Self;
import org.junit.jupiter.api.Test;

class P11_1_Product_of_Array_Except_SelfTest {

    @Test
    void productExceptSelf() {
        // given
        int[] nums = {1, 2, 3, 4};
        int[] expected = {24, 12, 8, 6};

        // when
        P11_1_Product_of_Array_Except_Self p11 = new P11_1_Product_of_Array_Except_Self();
        int[] answer = p11.productExceptSelf3(nums);

        // then
        Assertions.assertThat(answer).isEqualTo(expected);
    }

    @Test
    void swapInputArray() {
        // given
        int[] nums = {1, 2, 3, 4};
        int[] expected = {4, 3, 2, 1};

        // when
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }

        // then
        Assertions.assertThat(nums).isEqualTo(expected);
    }
}
