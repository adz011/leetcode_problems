class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = 0, j = 0, l = 0;
        int length = nums1.length + nums2.length;
        boolean isEven = length % 2 == 0;
        if (isEven) {
            length = length / 2 - 1;
        } else length = length / 2;
        while (l < length) {
            if (i == nums1.length) {
                j++;
            } else if (j == nums2.length) {
                i++;
            } else {
                if (nums1[i] <= nums2[j]) {
                    i++;
                } else j++;
            }
            l++;
        }
        if (isEven) {
            double median = 0;
            for (int x = 0; x < 2; x++) {
                if (i == nums1.length) {
                    median = median + nums2[j];
                    j++;
                } else if (j == nums2.length) {
                    median = median + nums1[i];
                    i++;
                } else {
                    if (nums1[i] <= nums2[j]) {
                        median = median + nums1[i];
                        i++;
                    } else {
                        median = median + nums2[j];
                        j++;
                    }
                }
            }
            return median / 2;

        } else {
            if (i == nums1.length) {
                return nums2[j];
            } else if (j == nums2.length) {
                return nums1[i];
            } else {
                return Math.min(nums1[i], nums2[j]);
            }
        }

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
    }
}