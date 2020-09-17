/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2020. All rights reserved.
 */

package No242;

import java.util.Arrays;

/**
 * 功能描述
 *
 * @since 2020-09-14
 */
public class IsAnagram {
    public boolean isAnagram(String s, String t) {
        return useSort(s, t);
    }

    private boolean useSort(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] chs = s.toCharArray();
        char[] cht = t.toCharArray();
        Arrays.sort(chs);
        Arrays.sort(cht);
        return Arrays.equals(chs, cht);
    }

    private boolean useHash(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] hashTable = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            hashTable[ch - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            hashTable[ch - 'a']--;
        }
        for (int c : hashTable) {
            if (c != 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * useHash 有两个地方可以优化：
     *
     * 1. 在一次for loop中，可以把s 和 t 都遍历掉 ---> useHashOptimal1;
     *
     * 2. 如果一次for loop中，只处理s，那么在第二次for loop中，t的元素遍历的同时，可以进行判断 ---> useHashOptimal2
     *
     * @param s
     * @param t
     * @return
     */
    private boolean useHashOptimal1(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] hashTable = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            hashTable[ch - 'a']++;
            ch = t.charAt(i);
            hashTable[ch - 'a']--;
        }

        for (int c : hashTable) {
            if (c != 0) {
                return false;
            }
        }
        return true;
    }

    private boolean useHashOptimal2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] hashTable = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            hashTable[ch - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            hashTable[ch - 'a']--;
            if (hashTable[ch - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
