学习笔记

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
###做题心得：
1. 在图的算法中，如果想找最短路径，一般就是BFS（水波纹），为了避免循环，要使用visited[i]进行记录；
2. BFS代码中，一般要在按层次遍历的时候，把当前层的元素个数len记录下来，用for循环遍历len个数的当前层的元素；不做len记录不行，因为一般情况下，queue队列的长度是会发生变化的，因为我们是一遍遍历一遍进入队列；
3. 双向BFS

### Homework
####简单
1. [柠檬水找零](https://leetcode-cn.com/problems/lemonade-change/description/) 1 times
2. [买卖股票的最佳时机](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/description/) 1 times
3. [分发饼干](https://leetcode-cn.com/problems/assign-cookies/description/) 0 time
4. [模拟行走机器人](https://leetcode-cn.com/problems/walking-robot-simulation/description/) 1 times
####中等 
1. [单词接龙](https://leetcode-cn.com/problems/word-ladder/description/) 1 times
2. [岛屿数量](https://leetcode-cn.com/problems/number-of-islands/) 1 times
3. [扫雷游戏](https://leetcode-cn.com/problems/minesweeper/description/) 0 times
####困难
1. [单词接龙2](https://leetcode-cn.com/problems/word-ladder-ii/description/) 0 time