package se.cygni.palmithor.tdd;

public class StringUtils {


    public boolean isPalindrome(final String str) {
        if(str == null) return false;
        StringBuilder sb = new StringBuilder(str);
        sb = sb.reverse();
        String sbStr = sb.toString();
        boolean isPalindrome = str.equals(sbStr);
        return isPalindrome;
    }


    /**
     * Checks if a String is empty (""), null or whitespace only.
     * @param str the string to check
     *
     * @return true if str is null, empty or whitespace only, otherwise false
     */
    public boolean isBlank(final String str) {
        if(str == null) return true;

        return str.trim().isEmpty();
    }
}
