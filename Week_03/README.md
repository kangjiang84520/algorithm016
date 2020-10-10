学习笔记

# 递归
## 代码模板
1. terminator
2. deal with current logic
3. drill down
4. reverse the current level status if needed
需要特别注意的有三点：
1. terminator部分，需要注意是否需要new copy，以防止递归退出本层后，存储的引用部分内容丢失，判断条件就是看递归调用的层与层之间，
是靠每一层的临时变量还是靠递归调用之外的参数（此时一般是通过递归调用的参数传递）
2. drill down 部分，要注意参数的变化；
3. 2、3、4会出现在循环中，比如求[组合77](https://leetcode-cn.com/problems/combinations/)、[全排列-无重复数字46](https://leetcode-cn.com/problems/permutations/) 、[全排列-有重复数字47](https://leetcode-cn.com/problems/permutations-ii/)

#### 要刻意训练递归思维，不要人肉递归；
#### 很多时候，手工模拟计算前1~3步，会对递归有帮助；
#### 不要忘记递归终止条件
#### 在递归过程中，可以根据条件，进行剪枝（主动放弃一些递归进入的路径）
#### 树的题目，一般考虑递归写法
#### 要避免傻递归，使用记忆会递归；

### 泛型递归和树的递归
#### 典型题目
1. [爬楼梯70](https://leetcode-cn.com/problems/climbing-stairs/)  2 times
2. [括号的生成22](https://leetcode-cn.com/problems/generate-parentheses/) 2 times 
3. [翻转二叉树226](https://leetcode-cn.com/problems/invert-binary-tree/description/) 1 time
4. [验证二叉搜索树98](https://leetcode-cn.com/problems/validate-binary-search-tree/)  1 time
5. [二叉树的最大深度104](https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/) 2 times
6. [二叉树的最小深度111](https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/) 0 time
7. [二叉树的序列化与反序列化297](https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/) 0 time

#### 课后作业
1. [二叉树的最近公共祖先236](https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/) 2 times
2. [从前序与中序遍历序列构造二叉树105](https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/) 0 time
3. [组合77](https://leetcode-cn.com/problems/combinations/) 1 time
4. [全排列-无重复数字46](https://leetcode-cn.com/problems/permutations/) 4 times
5. [全排列-有重复数字47](https://leetcode-cn.com/problems/permutations-ii/) 2 times

### 分治和回溯
#### 典型题目
1. [Pow](https://leetcode-cn.com/problems/powx-n/) 0 time
2. [子集](https://leetcode-cn.com/problems/subsets/) 2 time
3. [多数元素](https://leetcode-cn.com/problems/majority-element/description/) 1 time
4. [求众数2](https://leetcode-cn.com/problems/majority-element-ii/) 1 time
5. [电话号码的字母组合](https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/) 0 time
6. [N皇后](https://leetcode-cn.com/problems/n-queens/) 0 time

#### 做题的心得
1. 组合问题，相对于排列问题而言，不计较一个组合内元素的顺序性（即 [1, 2, 3] 与 [1, 3, 2] 认为是同一个组合），因此很多时候需要按某种顺序展开搜索，这样才能做到不重不漏；
2. 子集问题，相对于组合、排列，递归和回溯 不在for循环中，递归的终止条件也不一样，原因是。。。
3. 组合，在递归前后，就是简单的选择与不选择； 排列，要在组合的选与不选中，还要加上选过和没选过的判断。
```java
    // Subsets
private void helper1(int[] nums, int start, int len, List<Integer> ele, List<List<Integer>> resList) {
        if (start == nums.length) {
            resList.add(new ArrayList<>(ele));
            return;
        }
        // for (int i = start; i < len; i++) {
        // select it
        ele.add(nums[start]);
        helper1(nums, start + 1, len, ele, resList);
        // dont select it
        ele.remove(ele.size() - 1);
        helper1(nums, start + 1, len, ele, resList);
        // }
    }
	
	// Combine 组合
	private void helper1(int n, int k, int begin, List<Integer> ele, List<List<Integer>> resList) {
        // terminator
        if (k == ele.size()) {
            resList.add(new ArrayList<>(ele));
            return;
        }
        // 优化点，剪枝：搜索起点的上界 + 接下来要选择的元素个数 - 1 = n
        // for (int i = begin; i <= (n - (k - ele.size()) + 1); i++)
        for (int i = begin; i <= n; i++) {
            // deal with current logic
            ele.add(i);
            // drill down
            helper1(n, k, i + 1, ele, resList);
            // reverse if need
            ele.remove(ele.size() - 1);
        }
    }
	
	// Permute 排列 
	private void helper(int[] nums, Deque<Integer> ele, boolean[] visited, List<List<Integer>> resList) {
        // 叶子节点处：变量 path 所指向的列表 在深度优先遍历的过程中只有一份 ，深度优先遍历完成以后，回到了根结点，成为空列表。
        // 在 Java 中，参数传递是 值传递，对象类型变量在传参的过程中，复制的是变量的地址。这些地址被添加到 res 变量，但实际上指向的是同一块内存地址，
        // 因此我们会看到 6 个空的列表对象。解决的方法很简单，在 res.add(path); 这里做一次拷贝即可。
        if (nums.length == ele.size()) {
            resList.add(new ArrayList<>(ele));
        }
        // 在非叶子结点处，产生不同的分支，这一操作的语义是：在还未选择的数中依次选择一个元素作为下一个位置的元素，这显然得通过一个循环实现。
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            } else {
                visited[i] = true;
                ele.push(nums[i]);
                helper(nums, ele, visited, resList);
                // 注意：下面这两行代码发生 「回溯」，回溯发生在从 深层结点 回到 浅层结点 的过程，代码在形式上和递归之前是对称的
                visited[i] = false;
                ele.pop();
            }
        }
    }
```


