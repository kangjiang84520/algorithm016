/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2020. All rights reserved.
 */

package No231;

/**
 * 功能描述
 *
 * @since 2020-11-09
 */
public class IsPowerOfTwo {
    public static void main(String[] args) {
        IsPowerOfTwo power = new IsPowerOfTwo();
        System.out.println(power.isPowerOfTwo(8));
        System.out.println(power.isPowerOfTwo(9));
    }

    public boolean isPowerOfTwo(int n) {
        return helper1(n);
    }

    private boolean helper1(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}
