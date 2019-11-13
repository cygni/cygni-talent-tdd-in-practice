package se.cygni.palmithor.tdd;

public class StringUtils {


  public boolean isPalindrome(final String str) {
    if (str == null) {
      return false;
    }
    StringBuilder string = new StringBuilder(str);
    return string.reverse().toString().equals(str);
  }


  /**
   * Checks if a String is empty (""), null or whitespace only.
   *
   * @param str the string to check
   * @return true if str is null, empty or whitespace only, otherwise false
   */
  public boolean isBlank(final String str) {
    if (str == null ) {
      return true;
    }
    String trimmed = str.trim();
    return trimmed.equals("");
  }
}
