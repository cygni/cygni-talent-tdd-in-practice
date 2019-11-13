package se.cygni.palmithor.tdd;

public class StringUtils {


    public boolean isPalindrome(final String str) {

        if(str == null)  {
            return false;
        }


        for(int leftIndex = 0; leftIndex != str.length() / 2; leftIndex++){

            int rightIndex = str.length() - 1 - leftIndex;

            if(str.charAt(leftIndex) != str.charAt(rightIndex)){
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

        if(str == null){
            return true;
        }

        return str.trim().isEmpty();


    }
}
