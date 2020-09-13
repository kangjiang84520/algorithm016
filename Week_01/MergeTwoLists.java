/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2020. All rights reserved.
 */

package No21;

/**
 * 功能描述
 *
 * @since 2020-09-11
 */
public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        return mergeTwoListsByRecursion(l1, l2);
    }

    private ListNode mergeTwoListsByRecursion(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 != null ? l1 : l2;
        } else if (l1.val <= l2.val) {
            l1.next = mergeTwoListsByRecursion(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoListsByRecursion(l1, l2.next);
            return l2;
        }
    }

    private ListNode mergeTwoListsByIter(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 != null ? l1 : l2;
        }
        ListNode res = new ListNode(0);
        ListNode cur = res;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 != null ? l1 : l2;
        return res.next;
    }
}