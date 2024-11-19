/**
 * Represents a paragraph as an array of {@code Sentence} objects.
 * A {@code Paragraph} can be initialized with an array of {@code Sentence} objects
 * or parsed from a {@code StringBuffer}.
 *
 * <p>
 * The paragraph separates and organizes sentences based on sentence-ending
 * punctuation marks such as '.', '!', and '?'.
 * </p>
 */
public class Paragraph {
    private Sentence[] value;

    /**
     * Constructs a {@code Paragraph} object using the specified array of {@code Sentence} objects.
     *
     * @param paragraph an array of {@code Sentence} objects representing the paragraph
     */
    public Paragraph(Sentence[] paragraph) {
        this.value = paragraph;
    }

    /**
     * Constructs a {@code Paragraph} object by parsing the provided {@code StringBuffer}.
     * Sentences are identified and separated based on the sentence-ending punctuation
     * marks '.', '!', and '?'.
     *
     * @param sb the {@code StringBuffer} containing the paragraph to parse
     */
    public Paragraph(StringBuffer sb) {
        StringBuffer current = new StringBuffer();
        int sentenceCount = 0;

        // Determine the number of sentences
        for (int i = 0; i < sb.length(); i++) {
            char ch = sb.charAt(i);
            current.append(ch);
            if (ch == '.' || ch == '!' || ch == '?') {
                sentenceCount++;
                current.setLength(0);
            }
        }
        if (current.length() > 0) {
            sentenceCount++;
        }

        this.value = new Sentence[sentenceCount];
        current.setLength(0);
        int sentenceIndex = 0;

        // Populate the paragraph with Sentence objects
        for (int i = 0; i < sb.length(); i++) {
            char ch = sb.charAt(i);
            current.append(ch);
            if (ch == '.' || ch == '!' || ch == '?') {
                this.value[sentenceIndex++] = new Sentence(new StringBuffer(current));
                current.setLength(0);
            }
        }
        if (current.length() > 0) {
            this.value[sentenceIndex] = new Sentence(new StringBuffer(current));
        }
    }

    /**
     * Returns the array of {@code Sentence} objects that make up this {@code Paragraph}.
     *
     * @return an array of {@code Sentence} objects in this paragraph
     */
    public Sentence[] getValue() {
        return this.value;
    }

    /**
     * Returns a string representation of this {@code Paragraph}.
     * Sentences are separated by a single space in the output.
     *
     * @return the string representation of the paragraph
     */
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (Sentence sentence : this.value) {
            sb.append(sentence.toString()).append(" ");
        }
        return sb.toString().trim();
    }
}
