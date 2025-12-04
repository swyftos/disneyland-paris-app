package gherkin.stream;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.nio.charset.Charset;

/* loaded from: classes5.dex */
public class Stdio {
    public static final PrintWriter out = new PrintWriter((Writer) new OutputStreamWriter(System.out, Charset.forName("UTF-8")), true);
    public static final PrintWriter err = new PrintWriter((Writer) new OutputStreamWriter(System.err, Charset.forName("UTF-8")), true);
}
