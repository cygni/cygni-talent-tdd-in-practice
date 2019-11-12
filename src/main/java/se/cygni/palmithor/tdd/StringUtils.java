package se.cygni.palmithor.tdd;

public class StringUtils {

  public boolean isPalindrome(final String str) {
    if (str == null)
      return false;

    for (int i = 0; i < str.length(); i++) {
      char c = str.charAt(i);
      char opposite_c = str.charAt(str.length() - (i + 1));
      if (c != opposite_c) {
        return false;
      }
    }
    return true;
  }

  /**
   * Checks if a String is empty (""), null or whitespace only.
   * 
   * @param str the string to check
   *
   * @return true if str is null, empty or whitespace only, otherwise false
   */
  public boolean isBlank(final String str) {
    if (str == null || str.isEmpty())
      return true;
    return str.isBlank();
  }
}
