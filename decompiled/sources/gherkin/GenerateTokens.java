package gherkin;

import gherkin.stream.Stdio;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/* loaded from: classes5.dex */
public class GenerateTokens {
    public static void main(String[] strArr) throws UnsupportedEncodingException, FileNotFoundException {
        Parser parser = new Parser(new TokenFormatterBuilder());
        TokenMatcher tokenMatcher = new TokenMatcher();
        for (String str : strArr) {
            String str2 = (String) parser.parse(new InputStreamReader(new FileInputStream(str), "UTF-8"), tokenMatcher);
            PrintWriter printWriter = Stdio.out;
            printWriter.print(str2);
            printWriter.flush();
        }
    }
}
