学习笔记

### DFS and BFS
#### DFS
[深度优先搜索](https://leetcode-cn.com/problems/permutations/solution/hui-su-suan-fa-python-dai-ma-java-dai-ma-by-liweiw/) 算法（英语：Depth-First-Search，DFS）是一种用于遍历或搜索树或图的算法。
这个算法会 尽可能深 的搜索树的分支。当结点 v 的所在边都己被探寻过，搜索将 回溯 到发现结点 v 的那条边的起始结点。
这一过程一直进行到已发现从源结点可达的所有结点为止。
如果还存在未被发现的结点，则选择其中一个作为源结点并重复以上过程，整个进程反复进行直到所有结点都被访问为止。
#### BFS
[广度（宽度）优先遍历](https://leetcode-cn.com/problems/binary-tree-level-order-traversal/solution/bfs-de-shi-yong-chang-jing-zong-jie-ceng-xu-bian-l/)：水波纹，如果想找 最短路径 or 层序遍历，一般就是BFS。
1. 利用队列实现；
2. 从源节点开始依次按照宽度进入队列，然后弹出；
3. 每弹出一个节点，把该节点所有没有进入过队列的邻接点放入队列（依赖set内元素唯一性来实现）；
4. 直到队列为空。
##### 代码模板
```java 
    public static void bfs(Node node) {
        if (node == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<Node>();
        HashSet<Node> visited = new HashSet<Node>();
        queue.add(node);
        visited.add(node);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            System.out.println(cur.value);
            for (Node next : cur.nexts) {
                if (!visited.contains(next)) {
                    visited.add(next);
                    queue.add(next);
                }
            }
        }
    }
```
##### 实战题目
1. [二叉树的层序遍历](https://leetcode-cn.com/problems/binary-tree-level-order-traversal/#/description) 2 times; 此题有[心得](https://leetcode-cn.com/problems/binary-tree-level-order-traversal/solution/dfshe-bfsdu-gei-ni-men-by-lan-tian-cang-hai-t/)
2. [最小基因变化](https://leetcode-cn.com/problems/minimum-genetic-mutation/#/description)  1 times；
3. [括号生成](https://leetcode-cn.com/problems/generate-parentheses/#/description) 3 times [心得](https://leetcode-cn.com/problems/generate-parentheses/solution/hui-su-suan-fa-by-liweiwei1419/)
4. [在每个树行中找最大值](https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row/#/description) 1 times
#### 课后作业
1. [单词接龙](https://leetcode-cn.com/problems/word-ladder/description/) 1 times
2. [单词接龙2](https://leetcode-cn.com/problems/word-ladder-ii/description/) 0 time
3. [岛屿数量](https://leetcode-cn.com/problems/number-of-islands/) 1 times
4. [扫雷游戏](https://leetcode-cn.com/problems/minesweeper/description/) 0 time

### 贪心
#### 课后作业
1. [柠檬水找零](https://leetcode-cn.com/problems/lemonade-change/description/) 2 times 
2. [买卖股票的最佳时机](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/description/) 2 times [股票问题汇集](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/solution/si-chong-shi-xian-xiang-xi-tu-jie-122-mai-mai-gu-p/)
3. [分发饼干](https://leetcode-cn.com/problems/assign-cookies/description/) 0 time
4. [模拟行走机器人](https://leetcode-cn.com/problems/walking-robot-simulation/description/) 1 times
5. [跳跃游戏](https://leetcode-cn.com/problems/jump-game/) 2 times
6. [跳跃游戏2](https://leetcode-cn.com/problems/jump-game-ii/) 0 time

### 二分查找的前提
1. 目标函数单调性（单调递增或者递减）
2. 存在上下界（bounded）
3. 能够通过索引访问（index accessible）

#### 代码模板
```java
left = 0, right = len(array) - 1
while left <= right
	mid = (left + right) / 2
	if array[mid] == target
		#find the target
		break or return result
	eles if array[mid] < target
		left = mid + 1
	else 
		right = mid - 1
```
### 做题心得：
1. 在图的算法中，如果想找最短路径，一般就是BFS（水波纹），为了避免循环，要使用visited[i]进行记录；
2. BFS代码中，一般要在按层次遍历的时候，把当前层的元素个数len记录下来，用for循环遍历len个数的当前层的元素；不做len记录不行，因为一般情况下，queue队列的长度是会发生变化的，因为我们是一遍遍历一遍进入队列；
3. 双向BFS

### Homework
#### 简单
1. [柠檬水找零](https://leetcode-cn.com/problems/lemonade-change/description/) 1 times
2. [买卖股票的最佳时机](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/description/) 1 times
3. [分发饼干](https://leetcode-cn.com/problems/assign-cookies/description/) 0 time
4. [模拟行走机器人](https://leetcode-cn.com/problems/walking-robot-simulation/description/) 1 times
#### 中等 
1. [单词接龙](https://leetcode-cn.com/problems/word-ladder/description/) 1 times
2. [岛屿数量](https://leetcode-cn.com/problems/number-of-islands/) 1 times
3. [扫雷游戏](https://leetcode-cn.com/problems/minesweeper/description/) 0 times
#### 困难
1. [单词接龙2](https://leetcode-cn.com/problems/word-ladder-ii/description/) 0 time