/**
 * Represents a text composed of multiple {@code Paragraph} objects.
 * A {@code Text} can be initialized with an array of {@code Paragraph} objects
 * or parsed from a {@code StringBuffer}.
 *
 * <p>
 * Paragraphs in the text are separated by newline characters ('\n').
 * </p>
 */
public class Text {
    private Paragraph[] value;

    /**
     * Constructs a {@code Text} object using the specified array of {@code Paragraph} objects.
     *
     * @param text an array of {@code Paragraph} objects representing the text
     */
    public Text(Paragraph[] text) {
        this.value = text;
    }

    /**
     * Constructs a {@code Text} object by parsing the provided {@code StringBuffer}.
     * Paragraphs are identified and separated based on newline characters.
     *
     * @param sb the {@code StringBuffer} containing the text to parse
     */
    public Text(StringBuffer sb) {
        StringBuffer current = new StringBuffer();
        int paragraphCount = 0;

        // Determine the number of paragraphs
        for (int i = 0; i < sb.length(); i++) {
            char ch = sb.charAt(i);
            current.append(ch);
            if (ch == '\n') {
                paragraphCount++;
                current.setLength(0);
            }
        }
        if (current.length() > 0) {
            paragraphCount++;
        }

        this.value = new Paragraph[paragraphCount];
        current.setLength(0);
        int paragraphIndex = 0;

        // Populate the text with Paragraph objects
        for (int i = 0; i < sb.length(); i++) {
            char ch = sb.charAt(i);
            if (ch == '\n') {
                this.value[paragraphIndex++] = new Paragraph(new StringBuffer(current));
                current.setLength(0);
            } else {
                current.append(ch);
            }
        }
        if (current.length() > 0) {
            this.value[paragraphIndex] = new Paragraph(new StringBuffer(current));
        }
    }

    /**
     * Returns the array of {@code Paragraph} objects that make up this {@code Text}.
     *
     * @return an array of {@code Paragraph} objects in this text
     */
    public Paragraph[] getValue() {
        return this.value;
    }

    /**
     * Returns a string representation of this {@code Text}.
     * Paragraphs are separated by newline characters in the output.
     *
     * @return the string representation of the text
     */
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (Paragraph paragraph : this.value) {
            sb.append(paragraph.toString()).append("\n");
        }
        return sb.toString().trim();
    }
}
