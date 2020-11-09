/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2020. All rights reserved.
 */

package No190;

/**
 * 功能描述
 *
 * @since 2020-11-09
 */
public class ReverseBits {
    public static void main(String[] args) {
        ReverseBits r = new ReverseBits();
        System.out
            .println(Integer.toBinaryString(r.reverseBits(Integer.valueOf("00000010100101000001111010011100", 2))));
    }

    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        return helper1(n);
    }

    private int helper1(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res = (res << 1) + (n & 1);
            n >>= 1;
        }
        return res;
    }
}
