/**
 * Represents a punctuation mark and provides utilities for validating and working
 * with punctuation marks. A {@code PunctuationMark} can be initialized with a
 * character or the first character of a {@code StringBuffer}.
 */
public class PunctuationMark {
    private char value;

    /**
     * Constructs a {@code PunctuationMark} object with the specified character.
     *
     * @param mark the character to initialize the punctuation mark with
     */
    public PunctuationMark(char mark) {
        this.value = mark;
    }

    /**
     * Constructs a {@code PunctuationMark} object using the first character of
     * the given {@code StringBuffer}.
     *
     * @param sb the {@code StringBuffer} to extract the first character from
     */
    public PunctuationMark(StringBuffer sb) {
        this.value = sb.charAt(0);
    }

    /**
     * Returns the character value of this {@code PunctuationMark}.
     *
     * @return the character represented by this {@code PunctuationMark}
     */
    public char getValue() {
        return this.value;
    }

    /**
     * Validates if the given character is a recognized punctuation mark.
     * Supported punctuation marks are '.', ',', '?', and '!'.
     *
     * @param ch the character to validate
     * @return {@code true} if the character is a punctuation mark;
     *         {@code false} otherwise
     */
    public static boolean validate(char ch) {
        return ch == '.' ||
               ch == ',' ||
               ch == '?' ||
               ch == '!';
    }

    /**
     * Returns a string representation of this {@code PunctuationMark}.
     *
     * @return the string representation of the character value
     */
    @Override
    public String toString() {
        return String.valueOf(this.value);
    }
}
