/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2020. All rights reserved.
 */

package No347;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 功能描述 :
 *
 * @since 2020-09-17
 */
public class TopKFrequent {
    private class Node {
        public int val;
        public int len;

        Node(int val, int len) {
            this.val = val;
            this.len = len;
        }
    }

    public static void main(String[] args) {
        TopKFrequent top = new TopKFrequent();
        int[] nums = {1, 1, 1, 2, 2, 3};
        System.out.println(Arrays.toString(top.topKFrequent(nums, 2)));
    }

    public int[] topKFrequent(int[] nums, int k) {
        return topKFrequentBySmallHeap(nums, k);
    }

    public int[] topKFrequentByBigHeap(int[] nums, int k) {
        int[] res = new int[k];
        PriorityQueue<Node> queue = new PriorityQueue<>(k, (o1, o2) -> o2.len - o1.len);
        // key:element; value:frequent
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        for (Integer key : map.keySet()) {
            Node node = new Node(key, map.get(key));
            queue.add(node);
        }
        for (int i = 0; i < k; i++) {
            res[i] = queue.poll().val;
        }
        return res;
    }

    public int[] topKFrequentBySmallHeap(int[] nums, int k) {
        int[] res = new int[k];
        PriorityQueue<Node> queue = new PriorityQueue<>(k, Comparator.comparingInt(o -> o.len));
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        for (Integer key : map.keySet()) {
            if (queue.size() < k) {
                Node node = new Node(key, map.get(key));
                queue.add(node);
            } else if (map.get(key) > queue.peek().len) {
                queue.remove();
                Node node = new Node(key, map.get(key));
                queue.add(node);
            }
        }
        int index = 0;
        while (!queue.isEmpty()) {
            res[index++] = queue.poll().val;
        }

        return res;
    }
}
