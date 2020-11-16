/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2020. All rights reserved.
 */

package No387;

import java.util.HashMap;
import java.util.Map;

/**
 * 功能描述
 *
 * @since 2020-11-16
 */
public class FirstUniqChar {
    public static void main(String[] args) {
        FirstUniqChar f = new FirstUniqChar();
        // System.out.println(f.firstUniqChar("leetcode"));
        // System.out.println(f.firstUniqChar("loveleetcode"));
        System.out.println(f.firstUniqChar("cc"));
    }

    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }
        // return helper1(s);
        // return helper2(s);
        return helper3(s);
    }

    private int helper3(String s) {
        int res = -1;
        for (char c = 'a'; c <= 'z'; c++) {
            int index = s.indexOf(c);
            if (index != -1 && index == s.lastIndexOf(c)) {
                res = (res == -1 || res > index) ? index : res;
            }
        }
        return res;
    }

    private int helper2(String s) {
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (arr[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

    private int helper1(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (Character c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}
