package org.yorke.part02;

/**
 * @Author: Yorke
 * @Date: 2023/12/10 18:56
 *
 * 二分查找： 有序数组中找到 num
 */
public class Code08_BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1,2,5,7,8,9,11,22,25};
        System.out.println(find(arr, 11));
    }

    // arr保证有序
    public static boolean find(int[] arr, int num) {
        if(arr == null || arr.length == 0) {
            return false;
        }
        int L = 0;
        int R = arr.length - 1;
        // arr[0...N-1] num  arr[L,R] num
        while(L <= R) {
            int mid = (L + R) / 2;
            if(arr[mid] == num) {
                return true;
            }else if(arr[mid] < num) {
                L = mid + 1;
            }else {
                R = mid - 1;
            }
        }
        return false;
    }
}
