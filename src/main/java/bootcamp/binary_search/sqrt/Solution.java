package bootcamp.binary_search.sqrt;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().mySqrt(64));
    }

    public int mySqrt(int x) {

        if (x < 2) return x;

        int left = 2;
        int right = x / 2;
        //long num; int pivot;
        while (left <= right) {
            int pivot = left + (right - left) / 2;
            System.out.println(String.format("left:%s right:%s pivot:%s", left, right, pivot));
            long num = (long) pivot * pivot;
            if (num > x) {
                right = pivot - 1;
            } else if (num < x) {
                left = pivot + 1;
            } else {
                return pivot;
            }

        }

        return right;

    }
}
