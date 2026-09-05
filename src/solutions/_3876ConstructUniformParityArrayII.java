package solutions;

public class _3876ConstructUniformParityArrayII {
    public boolean uniformArray(int[] nums1) {
        int so = Integer.MAX_VALUE, se = Integer.MAX_VALUE;
        for (int x : nums1) {
            if (x % 2 == 0) {
                se = Math.min(se, x);
            } else so = Math.min(so, x);
        }
        int smallest = Math.min(so ,se);
        if(smallest % 2 ==1)return true;
        return so == Integer.MAX_VALUE;
    }
}
