package gherkin;

import gherkin.Parser;
import gherkin.ast.Location;
import java.util.List;

/* loaded from: classes5.dex */
public class Token {
    public final IGherkinLine line;
    public Location location;
    public GherkinDialect matchedGherkinDialect;
    public int matchedIndent;
    public String matchedKeyword;
    public String matchedText;
    public Parser.TokenType matchedType;
    public List<GherkinLineSpan> mathcedItems;

    public Token(IGherkinLine iGherkinLine, Location location) {
        this.line = iGherkinLine;
        this.location = location;
    }

    public boolean isEOF() {
        return this.line == null;
    }

    public void detach() {
        IGherkinLine iGherkinLine = this.line;
        if (iGherkinLine != null) {
            iGherkinLine.detach();
        }
    }

    public String getTokenValue() {
        return isEOF() ? "EOF" : this.line.getLineText(-1);
    }

    public String toString() {
        return String.format("%s: %s/%s", this.matchedType, this.matchedKeyword, this.matchedText);
    }
}
