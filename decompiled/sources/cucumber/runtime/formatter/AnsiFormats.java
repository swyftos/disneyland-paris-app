package cucumber.runtime.formatter;

import com.tagcommander.lib.serverside.ETCPurchaseStatus;
import cucumber.api.formatter.AnsiEscapes;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes5.dex */
final class AnsiFormats implements Formats {
    private static final Map formats = new HashMap() { // from class: cucumber.runtime.formatter.AnsiFormats.1
        {
            put("undefined", new ColorFormat(AnsiEscapes.YELLOW));
            put("undefined_arg", new ColorFormat(AnsiEscapes.YELLOW, AnsiEscapes.INTENSITY_BOLD));
            put("unused", new ColorFormat(AnsiEscapes.YELLOW));
            put("unused_arg", new ColorFormat(AnsiEscapes.YELLOW, AnsiEscapes.INTENSITY_BOLD));
            put(ETCPurchaseStatus.PENDING, new ColorFormat(AnsiEscapes.YELLOW));
            put("pending_arg", new ColorFormat(AnsiEscapes.YELLOW, AnsiEscapes.INTENSITY_BOLD));
            put("executing", new ColorFormat(AnsiEscapes.GREY));
            put("executing_arg", new ColorFormat(AnsiEscapes.GREY, AnsiEscapes.INTENSITY_BOLD));
            put("failed", new ColorFormat(AnsiEscapes.RED));
            put("failed_arg", new ColorFormat(AnsiEscapes.RED, AnsiEscapes.INTENSITY_BOLD));
            put("ambiguous", new ColorFormat(AnsiEscapes.RED));
            put("ambiguous_arg", new ColorFormat(AnsiEscapes.RED, AnsiEscapes.INTENSITY_BOLD));
            put("passed", new ColorFormat(AnsiEscapes.GREEN));
            put("passed_arg", new ColorFormat(AnsiEscapes.GREEN, AnsiEscapes.INTENSITY_BOLD));
            put("outline", new ColorFormat(AnsiEscapes.CYAN));
            put("outline_arg", new ColorFormat(AnsiEscapes.CYAN, AnsiEscapes.INTENSITY_BOLD));
            put("skipped", new ColorFormat(AnsiEscapes.CYAN));
            put("skipped_arg", new ColorFormat(AnsiEscapes.CYAN, AnsiEscapes.INTENSITY_BOLD));
            put("comment", new ColorFormat(AnsiEscapes.GREY));
            put("tag", new ColorFormat(AnsiEscapes.CYAN));
            put("output", new ColorFormat(AnsiEscapes.BLUE));
        }
    };

    AnsiFormats() {
    }

    private static final class ColorFormat implements Format {
        private final AnsiEscapes[] escapes;

        ColorFormat(AnsiEscapes... ansiEscapesArr) {
            this.escapes = ansiEscapesArr;
        }

        @Override // cucumber.runtime.formatter.Format
        public String text(String str) {
            StringBuilder sb = new StringBuilder();
            for (AnsiEscapes ansiEscapes : this.escapes) {
                ansiEscapes.appendTo(sb);
            }
            sb.append(str);
            AnsiEscapes.RESET.appendTo(sb);
            return sb.toString();
        }
    }

    @Override // cucumber.runtime.formatter.Formats
    public Format get(String str) {
        Format format = (Format) formats.get(str);
        if (format != null) {
            return format;
        }
        throw new NullPointerException("No format for key " + str);
    }

    @Override // cucumber.runtime.formatter.Formats
    public String up(int i) {
        return AnsiEscapes.up(i).toString();
    }
}
