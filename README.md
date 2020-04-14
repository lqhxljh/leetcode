# leetcode
Do the questions in leetCode every day, and study hard every day. Learning makes me progress, learning makes me happy to learn

#2019/11/20
 今天第一次上传，主要使记录leetcode刷题，为了自己梦想前进
# leetcode 09 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。

整体思路：
1、如果是负数直接返回false
2、如果是大于等于0的数
 1、获取最后一位 利用%10取余数
 2、将结果加上这个余数
 3、将该数除以10若概数大0 结果乘10继续循环

#
#leetcode 09
#罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
#<p>
#字符    数值
#I    1
#V    5
#X    10
#L    50
#C    100
#D    500
#M    1000
#例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
#<p>
#通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于
#大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
#<p>
#I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
#X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
#C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
#给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
#@param s
#@return

整体思路：
1、先将组合字符和单个字符枚举出来
2、每次取两个字符看是否存在枚举里面
 1、如果不存在就取单个字符值和结果自相加
 2、存在直接字符值和结果自相加
    
#
# 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
# 有效字符串需满足：
# 左括号必须用相同类型的右括号闭合。
# 左括号必须以正确的顺序闭合。
# 注意空字符串可被认为是有效字符串。
# 示例 1:
# 输入: "()"
# 输出: true
# 示例 2:
# 输入: "()[]{}"
# 输出: true
# 示例 3:
# 输入: "(]"
# 输出: false
# 示例 4:
# 输入: "([)]"
# 输出: false
# 示例 5:
# 输入: "{[]}"
# 输出: true
#

#整体思路：
##1、根据Stack属性先进后出
##2、碰到'{' 、'['  '(' 押入栈
##3、碰到'}' ']' ')'出栈如果不匹配就返回false
##4、最后判定栈是否为空

##
#2019/1/20


#验证回文字符串
#给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。

#说明：本题中，我们将空字符串定义为有效的回文串。
##
#2019/1/25
##外观数列
##「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。前五项如下：
##
##   1.  1
##   2.  11
##   3.  21
##   4.  1211
##   5.  111221
##   1 被读作  "one 1"  ("一个一") , 即 11。
##   11 被读作 "two 1s" ("两个一"）, 即 21。
##   21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
##
## 给定一个正整数 n（1 ≤ n ≤ 30），输出外观数列的第 n 项。
##
## 注意：整数序列中的每一项将表示为一个字符串。


##最长公共前缀
##编写一个函数来查找字符串数组中的最长公共前缀。

##如果不存在公共前缀，返回空字符串 ""。

##示例 1:

##输入: ["flower","flow","flight"]
##输出: "fl"
##示例 2:

##输入: ["dog","racecar","car"]
##输出: ""
##解释: 输入不存在公共前缀。


# 删除链表的倒数第N个节点
# 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。

# 示例：

# 给定一个链表: 1->2->3->4->5, 和 n = 2.

# 当删除了倒数第二个节点后，链表变为 1->2->3->5.
# 说明：

# 给定的 n 保证是有效的。


##2020 0131
# 验证二叉搜索树 isValidBST
# 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
#
# 假设一个二叉搜索树具有如下特征：
#
# 节点的左子树只包含小于当前节点的数。
# 节点的右子树只包含大于当前节点的数。
# 所有左子树和右子树自身必须也是二叉搜索树。

## 对称二叉树
# 给定一个二叉树，检查它是否是镜像对称的。

# 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。

    1
   / \
  2   2
 / \ / \
3  4 4  3
# 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:

    1
   / \
  2   2
   \   \
   3    3


 ##2020 0201
 
 
# 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
# <p>
# 说明:
# <p>
# 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
# 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
# 示例:
# <p>
# 输入:
# nums1 = [1,2,3,0,0,0], m = 3
# nums2 = [2,5,6],  n = 3
# <p>
# 输出: [1,2,2,3,5,6]


## 0218 ArraySolution 


#寻找数组的中心索引 
#给定一个整数类型的数组 nums，请编写一个能够返回数组“中心索引”的方法。

#我们是这样定义数组中心索引的：数组中心索引的左侧所有元素相加的和等于右侧所有元素相加的和。

#如果数组不存在中心索引，那么我们应该返回 -1。如果数组有多个中心索引，那么我们应该返回最靠近左边的那一个。

#示例 1:

#输入: 
#nums = [1, 7, 3, 6, 5, 6]
#输出: 3
#解释: 
#索引3 (nums[3] = 6) 的左侧数之和(1 + 7 + 3 = 11)，与右侧数之和(5 + 6 = 11)相等。
#同时, 3 也是第一个符合要求的中心索引。
#示例 2:

#输入: 
#nums = [1, 2, 3]
#输出: -1
#解释: 
#数组中不存在满足此条件的中心索引。
#说明:

#nums 的长度范围为 [0, 10000]。
#任何一个 nums[i] 将会是一个范围在 [-1000, 1000]的整数。


# 至少是其他数字两倍的最大数 dominantIndex
# 在一个给定的数组nums中，总是存在一个最大元素 。
# <p>
# 查找数组中的最大元素是否至少是数组中每个其他数字的两倍。
# <p>
# 如果是，则返回最大元素的索引，否则返回-1。
# <p>
# 示例 1:
# <p>
# 输入: nums = [3, 6, 1, 0]
# 输出: 1
# 解释: 6是最大的整数, 对于数组中的其他整数,
# 6大于数组中其他元素的两倍。6的索引是1, 所以我们返回1.
# <p>
# <p>
# 示例 2:
# <p>
# 输入: nums = [1, 2, 3, 4]
# 输出: -1
# 解释: 4没有超过3的两倍大, 所以我们返回 -1.
#/

#20200414
#给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
#
#示例 1:

#输入:
#11110
#11010
#11000
#00000
##
#输出: 1
#示例 2:

#输入:
#11000
#11000
#00100
#00011

###
解题思路：广度优先算法 QueueStackSolution numIslands