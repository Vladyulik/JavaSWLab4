public class App {
    public static void main(String[] args) {
        final String TEXT = "This is a text.\n" +
                "It? Can, have. Punctuation marks!\n" +
                "And consist of multiple paragraphs.";

        final char[] VOWELS = {'a', 'e', 'i', 'o', 'u'};

        System.out.println("Text before sorting:");
        System.out.println(TEXT);
        System.out.println();

        StringBuffer sb = new StringBuffer(TEXT);
        boolean sorted = false;

        while (!sorted) {
            sorted = true;

            int firstWordStart = -1;
            int firstWordEnd = -1;
            int firstWordVowels = 0;

            int secondWordStart = -1;
            int secondWordEnd = -1;
            int secondWordVowels = 0;

            for (int i = 0; i < sb.length(); i++) {
                char ch = sb.charAt(i);
                if (isLetter(ch)) {
                    if (firstWordEnd < 0) {
                        if (firstWordStart < 0) {
                            firstWordStart = i;
                        }
                        if (isCharInArray(ch, VOWELS)) {
                            firstWordVowels++;
                        }
                        continue;
                    }
                    if (secondWordEnd < 0) {
                        if (secondWordStart < 0) {
                            secondWordStart = i;
                        }
                        if (isCharInArray(ch, VOWELS)) {
                            secondWordVowels++;
                        }
                    }
                } else {
                    if (firstWordStart >= 0 && firstWordEnd < 0) {
                        firstWordEnd = i;
                        continue;
                    }
                    if (secondWordStart >= 0 && secondWordEnd < 0) {
                        secondWordEnd = i;

                        if (secondWordVowels < firstWordVowels) {
                            int firstWordLength = firstWordEnd - firstWordStart;
                            int secondWordLength = secondWordEnd - secondWordStart;

                            for (int j = 0; j < secondWordLength; j++) {
                                char c = sb.charAt(secondWordStart + j);
                                sb.deleteCharAt(secondWordStart + j);
                                sb.insert(firstWordStart + j, c);
                            }
                            for (int j = 0; j < firstWordLength; j++) {
                                char c = sb.charAt(firstWordStart + secondWordLength);
                                sb.insert(secondWordStart + secondWordLength, c);
                                sb.deleteCharAt(firstWordStart + secondWordLength);
                            }

                            firstWordStart = -1;
                            firstWordEnd = -1;
                            firstWordVowels = 0;

                            secondWordStart = -1;
                            secondWordEnd = -1;
                            secondWordVowels = 0;

                            sorted = false;
                        } else {
                            firstWordStart = secondWordStart;
                            firstWordEnd = secondWordEnd;
                            firstWordVowels = secondWordVowels;

                            secondWordStart = -1;
                            secondWordEnd = -1;
                            secondWordVowels = 0;
                        }
                    }
                }
            }
        }

        String sortedText = sb.toString();
        System.out.println("Text after sorting:");
        System.out.println(sortedText);
    }

    private static boolean isCharInArray(char ch, char[] array) {
        for (char c : array) {
            if (c == ch) {
                return true;
            }
        }
        return false;
    }

    private static boolean isLetter(char ch) {
        return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z');
    }
}
