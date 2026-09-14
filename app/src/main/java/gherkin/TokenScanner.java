package gherkin;

import gherkin.ast.Location;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

/* JADX INFO: loaded from: classes5.dex */
public class TokenScanner implements Parser.ITokenScanner {
    private int lineNumber;
    private final BufferedReader reader;

    public TokenScanner(String str) {
        this(new StringReader(str));
    }

    public TokenScanner(Reader reader) {
        this.reader = new BufferedReader(reader);
    }

    @Override // gherkin.Parser.ITokenScanner
    public Token read() {
        try {
            String line = this.reader.readLine();
            int i = this.lineNumber + 1;
            this.lineNumber = i;
            Location location = new Location(i, 0);
            return line == null ? new Token(null, location) : new Token(new GherkinLine(line), location);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
