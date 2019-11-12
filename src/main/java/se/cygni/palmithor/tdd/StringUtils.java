package se.cygni.palmithor.tdd;

public class StringUtils {


    public boolean isPalindrome(final String str) {
        if (str == null) return false;

        var maxIndex = str.length();
        for (int i = 0; i < str.length(); i++) {
            maxIndex--;
            if (str.charAt(i) != str.charAt(maxIndex))
                return false;
        }
        return true;

        // (throw new RuntimeException("Not yet implemented");
    }


    /**
     * Checks if a String is empty (""), null or whitespace only.
     *
     * @param str the string to check
     * @return true if str is null, empty or whitespace only, otherwise false
     */
    public boolean isBlank(final String str) {
        if (str == null)
            return true;
        String s = str.strip();
        if (s.isEmpty())
            return true;
        return false;
    }
}
