class Solution {
    private String generateCommonString(String str) {
        int[] count = new int[26];
        for(char ch : str.toCharArray()) {
            count[ch - 'a']++;
        }
        StringBuilder newS = new StringBuilder();
        for(int i=0; i<26; i++) {
            if(count[i] > 0) {
                newS.append(String.valueOf((char) (i + 'a')).repeat(count[i]));
            }
        }
        return newS.toString();
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String str : strs) {
            String newS = generateCommonString(str);
            if(!map.containsKey(newS)) {
                map.put(newS, new ArrayList<>());
            }
            map.get(newS).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
