package se.cygni.palmithor.tdd;

public class StringUtils {


    public boolean isPalindrome(final String str) {
        if (str == null) {
            return false;
        }

        int strLength = str.length();
        for (int i = 0; i < strLength / 2; i++) {
            if (str.charAt(i) != str.charAt(strLength-i-1)) {
                return false;
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
        if (str == null) {
            return true;
        }

        String emptified = str.replaceAll("\\s", "");
        return emptified.equals("");
    }
}
