学习笔记

原以为就是在[62](https://leetcode-cn.com/problems/unique-paths/)的递归公式里增加障碍物判断即可：
```java    
    if (grid[i][j] == 1) {
        dp[i][j] = 0;
    } else {
        dp[i][j] = dp[i-1][j] + dp[i][j-1];
    } 
```
所以第一版代码如下：
```java
private int byDp(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = 0;
        for (int i = 0; i < n; i++) { // A
            dp[0][i] = grid[0][i] == 0 ? 1 : 0;
        }
        for (int i = 0; i < m; i++) { // B
            dp[i][0] = grid[i][0] == 0 ? 1 : 0;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (grid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                } 
            }
        }
        return dp[m-1][n-1];
    }
```
结果[跪了](https://leetcode-cn.com/submissions/detail/124742630/)
看了题解，发现，在第一行和第一列里，如果存在一个障碍物，那么其后面和其下面的路，就被堵死了，也就是从障碍物之后和之下，dp值只能是0了；
所以，在AB两处对第一行和第一列的初始化，是错误的（错误之处就是：在第一行里，跨过障碍物之后，还继续给dp赋值为1，在第一列里，跨过障碍物之下，还继续给dp赋值为1！）
修改之后的代码如下：AA和BB处，一旦遇到障碍物，后面的dp值就是0了！（这里利用里java代码里，整型数组未显示初始化的默认值就是0）
```java
private int byDp(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 0) {
                dp[i][0] = 1;
            } else {
                break;  // AA
            }
        }
        for (int i = 0; i < n; i++) {
            if (grid[0][i] == 0) {
                dp[0][i] = 1;
            } else {
                break;  // BB
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (grid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                } 
            }
        }
        return dp[m-1][n-1];
    }
```
看题解，有更简洁的写法
```java
private int byDp(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m && grid[i][0] == 0; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n && grid[0][i] == 0; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (grid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                } 
            }
        }
        return dp[m-1][n-1];
    }
```
![image.png](https://pic.leetcode-cn.com/1603202135-hquuhw-image.png)

再补充一个压缩空间的解法
```java
private int byDp2(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] dp = new int[n+1];
        Arrays.fill(dp, 0);
        dp[1] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 1; j <= n; j++) {
                if (grid[i][j-1] == 0) {
                    dp[j] = dp[j] + dp[j-1];
                } else {
                    dp[j] = 0;
                }
            }
        }
        return dp[n];
    }
```
压缩的一维dp数组版代码，再优化（只申请长度n的数据，不再+1了）
```java
    private int byDp2(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] dp = new int[n];
        Arrays.fill(dp, 0);
        dp[0] = 1; // AA
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dp[j] = 0;
                } else if (j > 0){ // 完美避开第一列，确保AA处的初始化第一列值是1不会再循环中被冲掉
                    dp[j] = dp[j] + dp[j-1];
                }
            }
        }
        return dp[n-1];
    }
```
以上都是自顶向下的正序推导，现在转换思路，从右下角往左上角推导：
```java
private int byDpReverse(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int i = m - 1; i >= 0 && grid[i][n-1] == 0; i--) {
            dp[i][n-1] = 1;
        }
        for (int j = n-1; j >= 0 && grid[m-1][j] == 0; j--) {
            dp[m-1][j] = 1;
        }
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                if (grid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i+1][j] + dp[i][j+1];
                }
            }
        }
        return dp[0][0];
    }
```
一维空间压缩方法：
```java
private int byDp2Reverse(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] dp = new int[n];
        Arrays.fill(dp, 0);
        dp[n-1] = 1;
        for (int i = m -1; i >= 0; i--) {
            for (int j = n -1; j >= 0; j--) {
                if (grid[i][j] == 1) {
                    dp[j] = 0;
                } else if (j<n-1) {
                    dp[j] = dp[j] + dp[j+1];
                }
            }
        }
        return dp[0];
    }
```
