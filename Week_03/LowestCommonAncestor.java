/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2020. All rights reserved.
 */

package No236;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 功能描述
 *
 * @since 2020-09-24
 */
public class LowestCommonAncestor {
    boolean find = false;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return lowestCommonAncestorByPostOrder(root, p, q);
    }

    private TreeNode lowestCommonAncestorByPostOrder(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestorByPostOrder(root.left, p, q);
        TreeNode right = lowestCommonAncestorByPostOrder(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right; // 这里隐含 left right 都为null的时候，返回null
    }

    private TreeNode lowestCommonAncestorByPreOrder(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        Deque<TreeNode> pPath = new ArrayDeque<>();
        Deque<TreeNode> qPath = new ArrayDeque<>();
        find = false;
        preOrder(root, p, pPath);
        find = false;
        preOrder(root, q, qPath);
        TreeNode res = null;
        for (int i = 0; i < Math.min(pPath.size(), qPath.size()); i++) {
            TreeNode ptmp = pPath.removeFirst();
            TreeNode qtmp = qPath.removeFirst();
            if (ptmp.val == qtmp.val) {
                res = ptmp;
            }
        }
        return res;
    }

    private void preOrder(TreeNode root, TreeNode p, Deque<TreeNode> pPath) {
        if (root == null || find) {
            return;
        }
        pPath.offerLast(root);
        if (root.val == p.val) {
            find = true;
            return;
        }
        preOrder(root.left, p, pPath);
        preOrder(root.right, p, pPath);
        if (!find) {
            pPath.removeLast();
        }
    }
}
