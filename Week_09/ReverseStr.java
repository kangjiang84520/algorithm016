/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2020. All rights reserved.
 */

package No541;

/**
 * 功能描述
 *
 * @since 2020-11-16
 */
public class ReverseStr {
    public static void main(String[] args) {
        ReverseStr r = new ReverseStr();
        System.out.println(r.reverseStr("abcdefg", 2));
    }

    public String reverseStr(String s, int k) {
        char[] chs = s.toCharArray();
        int n = s.length();
        for (int i = 0; i < n; i += 2 * k) {
            int left = i;
            int right = (i + k - 1 < n) ? i + k - 1 : n - 1;
            while (left <= right) {
                char tmp = chs[left];
                chs[left] = chs[right];
                chs[right] = tmp;
                left++;
                right--;
            }
        }
        // return chs.toString();
        // return new String(chs);
        return String.valueOf(chs);
    }
}
