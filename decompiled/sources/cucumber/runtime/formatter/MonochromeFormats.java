package cucumber.runtime.formatter;

/* loaded from: classes5.dex */
final class MonochromeFormats implements Formats {
    private static final Format FORMAT = new Format() { // from class: cucumber.runtime.formatter.MonochromeFormats.1
        @Override // cucumber.runtime.formatter.Format
        public String text(String str) {
            return str;
        }
    };

    MonochromeFormats() {
    }

    @Override // cucumber.runtime.formatter.Formats
    public Format get(String str) {
        return FORMAT;
    }

    @Override // cucumber.runtime.formatter.Formats
    public String up(int i) {
        return "";
    }
}
