package se.cygni.palmithor.tdd;

public class StringUtils {


    public boolean isPalindrome(final String str) {
        if(str == null)
            return false;
        if(str.isEmpty() && str.isBlank())
            return true;

        String strCopy = new StringBuilder(str).reverse().toString();

        if(strCopy.equalsIgnoreCase(str))
            return true;
        return false;
/*


        boolean result = false;

        if (str == null) {
            result = false;
        }

        if (str.equals("")) result = false;

        return  result;*/
    }


    /**
     * Checks if a String is empty (""), null or whitespace only.
     * @param str the string to check
     *
     * @return true if str is null, empty or whitespace only, otherwise false
     */
    public boolean isBlank(final String str) {
        return str == null || str.isEmpty() || str.equals("") || str.trim().isEmpty();
    }
}
