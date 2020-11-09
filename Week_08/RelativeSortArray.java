/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2020. All rights reserved.
 */

package No1122;

import java.util.Arrays;

/**
 * 功能描述
 *
 * @since 2020-11-09
 */
public class RelativeSortArray {
    public static void main(String[] args) {
        RelativeSortArray r = new RelativeSortArray();
        int[] arr1 = {2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
        int[] arr2 = {2, 1, 4, 3, 9, 6};
        System.out.println(Arrays.toString(r.relativeSortArray(arr1, arr2)));
    }

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] arr = new int[1001];
        int[] res = new int[arr1.length];
        int index = 0;
        for (int item : arr1) {
            arr[item]++; // 统计arr1
        }
        for (int item : arr2) {
            while (arr[item]-- > 0) {
                res[index] = item;
                index++;
            }
        }
        for (int i = 0; i < 1001; i++) {
            while (arr[i]-- > 0) {
                res[index] = i;
                index++;
            }
        }
        return res;
    }
}
