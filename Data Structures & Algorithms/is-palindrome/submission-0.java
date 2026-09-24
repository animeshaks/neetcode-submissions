class Solution {

    private boolean isAlphaNumeric(char ch) {
        return (Character.isAlphabetic(ch) || Character.isDigit(ch));
    }

    public boolean isPalindrome(String s) {
        int n = s.length();
        s = s.toLowerCase();

        int i=0, j=n-1;
        while(i < j) {
            char chA = s.charAt(i);
            char chB = s.charAt(j);

            if(!isAlphaNumeric(chA)) {
                i++;
            } else if(!isAlphaNumeric(chB)) {
                j--;
            } else {
                if(chA != chB) {
                    return false;
                } 
                i++;
                j--;
            }
        }

        return true;
    }
}
