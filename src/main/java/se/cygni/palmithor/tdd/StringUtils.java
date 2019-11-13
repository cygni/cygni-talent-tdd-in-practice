package se.cygni.palmithor.tdd;

public class StringUtils {


    public boolean isPalindrome(final String str) {
        if(str == null) {
            return false;
        }

        for(int i1 = 0; i1 != str.length() /2; i1++) {

            int i2 = str.length() -1 - i1;
            
            if(str.charAt(i1) != str.charAt(i2)){
                return false;
            }
        }

        return true;

        //throw new RuntimeException("Not yet implemented");
    }


    /**
     * Checks if a String is empty (""), null or whitespace only.
     * @param str the string to check
     *
     * @return true if str is null, empty or whitespace only, otherwise false
     */
    public boolean isBlank(final String str) {
        return str == null || str == "" || str.trim().isEmpty();

    }
}
