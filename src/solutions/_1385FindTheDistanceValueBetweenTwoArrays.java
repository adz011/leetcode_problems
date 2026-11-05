package solutions;

public class _1385FindTheDistanceValueBetweenTwoArrays {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int n1 = arr1.length, n2 = arr2.length;
        int sum = 0;
        for (int i = 0; i < n1; i++) {
            int curr1 = arr1[i];
            sum++;
            for (int j = 0; j < n2; j++) {
                if (Math.abs(curr1 - arr2[j]) <= d) {
                    sum--;
                    break;
                }
            }
        }
        return sum;
    }
}
