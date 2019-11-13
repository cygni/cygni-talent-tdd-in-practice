package se.cygni.palmithor.tdd;

public class StringUtils {


    public boolean isPalindrome(final String str) {
        if (null == str) {
            return false;
        }
        StringBuilder originalString = new StringBuilder(str);
        StringBuilder reversedString = originalString.reverse();
        return originalString.equals(reversedString);
    }


    /**
     * Checks if a String is empty (""), null or whitespace only.
     * @param str the string to check
     *
     * @return true if str is null, empty or whitespace only, otherwise false
     */
    public boolean isBlank(final String str) {
        if (null == str || str.isBlank()) {
            return true;
        }
        return false;
    }
}
