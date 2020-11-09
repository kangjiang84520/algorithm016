/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2020. All rights reserved.
 */

package No191;

/**
 * 功能描述
 *
 * @since 2020-11-06
 */
public class HammingWeight {
    public static void main(String[] args) {
        HammingWeight h = new HammingWeight();
        System.out.println(h.hammingWeight(Long.valueOf("11111111111111111111111111111101", 2)));
    }

    public int hammingWeight(Long n) {
        return helper1(n);
    }

    private int helper1(Long n) {
        int count = 0;
        while (n > 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n = (n >> 1);
        }
        return count;
    }

    private int helper2(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if (((n >> i) & 1) == 1) {
                count++;
            }
        }
        return count;
    }
}
