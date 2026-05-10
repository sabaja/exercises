package com.js.exercises.pattern;

public class SlidingWindows {


    static void main() {
        testMaximumSumOverRangesNaive();
    }

    private static void testMaximumSumOverRangesNaive() {
        int[] arr = {2, 1, 5, 1, 3, 2};
        IO.println("Naive result: " + maximumSumOverRangesNaive(arr, arr.length, 3));
    }

    public static int maximumSumOverRangesNaive(int[] arr, int len, int k) {
        int answer = Integer.MIN_VALUE + Integer.MAX_VALUE;
        int sum;
        k = checkMaxLenght(len, k);

        for (int l = 0; l < len - k; l++) {
            sum = 0;
            for (int i = l; i < l + k; i++) {
                sum += arr[i];
            }
            answer = Math.max(answer, sum);
        }
        return answer;

    }

    private static int checkMaxLenght(int len, int k) {
        return Math.min(k, len);
    }
}
