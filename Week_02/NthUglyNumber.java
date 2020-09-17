/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2020. All rights reserved.
 */

package No264;

import java.util.TreeSet;

/**
 * 功能描述
 *
 * @since 2020-09-17
 */
public class NthUglyNumber {
    public static void main(String[] args) {
        NthUglyNumber uglyNumber = new NthUglyNumber();
        System.out.println(uglyNumber.nthUglyNumber(10));
    }

    public int nthUglyNumber(int n) {
        return uglyNumByDp(n);
    }

    private int uglyNumByHeap(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        long res = 1;
        TreeSet<Long> set = new TreeSet<>();
        set.add(res);

        // 所有丑数都是之前的丑数乘以 2, 3, 5 生成的
        for (int i = 1; i < n; i++) {
            res = set.pollFirst();
            set.add(res * 2);
            set.add(res * 3);
            set.add(res * 5);
            // System.out.println(set.size());
        }
        res = set.pollFirst();
        return (int) res;
    }

    /**
     * https://leetcode-cn.com/problems/ugly-number-ii/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-5-9/
     *
     * @param n
     * @return
     */
    int uglyNumByDp(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int[] ugly = new int[n];
        ugly[0] = 1;
        int p2 = 0, p3 = 0, p5 = 0;
        for (int i = 1; i < n; i++) {
            int factor2 = ugly[p2] * 2;
            int factor3 = ugly[p3] * 3;
            int factor5 = ugly[p5] * 5;
            int min = Math.min(factor5, Math.min(factor2, factor3));
            ugly[i] = min;
            // 这里需要注意的是，归并排序中我们每次从两个数组中选一个较小的，所以用的是 if...else...
            // 这里的话，用的是并列的 if , 这样如果有多组的当前值都是 min，指针都需要后移，从而保证 ugly 数组中不会加入重复元素。
            if (factor2 == min) {
                p2++;
            }
            if (factor3 == min) {
                p3++;
            }
            if (factor5 == min) {
                p5++;
            }
        }
        return ugly[n - 1];
    }
}
