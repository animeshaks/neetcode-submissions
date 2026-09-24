class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        if(n == k) {
            return nums;
        }

        // Get count of each number
        Map<Integer, Integer> counts = new HashMap<>();
        for(int num : nums) {
            counts.put(num, counts.getOrDefault(num, 0)+1);
        }

        // Create frequency array (List<Integer>)
        List<Integer>[] frequencies = new ArrayList[n+1];
        for(int num : counts.keySet()) {
            int count = counts.get(num);
            if(frequencies[count] == null) {
                frequencies[count] = new ArrayList<>();
            }
            frequencies[count].add(num);
        }

        List<Integer> result = new ArrayList<>();
        for(int i=frequencies.length-1; i>0; i--) {
            if(frequencies[i] != null) {
                result.addAll(frequencies[i]);
                if(result.size() == k) {
                    break;
                }
            }
        }

        int[] topK = new int[k];
        for(int i=0; i<k; i++) {
            topK[i] = result.get(i);
        }

        return topK;
    }
}