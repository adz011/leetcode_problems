package solutions;

public class _3875ConstructUniformParityArrayI {
    public boolean uniformArray(int[] nums1) {
        boolean containsOdd = false, containsEven = false;
        for (int x : nums1){
            if(x % 2 == 0){
                containsEven = true;
            }else containsOdd = true;
        }
        // if only of one them is true, our answer is just nums1
        // if both are true, we can convert all even values to odd, but not the other way around
        // (only if we have at least 2 odd numbers, we can convert to even only values, which we don't check)
        // if both are false, nums1.length == 0
        // on the other hand we can just return true, without iterating nums1
        return (containsOdd || containsEven);

    }
}
