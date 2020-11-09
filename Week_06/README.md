学习笔记
#### 动态规划问题的两个着眼点
1. 问题的状态
2. 状态转移方程
#### 动态规划的关键点
1. 动态规划和递归 or 分治 没有根本上的区别（关键看有无最优子结构）
2. 共性： 找到重复子问题
3. 差异性： 最优子结构、中途可以淘汰次优解

```java
int fib(int n) {
	return n <= 1 ? n : fib(n-1) + fib(n-2);
}

// 
int fib(int n, int[] memo) {
	if (n <= 1) {
		return n;
	}
	if (memo[n] == 0) {
		memo[n] = fib(n-1) + fib(n-2);
	}
	return memo[n];
}

// BottomUp,递推
int fib(int n) {
	a[0] = 0, a[1] = 1;
	for (int i = 2; i <= n; i++) {
		a[i] = a[i-1] + a[i-2];
	}
}