/**
 * Represents a sentence composed of {@code Word} and {@code PunctuationMark} objects.
 * A {@code Sentence} can be initialized with an array of objects or parsed from a
 * {@code StringBuffer}.
 *
 * <p>
 * The sentence intelligently separates words and punctuation marks from the input
 * and organizes them in the order they appear.
 * </p>
 */
public class Sentence {
    private Object[] value;

    /**
     * Constructs a {@code Sentence} object using the specified array of objects.
     * The array elements must be instances of {@code Word} or {@code PunctuationMark}.
     *
     * @param sentence an array of objects representing the sentence
     */
    public Sentence(Object[] sentence) {
        this.value = sentence;
    }

    /**
     * Constructs a {@code Sentence} object by parsing the provided {@code StringBuffer}.
     * Words are identified by contiguous sequences of valid letters, and punctuation
     * marks are extracted as individual elements.
     *
     * @param sb the {@code StringBuffer} containing the sentence to parse
     */
    public Sentence(StringBuffer sb) {
        StringBuffer current = new StringBuffer();
        int elementCount = 0;

        // Determine the number of elements (words and punctuation marks)
        for (int i = 0; i < sb.length(); i++) {
            char ch = sb.charAt(i);
            if (Letter.validate(ch)) {
                current.append(ch);
            }
            if (!Letter.validate(ch)) {
                if (current.length() > 0) {
                    elementCount++;
                    current.setLength(0);
                }
            }
            if (PunctuationMark.validate(ch)) {
                elementCount++;
            }
        }
        if (current.length() > 0) {
            elementCount++;
        }

        this.value = new Object[elementCount];
        current.setLength(0);
        int index = 0;

        // Populate the sentence array with Word and PunctuationMark objects
        for (int i = 0; i < sb.length(); i++) {
            char ch = sb.charAt(i);
            if (Letter.validate(ch)) {
                current.append(ch);
            }
            if (!Letter.validate(ch)) {
                if (current.length() > 0) {
                    this.value[index++] = new Word(new StringBuffer(current));
                    current.setLength(0);
                }
            }
            if (PunctuationMark.validate(ch)) {
                this.value[index++] = new PunctuationMark(new StringBuffer().append(ch));
            }
        }
        if (current.length() > 0) {
            this.value[index] = new Word(new StringBuffer(current));
        }
    }

    /**
     * Returns the array of {@code Word} and {@code PunctuationMark} objects that
     * make up this sentence.
     *
     * @return an array of objects representing the sentence
     */
    public Object[] getValue() {
        return this.value;
    }

    /**
     * Returns a string representation of this {@code Sentence}.
     * Words are separated by spaces, and punctuation marks are appended directly
     * to words or separated by a space, depending on their position.
     *
     * @return the string representation of the sentence
     */
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < this.value.length; i++) {
            if (this.value[i] instanceof Word) {
                sb.append(this.value[i].toString());
                if (i + 1 < this.value.length && this.value[i + 1] instanceof Word) {
                    sb.append(" ");
                }
            } else if (this.value[i] instanceof PunctuationMark) {
                sb.append(this.value[i].toString()).append(" ");
            }
        }
        return sb.toString().trim();
    }
}
