class Solution {

    public String encode(List<String> strs) {
        StringBuilder encoded = new StringBuilder();
        for(String str : strs) {
            encoded.append(str.length()).append("#").append(str);
        }
        return encoded.toString();
    }

    public List<String> decode(String str) {
        List<String> decoded = new ArrayList<>();

        int i=0;

        while(i < str.length()) {
            int j = i;

            // Find the '#' separator
            while(str.charAt(j) != '#') {
                j++;
            }

            int length = Integer.parseInt(str.substring(i, j));  // Get the length
            j++;  // Move past '#'
            decoded.add(str.substring(j, j+length));
            i = j + length;
        }

        return decoded;
    }
}
