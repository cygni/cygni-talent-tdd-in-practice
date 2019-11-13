package se.cygni.palmithor.tdd;

import java.util.Arrays;

public class StringUtils {


    public boolean isPalindrome(final String str) {
        if (str == null) return false;
        var reverse = new StringBuilder(str).reverse().toString();
        return str.equalsIgnoreCase(reverse);
    }


    /**
     * Checks if a String is empty (""), null or whitespace only.
     * @param str the string to check
     *
     * @return true if str is null, empty or whitespace only, otherwise false
     */
    public boolean isBlank(final String str) {
        if (str == null) return true;
        return str.chars()
                .mapToObj(i -> (char) i)
                .allMatch(c -> c.equals(' '));
    }
}
