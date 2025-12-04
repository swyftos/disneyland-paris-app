package gherkin;

import gherkin.Parser;
import gherkin.ast.Location;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes5.dex */
public class TokenMatcher implements Parser.ITokenMatcher {
    private static final Pattern LANGUAGE_PATTERN = Pattern.compile("^\\s*#\\s*language\\s*:\\s*([a-zA-Z\\-_]+)\\s*$");
    private String activeDocStringSeparator;
    private GherkinDialect currentDialect;
    private final IGherkinDialectProvider dialectProvider;
    private int indentToRemove;

    public TokenMatcher(IGherkinDialectProvider iGherkinDialectProvider) {
        this.activeDocStringSeparator = null;
        this.indentToRemove = 0;
        this.dialectProvider = iGherkinDialectProvider;
        reset();
    }

    public TokenMatcher() {
        this(new GherkinDialectProvider());
    }

    public TokenMatcher(String str) {
        this(new GherkinDialectProvider(str));
    }

    @Override // gherkin.Parser.ITokenMatcher
    public void reset() {
        this.activeDocStringSeparator = null;
        this.indentToRemove = 0;
        this.currentDialect = this.dialectProvider.getDefaultDialect();
    }

    public GherkinDialect getCurrentDialect() {
        return this.currentDialect;
    }

    protected void setTokenMatched(Token token, Parser.TokenType tokenType, String str, String str2, Integer num, List<GherkinLineSpan> list) {
        int iIntValue;
        token.matchedType = tokenType;
        token.matchedKeyword = str2;
        token.matchedText = str;
        token.mathcedItems = list;
        token.matchedGherkinDialect = getCurrentDialect();
        if (num != null) {
            iIntValue = num.intValue();
        } else {
            IGherkinLine iGherkinLine = token.line;
            iIntValue = iGherkinLine == null ? 0 : iGherkinLine.indent().intValue();
        }
        token.matchedIndent = iIntValue;
        token.location = new Location(token.location.getLine(), token.matchedIndent + 1);
    }

    @Override // gherkin.Parser.ITokenMatcher
    public boolean match_EOF(Token token) {
        if (!token.isEOF()) {
            return false;
        }
        setTokenMatched(token, Parser.TokenType.EOF, null, null, null, null);
        return true;
    }

    @Override // gherkin.Parser.ITokenMatcher
    public boolean match_Other(Token token) {
        setTokenMatched(token, Parser.TokenType.Other, unescapeDocString(token.line.getLineText(this.indentToRemove)), null, 0, null);
        return true;
    }

    @Override // gherkin.Parser.ITokenMatcher
    public boolean match_Empty(Token token) {
        if (!token.line.isEmpty()) {
            return false;
        }
        setTokenMatched(token, Parser.TokenType.Empty, null, null, null, null);
        return true;
    }

    @Override // gherkin.Parser.ITokenMatcher
    public boolean match_Comment(Token token) {
        if (!token.line.startsWith(GherkinLanguageConstants.COMMENT_PREFIX)) {
            return false;
        }
        setTokenMatched(token, Parser.TokenType.Comment, token.line.getLineText(0), null, 0, null);
        return true;
    }

    @Override // gherkin.Parser.ITokenMatcher
    public boolean match_Language(Token token) {
        Matcher matcher = LANGUAGE_PATTERN.matcher(token.line.getLineText(0));
        if (!matcher.matches()) {
            return false;
        }
        String strGroup = matcher.group(1);
        setTokenMatched(token, Parser.TokenType.Language, strGroup, null, null, null);
        this.currentDialect = this.dialectProvider.getDialect(strGroup, token.location);
        return true;
    }

    @Override // gherkin.Parser.ITokenMatcher
    public boolean match_TagLine(Token token) {
        if (!token.line.startsWith(GherkinLanguageConstants.TAG_PREFIX)) {
            return false;
        }
        setTokenMatched(token, Parser.TokenType.TagLine, null, null, null, token.line.getTags());
        return true;
    }

    @Override // gherkin.Parser.ITokenMatcher
    public boolean match_FeatureLine(Token token) {
        return matchTitleLine(token, Parser.TokenType.FeatureLine, this.currentDialect.getFeatureKeywords());
    }

    @Override // gherkin.Parser.ITokenMatcher
    public boolean match_BackgroundLine(Token token) {
        return matchTitleLine(token, Parser.TokenType.BackgroundLine, this.currentDialect.getBackgroundKeywords());
    }

    @Override // gherkin.Parser.ITokenMatcher
    public boolean match_ScenarioLine(Token token) {
        return matchTitleLine(token, Parser.TokenType.ScenarioLine, this.currentDialect.getScenarioKeywords());
    }

    @Override // gherkin.Parser.ITokenMatcher
    public boolean match_ScenarioOutlineLine(Token token) {
        return matchTitleLine(token, Parser.TokenType.ScenarioOutlineLine, this.currentDialect.getScenarioOutlineKeywords());
    }

    @Override // gherkin.Parser.ITokenMatcher
    public boolean match_ExamplesLine(Token token) {
        return matchTitleLine(token, Parser.TokenType.ExamplesLine, this.currentDialect.getExamplesKeywords());
    }

    private boolean matchTitleLine(Token token, Parser.TokenType tokenType, List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (token.line.startsWithTitleKeyword(str)) {
                setTokenMatched(token, tokenType, token.line.getRestTrimmed(str.length() + 1), str, null, null);
                return true;
            }
        }
        return false;
    }

    @Override // gherkin.Parser.ITokenMatcher
    public boolean match_DocStringSeparator(Token token) {
        String str = this.activeDocStringSeparator;
        if (str == null) {
            return match_DocStringSeparator(token, GherkinLanguageConstants.DOCSTRING_SEPARATOR, true) || match_DocStringSeparator(token, GherkinLanguageConstants.DOCSTRING_ALTERNATIVE_SEPARATOR, true);
        }
        return match_DocStringSeparator(token, str, false);
    }

    private boolean match_DocStringSeparator(Token token, String str, boolean z) {
        String restTrimmed;
        if (!token.line.startsWith(str)) {
            return false;
        }
        if (z) {
            restTrimmed = token.line.getRestTrimmed(str.length());
            this.activeDocStringSeparator = str;
            this.indentToRemove = token.line.indent().intValue();
        } else {
            restTrimmed = null;
            this.activeDocStringSeparator = null;
            this.indentToRemove = 0;
        }
        setTokenMatched(token, Parser.TokenType.DocStringSeparator, restTrimmed, null, null, null);
        return true;
    }

    @Override // gherkin.Parser.ITokenMatcher
    public boolean match_StepLine(Token token) {
        for (String str : this.currentDialect.getStepKeywords()) {
            if (token.line.startsWith(str)) {
                setTokenMatched(token, Parser.TokenType.StepLine, token.line.getRestTrimmed(str.length()), str, null, null);
                return true;
            }
        }
        return false;
    }

    @Override // gherkin.Parser.ITokenMatcher
    public boolean match_TableRow(Token token) {
        if (!token.line.startsWith(GherkinLanguageConstants.TABLE_CELL_SEPARATOR)) {
            return false;
        }
        setTokenMatched(token, Parser.TokenType.TableRow, null, null, null, token.line.getTableCells());
        return true;
    }

    private String unescapeDocString(String str) {
        return this.activeDocStringSeparator != null ? str.replace("\\\"\\\"\\\"", GherkinLanguageConstants.DOCSTRING_SEPARATOR) : str;
    }
}
