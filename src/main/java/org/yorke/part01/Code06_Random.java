package org.yorke.part01;

import java.util.Arrays;

/**
 * @Author: Yorke
 * @Date: 2023/12/10 9:06
 */
public class Code06_Random {
    public static void main(String[] args) {
        System.out.println("测试开始");
        // Math.random() -> double -> [0-1) 随机，且等概率
        int testTimes = 10000000;
        int count = 0;
        for(int i = 0; i < testTimes; i++) {
            if(Math.random() < 0.75){
                count ++;
            }
        }
        System.out.println((double) count / (double) testTimes);

        System.out.println("===============");

        // [0,1) * 8 = [0,8) 随机，且等概率
        count = 0;
        for(int i = 0; i < testTimes; i++) {
            if(Math.random() * 8 < 4){
                count ++;
            }
        }
        System.out.println((double) count / (double) testTimes);

        System.out.println("===============");

        int K = 9;
        int counts[] = new int[9];
        // [0,K) -> [0, K-1]
        for(int i = 0; i < testTimes; i++) {
            int ans = (int)(Math.random() * K);
            counts[ans] ++;
        }

        System.out.println(Arrays.toString(counts));

        System.out.println("====================");

        count = 0;
        double x = 0.8;
        for(int i = 0; i < testTimes; i++) {
            if(xToXPower3() < x){
                count++;
            }
        }
        System.out.println((double) count / (double) testTimes);
        System.out.println(Math.pow(x,3));

        System.out.println("====================");
        count = 0;
        for(int i = 0; i < testTimes; i++) {
            if(f2() == 0) {
                count++;
            }
        }
        System.out.println((double) count / (double) testTimes);

        System.out.println("====================");

        counts = new int[8];
        for(int i = 0; i < testTimes; i++) {
            counts[f3()] ++;
        }
        System.out.println(Arrays.toString(counts));

        System.out.println("====================");

        counts = new int[8];
        for(int i = 0; i < testTimes; i++) {
            counts[f4()] ++;
        }
        System.out.println(Arrays.toString(counts));

    }

    // 返回[0,1)的一个小数
    // 任意的x，x属于[0,1),[0,x)范围上的数出现概率由原来的x调整成x平方
    // 例如：xToXPower2 < 0.5 时，只有Math.max(a,b) 中，a,b 都<0.5才成立，故概率为0.5 * 0.5 = 0.5^2
    public static double xToXPower2() {
        return Math.max(Math.random(), Math.random());
    }

    // x 3次方
    public static double xToXPower3() {
        return Math.max(Math.random(), Math.max(Math.random(), Math.random()));
    }

    // 假设f()为lib中的函数不可变，功能：返回1,2,3,4,5中的一个，且等概率
    public static int f() {
        return (int)(Math.random() * 5) + 1;
    }

    //构造f2() 0,1发生器，目标等概率返回0或1
    public static int f2() {
        int ans = 0;
        do{
            ans = f();
        }while(ans == 3);
        return ans < 3 ? 0 : 1;
    }

    //构造f3(), 目标000-111等概率, 即0~7等概率返回
    public static int f3() {
        return (f2() << 2) + (f2() << 1) + f2();
    }

    //构造f4(), 目标0~6等概率返回
    public static int f4() {
        int ans = 0;

        do{
            ans = (f2() << 2) + (f2() << 1) + f2();
        }while(ans == 7);
        return ans;
    }

    // 假设g() 为 lib函数，不可变，只会返回0，1, 但0，1不等概率
    public static int g() {
        return Math.random() < 0.84 ? 0 : 1;
    }

    // 构造g2(), 目标：等概率返回0，1
    public static int g1() {
        int ans = 0;
        do {
            ans = g();
        }while(ans == g()); // 如果第二次随机值与第一次随机值不同，则返回，否则重随（优雅）
        return ans;
    }
}
