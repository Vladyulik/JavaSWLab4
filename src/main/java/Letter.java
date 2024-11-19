/**
 * Represents a single letter and provides utilities for working with letters.
 * A Letter instance can be initialized with either a character or the first
 * character of a {@code StringBuffer}.
 */
public class Letter {
    private char value;

    /**
     * Constructs a {@code Letter} object with the specified character.
     *
     * @param ch the character to initialize the letter with
     */
    public Letter(char ch) {
        this.value = ch;
    }

    /**
     * Constructs a {@code Letter} object using the first character of
     * the given {@code StringBuffer}.
     *
     * @param sb the {@code StringBuffer} to extract the first character from
     */
    public Letter(StringBuffer sb) {
        this.value = sb.charAt(0);
    }

    /**
     * Returns the character value of this {@code Letter}.
     *
     * @return the character represented by this {@code Letter}
     */
    public char getValue() {
        return this.value;
    }

    /**
     * Determines if this {@code Letter} represents a vowel (case-insensitive).
     * Vowels are considered to be 'a', 'e', 'i', 'o', and 'u'.
     *
     * @return {@code true} if the letter is a vowel; {@code false} otherwise
     */
    public boolean isVowel() {
        char lowerCaseChar = Character.toLowerCase(this.value);
        return lowerCaseChar == 'a' ||
               lowerCaseChar == 'e' ||
               lowerCaseChar == 'i' ||
               lowerCaseChar == 'o' ||
               lowerCaseChar == 'u';
    }

    /**
     * Validates if the given character is a letter (either uppercase or lowercase).
     *
     * @param ch the character to validate
     * @return {@code true} if the character is a letter; {@code false} otherwise
     */
    public static boolean validate(char ch) {
        return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z');
    }

    /**
     * Returns a string representation of this {@code Letter}.
     *
     * @return the string representation of the character value
     */
    @Override
    public String toString() {
        return String.valueOf(this.value);
    }
}
