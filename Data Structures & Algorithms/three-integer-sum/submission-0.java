class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        Arrays.sort(nums);

        for (int k = 0; k < nums.length - 2; k++) {
            if (k > 0 && nums[k] == nums[k - 1]) continue; // skip duplicate a

            int a = nums[k];
            int i = k + 1, j = nums.length - 1;

            while (i < j) {
                int b = nums[i], c = nums[j];
                int sum = a + b + c;

                if (sum == 0) {
                    answer.add(List.of(a, b, c));
                    i++;
                    j--;

                    // skip duplicate b and c
                    while (i < j && nums[i] == nums[i - 1]) i++;
                    while (i < j && nums[j] == nums[j + 1]) j--;

                } else if (sum < 0) {
                    i++;
                } else {
                    j--;
                }
            }
        }
        return answer;
    }
}
