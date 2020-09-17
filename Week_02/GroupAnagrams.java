/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2020. All rights reserved.
 */

package No49;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 功能描述
 *
 * @since 2020-09-14
 */
public class GroupAnagrams {
    public static void main(String[] args) {
        GroupAnagrams g = new GroupAnagrams();
        // String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        // String[] strs = {"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"};
        String[] strs = {"tin", "ram", "zip", "cry", "pus", "jon", "zip", "pyx"};
        List<List<String>> res = g.groupAnagrams(strs);
        System.out.println(Arrays.toString(res.toArray()));
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        return groupAnagramsWithPrime(strs);
    }

    /**
     * 暴力解法+used数组优化
     * <p>
     * 比较通用的解法，不管字符串里边是大写字母，小写字母，数字，都可以用这个算法解决
     */
    private List<List<String>> groupAnagramsWithUsed(String[] strs) {
        if (strs == null) {
            return null;
        }
        List<List<String>> res = new ArrayList<>();
        boolean[] used = new boolean[strs.length];
        for (int i = 0; i < strs.length; i++) {
            List<String> element = new ArrayList<>();
            if (!used[i]) {
                element.add(strs[i]);
                used[i] = true;
                for (int j = i + 1; j < strs.length; j++) {
                    if ((!used[j]) && isAnagram(strs[i], strs[j])) {
                        element.add(strs[j]);
                        used[j] = true;
                    }
                }
                res.add(element);
            }
        }
        return res;
    }

    private boolean isAnagram(String s, String t) {
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

    /**
     * 题目告诉我们字符串中只有小写字母，针对这个限制，我们可以再用一些针对性强的算法
     * <p>
     * 下边的算法本质是，我们只要把一类的字符串用某一种方法唯一的映射到同一个位置就可以
     */
    private List<List<String>> groupAnagramsWithHash(String[] strs) {
        if (strs == null) {
            return null;
        }

        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] tmp = str.toCharArray();
            Arrays.sort(tmp);
            String keyStr = new String(tmp);
            if (!map.containsKey(keyStr)) {
                List<String> element = new ArrayList<>();
                element.add(str);
                map.put(keyStr, element);
            } else {
                map.get(keyStr).add(str);
            }
        }
        return new ArrayList<>(map.values());
    }

    /**
     * 算术基本定理，又称为正整数的唯一分解定理，即：每个大于1的自然数，要么本身就是质数，要么可以写为2个以上的质数的积，
     * <p>
     * 而且这些质因子按大小排列之后，写法仅有一种方式。
     * <p>
     * 作者：windliang
     * 链接：https://leetcode-cn.com/problems/group-anagrams/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by--16/
     * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    private List<List<String>> groupAnagramsWithPrime(String[] strs) {
        if (strs == null) {
            return null;
        }
        int[] prims =
            {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};
        Map<Long, List<String>> map = new HashMap<>();
        for (String str : strs) {
            long key = 1;
            for (int i = 0; i < str.length(); i++) {
                key *= prims[str.charAt(i) - 'a'];
            }
            if (map.containsKey(key)) {
                map.get(key).add(str);
            } else {
                List<String> element = new ArrayList<>();
                element.add(str);
                map.put(key, element);
            }
        }
        return new ArrayList<>(map.values());
    }
}
