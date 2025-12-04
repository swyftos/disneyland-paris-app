package gherkin;

/* loaded from: classes5.dex */
public class GherkinLineSpan {
    public final int column;
    public final String text;

    public GherkinLineSpan(int i, String str) {
        this.column = i;
        this.text = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        GherkinLineSpan gherkinLineSpan = (GherkinLineSpan) obj;
        return this.column == gherkinLineSpan.column && this.text.equals(gherkinLineSpan.text);
    }

    public int hashCode() {
        return (this.column * 31) + this.text.hashCode();
    }
}
