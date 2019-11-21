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


 #public boolean isPalindrome(int x) {
 #       if (x < 0) {
 #          return false;
 #       } else {
 #           int temp = x;
 #           int result = 0;
 #           while (temp > 0) {
 #               result = result + temp % 10;
 #               temp /= 10;
 #               if (temp > 0) {
 #                   result *= 10;
 #               }
 #           }
 #           if (result == x) {
 #                return true;
 #            } else {
 #                return false;
 #            }
 #        }
 #
 #    }
   
