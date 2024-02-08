package org.javaalgorithminterview.ch7_array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P9_1_3Sum {
    /**
     * A solution the textbook suggests
     * This solution doesn't use Set type. It removes duplication using two pointers
     * <p>
     * 1. Sort the input array
     * 2. Utilize iteration and two pointer
     * 3. remove duplicate paris
     */
    public List<List<Integer>> threeSum4(int[] nums) {

        List<List<Integer>> answer = new ArrayList<>();

        // 1
        Arrays.sort(nums);

        // 2

        for (int i = 0; i < nums.length - 2; i++) {

            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                if (nums[i] + nums[left] + nums[right] < 0) {
                    left++;
                } else if (nums[i] + nums[left] + nums[right] > 0) {
                    right--;
                } else {
                    answer.add(List.of(nums[i], nums[left], nums[right]));

                    // 3.
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                }
            }
        }
        return answer;
    }

    /**
     * When I change the method of removing the duplicate triplets
     * from using the 'contains' method of a List to using the Set data type,
     * I can reduce the ruuning time by almost 500 milliseconds.
     */
    public List<List<Integer>> threeSum3(int[] nums) {
        long start = System.currentTimeMillis();
        Set<List<Integer>> answer = new HashSet<>();

        // 1
        Arrays.sort(nums);
        long mid = System.currentTimeMillis();


        System.out.println("Sorting Time");
        System.out.println(mid - start);
        System.out.println("====");


        // 2
        for (int i = 0; i < nums.length - 2; i++) {

            int target = -nums[i];

            // 3
            int left = i + 1;
            int right = nums.length - 1;

            if (target > nums[right] + nums[right - 1]
                    || (target < nums[left] + nums[left + 1])
                    || (i > 0 && nums[i - 1] == nums[i])) {
                continue;
            }

            if (nums[i] > 0) {
                break;
            }


            while (left < right) {
                if (nums[left] + nums[right] < target) {
                    left++;
                } else if (nums[left] + nums[right] > target) {
                    right--;
                } else {
                    answer.add(List.of(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                }
            }
        }
        long end = System.currentTimeMillis();

        System.out.println("Sum time");
        System.out.println(end - mid);
        System.out.println("====");

        return new ArrayList<>(answer);
    }


    /**
     * 1. Sort the input array
     * 2. Utilize triple interation
     * 3. Sum three elements from the input array and compare the sum with zero
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();

        // 1
        Arrays.sort(nums);

        // 2
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 1; j++) {
                if (nums[i] + nums[j] > nums[j + 1]) {
                    continue;
                }
                for (int k = j + 1; k < nums.length; k++) {
                    // 3
                    if (nums[i] + nums[j] + nums[k] == 0 && !answer.contains(List.of(nums[i], nums[j], nums[k]))) {
                        answer.add(List.of(nums[i], nums[j], nums[k]));
                    }
                }
            }
        }
        return answer;
    }

    /**
     * 1. Sort the input Array
     * 2. utilize iteration
     * 3. Use two Pointer
     */
    public List<List<Integer>> threeSum2(int[] nums) {
        long start = System.currentTimeMillis();
        List<List<Integer>> answer = new ArrayList<>();

        // 1
        Arrays.sort(nums);
        long mid = System.currentTimeMillis();


        System.out.println("Sorting Time");
        System.out.println(mid - start);
        System.out.println("====");


        // 2
        for (int i = 0; i < nums.length - 2; i++) {

            int target = -nums[i];

            // 3
            int left = i + 1;
            int right = nums.length - 1;

            if (target > nums[right] + nums[right - 1]
                    || (target < nums[left] + nums[left + 1])
                    || (i > 0 && nums[i - 1] == nums[i])) {
                continue;
            }

            if (nums[i] > 0) {
                break;
            }


            while (left < right) {
                if (nums[left] + nums[right] < target) {
                    left++;
                } else if (nums[left] + nums[right] > target) {
                    right--;
                } else {
                    if (!answer.contains(List.of(nums[i], nums[left], nums[right]))) {
                        answer.add(List.of(nums[i], nums[left], nums[right]));
                    }
                    left++;
                    right--;
                }
            }
        }
        long end = System.currentTimeMillis();

        System.out.println("Sum time");
        System.out.println(end - mid);
        System.out.println("====");

        return answer;
    }
}
