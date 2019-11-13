package se.cygni.palmithor.tdd;

public class StringUtils {


    public boolean isPalindrome(final String str) {
        if (str == null) return false;
        
        if (str.isEmpty()) {
            return true;
        }
        for(int i=0; i < str.length()/2; ++i) {
            if (str.charAt(i) != str.charAt(str.length()-1-i)) {
                return false;
                //git
            }
        }
        return true;
    }


    /**
     * Checks if a String is empty (""), null or whitespace only.
     * @param str the string to check
     *
     * @return true if str is null, empty or whitespace only, otherwise false
     */
    public boolean isBlank(final String str) {
        if (str == null || str.trim().isEmpty()) return true;

        return false;
    }
}
