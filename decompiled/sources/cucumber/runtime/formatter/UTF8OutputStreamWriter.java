package cucumber.runtime.formatter;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;

/* loaded from: classes5.dex */
class UTF8OutputStreamWriter extends OutputStreamWriter {
    UTF8OutputStreamWriter(OutputStream outputStream) {
        super(outputStream, Charset.forName("UTF-8"));
    }
}
