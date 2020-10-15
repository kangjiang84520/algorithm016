/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2020. All rights reserved.
 */

package No105;

import java.util.HashMap;
import java.util.Map;

/**
 * 功能描述
 *
 * @since 2020-10-15
 */
public class BuildTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        if (preorder == null || inorder == null || preorder.length != inorder.length) {
            return null;
        }
        return buildTreeByRecursion(preorder, 0, preorder.length, inorder, 0, inorder.length, map);

    }

    private TreeNode buildTreeByRecursion(int[] preorder, int pStart, int pEnd, int[] inorder, int iStart, int iEnd,
        Map<Integer, Integer> map) {
        // terminator
        if (pStart == pEnd) {
            return null;
        }
        // current logic
        int rootVal = preorder[pStart];
        TreeNode root = new TreeNode(rootVal);
        // drill down
        int iRootIndex = map.get(rootVal);
        int leftNum = iRootIndex - iStart;
        root.left = buildTreeByRecursion(preorder, pStart + 1, pStart + 1 + leftNum, inorder, iStart, iRootIndex, map);
        root.right = buildTreeByRecursion(preorder, pStart + 1 + leftNum, pEnd, inorder, iRootIndex + 1, iEnd, map);
        return root;
        // revert if need

    }
}
