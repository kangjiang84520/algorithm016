学习笔记

# 递归
## 代码模板
1. terminator
2. deal with current logic
3. drill down
4. revert
需要特别注意的有两点：
1. terminator部分，需要注意是否需要new copy，以防止递归退出本层后，存储的引用部分内容丢失，判断条件就是看递归调用的层与层之间，
是靠每一层的临时变量还是靠递归调用之外的参数（此时一般是通过递归调用的参数传递）
2. drill down 部分，要注意参数的变化；