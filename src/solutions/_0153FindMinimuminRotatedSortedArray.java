package solutions;

public class _0153FindMinimuminRotatedSortedArray {
    static public int findMin(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        int left = 0, right = n -1;
        if(nums[left] < nums[right]) return nums[left];

        while(left < right){
            int middle = (right + left) / 2;
            if(nums[middle] > nums[left]) left = middle;
            else right = middle;
        }
        return nums[left+1];
    }
}
