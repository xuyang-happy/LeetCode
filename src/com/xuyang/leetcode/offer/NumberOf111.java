package com.xuyang.leetcode.offer;

import java.util.Arrays;

/**
 * @author Li Xuyang
 * @date 2020/3/9 10:15
 * 二进制中1的个数
 */
public class NumberOf111 {

    //输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。


    /*
    如果一个整数不为0，那么这个整数至少有一位是1。如果我们把这个整数减1，那么原来处在整数最右边的1就会变为0，
    原来在1后面的所有的0都会变成1(如果最右边的1后面还有0的话)。其余所有位将不会受到影响。
    举个例子：一个二进制数1100，从右边数起第三位是处于最右边的一个1。减去1后，第三位变成0，它后面的两位0变成了1，而前面的1保持不变，
    因此得到的结果是1011.我们发现减1的结果是把最右边的一个1开始的所有位都取反了。
    这个时候如果我们再把原来的整数和减去1之后的结果做与运算，从原来整数最右边一个1那一位开始所有位都会变成0。
    如1100&1011=1000.也就是说，把一个整数减去1，再和原整数做与运算，会把该整数最右边一个1变成0.那么一个整数的二进制有多少个1，就可以进行多少次这样的操作。
     */
    public static int numberOf1(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n - 1);
            System.out.println(n);
            count++;

        }

        return count;


    }


    //暴力法，先把十进制转化为二进制，然后存入，然后查看有多少个1
    public static int numberOf12(int n) {

        int count = 0;

        //Integer.toBinaryString方法将十进制的数转化成二进制字符串，负数用的补码表示的
        String s = Integer.toBinaryString(n);

        //split 方法：将一个字符串分割为子字符串，然后将结果作为字符串数组返回。
        //传入双引号，应该就是每个字符分开
        String[] split = s.split("");
        System.out.println(Arrays.toString(split));

        for (int i = 0; i < split.length; i++) {

            if (split[i].equals("1")) {
                count++;
            }
        }


        return count;


    }

    public static void main(String[] args) {
        System.out.println(numberOf1(10));
        System.out.println(numberOf12(10));
    }
}
