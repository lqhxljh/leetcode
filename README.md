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
#字符          数值
#I             1
#V             5
#X             10
#L             50
#C             100
#D             500
#M             1000
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
