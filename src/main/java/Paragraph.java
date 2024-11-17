public class Paragraph {
    private Sentence[] value;

    public Paragraph(Sentence[] paragraph) {
        this.value = paragraph;
    }

    public Paragraph(StringBuffer sb) {
        StringBuffer current = new StringBuffer();
        int sentenceCount = 0;

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

    public Sentence[] getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (Sentence sentence : this.value) {
            sb.append(sentence.toString()).append(" ");
        }
        return sb.toString().trim();
    }
}
