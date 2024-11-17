public class Letter {
    private char value;

    public Letter(char ch) {
        this.value = ch;
    }

    public Letter(StringBuffer sb) {
        this.value = sb.charAt(0);
    }

    public char getValue() {
        return this.value;
    }

    public boolean isVowel() {
        char lowerCaseChar = Character.toLowerCase(this.value);
        return lowerCaseChar == 'a' ||
               lowerCaseChar == 'e' ||
               lowerCaseChar == 'i' ||
               lowerCaseChar == 'o' ||
               lowerCaseChar == 'u';
    }

    public static boolean validate(char ch) {
        return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z');
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }
}
