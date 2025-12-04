package cucumber.api.formatter;

import androidx.exifinterface.media.ExifInterface;
import java.io.IOException;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes5.dex */
public class AnsiEscapes {
    private final String value;
    public static AnsiEscapes RESET = color(0);
    public static AnsiEscapes BLACK = color(30);
    public static AnsiEscapes RED = color(31);
    public static AnsiEscapes GREEN = color(32);
    public static AnsiEscapes YELLOW = color(33);
    public static AnsiEscapes BLUE = color(34);
    public static AnsiEscapes MAGENTA = color(35);
    public static AnsiEscapes CYAN = color(36);
    public static AnsiEscapes WHITE = color(37);
    public static AnsiEscapes DEFAULT = color(9);
    public static AnsiEscapes GREY = color(90);
    public static AnsiEscapes INTENSITY_BOLD = color(1);

    private static AnsiEscapes color(int i) {
        return new AnsiEscapes(String.valueOf(i) + "m");
    }

    public static AnsiEscapes up(int i) {
        return new AnsiEscapes(String.valueOf(i) + ExifInterface.GPS_MEASUREMENT_IN_PROGRESS);
    }

    private AnsiEscapes(String str) {
        this.value = str;
    }

    public void appendTo(NiceAppendable niceAppendable) throws IOException {
        niceAppendable.append((char) 27).append(AbstractJsonLexerKt.BEGIN_LIST).append((CharSequence) this.value);
    }

    public void appendTo(StringBuilder sb) {
        sb.append((char) 27);
        sb.append(AbstractJsonLexerKt.BEGIN_LIST);
        sb.append(this.value);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        appendTo(sb);
        return sb.toString();
    }
}
