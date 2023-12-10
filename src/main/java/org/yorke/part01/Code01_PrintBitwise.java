package org.yorke.part01;

/**
 * @Author: Yorke
 * @Date: 2023/12/5 21:33
 *
 * 二进制位运算
 */
public class Code01_PrintBitwise {
    public static void main(String[] args) {
        //打印32位2进制
        //int num = 20231205;

        //int num = Integer.MAX_VALUE;
        int num = Integer.MIN_VALUE;

        System.out.println(num);
        print(num);

        //int a = -10086;
        //print(a);
        //// >> 带符号右移
        //print(a >> 1);
        //// >>> 不带符号右移
        //print(a >>> 1);
        //
        //print(a << 1);

        // 求相反数 取反+1
        //int a = -0;
        //print(a);
        //int b = ~ a + 1;
        //System.out.println(b);
        //print(b);

    }

    private static void print(int num) {
        for(int i = 31; i >= 0; i--) {
            System.out.print((num & (1 << i)) == 0 ? '0' : '1');
        }
        System.out.println();
    }


}
