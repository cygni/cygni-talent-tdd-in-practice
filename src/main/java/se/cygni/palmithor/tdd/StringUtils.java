package se.cygni.palmithor.tdd;

public class StringUtils {


    public boolean isPalindrome(final String str) {
        if (str == null) {
            return false;
        }
        StringBuilder sb = new StringBuilder(str);
        sb.reverse();
        return str.equals(sb.toString());
        //throw new RuntimeException("Not yet implemented");
    }


    /**
     * Checks if a String is empty (""), null or whitespace only.
     *
     * @param str the string to check
     * @return true if str is null, empty or whitespace only, otherwise false
     */
    public boolean isBlank(final String str) {
        return str == null ||  str.trim().isEmpty();
    }
}
