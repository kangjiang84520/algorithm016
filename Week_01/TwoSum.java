/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2020. All rights reserved.
 */

package No1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 功能描述
 *
 * @since 2020-09-08
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        return withHashOnce(nums, target);
    }

    public static void main(String[] args) {
        TwoSum t = new TwoSum();
        // int[] nums = {2, 7, 11, 15};
        // int[] nums = {3, 2, 4};
        int[] nums = {3, 3};
        System.out.println(Arrays.toString(t.twoSum(nums, 6)));
    }

    public int[] withHashTwice(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] {i, map.get(complement)};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public int[] withHashOnce(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complment = target - nums[i];
            if (map.containsKey(complment)) {
                return new int[] {map.get(complment), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     * 此方法是自己的第一感觉，经实践后不行，不再死磕
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] sortAndDoublePointer(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        Arrays.sort(nums);
        int i = 0;
        int j = nums.length - 1;
        int[] res = new int[2];
        while (i < j) {
            if ((nums[i] + nums[j]) < target) {
                i++;
            } else if ((nums[i] + nums[j]) > target) {
                j--;
            } else {
                break;
            }
        }
        res[0] = map.get(nums[i]);
        res[1] = map.get(nums[j]);
        return res;
    }
}
