/**
 * Represents a word as an array of {@code Letter} objects and provides methods
 * to work with words. A {@code Word} can be initialized with an array of
 * {@code Letter} objects or a {@code StringBuffer}.
 * Implements {@code Comparable} to allow comparison based on the count of vowels.
 */
public class Word implements Comparable<Word> {
    private Letter[] value;

    /**
     * Constructs a {@code Word} object with the specified array of {@code Letter} objects.
     *
     * @param word an array of {@code Letter} objects representing the word
     */
    public Word(Letter[] word) {
        this.value = word;
    }

    /**
     * Constructs a {@code Word} object using characters from the specified
     * {@code StringBuffer}. Each character in the {@code StringBuffer} is
     * converted to a {@code Letter} object.
     *
     * @param sb the {@code StringBuffer} whose characters form the {@code Word}
     */
    public Word(StringBuffer sb) {
        this.value = new Letter[sb.length()];
        for (int i = 0; i < sb.length(); i++) {
            this.value[i] = new Letter(new StringBuffer().append(sb.charAt(i)));
        }
    }

    /**
     * Returns the array of {@code Letter} objects that represents this {@code Word}.
     *
     * @return the array of {@code Letter} objects in this {@code Word}
     */
    public Letter[] getValue() {
        return this.value;
    }

    /**
     * Counts the number of vowels in this {@code Word}.
     *
     * @return the number of vowels in this {@code Word}
     */
    public int countVowels() {
        int total = 0;
        for (Letter letter : this.value) {
            if (letter.isVowel()) {
                total++;
            }
        }
        return total;
    }

    /**
     * Compares this {@code Word} with another {@code Word} based on the count
     * of vowels. Words with more vowels are considered greater.
     *
     * @param other the {@code Word} to be compared
     * @return a positive integer if this {@code Word} has more vowels than {@code other};
     *         a negative integer if it has fewer vowels; 0 if the vowel counts are equal
     */
    @Override
    public int compareTo(Word other) {
        if (this.countVowels() > other.countVowels()) { return 1; }
        if (this.countVowels() < other.countVowels()) { return -1; }
        return 0;
    }

    /**
     * Returns a string representation of this {@code Word}.
     *
     * @return the string formed by concatenating the string representations
     *         of each {@code Letter} in this {@code Word}
     */
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (Letter letter : this.value) {
            sb.append(letter.toString());
        }
        return sb.toString();
    }
}
