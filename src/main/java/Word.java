public class Word implements Comparable<Word> {
    private Letter[] value;

    public Word(Letter[] word) {
        this.value = word;
    }

    public Word(StringBuffer sb) {
        this.value = new Letter[sb.length()];
        for (int i = 0; i < sb.length(); i++) {
            this.value[i] = new Letter(new StringBuffer().append(sb.charAt(i)));
        }
    }

    public Letter[] getValue() {
        return this.value;
    }

    public int countVowels() {
        int total = 0;
        for (Letter letter : this.value) {
            if (letter.isVowel()) {
                total++;
            }
        }
        return total;
    }

    @Override
    public int compareTo(Word other) {
        if (this.countVowels() > other.countVowels()) { return 1; }
        if (this.countVowels() < other.countVowels()) { return -1; }
        return 0;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (Letter letter : this.value) {
            sb.append(letter.toString());
        }
        return sb.toString();
    }
}
