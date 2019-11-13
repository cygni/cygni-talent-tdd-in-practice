package se.cygni.palmithor.tdd;

import java.sql.SQLOutput;

public class StringUtils {


    public boolean isPalindrome(final String str) {
        if(str == null){
            return false;
        }
        StringBuffer s = new StringBuffer(str);
        StringBuffer s2 = s.reverse();
        return s.equals(s2);
    }


    /**
     * Checks if a String is empty (""), null or whitespace only.
     * @param str the string to check
     *
     * @return true if str is null, empty or whitespace only, otherwise false
     */
    public boolean isBlank(final String str) {
        return (str == null || str.isEmpty() || (str.trim().equals("")));
    }
}
