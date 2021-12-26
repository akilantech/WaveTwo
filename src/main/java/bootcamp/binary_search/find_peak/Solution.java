package bootcamp.binary_search.find_peak;

public class Solution {
    public static void main(String[] args) {
        //System.out.println(new Solution().findPeakElement(new int[]{0, 1, 2, 3, 4, 5,6,4, 2,1,0,-1}));

        System.out.println(new Solution().findPeakElement(new int[]{0, 1, 5, 4, 3,1,0,-1,-2,-3,-4}));

    }

    public int findPeakElement(int[] nums) {
        int lo = 0;
        int hi = nums.length;

        while (lo < hi) {

            int mid = lo + (hi - lo) / 2;
            System.out.printf("lo: %s hi: %s mid: %s",lo,hi,mid);
            System.out.println();
            if (nums[mid] > nums[mid + 1]){
                hi = mid;
            }else{
                lo = mid + 1;
                //move lo till it reaches the peak
            }

        }
        return lo;
    }
}
