学习笔记

# 递归
## 代码模板
1. terminator
2. deal with current logic
3. drill down
4. reverse the current level status if needed
需要特别注意的有两点：
1. terminator部分，需要注意是否需要new copy，以防止递归退出本层后，存储的引用部分内容丢失，判断条件就是看递归调用的层与层之间，
是靠每一层的临时变量还是靠递归调用之外的参数（此时一般是通过递归调用的参数传递）
2. drill down 部分，要注意参数的变化；

#### 要刻意训练递归思维，不要人肉递归；
#### 很多时候，手工模拟计算前1~3步，会对递归有帮助；
#### 不要忘记递归终止条件
#### 在递归过程中，可以根据条件，进行剪枝（主动放弃一些递归进入的路径）
#### 树的题目，一般考虑递归写法
#### 要避免傻递归，使用记忆会递归；

### 泛型递归和树的递归
#### 典型题目
1. [爬楼梯](https://leetcode-cn.com/problems/climbing-stairs/)  2 times
2. [括号的生成](https://leetcode-cn.com/problems/generate-parentheses/) 2 times 
3. [翻转二叉树](https://leetcode-cn.com/problems/invert-binary-tree/description/) 1 time
4. [验证二叉搜索树](https://leetcode-cn.com/problems/validate-binary-search-tree)  1 time
5. [二叉树的最大深度](https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/) 2 times
6. [二叉树的最小深度](https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/) 0 time
7. [二叉树的序列化与反序列化](https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/) 0 time

#### 课后作业
1. [二叉树的最近公共祖先](https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/) 2 times
2. [从前序与中序遍历序列构造二叉树](https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/) 0 time
3. [组合](https://leetcode-cn.com/problems/combinations/) 0 time
4. [全排列-无重复数字](https://leetcode-cn.com/problems/permutations/) 3 times
5. [全排列-有重复数字](https://leetcode-cn.com/problems/permutations-ii/) 2 times

### 分治和回溯
#### 典型题目
1. [Pow](https://leetcode-cn.com/problems/powx-n/) 0 time
2. [子集](https://leetcode-cn.com/problems/subsets/) 0 time
3. [多数元素](https://leetcode-cn.com/problems/majority-element/description/) 1 time
4. [求众数2](https://leetcode-cn.com/problems/majority-element-ii/) 1 time
5. [电话号码的字母组合](https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/) 0 time
6. [N皇后](https://leetcode-cn.com/problems/n-queens/) 0 time
