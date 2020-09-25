/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2020. All rights reserved.
 */

package No46;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

/**
 * 功能描述
 *
 * @since 2020-09-22
 */
public class PermuteWithNoRepeat {
    public static void main(String[] args) {
        PermuteWithNoRepeat p = new PermuteWithNoRepeat();
        int[] nums = {1, 2, 3};
        System.out.println(p.permute(nums));
    }

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        // 使用一个动态数组保存所有可能的全排列
        List<List<Integer>> resList = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        Deque<Integer> stack = new ArrayDeque<>();
        helper(nums, stack, visited, resList);
        /*
         * List<Integer> ele = new ArrayList<>(); for (int num : nums) { ele.add(num); } traceback(nums.length, ele,
         * resList, 0);
         */
        return resList;
    }

    /**
     * 总结搜索的方法：按顺序枚举每一位可能出现的情况，已经选择的数字在 当前 要选择的数字中不能出现。
     *
     * 按照这种策略搜索就能够做到 不重不漏。这样的思路，可以用一个树形结构表示
     *
     * 作者：liweiwei1419
     * 链接：https://leetcode-cn.com/problems/permutations/solution/hui-su-suan-fa-python-dai-ma-java-dai-ma-by-liweiw/
     *
     * @param nums
     * @param ele
     * @param visited
     * @param resList
     */
    private void helper(int[] nums, Deque<Integer> ele, boolean[] visited, List<List<Integer>> resList) {
        // 叶子节点处：变量 path 所指向的列表 在深度优先遍历的过程中只有一份 ，深度优先遍历完成以后，回到了根结点，成为空列表。
        // 在 Java 中，参数传递是 值传递，对象类型变量在传参的过程中，复制的是变量的地址。这些地址被添加到 res 变量，但实际上指向的是同一块内存地址，
        // 因此我们会看到 6 个空的列表对象。解决的方法很简单，在 res.add(path); 这里做一次拷贝即可。
        if (nums.length == ele.size()) {
            resList.add(new ArrayList<>(ele));
        }
        // 在非叶子结点处，产生不同的分支，这一操作的语义是：在还未选择的数中依次选择一个元素作为下一个位置的元素，这显然得通过一个循环实现。
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            } else {
                visited[i] = true;
                ele.push(nums[i]);
                helper(nums, ele, visited, resList);
                // 注意：下面这两行代码发生 「回溯」，回溯发生在从 深层结点 回到 浅层结点 的过程，代码在形式上和递归之前是对称的
                visited[i] = false;
                ele.pop();
            }
        }
    }

    /**
     * 以交换数组元素的方式做，时空效率均很高。解释：求1—n-1的全排列，过程应是这样的：先将第一个数固定，
     *
     * 然后求剩下的n-1个数的全排列。求n-1个数的全排列的时候，还是一样，将第一个数固定，求n-2个数的全排列。
     *
     * 直到剩下一个数，那他的全排列就是自己。那这个固定的数字应该有多种取值，比如求0,1,2三个数的全排列，固定的第一个数，
     *
     * 应有0,1,2三种取值对吧，当固定第一个数，比如固定了0，那剩下1,2两个数，再固定一个数，这个数有1和2两种取值，有没有发现什么？
     *
     * 我们发现，这个固定的数的取值，不就是将固定的位置的数和剩下的数字不断交换的过程么
     *
     * @param len
     * @param ele
     * @param resList
     * @param first
     */
    private void traceback(int len, List<Integer> ele, List<List<Integer>> resList, int first) {
        if (len == first) {
            resList.add(new ArrayList<>(ele));
            return;
        }
        for (int i = first; i < len; i++) {
            Collections.swap(ele, first, i);
            traceback(len, ele, resList, first + 1);
            Collections.swap(ele, first, i);
        }
    }
}
