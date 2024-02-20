package org.yorke.part02;

/**
 * @Author: Yorke
 * @Date: 2023/12/10 19:05
 *
 * 有序数组，找出 >= num 的最左元素位置
 */
public class Code09_BSNearLeft {
    public static void main(String[] args) {
        int[] arr = {1,2,5,7,8,9,11,22,25};
        System.out.println(mostLeft(arr, 11));
    }

    //arr 有序，找出 >= num 的最左的元素位置
    public static int mostLeft(int[] arr, int num) {
        if(arr == null || arr.length == 0) {
            return -1;
        }

        int L = 0;
        int R = arr.length - 1;
        int ans = -1;
        while(L <= R) {
            int mid = (L + R) / 2;
            if(arr[mid] < num) {
                L = mid + 1;
            }else {
                R = mid - 1;
                ans = mid;
            }
        }
        return ans;
    }
}
