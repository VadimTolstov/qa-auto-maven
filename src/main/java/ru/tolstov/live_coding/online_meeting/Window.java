package ru.tolstov.live_coding.online_meeting;

/*
найти максимальную сумму масcива длиной K
пример [1,1,3,5,5,1] -> 13
пример [1,1,2,5,5,5] -> 15
если k < 1 -> ill
если k > array.length -> ill
 */
public class Window {
    public static int maxWindow(int[] array, int k) {
        if (k < 1 || k > array.length) {
            throw new IllegalArgumentException();
        }
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
            if (i >= k) {
                sum -= array[i - k];
            }
            if (i >= k - 1) {
                maxSum = Math.max(sum, maxSum);
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println(maxWindow(new int[]{-11, -2}, 2));
    }
}
