public class PunctuationMark {
    private char value;

    public PunctuationMark(char mark) {
        this.value = mark;
    }

    public PunctuationMark(StringBuffer sb) {
        this.value = sb.charAt(0);
    }

    public char getValue() {
        return this.value;
    }

    public static boolean validate(char ch) {
        return ch == '.' ||
               ch == ',' ||
               ch == '?' ||
               ch == '!';
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }
}
