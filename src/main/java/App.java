import java.util.Arrays;

/**
 * Demonstrates sorting words in a text while maintaining the structure of the text.
 * This application processes a multi-paragraph text input, separates it into words,
 * sorts the words, and reinserts them back into the original text structure.
 * Prints the original and sorted versions of the text.
 */
public class App {

    /**
     * The entry point of the application.
     * The method:
     * - Defines a sample input text containing multiple paragraphs and punctuation marks.
     * - Parses the text into {@code Text} object.
     * - Extracts all words, sorts them, and reinserts them back into the original structure.
     * - Prints the original and sorted versions of the text.
     *
     * @param args the command-line arguments (not used in this application)
     */
    public static void main(String[] args) {
        // Input text
        final String INPUT = "Here is a usual text.\n" +
                "It? Can, have. Punctuation marks!\n" +
                "And consist of multiple paragraphs.";

        // Print the original text
        System.out.println("Text before sorting:");
        System.out.println(INPUT);
        System.out.println();

        // Convert input to StringBuffer
        StringBuffer sb = new StringBuffer(INPUT);

        // Parse StringBuffer into Text object
        Text text = new Text(sb);

        // Count words in the text
        int wordCount = 0;
        for (Paragraph paragraph : text.getValue()) {
            for (Sentence sentence : paragraph.getValue()) {
                for (Object element : sentence.getValue()) {
                    if (element instanceof Word) {
                        wordCount++;
                    }
                }
            }
        }

        // Extract all words into an array
        Word[] words = new Word[wordCount];

        int index = 0;
        for (Paragraph paragraph : text.getValue()) {
            for (Sentence sentence : paragraph.getValue()) {
                for (Object element : sentence.getValue()) {
                    if (element instanceof Word) {
                        words[index++] = (Word) element;
                    }
                }
            }
        }

        // Sort the words
        Arrays.sort(words);

        // Reinsert sorted words back into the original text structure
        int wordIndex = 0;
        for (Paragraph paragraph : text.getValue()) {
            for (Sentence sentence : paragraph.getValue()) {
                Object[] elements = sentence.getValue();
                for (int i = 0; i < elements.length; i++) {
                    if (elements[i] instanceof Word) {
                        elements[i] = words[wordIndex++];
                    }
                }
            }
        }

        // Print the sorted text
        String sortedText = text.toString();
        System.out.println("Text after sorting:");
        System.out.println(sortedText);
    }
}
