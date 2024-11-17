public class Text {
    private Paragraph[] value;

    public Text(Paragraph[] text) {
        this.value = text;
    }

    public Text(StringBuffer sb) {
        StringBuffer current = new StringBuffer();
        int paragraphCount = 0;

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

    public Paragraph[] getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (Paragraph paragraph : this.value) {
            sb.append(paragraph.toString()).append("\n");
        }
        return sb.toString().trim();
    }
}
