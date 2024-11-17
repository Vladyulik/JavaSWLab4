public class Sentence {
    private Object[] value;

    public Sentence(Object[] sentence) {
        this.value = sentence;
    }

    public Sentence(StringBuffer sb) {
        StringBuffer current = new StringBuffer();
        int elementCount = 0;

        for (int i = 0; i < sb.length(); i++) {
            char ch = sb.charAt(i);
            if (Letter.validate(ch)) {
                current.append(ch);
            }
            if (!Letter.validate(ch)) {
                if (current.length() > 0) {
                    elementCount++;
                    current.setLength(0);
                }
            }
            if (PunctuationMark.validate(ch)) {
                elementCount++;
            }
        }
        if (current.length() > 0) {
            elementCount++;
        }

        this.value = new Object[elementCount];
        current.setLength(0);
        int index = 0;

        for (int i = 0; i < sb.length(); i++) {
            char ch = sb.charAt(i);
            if (Letter.validate(ch)) {
                current.append(ch);
            }
            if (!Letter.validate(ch)) {
                if (current.length() > 0) {
                    this.value[index++] = new Word(new StringBuffer(current));
                    current.setLength(0);
                }
            }
            if (PunctuationMark.validate(ch)) {
                this.value[index++] = new PunctuationMark(new StringBuffer().append(ch));
            }
        }
        if (current.length() > 0) {
            this.value[index] = new Word(new StringBuffer(current));
        }
    }

    public Object[] getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < this.value.length; i++) {
            if (this.value[i] instanceof Word) {
                sb.append(this.value[i].toString());
                if (i + 1 < this.value.length && this.value[i + 1] instanceof Word) {
                    sb.append(" ");
                }
            } else if (this.value[i] instanceof PunctuationMark) {
                sb.append(this.value[i].toString()).append(" ");
            }
        }
        return sb.toString().trim();
    }
}
