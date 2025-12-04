package gherkin;

import gherkin.StringUtils;
import java.util.List;

/* loaded from: classes5.dex */
public class TokenFormatter {
    private static final StringUtils.ToString SPAN_TO_STRING = new StringUtils.ToString() { // from class: gherkin.TokenFormatter.1
        @Override // gherkin.StringUtils.ToString
        public String toString(GherkinLineSpan gherkinLineSpan) {
            return gherkinLineSpan.column + ":" + gherkinLineSpan.text;
        }
    };

    public String formatToken(Token token) {
        if (token.isEOF()) {
            return "EOF";
        }
        String string = toString(Integer.valueOf(token.location.getLine()));
        String string2 = toString(Integer.valueOf(token.location.getColumn()));
        String string3 = toString(token.matchedType);
        String string4 = toString(token.matchedKeyword);
        String string5 = toString(token.matchedText);
        List<GherkinLineSpan> list = token.mathcedItems;
        return String.format("(%s:%s)%s:%s/%s/%s", string, string2, string3, string4, string5, toString(list == null ? "" : StringUtils.join(SPAN_TO_STRING, ",", list)));
    }

    private String toString(Object obj) {
        return obj == null ? "" : obj.toString();
    }
}
