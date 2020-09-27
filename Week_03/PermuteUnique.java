/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2020. All rights reserved.
 */

package No47;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 功能描述
 *
 * @since 2020-09-27
 */
public class PermuteUnique {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ele = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums); // 考虑重复元素一定要优先排序，将重复的都放在一起，便于找到重复元素和剪枝
        helper(nums, visited, res, ele);
        return res;
    }

    private void helper(int[] nums, boolean[] visited, List<List<Integer>> res, List<Integer> ele) {
        if (nums.length == ele.size()) {
            res.add(new ArrayList<>(ele));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] || (i > 0 && nums[i - 1] == nums[i] && !visited[i - 1])) {
                continue;
            }
            ele.add(nums[i]);
            visited[i] = true;
            helper(nums, visited, res, ele);
            ele.remove(ele.size() - 1);
            visited[i] = false;
        }
    }
}
