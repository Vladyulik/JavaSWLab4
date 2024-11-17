import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        final String INPUT = "Here is a usual text.\n" +
                "It? Can, have. Punctuation marks!\n" +
                "And consist of multiple paragraphs.";

        System.out.println("Text before sorting:");
        System.out.println(INPUT);
        System.out.println();

        StringBuffer sb = new StringBuffer(INPUT);

        Text text = new Text(sb);

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

        Arrays.sort(words);

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

        String sortedText = text.toString();
        System.out.println("Text after sorting:");
        System.out.println(sortedText);
    }
}
