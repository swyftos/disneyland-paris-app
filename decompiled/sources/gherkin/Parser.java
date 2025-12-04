package gherkin;

import gherkin.ParserException;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/* loaded from: classes5.dex */
public class Parser<T> {
    private final Builder builder;
    public boolean stopAtFirstError;

    public interface Builder<T> {
        void build(Token token);

        void endRule(RuleType ruleType);

        T getResult();

        void reset();

        void startRule(RuleType ruleType);
    }

    public interface ITokenMatcher {
        boolean match_BackgroundLine(Token token);

        boolean match_Comment(Token token);

        boolean match_DocStringSeparator(Token token);

        boolean match_EOF(Token token);

        boolean match_Empty(Token token);

        boolean match_ExamplesLine(Token token);

        boolean match_FeatureLine(Token token);

        boolean match_Language(Token token);

        boolean match_Other(Token token);

        boolean match_ScenarioLine(Token token);

        boolean match_ScenarioOutlineLine(Token token);

        boolean match_StepLine(Token token);

        boolean match_TableRow(Token token);

        boolean match_TagLine(Token token);

        void reset();
    }

    public interface ITokenScanner {
        Token read();
    }

    public enum TokenType {
        None,
        EOF,
        Empty,
        Comment,
        TagLine,
        FeatureLine,
        BackgroundLine,
        ScenarioLine,
        ScenarioOutlineLine,
        ExamplesLine,
        StepLine,
        DocStringSeparator,
        TableRow,
        Language,
        Other
    }

    public enum RuleType {
        None,
        _EOF,
        _Empty,
        _Comment,
        _TagLine,
        _FeatureLine,
        _BackgroundLine,
        _ScenarioLine,
        _ScenarioOutlineLine,
        _ExamplesLine,
        _StepLine,
        _DocStringSeparator,
        _TableRow,
        _Language,
        _Other,
        GherkinDocument,
        Feature,
        Feature_Header,
        Background,
        Scenario_Definition,
        Scenario,
        ScenarioOutline,
        Examples_Definition,
        Examples,
        Examples_Table,
        Step,
        Step_Arg,
        DataTable,
        DocString,
        Tags,
        Description_Helper,
        Description;

        public static RuleType cast(TokenType tokenType) {
            return values()[tokenType.ordinal()];
        }
    }

    class ParserContext {
        public final List errors;
        public final ITokenMatcher tokenMatcher;
        public final Queue tokenQueue;
        public final ITokenScanner tokenScanner;

        ParserContext(ITokenScanner iTokenScanner, ITokenMatcher iTokenMatcher, Queue queue, List list) {
            this.tokenScanner = iTokenScanner;
            this.tokenMatcher = iTokenMatcher;
            this.tokenQueue = queue;
            this.errors = list;
        }
    }

    public Parser(Builder<T> builder) {
        this.builder = builder;
    }

    public T parse(String str) {
        return parse(new StringReader(str));
    }

    public T parse(Reader reader) {
        return parse(new TokenScanner(reader));
    }

    public T parse(ITokenScanner iTokenScanner) {
        return parse(iTokenScanner, new TokenMatcher());
    }

    public T parse(String str, ITokenMatcher iTokenMatcher) {
        return parse(new StringReader(str), iTokenMatcher);
    }

    public T parse(Reader reader, ITokenMatcher iTokenMatcher) {
        return parse(new TokenScanner(reader), iTokenMatcher);
    }

    public T parse(ITokenScanner iTokenScanner, ITokenMatcher iTokenMatcher) {
        Token token;
        this.builder.reset();
        iTokenMatcher.reset();
        ParserContext parserContext = new ParserContext(iTokenScanner, iTokenMatcher, new LinkedList(), new ArrayList());
        startRule(parserContext, RuleType.GherkinDocument);
        int iMatchToken = 0;
        do {
            token = readToken(parserContext);
            iMatchToken = matchToken(iMatchToken, token, parserContext);
        } while (!token.isEOF());
        endRule(parserContext, RuleType.GherkinDocument);
        if (parserContext.errors.size() > 0) {
            throw new ParserException.CompositeParserException(parserContext.errors);
        }
        return (T) this.builder.getResult();
    }

    private void addError(ParserContext parserContext, ParserException parserException) {
        parserContext.errors.add(parserException);
        if (parserContext.errors.size() > 10) {
            throw new ParserException.CompositeParserException(parserContext.errors);
        }
    }

    private Object handleAstError(ParserContext parserContext, Func func) {
        return handleExternalError(parserContext, func, null);
    }

    private Object handleExternalError(ParserContext parserContext, Func func, Object obj) {
        if (this.stopAtFirstError) {
            return func.call();
        }
        try {
            return func.call();
        } catch (ParserException.CompositeParserException e) {
            Iterator<ParserException> it = e.errors.iterator();
            while (it.hasNext()) {
                this.addError(parserContext, it.next());
            }
            return obj;
        } catch (ParserException e2) {
            this.addError(parserContext, e2);
            return obj;
        }
    }

    private void build(ParserContext parserContext, final Token token) {
        handleAstError(parserContext, new Func() { // from class: gherkin.Parser.1
            @Override // gherkin.Func
            public Void call() {
                Parser.this.builder.build(token);
                return null;
            }
        });
    }

    private void startRule(ParserContext parserContext, final RuleType ruleType) {
        handleAstError(parserContext, new Func() { // from class: gherkin.Parser.2
            @Override // gherkin.Func
            public Void call() {
                Parser.this.builder.startRule(ruleType);
                return null;
            }
        });
    }

    private void endRule(ParserContext parserContext, final RuleType ruleType) {
        handleAstError(parserContext, new Func() { // from class: gherkin.Parser.3
            @Override // gherkin.Func
            public Void call() {
                Parser.this.builder.endRule(ruleType);
                return null;
            }
        });
    }

    private Token readToken(ParserContext parserContext) {
        return parserContext.tokenQueue.size() > 0 ? (Token) parserContext.tokenQueue.remove() : parserContext.tokenScanner.read();
    }

    private boolean match_EOF(final ParserContext parserContext, final Token token) {
        return ((Boolean) handleExternalError(parserContext, new Func() { // from class: gherkin.Parser.4
            @Override // gherkin.Func
            public Boolean call() {
                return Boolean.valueOf(parserContext.tokenMatcher.match_EOF(token));
            }
        }, Boolean.FALSE)).booleanValue();
    }

    private boolean match_Empty(final ParserContext parserContext, final Token token) {
        if (token.isEOF()) {
            return false;
        }
        return ((Boolean) handleExternalError(parserContext, new Func() { // from class: gherkin.Parser.5
            @Override // gherkin.Func
            public Boolean call() {
                return Boolean.valueOf(parserContext.tokenMatcher.match_Empty(token));
            }
        }, Boolean.FALSE)).booleanValue();
    }

    private boolean match_Comment(final ParserContext parserContext, final Token token) {
        if (token.isEOF()) {
            return false;
        }
        return ((Boolean) handleExternalError(parserContext, new Func() { // from class: gherkin.Parser.6
            @Override // gherkin.Func
            public Boolean call() {
                return Boolean.valueOf(parserContext.tokenMatcher.match_Comment(token));
            }
        }, Boolean.FALSE)).booleanValue();
    }

    private boolean match_TagLine(final ParserContext parserContext, final Token token) {
        if (token.isEOF()) {
            return false;
        }
        return ((Boolean) handleExternalError(parserContext, new Func() { // from class: gherkin.Parser.7
            @Override // gherkin.Func
            public Boolean call() {
                return Boolean.valueOf(parserContext.tokenMatcher.match_TagLine(token));
            }
        }, Boolean.FALSE)).booleanValue();
    }

    private boolean match_FeatureLine(final ParserContext parserContext, final Token token) {
        if (token.isEOF()) {
            return false;
        }
        return ((Boolean) handleExternalError(parserContext, new Func() { // from class: gherkin.Parser.8
            @Override // gherkin.Func
            public Boolean call() {
                return Boolean.valueOf(parserContext.tokenMatcher.match_FeatureLine(token));
            }
        }, Boolean.FALSE)).booleanValue();
    }

    private boolean match_BackgroundLine(final ParserContext parserContext, final Token token) {
        if (token.isEOF()) {
            return false;
        }
        return ((Boolean) handleExternalError(parserContext, new Func() { // from class: gherkin.Parser.9
            @Override // gherkin.Func
            public Boolean call() {
                return Boolean.valueOf(parserContext.tokenMatcher.match_BackgroundLine(token));
            }
        }, Boolean.FALSE)).booleanValue();
    }

    private boolean match_ScenarioLine(final ParserContext parserContext, final Token token) {
        if (token.isEOF()) {
            return false;
        }
        return ((Boolean) handleExternalError(parserContext, new Func() { // from class: gherkin.Parser.10
            @Override // gherkin.Func
            public Boolean call() {
                return Boolean.valueOf(parserContext.tokenMatcher.match_ScenarioLine(token));
            }
        }, Boolean.FALSE)).booleanValue();
    }

    private boolean match_ScenarioOutlineLine(final ParserContext parserContext, final Token token) {
        if (token.isEOF()) {
            return false;
        }
        return ((Boolean) handleExternalError(parserContext, new Func() { // from class: gherkin.Parser.11
            @Override // gherkin.Func
            public Boolean call() {
                return Boolean.valueOf(parserContext.tokenMatcher.match_ScenarioOutlineLine(token));
            }
        }, Boolean.FALSE)).booleanValue();
    }

    private boolean match_ExamplesLine(final ParserContext parserContext, final Token token) {
        if (token.isEOF()) {
            return false;
        }
        return ((Boolean) handleExternalError(parserContext, new Func() { // from class: gherkin.Parser.12
            @Override // gherkin.Func
            public Boolean call() {
                return Boolean.valueOf(parserContext.tokenMatcher.match_ExamplesLine(token));
            }
        }, Boolean.FALSE)).booleanValue();
    }

    private boolean match_StepLine(final ParserContext parserContext, final Token token) {
        if (token.isEOF()) {
            return false;
        }
        return ((Boolean) handleExternalError(parserContext, new Func() { // from class: gherkin.Parser.13
            @Override // gherkin.Func
            public Boolean call() {
                return Boolean.valueOf(parserContext.tokenMatcher.match_StepLine(token));
            }
        }, Boolean.FALSE)).booleanValue();
    }

    private boolean match_DocStringSeparator(final ParserContext parserContext, final Token token) {
        if (token.isEOF()) {
            return false;
        }
        return ((Boolean) handleExternalError(parserContext, new Func() { // from class: gherkin.Parser.14
            @Override // gherkin.Func
            public Boolean call() {
                return Boolean.valueOf(parserContext.tokenMatcher.match_DocStringSeparator(token));
            }
        }, Boolean.FALSE)).booleanValue();
    }

    private boolean match_TableRow(final ParserContext parserContext, final Token token) {
        if (token.isEOF()) {
            return false;
        }
        return ((Boolean) handleExternalError(parserContext, new Func() { // from class: gherkin.Parser.15
            @Override // gherkin.Func
            public Boolean call() {
                return Boolean.valueOf(parserContext.tokenMatcher.match_TableRow(token));
            }
        }, Boolean.FALSE)).booleanValue();
    }

    private boolean match_Language(final ParserContext parserContext, final Token token) {
        if (token.isEOF()) {
            return false;
        }
        return ((Boolean) handleExternalError(parserContext, new Func() { // from class: gherkin.Parser.16
            @Override // gherkin.Func
            public Boolean call() {
                return Boolean.valueOf(parserContext.tokenMatcher.match_Language(token));
            }
        }, Boolean.FALSE)).booleanValue();
    }

    private boolean match_Other(final ParserContext parserContext, final Token token) {
        if (token.isEOF()) {
            return false;
        }
        return ((Boolean) handleExternalError(parserContext, new Func() { // from class: gherkin.Parser.17
            @Override // gherkin.Func
            public Boolean call() {
                return Boolean.valueOf(parserContext.tokenMatcher.match_Other(token));
            }
        }, Boolean.FALSE)).booleanValue();
    }

    private int matchToken(int i, Token token, ParserContext parserContext) {
        switch (i) {
            case 0:
                return matchTokenAt_0(token, parserContext);
            case 1:
                return matchTokenAt_1(token, parserContext);
            case 2:
                return matchTokenAt_2(token, parserContext);
            case 3:
                return matchTokenAt_3(token, parserContext);
            case 4:
                return matchTokenAt_4(token, parserContext);
            case 5:
                return matchTokenAt_5(token, parserContext);
            case 6:
                return matchTokenAt_6(token, parserContext);
            case 7:
                return matchTokenAt_7(token, parserContext);
            case 8:
                return matchTokenAt_8(token, parserContext);
            case 9:
                return matchTokenAt_9(token, parserContext);
            case 10:
                return matchTokenAt_10(token, parserContext);
            case 11:
                return matchTokenAt_11(token, parserContext);
            case 12:
                return matchTokenAt_12(token, parserContext);
            case 13:
                return matchTokenAt_13(token, parserContext);
            case 14:
                return matchTokenAt_14(token, parserContext);
            case 15:
                return matchTokenAt_15(token, parserContext);
            case 16:
                return matchTokenAt_16(token, parserContext);
            case 17:
                return matchTokenAt_17(token, parserContext);
            case 18:
                return matchTokenAt_18(token, parserContext);
            case 19:
                return matchTokenAt_19(token, parserContext);
            case 20:
                return matchTokenAt_20(token, parserContext);
            case 21:
                return matchTokenAt_21(token, parserContext);
            case 22:
                return matchTokenAt_22(token, parserContext);
            case 23:
                return matchTokenAt_23(token, parserContext);
            case 24:
                return matchTokenAt_24(token, parserContext);
            case 25:
                return matchTokenAt_25(token, parserContext);
            case 26:
                return matchTokenAt_26(token, parserContext);
            case 27:
            default:
                throw new IllegalStateException("Unknown state: " + i);
            case 28:
                return matchTokenAt_28(token, parserContext);
            case 29:
                return matchTokenAt_29(token, parserContext);
            case 30:
                return matchTokenAt_30(token, parserContext);
            case 31:
                return matchTokenAt_31(token, parserContext);
            case 32:
                return matchTokenAt_32(token, parserContext);
            case 33:
                return matchTokenAt_33(token, parserContext);
        }
    }

    private int matchTokenAt_0(Token token, ParserContext parserContext) {
        if (match_EOF(parserContext, token)) {
            build(parserContext, token);
            return 27;
        }
        if (match_Language(parserContext, token)) {
            startRule(parserContext, RuleType.Feature);
            startRule(parserContext, RuleType.Feature_Header);
            build(parserContext, token);
            return 1;
        }
        if (match_TagLine(parserContext, token)) {
            startRule(parserContext, RuleType.Feature);
            startRule(parserContext, RuleType.Feature_Header);
            startRule(parserContext, RuleType.Tags);
            build(parserContext, token);
            return 2;
        }
        if (match_FeatureLine(parserContext, token)) {
            startRule(parserContext, RuleType.Feature);
            startRule(parserContext, RuleType.Feature_Header);
            build(parserContext, token);
            return 3;
        }
        if (match_Comment(parserContext, token)) {
            build(parserContext, token);
            return 0;
        }
        if (match_Empty(parserContext, token)) {
            build(parserContext, token);
            return 0;
        }
        token.detach();
        List listAsList = Arrays.asList("#EOF", "#Language", "#TagLine", "#FeatureLine", "#Comment", "#Empty");
        ParserException unexpectedEOFException = token.isEOF() ? new ParserException.UnexpectedEOFException(token, listAsList, "State: 0 - Start") : new ParserException.UnexpectedTokenException(token, listAsList, "State: 0 - Start");
        if (this.stopAtFirstError) {
            throw unexpectedEOFException;
        }
        addError(parserContext, unexpectedEOFException);
        return 0;
    }

    private int matchTokenAt_1(Token token, ParserContext parserContext) {
        if (match_TagLine(parserContext, token)) {
            startRule(parserContext, RuleType.Tags);
            build(parserContext, token);
            return 2;
        }
        if (match_FeatureLine(parserContext, token)) {
            build(parserContext, token);
            return 3;
        }
        if (match_Comment(parserContext, token)) {
            build(parserContext, token);
            return 1;
        }
        if (match_Empty(parserContext, token)) {
            build(parserContext, token);
            return 1;
        }
        token.detach();
        List listAsList = Arrays.asList("#TagLine", "#FeatureLine", "#Comment", "#Empty");
        ParserException unexpectedEOFException = token.isEOF() ? new ParserException.UnexpectedEOFException(token, listAsList, "State: 1 - GherkinDocument:0>Feature:0>Feature_Header:0>#Language:0") : new ParserException.UnexpectedTokenException(token, listAsList, "State: 1 - GherkinDocument:0>Feature:0>Feature_Header:0>#Language:0");
        if (this.stopAtFirstError) {
            throw unexpectedEOFException;
        }
        addError(parserContext, unexpectedEOFException);
        return 1;
    }

    private int matchTokenAt_2(Token token, ParserContext parserContext) {
        if (match_TagLine(parserContext, token)) {
            build(parserContext, token);
            return 2;
        }
        if (match_FeatureLine(parserContext, token)) {
            endRule(parserContext, RuleType.Tags);
            build(parserContext, token);
            return 3;
        }
        if (match_Comment(parserContext, token)) {
            build(parserContext, token);
            return 2;
        }
        if (match_Empty(parserContext, token)) {
            build(parserContext, token);
            return 2;
        }
        token.detach();
        List listAsList = Arrays.asList("#TagLine", "#FeatureLine", "#Comment", "#Empty");
        ParserException unexpectedEOFException = token.isEOF() ? new ParserException.UnexpectedEOFException(token, listAsList, "State: 2 - GherkinDocument:0>Feature:0>Feature_Header:1>Tags:0>#TagLine:0") : new ParserException.UnexpectedTokenException(token, listAsList, "State: 2 - GherkinDocument:0>Feature:0>Feature_Header:1>Tags:0>#TagLine:0");
        if (this.stopAtFirstError) {
            throw unexpectedEOFException;
        }
        addError(parserContext, unexpectedEOFException);
        return 2;
    }

    private int matchTokenAt_3(Token token, ParserContext parserContext) {
        if (match_EOF(parserContext, token)) {
            endRule(parserContext, RuleType.Feature_Header);
            endRule(parserContext, RuleType.Feature);
            build(parserContext, token);
            return 27;
        }
        if (match_Empty(parserContext, token)) {
            build(parserContext, token);
            return 3;
        }
        if (match_Comment(parserContext, token)) {
            build(parserContext, token);
            return 5;
        }
        if (match_BackgroundLine(parserContext, token)) {
            endRule(parserContext, RuleType.Feature_Header);
            startRule(parserContext, RuleType.Background);
            build(parserContext, token);
            return 6;
        }
        if (match_TagLine(parserContext, token)) {
            endRule(parserContext, RuleType.Feature_Header);
            startRule(parserContext, RuleType.Scenario_Definition);
            startRule(parserContext, RuleType.Tags);
            build(parserContext, token);
            return 11;
        }
        if (match_ScenarioLine(parserContext, token)) {
            endRule(parserContext, RuleType.Feature_Header);
            startRule(parserContext, RuleType.Scenario_Definition);
            startRule(parserContext, RuleType.Scenario);
            build(parserContext, token);
            return 12;
        }
        if (match_ScenarioOutlineLine(parserContext, token)) {
            endRule(parserContext, RuleType.Feature_Header);
            startRule(parserContext, RuleType.Scenario_Definition);
            startRule(parserContext, RuleType.ScenarioOutline);
            build(parserContext, token);
            return 17;
        }
        if (match_Other(parserContext, token)) {
            startRule(parserContext, RuleType.Description);
            build(parserContext, token);
            return 4;
        }
        token.detach();
        List listAsList = Arrays.asList("#EOF", "#Empty", "#Comment", "#BackgroundLine", "#TagLine", "#ScenarioLine", "#ScenarioOutlineLine", "#Other");
        ParserException unexpectedEOFException = token.isEOF() ? new ParserException.UnexpectedEOFException(token, listAsList, "State: 3 - GherkinDocument:0>Feature:0>Feature_Header:2>#FeatureLine:0") : new ParserException.UnexpectedTokenException(token, listAsList, "State: 3 - GherkinDocument:0>Feature:0>Feature_Header:2>#FeatureLine:0");
        if (this.stopAtFirstError) {
            throw unexpectedEOFException;
        }
        addError(parserContext, unexpectedEOFException);
        return 3;
    }

    private int matchTokenAt_4(Token token, ParserContext parserContext) {
        if (match_EOF(parserContext, token)) {
            endRule(parserContext, RuleType.Description);
            endRule(parserContext, RuleType.Feature_Header);
            endRule(parserContext, RuleType.Feature);
            build(parserContext, token);
            return 27;
        }
        if (match_Comment(parserContext, token)) {
            endRule(parserContext, RuleType.Description);
            build(parserContext, token);
            return 5;
        }
        if (match_BackgroundLine(parserContext, token)) {
            endRule(parserContext, RuleType.Description);
            endRule(parserContext, RuleType.Feature_Header);
            startRule(parserContext, RuleType.Background);
            build(parserContext, token);
            return 6;
        }
        if (match_TagLine(parserContext, token)) {
            endRule(parserContext, RuleType.Description);
            endRule(parserContext, RuleType.Feature_Header);
            startRule(parserContext, RuleType.Scenario_Definition);
            startRule(parserContext, RuleType.Tags);
            build(parserContext, token);
            return 11;
        }
        if (match_ScenarioLine(parserContext, token)) {
            endRule(parserContext, RuleType.Description);
            endRule(parserContext, RuleType.Feature_Header);
            startRule(parserContext, RuleType.Scenario_Definition);
            startRule(parserContext, RuleType.Scenario);
            build(parserContext, token);
            return 12;
        }
        if (match_ScenarioOutlineLine(parserContext, token)) {
            endRule(parserContext, RuleType.Description);
            endRule(parserContext, RuleType.Feature_Header);
            startRule(parserContext, RuleType.Scenario_Definition);
            startRule(parserContext, RuleType.ScenarioOutline);
            build(parserContext, token);
            return 17;
        }
        if (match_Other(parserContext, token)) {
            build(parserContext, token);
            return 4;
        }
        token.detach();
        List listAsList = Arrays.asList("#EOF", "#Comment", "#BackgroundLine", "#TagLine", "#ScenarioLine", "#ScenarioOutlineLine", "#Other");
        ParserException unexpectedEOFException = token.isEOF() ? new ParserException.UnexpectedEOFException(token, listAsList, "State: 4 - GherkinDocument:0>Feature:0>Feature_Header:3>Description_Helper:1>Description:0>#Other:0") : new ParserException.UnexpectedTokenException(token, listAsList, "State: 4 - GherkinDocument:0>Feature:0>Feature_Header:3>Description_Helper:1>Description:0>#Other:0");
        if (this.stopAtFirstError) {
            throw unexpectedEOFException;
        }
        addError(parserContext, unexpectedEOFException);
        return 4;
    }

    private int matchTokenAt_5(Token token, ParserContext parserContext) {
        if (match_EOF(parserContext, token)) {
            endRule(parserContext, RuleType.Feature_Header);
            endRule(parserContext, RuleType.Feature);
            build(parserContext, token);
            return 27;
        }
        if (match_Comment(parserContext, token)) {
            build(parserContext, token);
            return 5;
        }
        if (match_BackgroundLine(parserContext, token)) {
            endRule(parserContext, RuleType.Feature_Header);
            startRule(parserContext, RuleType.Background);
            build(parserContext, token);
            return 6;
        }
        if (match_TagLine(parserContext, token)) {
            endRule(parserContext, RuleType.Feature_Header);
            startRule(parserContext, RuleType.Scenario_Definition);
            startRule(parserContext, RuleType.Tags);
            build(parserContext, token);
            return 11;
        }
        if (match_ScenarioLine(parserContext, token)) {
            endRule(parserContext, RuleType.Feature_Header);
            startRule(parserContext, RuleType.Scenario_Definition);
            startRule(parserContext, RuleType.Scenario);
            build(parserContext, token);
            return 12;
        }
        if (match_ScenarioOutlineLine(parserContext, token)) {
            endRule(parserContext, RuleType.Feature_Header);
            startRule(parserContext, RuleType.Scenario_Definition);
            startRule(parserContext, RuleType.ScenarioOutline);
            build(parserContext, token);
            return 17;
        }
        if (match_Empty(parserContext, token)) {
            build(parserContext, token);
            return 5;
        }
        token.detach();
        List listAsList = Arrays.asList("#EOF", "#Comment", "#BackgroundLine", "#TagLine", "#ScenarioLine", "#ScenarioOutlineLine", "#Empty");
        ParserException unexpectedEOFException = token.isEOF() ? new ParserException.UnexpectedEOFException(token, listAsList, "State: 5 - GherkinDocument:0>Feature:0>Feature_Header:3>Description_Helper:2>#Comment:0") : new ParserException.UnexpectedTokenException(token, listAsList, "State: 5 - GherkinDocument:0>Feature:0>Feature_Header:3>Description_Helper:2>#Comment:0");
        if (this.stopAtFirstError) {
            throw unexpectedEOFException;
        }
        addError(parserContext, unexpectedEOFException);
        return 5;
    }

    private int matchTokenAt_6(Token token, ParserContext parserContext) {
        if (match_EOF(parserContext, token)) {
            endRule(parserContext, RuleType.Background);
            endRule(parserContext, RuleType.Feature);
            build(parserContext, token);
            return 27;
        }
        if (match_Empty(parserContext, token)) {
            build(parserContext, token);
            return 6;
        }
        if (match_Comment(parserContext, token)) {
            build(parserContext, token);
            return 8;
        }
        if (match_StepLine(parserContext, token)) {
            startRule(parserContext, RuleType.Step);
            build(parserContext, token);
            return 9;
        }
        if (match_TagLine(parserContext, token)) {
            endRule(parserContext, RuleType.Background);
            startRule(parserContext, RuleType.Scenario_Definition);
            startRule(parserContext, RuleType.Tags);
            build(parserContext, token);
            return 11;
        }
        if (match_ScenarioLine(parserContext, token)) {
            endRule(parserContext, RuleType.Background);
            startRule(parserContext, RuleType.Scenario_Definition);
            startRule(parserContext, RuleType.Scenario);
            build(parserContext, token);
            return 12;
        }
        if (match_ScenarioOutlineLine(parserContext, token)) {
            endRule(parserContext, RuleType.Background);
            startRule(parserContext, RuleType.Scenario_Definition);
            startRule(parserContext, RuleType.ScenarioOutline);
            build(parserContext, token);
            return 17;
        }
        if (match_Other(parserContext, token)) {
            startRule(parserContext, RuleType.Description);
            build(parserContext, token);
            return 7;
        }
        token.detach();
        List listAsList = Arrays.asList("#EOF", "#Empty", "#Comment", "#StepLine", "#TagLine", "#ScenarioLine", "#ScenarioOutlineLine", "#Other");
        ParserException unexpectedEOFException = token.isEOF() ? new ParserException.UnexpectedEOFException(token, listAsList, "State: 6 - GherkinDocument:0>Feature:1>Background:0>#BackgroundLine:0") : new ParserException.UnexpectedTokenException(token, listAsList, "State: 6 - GherkinDocument:0>Feature:1>Background:0>#BackgroundLine:0");
        if (this.stopAtFirstError) {
            throw unexpectedEOFException;
        }
        addError(parserContext, unexpectedEOFException);
        return 6;
    }

    private int matchTokenAt_7(Token token, ParserContext parserContext) {
        if (match_EOF(parserContext, token)) {
            endRule(parserContext, RuleType.Description);
            endRule(parserContext, RuleType.Background);
            endRule(parserContext, RuleType.Feature);
            build(parserContext, token);
            return 27;
        }
        if (match_Comment(parserContext, token)) {
            endRule(parserContext, RuleType.Description);
            build(parserContext, token);
            return 8;
        }
        if (match_StepLine(parserContext, token)) {
            endRule(parserContext, RuleType.Description);
            startRule(parserContext, RuleType.Step);
            build(parserContext, token);
            return 9;
        }
        if (match_TagLine(parserContext, token)) {
            endRule(parserContext, RuleType.Description);
            endRule(parserContext, RuleType.Background);
            startRule(parserContext, RuleType.Scenario_Definition);
            startRule(parserContext, RuleType.Tags);
            build(parserContext, token);
            return 11;
        }
        if (match_ScenarioLine(parserContext, token)) {
            endRule(parserContext, RuleType.Description);
            endRule(parserContext, RuleType.Background);
            startRule(parserContext, RuleType.Scenario_Definition);
            startRule(parserContext, RuleType.Scenario);
            build(parserContext, token);
            return 12;
        }
        if (match_ScenarioOutlineLine(parserContext, token)) {
            endRule(parserContext, RuleType.Description);
            endRule(parserContext, RuleType.Background);
            startRule(parserContext, RuleType.Scenario_Definition);
            startRule(parserContext, RuleType.ScenarioOutline);
            build(parserContext, token);
            return 17;
        }
        if (match_Other(parserContext, token)) {
            build(parserContext, token);
            return 7;
        }
        token.detach();
        List listAsList = Arrays.asList("#EOF", "#Comment", "#StepLine", "#TagLine", "#ScenarioLine", "#ScenarioOutlineLine", "#Other");
        ParserException unexpectedEOFException = token.isEOF() ? new ParserException.UnexpectedEOFException(token, listAsList, "State: 7 - GherkinDocument:0>Feature:1>Background:1>Description_Helper:1>Description:0>#Other:0") : new ParserException.UnexpectedTokenException(token, listAsList, "State: 7 - GherkinDocument:0>Feature:1>Background:1>Description_Helper:1>Description:0>#Other:0");
        if (this.stopAtFirstError) {
            throw unexpectedEOFException;
        }
        addError(parserContext, unexpectedEOFException);
        return 7;
    }

    private int matchTokenAt_8(Token token, ParserContext parserContext) {
        if (match_EOF(parserContext, token)) {
            endRule(parserContext, RuleType.Background);
            endRule(parserContext, RuleType.Feature);
            build(parserContext, token);
            return 27;
        }
        if (match_Comment(parserContext, token)) {
            build(parserContext, token);
            return 8;
        }
        if (match_StepLine(parserContext, token)) {
            startRule(parserContext, RuleType.Step);
            build(parserContext, token);
            return 9;
        }
        if (match_TagLine(parserContext, token)) {
            endRule(parserContext, RuleType.Background);
            startRule(parserContext, RuleType.Scenario_Definition);
            startRule(parserContext, RuleType.Tags);
            build(parserContext, token);
            return 11;
        }
        if (match_ScenarioLine(parserContext, token)) {
            endRule(parserContext, RuleType.Background);
            startRule(parserContext, RuleType.Scenario_Definition);
            startRule(parserContext, RuleType.Scenario);
            build(parserContext, token);
            return 12;
        }
        if (match_ScenarioOutlineLine(parserContext, token)) {
            endRule(parserContext, RuleType.Background);
            startRule(parserContext, RuleType.Scenario_Definition);
            startRule(parserContext, RuleType.ScenarioOutline);
            build(parserContext, token);
            return 17;
        }
        if (match_Empty(parserContext, token)) {
            build(parserContext, token);
            return 8;
        }
        token.detach();
        List listAsList = Arrays.asList("#EOF", "#Comment", "#StepLine", "#TagLine", "#ScenarioLine", "#ScenarioOutlineLine", "#Empty");
        ParserException unexpectedEOFException = token.isEOF() ? new ParserException.UnexpectedEOFException(token, listAsList, "State: 8 - GherkinDocument:0>Feature:1>Background:1>Description_Helper:2>#Comment:0") : new ParserException.UnexpectedTokenException(token, listAsList, "State: 8 - GherkinDocument:0>Feature:1>Background:1>Description_Helper:2>#Comment:0");
        if (this.stopAtFirstError) {
            throw unexpectedEOFException;
        }
        addError(parserContext, unexpectedEOFException);
        return 8;
    }

    private int matchTokenAt_9(Token token, ParserContext parserContext) {
        if (match_EOF(parserContext, token)) {
            endRule(parserContext, RuleType.Step);
            endRule(parserContext, RuleType.Background);
            endRule(parserContext, RuleType.Feature);
            build(parserContext, token);
            return 27;
        }
        if (match_TableRow(parserContext, token)) {
            startRule(parserContext, RuleType.DataTable);
            build(parserContext, token);
            return 10;
        }
        if (match_DocStringSeparator(parserContext, token)) {
            startRule(parserContext, RuleType.DocString);
            build(parserContext, token);
            return 32;
        }
        if (match_StepLine(parserContext, token)) {
            RuleType ruleType = RuleType.Step;
            endRule(parserContext, ruleType);
            startRule(parserContext, ruleType);
            build(parserContext, token);
            return 9;
        }
        if (match_TagLine(parserContext, token)) {
            endRule(parserContext, RuleType.Step);
            endRule(parserContext, RuleType.Background);
            startRule(parserContext, RuleType.Scenario_Definition);
            startRule(parserContext, RuleType.Tags);
            build(parserContext, token);
            return 11;
        }
        if (match_ScenarioLine(parserContext, token)) {
            endRule(parserContext, RuleType.Step);
            endRule(parserContext, RuleType.Background);
            startRule(parserContext, RuleType.Scenario_Definition);
            startRule(parserContext, RuleType.Scenario);
            build(parserContext, token);
            return 12;
        }
        if (match_ScenarioOutlineLine(parserContext, token)) {
            endRule(parserContext, RuleType.Step);
            endRule(parserContext, RuleType.Background);
            startRule(parserContext, RuleType.Scenario_Definition);
            startRule(parserContext, RuleType.ScenarioOutline);
            build(parserContext, token);
            return 17;
        }
        if (match_Comment(parserContext, token)) {
            build(parserContext, token);
            return 9;
        }
        if (match_Empty(parserContext, token)) {
            build(parserContext, token);
            return 9;
        }
        token.detach();
        List listAsList = Arrays.asList("#EOF", "#TableRow", "#DocStringSeparator", "#StepLine", "#TagLine", "#ScenarioLine", "#ScenarioOutlineLine", "#Comment", "#Empty");
        ParserException unexpectedEOFException = token.isEOF() ? new ParserException.UnexpectedEOFException(token, listAsList, "State: 9 - GherkinDocument:0>Feature:1>Background:2>Step:0>#StepLine:0") : new ParserException.UnexpectedTokenException(token, listAsList, "State: 9 - GherkinDocument:0>Feature:1>Background:2>Step:0>#StepLine:0");
        if (this.stopAtFirstError) {
            throw unexpectedEOFException;
        }
        addError(parserContext, unexpectedEOFException);
        return 9;
    }

    private int matchTokenAt_10(Token token, ParserContext parserContext) {
        if (match_EOF(parserContext, token)) {
            endRule(parserContext, RuleType.DataTable);
            endRule(parserContext, RuleType.Step);
            endRule(parserContext, RuleType.Background);
            endRule(parserContext, RuleType.Feature);
            build(parserContext, token);
            return 27;
        }
        if (match_TableRow(parserContext, token)) {
            build(parserContext, token);
            return 10;
        }
        if (match_StepLine(parserContext, token)) {
            endRule(parserContext, RuleType.DataTable);
            RuleType ruleType = RuleType.Step;
            endRule(parserContext, ruleType);
            startRule(parserContext, ruleType);
            build(parserContext, token);
            return 9;
        }
        if (match_TagLine(parserContext, token)) {
            endRule(parserContext, RuleType.DataTable);
            endRule(parserContext, RuleType.Step);
            endRule(parserContext, RuleType.Background);
            startRule(parserContext, RuleType.Scenario_Definition);
            startRule(parserContext, RuleType.Tags);
            build(parserContext, token);
            return 11;
        }
        if (match_ScenarioLine(parserContext, token)) {
            endRule(parserContext, RuleType.DataTable);
            endRule(parserContext, RuleType.Step);
            endRule(parserContext, RuleType.Background);
            startRule(parserContext, RuleType.Scenario_Definition);
            startRule(parserContext, RuleType.Scenario);
            build(parserContext, token);
            return 12;
        }
        if (match_ScenarioOutlineLine(parserContext, token)) {
            endRule(parserContext, RuleType.DataTable);
            endRule(parserContext, RuleType.Step);
            endRule(parserContext, RuleType.Background);
            startRule(parserContext, RuleType.Scenario_Definition);
            startRule(parserContext, RuleType.ScenarioOutline);
            build(parserContext, token);
            return 17;
        }
        if (match_Comment(parserContext, token)) {
            build(parserContext, token);
            return 10;
        }
        if (match_Empty(parserContext, token)) {
            build(parserContext, token);
            return 10;
        }
        token.detach();
        List listAsList = Arrays.asList("#EOF", "#TableRow", "#StepLine", "#TagLine", "#ScenarioLine", "#ScenarioOutlineLine", "#Comment", "#Empty");
        ParserException unexpectedEOFException = token.isEOF() ? new ParserException.UnexpectedEOFException(token, listAsList, "State: 10 - GherkinDocument:0>Feature:1>Background:2>Step:1>Step_Arg:0>__alt1:0>DataTable:0>#TableRow:0") : new ParserException.UnexpectedTokenException(token, listAsList, "State: 10 - GherkinDocument:0>Feature:1>Background:2>Step:1>Step_Arg:0>__alt1:0>DataTable:0>#TableRow:0");
        if (this.stopAtFirstError) {
            throw unexpectedEOFException;
        }
        addError(parserContext, unexpectedEOFException);
        return 10;
    }

    private int matchTokenAt_11(Token token, ParserContext parserContext) {
        if (match_TagLine(parserContext, token)) {
            build(parserContext, token);
            return 11;
        }
        if (match_ScenarioLine(parserContext, token)) {
            endRule(parserContext, RuleType.Tags);
            startRule(parserContext, RuleType.Scenario);
            build(parserContext, token);
            return 12;
        }
        if (match_ScenarioOutlineLine(parserContext, token)) {
            endRule(parserContext, RuleType.Tags);
            startRule(parserContext, RuleType.ScenarioOutline);
            build(parserContext, token);
            return 17;
        }
        if (match_Comment(parserContext, token)) {
            build(parserContext, token);
            return 11;
        }
        if (match_Empty(parserContext, token)) {
            build(parserContext, token);
            return 11;
        }
        token.detach();
        List listAsList = Arrays.asList("#TagLine", "#ScenarioLine", "#ScenarioOutlineLine", "#Comment", "#Empty");
        ParserException unexpectedEOFException = token.isEOF() ? new ParserException.UnexpectedEOFException(token, listAsList, "State: 11 - GherkinDocument:0>Feature:2>Scenario_Definition:0>Tags:0>#TagLine:0") : new ParserException.UnexpectedTokenException(token, listAsList, "State: 11 - GherkinDocument:0>Feature:2>Scenario_Definition:0>Tags:0>#TagLine:0");
        if (this.stopAtFirstError) {
            throw unexpectedEOFException;
        }
        addError(parserContext, unexpectedEOFException);
        return 11;
    }

    private int matchTokenAt_12(Token token, ParserContext parserContext) {
        if (match_EOF(parserContext, token)) {
            endRule(parserContext, RuleType.Scenario);
            endRule(parserContext, RuleType.Scenario_Definition);
            endRule(parserContext, RuleType.Feature);
            build(parserContext, token);
            return 27;
        }
        if (match_Empty(parserContext, token)) {
            build(parserContext, token);
            return 12;
        }
        if (match_Comment(parserContext, token)) {
            build(parserContext, token);
            return 14;
        }
        if (match_StepLine(parserContext, token)) {
            startRule(parserContext, RuleType.Step);
            build(parserContext, token);
            return 15;
        }
        if (match_TagLine(parserContext, token)) {
            endRule(parserContext, RuleType.Scenario);
            RuleType ruleType = RuleType.Scenario_Definition;
            endRule(parserContext, ruleType);
            startRule(parserContext, ruleType);
            startRule(parserContext, RuleType.Tags);
            build(parserContext, token);
            return 11;
        }
        if (match_ScenarioLine(parserContext, token)) {
            RuleType ruleType2 = RuleType.Scenario;
            endRule(parserContext, ruleType2);
            RuleType ruleType3 = RuleType.Scenario_Definition;
            endRule(parserContext, ruleType3);
            startRule(parserContext, ruleType3);
            startRule(parserContext, ruleType2);
            build(parserContext, token);
            return 12;
        }
        if (match_ScenarioOutlineLine(parserContext, token)) {
            endRule(parserContext, RuleType.Scenario);
            RuleType ruleType4 = RuleType.Scenario_Definition;
            endRule(parserContext, ruleType4);
            startRule(parserContext, ruleType4);
            startRule(parserContext, RuleType.ScenarioOutline);
            build(parserContext, token);
            return 17;
        }
        if (match_Other(parserContext, token)) {
            startRule(parserContext, RuleType.Description);
            build(parserContext, token);
            return 13;
        }
        token.detach();
        List listAsList = Arrays.asList("#EOF", "#Empty", "#Comment", "#StepLine", "#TagLine", "#ScenarioLine", "#ScenarioOutlineLine", "#Other");
        ParserException unexpectedEOFException = token.isEOF() ? new ParserException.UnexpectedEOFException(token, listAsList, "State: 12 - GherkinDocument:0>Feature:2>Scenario_Definition:1>__alt0:0>Scenario:0>#ScenarioLine:0") : new ParserException.UnexpectedTokenException(token, listAsList, "State: 12 - GherkinDocument:0>Feature:2>Scenario_Definition:1>__alt0:0>Scenario:0>#ScenarioLine:0");
        if (this.stopAtFirstError) {
            throw unexpectedEOFException;
        }
        addError(parserContext, unexpectedEOFException);
        return 12;
    }

    private int matchTokenAt_13(Token token, ParserContext parserContext) {
        if (match_EOF(parserContext, token)) {
            endRule(parserContext, RuleType.Description);
            endRule(parserContext, RuleType.Scenario);
            endRule(parserContext, RuleType.Scenario_Definition);
            endRule(parserContext, RuleType.Feature);
            build(parserContext, token);
            return 27;
        }
        if (match_Comment(parserContext, token)) {
            endRule(parserContext, RuleType.Description);
            build(parserContext, token);
            return 14;
        }
        if (match_StepLine(parserContext, token)) {
            endRule(parserContext, RuleType.Description);
            startRule(parserContext, RuleType.Step);
            build(parserContext, token);
            return 15;
        }
        if (match_TagLine(parserContext, token)) {
            endRule(parserContext, RuleType.Description);
            endRule(parserContext, RuleType.Scenario);
            RuleType ruleType = RuleType.Scenario_Definition;
            endRule(parserContext, ruleType);
            startRule(parserContext, ruleType);
            startRule(parserContext, RuleType.Tags);
            build(parserContext, token);
            return 11;
        }
        if (match_ScenarioLine(parserContext, token)) {
            endRule(parserContext, RuleType.Description);
            RuleType ruleType2 = RuleType.Scenario;
            endRule(parserContext, ruleType2);
            RuleType ruleType3 = RuleType.Scenario_Definition;
            endRule(parserContext, ruleType3);
            startRule(parserContext, ruleType3);
            startRule(parserContext, ruleType2);
            build(parserContext, token);
            return 12;
        }
        if (match_ScenarioOutlineLine(parserContext, token)) {
            endRule(parserContext, RuleType.Description);
            endRule(parserContext, RuleType.Scenario);
            RuleType ruleType4 = RuleType.Scenario_Definition;
            endRule(parserContext, ruleType4);
            startRule(parserContext, ruleType4);
            startRule(parserContext, RuleType.ScenarioOutline);
            build(parserContext, token);
            return 17;
        }
        if (match_Other(parserContext, token)) {
            build(parserContext, token);
            return 13;
        }
        token.detach();
        List listAsList = Arrays.asList("#EOF", "#Comment", "#StepLine", "#TagLine", "#ScenarioLine", "#ScenarioOutlineLine", "#Other");
        ParserException unexpectedEOFException = token.isEOF() ? new ParserException.UnexpectedEOFException(token, listAsList, "State: 13 - GherkinDocument:0>Feature:2>Scenario_Definition:1>__alt0:0>Scenario:1>Description_Helper:1>Description:0>#Other:0") : new ParserException.UnexpectedTokenException(token, listAsList, "State: 13 - GherkinDocument:0>Feature:2>Scenario_Definition:1>__alt0:0>Scenario:1>Description_Helper:1>Description:0>#Other:0");
        if (this.stopAtFirstError) {
            throw unexpectedEOFException;
        }
        addError(parserContext, unexpectedEOFException);
        return 13;
    }

    private int matchTokenAt_14(Token token, ParserContext parserContext) {
        if (match_EOF(parserContext, token)) {
            endRule(parserContext, RuleType.Scenario);
            endRule(parserContext, RuleType.Scenario_Definition);
            endRule(parserContext, RuleType.Feature);
            build(parserContext, token);
            return 27;
        }
        if (match_Comment(parserContext, token)) {
            build(parserContext, token);
            return 14;
        }
        if (match_StepLine(parserContext, token)) {
            startRule(parserContext, RuleType.Step);
            build(parserContext, token);
            return 15;
        }
        if (match_TagLine(parserContext, token)) {
            endRule(parserContext, RuleType.Scenario);
            RuleType ruleType = RuleType.Scenario_Definition;
            endRule(parserContext, ruleType);
            startRule(parserContext, ruleType);
            startRule(parserContext, RuleType.Tags);
            build(parserContext, token);
            return 11;
        }
        if (match_ScenarioLine(parserContext, token)) {
            RuleType ruleType2 = RuleType.Scenario;
            endRule(parserContext, ruleType2);
            RuleType ruleType3 = RuleType.Scenario_Definition;
            endRule(parserContext, ruleType3);
            startRule(parserContext, ruleType3);
            startRule(parserContext, ruleType2);
            build(parserContext, token);
            return 12;
        }
        if (match_ScenarioOutlineLine(parserContext, token)) {
            endRule(parserContext, RuleType.Scenario);
            RuleType ruleType4 = RuleType.Scenario_Definition;
            endRule(parserContext, ruleType4);
            startRule(parserContext, ruleType4);
            startRule(parserContext, RuleType.ScenarioOutline);
            build(parserContext, token);
            return 17;
        }
        if (match_Empty(parserContext, token)) {
            build(parserContext, token);
            return 14;
        }
        token.detach();
        List listAsList = Arrays.asList("#EOF", "#Comment", "#StepLine", "#TagLine", "#ScenarioLine", "#ScenarioOutlineLine", "#Empty");
        ParserException unexpectedEOFException = token.isEOF() ? new ParserException.UnexpectedEOFException(token, listAsList, "State: 14 - GherkinDocument:0>Feature:2>Scenario_Definition:1>__alt0:0>Scenario:1>Description_Helper:2>#Comment:0") : new ParserException.UnexpectedTokenException(token, listAsList, "State: 14 - GherkinDocument:0>Feature:2>Scenario_Definition:1>__alt0:0>Scenario:1>Description_Helper:2>#Comment:0");
        if (this.stopAtFirstError) {
            throw unexpectedEOFException;
        }
        addError(parserContext, unexpectedEOFException);
        return 14;
    }

    private int matchTokenAt_15(Token token, ParserContext parserContext) {
        if (match_EOF(parserContext, token)) {
            endRule(parserContext, RuleType.Step);
            endRule(parserContext, RuleType.Scenario);
            endRule(parserContext, RuleType.Scenario_Definition);
            endRule(parserContext, RuleType.Feature);
            build(parserContext, token);
            return 27;
        }
        if (match_TableRow(parserContext, token)) {
            startRule(parserContext, RuleType.DataTable);
            build(parserContext, token);
            return 16;
        }
        if (match_DocStringSeparator(parserContext, token)) {
            startRule(parserContext, RuleType.DocString);
            build(parserContext, token);
            return 30;
        }
        if (match_StepLine(parserContext, token)) {
            RuleType ruleType = RuleType.Step;
            endRule(parserContext, ruleType);
            startRule(parserContext, ruleType);
            build(parserContext, token);
            return 15;
        }
        if (match_TagLine(parserContext, token)) {
            endRule(parserContext, RuleType.Step);
            endRule(parserContext, RuleType.Scenario);
            RuleType ruleType2 = RuleType.Scenario_Definition;
            endRule(parserContext, ruleType2);
            startRule(parserContext, ruleType2);
            startRule(parserContext, RuleType.Tags);
            build(parserContext, token);
            return 11;
        }
        if (match_ScenarioLine(parserContext, token)) {
            endRule(parserContext, RuleType.Step);
            RuleType ruleType3 = RuleType.Scenario;
            endRule(parserContext, ruleType3);
            RuleType ruleType4 = RuleType.Scenario_Definition;
            endRule(parserContext, ruleType4);
            startRule(parserContext, ruleType4);
            startRule(parserContext, ruleType3);
            build(parserContext, token);
            return 12;
        }
        if (match_ScenarioOutlineLine(parserContext, token)) {
            endRule(parserContext, RuleType.Step);
            endRule(parserContext, RuleType.Scenario);
            RuleType ruleType5 = RuleType.Scenario_Definition;
            endRule(parserContext, ruleType5);
            startRule(parserContext, ruleType5);
            startRule(parserContext, RuleType.ScenarioOutline);
            build(parserContext, token);
            return 17;
        }
        if (match_Comment(parserContext, token)) {
            build(parserContext, token);
            return 15;
        }
        if (match_Empty(parserContext, token)) {
            build(parserContext, token);
            return 15;
        }
        token.detach();
        List listAsList = Arrays.asList("#EOF", "#TableRow", "#DocStringSeparator", "#StepLine", "#TagLine", "#ScenarioLine", "#ScenarioOutlineLine", "#Comment", "#Empty");
        ParserException unexpectedEOFException = token.isEOF() ? new ParserException.UnexpectedEOFException(token, listAsList, "State: 15 - GherkinDocument:0>Feature:2>Scenario_Definition:1>__alt0:0>Scenario:2>Step:0>#StepLine:0") : new ParserException.UnexpectedTokenException(token, listAsList, "State: 15 - GherkinDocument:0>Feature:2>Scenario_Definition:1>__alt0:0>Scenario:2>Step:0>#StepLine:0");
        if (this.stopAtFirstError) {
            throw unexpectedEOFException;
        }
        addError(parserContext, unexpectedEOFException);
        return 15;
    }

    private int matchTokenAt_16(Token token, ParserContext parserContext) {
        if (match_EOF(parserContext, token)) {
            endRule(parserContext, RuleType.DataTable);
            endRule(parserContext, RuleType.Step);
            endRule(parserContext, RuleType.Scenario);
            endRule(parserContext, RuleType.Scenario_Definition);
            endRule(parserContext, RuleType.Feature);
            build(parserContext, token);
            return 27;
        }
        if (match_TableRow(parserContext, token)) {
            build(parserContext, token);
            return 16;
        }
        if (match_StepLine(parserContext, token)) {
            endRule(parserContext, RuleType.DataTable);
            RuleType ruleType = RuleType.Step;
            endRule(parserContext, ruleType);
            startRule(parserContext, ruleType);
            build(parserContext, token);
            return 15;
        }
        if (match_TagLine(parserContext, token)) {
            endRule(parserContext, RuleType.DataTable);
            endRule(parserContext, RuleType.Step);
            endRule(parserContext, RuleType.Scenario);
            RuleType ruleType2 = RuleType.Scenario_Definition;
            endRule(parserContext, ruleType2);
            startRule(parserContext, ruleType2);
            startRule(parserContext, RuleType.Tags);
            build(parserContext, token);
            return 11;
        }
        if (match_ScenarioLine(parserContext, token)) {
            endRule(parserContext, RuleType.DataTable);
            endRule(parserContext, RuleType.Step);
            RuleType ruleType3 = RuleType.Scenario;
            endRule(parserContext, ruleType3);
            RuleType ruleType4 = RuleType.Scenario_Definition;
            endRule(parserContext, ruleType4);
            startRule(parserContext, ruleType4);
            startRule(parserContext, ruleType3);
            build(parserContext, token);
            return 12;
        }
        if (match_ScenarioOutlineLine(parserContext, token)) {
            endRule(parserContext, RuleType.DataTable);
            endRule(parserContext, RuleType.Step);
            endRule(parserContext, RuleType.Scenario);
            RuleType ruleType5 = RuleType.Scenario_Definition;
            endRule(parserContext, ruleType5);
            startRule(parserContext, ruleType5);
            startRule(parserContext, RuleType.ScenarioOutline);
            build(parserContext, token);
            return 17;
        }
        if (match_Comment(parserContext, token)) {
            build(parserContext, token);
            return 16;
        }
        if (match_Empty(parserContext, token)) {
            build(parserContext, token);
            return 16;
        }
        token.detach();
        List listAsList = Arrays.asList("#EOF", "#TableRow", "#StepLine", "#TagLine", "#ScenarioLine", "#ScenarioOutlineLine", "#Comment", "#Empty");
        ParserException unexpectedEOFException = token.isEOF() ? new ParserException.UnexpectedEOFException(token, listAsList, "State: 16 - GherkinDocument:0>Feature:2>Scenario_Definition:1>__alt0:0>Scenario:2>Step:1>Step_Arg:0>__alt1:0>DataTable:0>#TableRow:0") : new ParserException.UnexpectedTokenException(token, listAsList, "State: 16 - GherkinDocument:0>Feature:2>Scenario_Definition:1>__alt0:0>Scenario:2>Step:1>Step_Arg:0>__alt1:0>DataTable:0>#TableRow:0");
        if (this.stopAtFirstError) {
            throw unexpectedEOFException;
        }
        addError(parserContext, unexpectedEOFException);
        return 16;
    }

    private int matchTokenAt_17(Token token, ParserContext parserContext) {
        if (match_EOF(parserContext, token)) {
            endRule(parserContext, RuleType.ScenarioOutline);
            endRule(parserContext, RuleType.Scenario_Definition);
            endRule(parserContext, RuleType.Feature);
            build(parserContext, token);
            return 27;
        }
        if (match_Empty(parserContext, token)) {
            build(parserContext, token);
            return 17;
        }
        if (match_Comment(parserContext, token)) {
            build(parserContext, token);
            return 19;
        }
        if (match_StepLine(parserContext, token)) {
            startRule(parserContext, RuleType.Step);
            build(parserContext, token);
            return 20;
        }
        if (match_TagLine(parserContext, token) && lookahead_0(parserContext, token)) {
            startRule(parserContext, RuleType.Examples_Definition);
            startRule(parserContext, RuleType.Tags);
            build(parserContext, token);
            return 22;
        }
        if (match_TagLine(parserContext, token)) {
            endRule(parserContext, RuleType.ScenarioOutline);
            RuleType ruleType = RuleType.Scenario_Definition;
            endRule(parserContext, ruleType);
            startRule(parserContext, ruleType);
            startRule(parserContext, RuleType.Tags);
            build(parserContext, token);
            return 11;
        }
        if (match_ExamplesLine(parserContext, token)) {
            startRule(parserContext, RuleType.Examples_Definition);
            startRule(parserContext, RuleType.Examples);
            build(parserContext, token);
            return 23;
        }
        if (match_ScenarioLine(parserContext, token)) {
            endRule(parserContext, RuleType.ScenarioOutline);
            RuleType ruleType2 = RuleType.Scenario_Definition;
            endRule(parserContext, ruleType2);
            startRule(parserContext, ruleType2);
            startRule(parserContext, RuleType.Scenario);
            build(parserContext, token);
            return 12;
        }
        if (match_ScenarioOutlineLine(parserContext, token)) {
            RuleType ruleType3 = RuleType.ScenarioOutline;
            endRule(parserContext, ruleType3);
            RuleType ruleType4 = RuleType.Scenario_Definition;
            endRule(parserContext, ruleType4);
            startRule(parserContext, ruleType4);
            startRule(parserContext, ruleType3);
            build(parserContext, token);
            return 17;
        }
        if (match_Other(parserContext, token)) {
            startRule(parserContext, RuleType.Description);
            build(parserContext, token);
            return 18;
        }
        token.detach();
        List listAsList = Arrays.asList("#EOF", "#Empty", "#Comment", "#StepLine", "#TagLine", "#ExamplesLine", "#ScenarioLine", "#ScenarioOutlineLine", "#Other");
        ParserException unexpectedEOFException = token.isEOF() ? new ParserException.UnexpectedEOFException(token, listAsList, "State: 17 - GherkinDocument:0>Feature:2>Scenario_Definition:1>__alt0:1>ScenarioOutline:0>#ScenarioOutlineLine:0") : new ParserException.UnexpectedTokenException(token, listAsList, "State: 17 - GherkinDocument:0>Feature:2>Scenario_Definition:1>__alt0:1>ScenarioOutline:0>#ScenarioOutlineLine:0");
        if (this.stopAtFirstError) {
            throw unexpectedEOFException;
        }
        addError(parserContext, unexpectedEOFException);
        return 17;
    }

    private int matchTokenAt_18(Token token, ParserContext parserContext) {
        if (match_EOF(parserContext, token)) {
            endRule(parserContext, RuleType.Description);
            endRule(parserContext, RuleType.ScenarioOutline);
            endRule(parserContext, RuleType.Scenario_Definition);
            endRule(parserContext, RuleType.Feature);
            build(parserContext, token);
            return 27;
        }
        if (match_Comment(parserContext, token)) {
            endRule(parserContext, RuleType.Description);
            build(parserContext, token);
            return 19;
        }
        if (match_StepLine(parserContext, token)) {
            endRule(parserContext, RuleType.Description);
            startRule(parserContext, RuleType.Step);
            build(parserContext, token);
            return 20;
        }
        if (match_TagLine(parserContext, token) && lookahead_0(parserContext, token)) {
            endRule(parserContext, RuleType.Description);
            startRule(parserContext, RuleType.Examples_Definition);
            startRule(parserContext, RuleType.Tags);
            build(parserContext, token);
            return 22;
        }
        if (match_TagLine(parserContext, token)) {
            endRule(parserContext, RuleType.Description);
            endRule(parserContext, RuleType.ScenarioOutline);
            RuleType ruleType = RuleType.Scenario_Definition;
            endRule(parserContext, ruleType);
            startRule(parserContext, ruleType);
            startRule(parserContext, RuleType.Tags);
            build(parserContext, token);
            return 11;
        }
        if (match_ExamplesLine(parserContext, token)) {
            endRule(parserContext, RuleType.Description);
            startRule(parserContext, RuleType.Examples_Definition);
            startRule(parserContext, RuleType.Examples);
            build(parserContext, token);
            return 23;
        }
        if (match_ScenarioLine(parserContext, token)) {
            endRule(parserContext, RuleType.Description);
            endRule(parserContext, RuleType.ScenarioOutline);
            RuleType ruleType2 = RuleType.Scenario_Definition;
            endRule(parserContext, ruleType2);
            startRule(parserContext, ruleType2);
            startRule(parserContext, RuleType.Scenario);
            build(parserContext, token);
            return 12;
        }
        if (match_ScenarioOutlineLine(parserContext, token)) {
            endRule(parserContext, RuleType.Description);
            RuleType ruleType3 = RuleType.ScenarioOutline;
            endRule(parserContext, ruleType3);
            RuleType ruleType4 = RuleType.Scenario_Definition;
            endRule(parserContext, ruleType4);
            startRule(parserContext, ruleType4);
            startRule(parserContext, ruleType3);
            build(parserContext, token);
            return 17;
        }
        if (match_Other(parserContext, token)) {
            build(parserContext, token);
            return 18;
        }
        token.detach();
        List listAsList = Arrays.asList("#EOF", "#Comment", "#StepLine", "#TagLine", "#ExamplesLine", "#ScenarioLine", "#ScenarioOutlineLine", "#Other");
        ParserException unexpectedEOFException = token.isEOF() ? new ParserException.UnexpectedEOFException(token, listAsList, "State: 18 - GherkinDocument:0>Feature:2>Scenario_Definition:1>__alt0:1>ScenarioOutline:1>Description_Helper:1>Description:0>#Other:0") : new ParserException.UnexpectedTokenException(token, listAsList, "State: 18 - GherkinDocument:0>Feature:2>Scenario_Definition:1>__alt0:1>ScenarioOutline:1>Description_Helper:1>Description:0>#Other:0");
        if (this.stopAtFirstError) {
            throw unexpectedEOFException;
        }
        addError(parserContext, unexpectedEOFException);
        return 18;
    }

    private int matchTokenAt_19(Token token, ParserContext parserContext) {
        if (match_EOF(parserContext, token)) {
            endRule(parserContext, RuleType.ScenarioOutline);
            endRule(parserContext, RuleType.Scenario_Definition);
            endRule(parserContext, RuleType.Feature);
            build(parserContext, token);
            return 27;
        }
        if (match_Comment(parserContext, token)) {
            build(parserContext, token);
            return 19;
        }
        if (match_StepLine(parserContext, token)) {
            startRule(parserContext, RuleType.Step);
            build(parserContext, token);
            return 20;
        }
        if (match_TagLine(parserContext, token) && lookahead_0(parserContext, token)) {
            startRule(parserContext, RuleType.Examples_Definition);
            startRule(parserContext, RuleType.Tags);
            build(parserContext, token);
            return 22;
        }
        if (match_TagLine(parserContext, token)) {
            endRule(parserContext, RuleType.ScenarioOutline);
            RuleType ruleType = RuleType.Scenario_Definition;
            endRule(parserContext, ruleType);
            startRule(parserContext, ruleType);
            startRule(parserContext, RuleType.Tags);
            build(parserContext, token);
            return 11;
        }
        if (match_ExamplesLine(parserContext, token)) {
            startRule(parserContext, RuleType.Examples_Definition);
            startRule(parserContext, RuleType.Examples);
            build(parserContext, token);
            return 23;
        }
        if (match_ScenarioLine(parserContext, token)) {
            endRule(parserContext, RuleType.ScenarioOutline);
            RuleType ruleType2 = RuleType.Scenario_Definition;
            endRule(parserContext, ruleType2);
            startRule(parserContext, ruleType2);
            startRule(parserContext, RuleType.Scenario);
            build(parserContext, token);
            return 12;
        }
        if (match_ScenarioOutlineLine(parserContext, token)) {
            RuleType ruleType3 = RuleType.ScenarioOutline;
            endRule(parserContext, ruleType3);
            RuleType ruleType4 = RuleType.Scenario_Definition;
            endRule(parserContext, ruleType4);
            startRule(parserContext, ruleType4);
            startRule(parserContext, ruleType3);
            build(parserContext, token);
            return 17;
        }
        if (match_Empty(parserContext, token)) {
            build(parserContext, token);
            return 19;
        }
        token.detach();
        List listAsList = Arrays.asList("#EOF", "#Comment", "#StepLine", "#TagLine", "#ExamplesLine", "#ScenarioLine", "#ScenarioOutlineLine", "#Empty");
        ParserException unexpectedEOFException = token.isEOF() ? new ParserException.UnexpectedEOFException(token, listAsList, "State: 19 - GherkinDocument:0>Feature:2>Scenario_Definition:1>__alt0:1>ScenarioOutline:1>Description_Helper:2>#Comment:0") : new ParserException.UnexpectedTokenException(token, listAsList, "State: 19 - GherkinDocument:0>Feature:2>Scenario_Definition:1>__alt0:1>ScenarioOutline:1>Description_Helper:2>#Comment:0");
        if (this.stopAtFirstError) {
            throw unexpectedEOFException;
        }
        addError(parserContext, unexpectedEOFException);
        return 19;
    }

    private int matchTokenAt_20(Token token, ParserContext parserContext) {
        if (match_EOF(parserContext, token)) {
            endRule(parserContext, RuleType.Step);
            endRule(parserContext, RuleType.ScenarioOutline);
            endRule(parserContext, RuleType.Scenario_Definition);
            endRule(parserContext, RuleType.Feature);
            build(parserContext, token);
            return 27;
        }
        if (match_TableRow(parserContext, token)) {
            startRule(parserContext, RuleType.DataTable);
            build(parserContext, token);
            return 21;
        }
        if (match_DocStringSeparator(parserContext, token)) {
            startRule(parserContext, RuleType.DocString);
            build(parserContext, token);
            return 28;
        }
        if (match_StepLine(parserContext, token)) {
            RuleType ruleType = RuleType.Step;
            endRule(parserContext, ruleType);
            startRule(parserContext, ruleType);
            build(parserContext, token);
            return 20;
        }
        if (match_TagLine(parserContext, token) && lookahead_0(parserContext, token)) {
            endRule(parserContext, RuleType.Step);
            startRule(parserContext, RuleType.Examples_Definition);
            startRule(parserContext, RuleType.Tags);
            build(parserContext, token);
            return 22;
        }
        if (match_TagLine(parserContext, token)) {
            endRule(parserContext, RuleType.Step);
            endRule(parserContext, RuleType.ScenarioOutline);
            RuleType ruleType2 = RuleType.Scenario_Definition;
            endRule(parserContext, ruleType2);
            startRule(parserContext, ruleType2);
            startRule(parserContext, RuleType.Tags);
            build(parserContext, token);
            return 11;
        }
        if (match_ExamplesLine(parserContext, token)) {
            endRule(parserContext, RuleType.Step);
            startRule(parserContext, RuleType.Examples_Definition);
            startRule(parserContext, RuleType.Examples);
            build(parserContext, token);
            return 23;
        }
        if (match_ScenarioLine(parserContext, token)) {
            endRule(parserContext, RuleType.Step);
            endRule(parserContext, RuleType.ScenarioOutline);
            RuleType ruleType3 = RuleType.Scenario_Definition;
            endRule(parserContext, ruleType3);
            startRule(parserContext, ruleType3);
            startRule(parserContext, RuleType.Scenario);
            build(parserContext, token);
            return 12;
        }
        if (match_ScenarioOutlineLine(parserContext, token)) {
            endRule(parserContext, RuleType.Step);
            RuleType ruleType4 = RuleType.ScenarioOutline;
            endRule(parserContext, ruleType4);
            RuleType ruleType5 = RuleType.Scenario_Definition;
            endRule(parserContext, ruleType5);
            startRule(parserContext, ruleType5);
            startRule(parserContext, ruleType4);
            build(parserContext, token);
            return 17;
        }
        if (match_Comment(parserContext, token)) {
            build(parserContext, token);
            return 20;
        }
        if (match_Empty(parserContext, token)) {
            build(parserContext, token);
            return 20;
        }
        token.detach();
        List listAsList = Arrays.asList("#EOF", "#TableRow", "#DocStringSeparator", "#StepLine", "#TagLine", "#ExamplesLine", "#ScenarioLine", "#ScenarioOutlineLine", "#Comment", "#Empty");
        ParserException unexpectedEOFException = token.isEOF() ? new ParserException.UnexpectedEOFException(token, listAsList, "State: 20 - GherkinDocument:0>Feature:2>Scenario_Definition:1>__alt0:1>ScenarioOutline:2>Step:0>#StepLine:0") : new ParserException.UnexpectedTokenException(token, listAsList, "State: 20 - GherkinDocument:0>Feature:2>Scenario_Definition:1>__alt0:1>ScenarioOutline:2>Step:0>#StepLine:0");
        if (this.stopAtFirstError) {
            throw unexpectedEOFException;
        }
        addError(parserContext, unexpectedEOFException);
        return 20;
    }

    private int matchTokenAt_21(Token token, ParserContext parserContext) {
        if (match_EOF(parserContext, token)) {
            endRule(parserContext, RuleType.DataTable);
            endRule(parserContext, RuleType.Step);
            endRule(parserContext, RuleType.ScenarioOutline);
            endRule(parserContext, RuleType.Scenario_Definition);
            endRule(parserContext, RuleType.Feature);
            build(parserContext, token);
            return 27;
        }
        if (match_TableRow(parserContext, token)) {
            build(parserContext, token);
            return 21;
        }
        if (match_StepLine(parserContext, token)) {
            endRule(parserContext, RuleType.DataTable);
            RuleType ruleType = RuleType.Step;
            endRule(parserContext, ruleType);
            startRule(parserContext, ruleType);
            build(parserContext, token);
            return 20;
        }
        if (match_TagLine(parserContext, token) && lookahead_0(parserContext, token)) {
            endRule(parserContext, RuleType.DataTable);
            endRule(parserContext, RuleType.Step);
            startRule(parserContext, RuleType.Examples_Definition);
            startRule(parserContext, RuleType.Tags);
            build(parserContext, token);
            return 22;
        }
        if (match_TagLine(parserContext, token)) {
            endRule(parserContext, RuleType.DataTable);
            endRule(parserContext, RuleType.Step);
            endRule(parserContext, RuleType.ScenarioOutline);
            RuleType ruleType2 = RuleType.Scenario_Definition;
            endRule(parserContext, ruleType2);
            startRule(parserContext, ruleType2);
            startRule(parserContext, RuleType.Tags);
            build(parserContext, token);
            return 11;
        }
        if (match_ExamplesLine(parserContext, token)) {
            endRule(parserContext, RuleType.DataTable);
            endRule(parserContext, RuleType.Step);
            startRule(parserContext, RuleType.Examples_Definition);
            startRule(parserContext, RuleType.Examples);
            build(parserContext, token);
            return 23;
        }
        if (match_ScenarioLine(parserContext, token)) {
            endRule(parserContext, RuleType.DataTable);
            endRule(parserContext, RuleType.Step);
            endRule(parserContext, RuleType.ScenarioOutline);
            RuleType ruleType3 = RuleType.Scenario_Definition;
            endRule(parserContext, ruleType3);
            startRule(parserContext, ruleType3);
            startRule(parserContext, RuleType.Scenario);
            build(parserContext, token);
            return 12;
        }
        if (match_ScenarioOutlineLine(parserContext, token)) {
            endRule(parserContext, RuleType.DataTable);
            endRule(parserContext, RuleType.Step);
            RuleType ruleType4 = RuleType.ScenarioOutline;
            endRule(parserContext, ruleType4);
            RuleType ruleType5 = RuleType.Scenario_Definition;
            endRule(parserContext, ruleType5);
            startRule(parserContext, ruleType5);
            startRule(parserContext, ruleType4);
            build(parserContext, token);
            return 17;
        }
        if (match_Comment(parserContext, token)) {
            build(parserContext, token);
            return 21;
        }
        if (match_Empty(parserContext, token)) {
            build(parserContext, token);
            return 21;
        }
        token.detach();
        List listAsList = Arrays.asList("#EOF", "#TableRow", "#StepLine", "#TagLine", "#ExamplesLine", "#ScenarioLine", "#ScenarioOutlineLine", "#Comment", "#Empty");
        ParserException unexpectedEOFException = token.isEOF() ? new ParserException.UnexpectedEOFException(token, listAsList, "State: 21 - GherkinDocument:0>Feature:2>Scenario_Definition:1>__alt0:1>ScenarioOutline:2>Step:1>Step_Arg:0>__alt1:0>DataTable:0>#TableRow:0") : new ParserException.UnexpectedTokenException(token, listAsList, "State: 21 - GherkinDocument:0>Feature:2>Scenario_Definition:1>__alt0:1>ScenarioOutline:2>Step:1>Step_Arg:0>__alt1:0>DataTable:0>#TableRow:0");
        if (this.stopAtFirstError) {
            throw unexpectedEOFException;
        }
        addError(parserContext, unexpectedEOFException);
        return 21;
    }

    private int matchTokenAt_22(Token token, ParserContext parserContext) {
        if (match_TagLine(parserContext, token)) {
            build(parserContext, token);
            return 22;
        }
        if (match_ExamplesLine(parserContext, token)) {
            endRule(parserContext, RuleType.Tags);
            startRule(parserContext, RuleType.Examples);
            build(parserContext, token);
            return 23;
        }
        if (match_Comment(parserContext, token)) {
            build(parserContext, token);
            return 22;
        }
        if (match_Empty(parserContext, token)) {
            build(parserContext, token);
            return 22;
        }
        token.detach();
        List listAsList = Arrays.asList("#TagLine", "#ExamplesLine", "#Comment", "#Empty");
        ParserException unexpectedEOFException = token.isEOF() ? new ParserException.UnexpectedEOFException(token, listAsList, "State: 22 - GherkinDocument:0>Feature:2>Scenario_Definition:1>__alt0:1>ScenarioOutline:3>Examples_Definition:0>Tags:0>#TagLine:0") : new ParserException.UnexpectedTokenException(token, listAsList, "State: 22 - GherkinDocument:0>Feature:2>Scenario_Definition:1>__alt0:1>ScenarioOutline:3>Examples_Definition:0>Tags:0>#TagLine:0");
        if (this.stopAtFirstError) {
            throw unexpectedEOFException;
        }
        addError(parserContext, unexpectedEOFException);
        return 22;
    }

    private int matchTokenAt_23(Token token, ParserContext parserContext) {
        if (match_EOF(parserContext, token)) {
            endRule(parserContext, RuleType.Examples);
            endRule(parserContext, RuleType.Examples_Definition);
            endRule(parserContext, RuleType.ScenarioOutline);
            endRule(parserContext, RuleType.Scenario_Definition);
            endRule(parserContext, RuleType.Feature);
            build(parserContext, token);
            return 27;
        }
        if (match_Empty(parserContext, token)) {
            build(parserContext, token);
            return 23;
        }
        if (match_Comment(parserContext, token)) {
            build(parserContext, token);
            return 25;
        }
        if (match_TableRow(parserContext, token)) {
            startRule(parserContext, RuleType.Examples_Table);
            build(parserContext, token);
            return 26;
        }
        if (match_TagLine(parserContext, token) && lookahead_0(parserContext, token)) {
            endRule(parserContext, RuleType.Examples);
            RuleType ruleType = RuleType.Examples_Definition;
            endRule(parserContext, ruleType);
            startRule(parserContext, ruleType);
            startRule(parserContext, RuleType.Tags);
            build(parserContext, token);
            return 22;
        }
        if (match_TagLine(parserContext, token)) {
            endRule(parserContext, RuleType.Examples);
            endRule(parserContext, RuleType.Examples_Definition);
            endRule(parserContext, RuleType.ScenarioOutline);
            RuleType ruleType2 = RuleType.Scenario_Definition;
            endRule(parserContext, ruleType2);
            startRule(parserContext, ruleType2);
            startRule(parserContext, RuleType.Tags);
            build(parserContext, token);
            return 11;
        }
        if (match_ExamplesLine(parserContext, token)) {
            RuleType ruleType3 = RuleType.Examples;
            endRule(parserContext, ruleType3);
            RuleType ruleType4 = RuleType.Examples_Definition;
            endRule(parserContext, ruleType4);
            startRule(parserContext, ruleType4);
            startRule(parserContext, ruleType3);
            build(parserContext, token);
            return 23;
        }
        if (match_ScenarioLine(parserContext, token)) {
            endRule(parserContext, RuleType.Examples);
            endRule(parserContext, RuleType.Examples_Definition);
            endRule(parserContext, RuleType.ScenarioOutline);
            RuleType ruleType5 = RuleType.Scenario_Definition;
            endRule(parserContext, ruleType5);
            startRule(parserContext, ruleType5);
            startRule(parserContext, RuleType.Scenario);
            build(parserContext, token);
            return 12;
        }
        if (match_ScenarioOutlineLine(parserContext, token)) {
            endRule(parserContext, RuleType.Examples);
            endRule(parserContext, RuleType.Examples_Definition);
            RuleType ruleType6 = RuleType.ScenarioOutline;
            endRule(parserContext, ruleType6);
            RuleType ruleType7 = RuleType.Scenario_Definition;
            endRule(parserContext, ruleType7);
            startRule(parserContext, ruleType7);
            startRule(parserContext, ruleType6);
            build(parserContext, token);
            return 17;
        }
        if (match_Other(parserContext, token)) {
            startRule(parserContext, RuleType.Description);
            build(parserContext, token);
            return 24;
        }
        token.detach();
        List listAsList = Arrays.asList("#EOF", "#Empty", "#Comment", "#TableRow", "#TagLine", "#ExamplesLine", "#ScenarioLine", "#ScenarioOutlineLine", "#Other");
        ParserException unexpectedEOFException = token.isEOF() ? new ParserException.UnexpectedEOFException(token, listAsList, "State: 23 - GherkinDocument:0>Feature:2>Scenario_Definition:1>__alt0:1>ScenarioOutline:3>Examples_Definition:1>Examples:0>#ExamplesLine:0") : new ParserException.UnexpectedTokenException(token, listAsList, "State: 23 - GherkinDocument:0>Feature:2>Scenario_Definition:1>__alt0:1>ScenarioOutline:3>Examples_Definition:1>Examples:0>#ExamplesLine:0");
        if (this.stopAtFirstError) {
            throw unexpectedEOFException;
        }
        addError(parserContext, unexpectedEOFException);
        return 23;
    }

    private int matchTokenAt_24(Token token, ParserContext parserContext) {
        if (match_EOF(parserContext, token)) {
            endRule(parserContext, RuleType.Description);
            endRule(parserContext, RuleType.Examples);
            endRule(parserContext, RuleType.Examples_Definition);
            endRule(parserContext, RuleType.ScenarioOutline);
            endRule(parserContext, RuleType.Scenario_Definition);
            endRule(parserContext, RuleType.Feature);
            build(parserContext, token);
            return 27;
        }
        if (match_Comment(parserContext, token)) {
            endRule(parserContext, RuleType.Description);
            build(parserContext, token);
            return 25;
        }
        if (match_TableRow(parserContext, token)) {
            endRule(parserContext, RuleType.Description);
            startRule(parserContext, RuleType.Examples_Table);
            build(parserContext, token);
            return 26;
        }
        if (match_TagLine(parserContext, token) && lookahead_0(parserContext, token)) {
            endRule(parserContext, RuleType.Description);
            endRule(parserContext, RuleType.Examples);
            RuleType ruleType = RuleType.Examples_Definition;
            endRule(parserContext, ruleType);
            startRule(parserContext, ruleType);
            startRule(parserContext, RuleType.Tags);
            build(parserContext, token);
            return 22;
        }
        if (match_TagLine(parserContext, token)) {
            endRule(parserContext, RuleType.Description);
            endRule(parserContext, RuleType.Examples);
            endRule(parserContext, RuleType.Examples_Definition);
            endRule(parserContext, RuleType.ScenarioOutline);
            RuleType ruleType2 = RuleType.Scenario_Definition;
            endRule(parserContext, ruleType2);
            startRule(parserContext, ruleType2);
            startRule(parserContext, RuleType.Tags);
            build(parserContext, token);
            return 11;
        }
        if (match_ExamplesLine(parserContext, token)) {
            endRule(parserContext, RuleType.Description);
            RuleType ruleType3 = RuleType.Examples;
            endRule(parserContext, ruleType3);
            RuleType ruleType4 = RuleType.Examples_Definition;
            endRule(parserContext, ruleType4);
            startRule(parserContext, ruleType4);
            startRule(parserContext, ruleType3);
            build(parserContext, token);
            return 23;
        }
        if (match_ScenarioLine(parserContext, token)) {
            endRule(parserContext, RuleType.Description);
            endRule(parserContext, RuleType.Examples);
            endRule(parserContext, RuleType.Examples_Definition);
            endRule(parserContext, RuleType.ScenarioOutline);
            RuleType ruleType5 = RuleType.Scenario_Definition;
            endRule(parserContext, ruleType5);
            startRule(parserContext, ruleType5);
            startRule(parserContext, RuleType.Scenario);
            build(parserContext, token);
            return 12;
        }
        if (match_ScenarioOutlineLine(parserContext, token)) {
            endRule(parserContext, RuleType.Description);
            endRule(parserContext, RuleType.Examples);
            endRule(parserContext, RuleType.Examples_Definition);
            RuleType ruleType6 = RuleType.ScenarioOutline;
            endRule(parserContext, ruleType6);
            RuleType ruleType7 = RuleType.Scenario_Definition;
            endRule(parserContext, ruleType7);
            startRule(parserContext, ruleType7);
            startRule(parserContext, ruleType6);
            build(parserContext, token);
            return 17;
        }
        if (match_Other(parserContext, token)) {
            build(parserContext, token);
            return 24;
        }
        token.detach();
        List listAsList = Arrays.asList("#EOF", "#Comment", "#TableRow", "#TagLine", "#ExamplesLine", "#ScenarioLine", "#ScenarioOutlineLine", "#Other");
        ParserException unexpectedEOFException = token.isEOF() ? new ParserException.UnexpectedEOFException(token, listAsList, "State: 24 - GherkinDocument:0>Feature:2>Scenario_Definition:1>__alt0:1>ScenarioOutline:3>Examples_Definition:1>Examples:1>Description_Helper:1>Description:0>#Other:0") : new ParserException.UnexpectedTokenException(token, listAsList, "State: 24 - GherkinDocument:0>Feature:2>Scenario_Definition:1>__alt0:1>ScenarioOutline:3>Examples_Definition:1>Examples:1>Description_Helper:1>Description:0>#Other:0");
        if (this.stopAtFirstError) {
            throw unexpectedEOFException;
        }
        addError(parserContext, unexpectedEOFException);
        return 24;
    }

    private int matchTokenAt_25(Token token, ParserContext parserContext) {
        if (match_EOF(parserContext, token)) {
            endRule(parserContext, RuleType.Examples);
            endRule(parserContext, RuleType.Examples_Definition);
            endRule(parserContext, RuleType.ScenarioOutline);
            endRule(parserContext, RuleType.Scenario_Definition);
            endRule(parserContext, RuleType.Feature);
            build(parserContext, token);
            return 27;
        }
        if (match_Comment(parserContext, token)) {
            build(parserContext, token);
            return 25;
        }
        if (match_TableRow(parserContext, token)) {
            startRule(parserContext, RuleType.Examples_Table);
            build(parserContext, token);
            return 26;
        }
        if (match_TagLine(parserContext, token) && lookahead_0(parserContext, token)) {
            endRule(parserContext, RuleType.Examples);
            RuleType ruleType = RuleType.Examples_Definition;
            endRule(parserContext, ruleType);
            startRule(parserContext, ruleType);
            startRule(parserContext, RuleType.Tags);
            build(parserContext, token);
            return 22;
        }
        if (match_TagLine(parserContext, token)) {
            endRule(parserContext, RuleType.Examples);
            endRule(parserContext, RuleType.Examples_Definition);
            endRule(parserContext, RuleType.ScenarioOutline);
            RuleType ruleType2 = RuleType.Scenario_Definition;
            endRule(parserContext, ruleType2);
            startRule(parserContext, ruleType2);
            startRule(parserContext, RuleType.Tags);
            build(parserContext, token);
            return 11;
        }
        if (match_ExamplesLine(parserContext, token)) {
            RuleType ruleType3 = RuleType.Examples;
            endRule(parserContext, ruleType3);
            RuleType ruleType4 = RuleType.Examples_Definition;
            endRule(parserContext, ruleType4);
            startRule(parserContext, ruleType4);
            startRule(parserContext, ruleType3);
            build(parserContext, token);
            return 23;
        }
        if (match_ScenarioLine(parserContext, token)) {
            endRule(parserContext, RuleType.Examples);
            endRule(parserContext, RuleType.Examples_Definition);
            endRule(parserContext, RuleType.ScenarioOutline);
            RuleType ruleType5 = RuleType.Scenario_Definition;
            endRule(parserContext, ruleType5);
            startRule(parserContext, ruleType5);
            startRule(parserContext, RuleType.Scenario);
            build(parserContext, token);
            return 12;
        }
        if (match_ScenarioOutlineLine(parserContext, token)) {
            endRule(parserContext, RuleType.Examples);
            endRule(parserContext, RuleType.Examples_Definition);
            RuleType ruleType6 = RuleType.ScenarioOutline;
            endRule(parserContext, ruleType6);
            RuleType ruleType7 = RuleType.Scenario_Definition;
            endRule(parserContext, ruleType7);
            startRule(parserContext, ruleType7);
            startRule(parserContext, ruleType6);
            build(parserContext, token);
            return 17;
        }
        if (match_Empty(parserContext, token)) {
            build(parserContext, token);
            return 25;
        }
        token.detach();
        List listAsList = Arrays.asList("#EOF", "#Comment", "#TableRow", "#TagLine", "#ExamplesLine", "#ScenarioLine", "#ScenarioOutlineLine", "#Empty");
        ParserException unexpectedEOFException = token.isEOF() ? new ParserException.UnexpectedEOFException(token, listAsList, "State: 25 - GherkinDocument:0>Feature:2>Scenario_Definition:1>__alt0:1>ScenarioOutline:3>Examples_Definition:1>Examples:1>Description_Helper:2>#Comment:0") : new ParserException.UnexpectedTokenException(token, listAsList, "State: 25 - GherkinDocument:0>Feature:2>Scenario_Definition:1>__alt0:1>ScenarioOutline:3>Examples_Definition:1>Examples:1>Description_Helper:2>#Comment:0");
        if (this.stopAtFirstError) {
            throw unexpectedEOFException;
        }
        addError(parserContext, unexpectedEOFException);
        return 25;
    }

    private int matchTokenAt_26(Token token, ParserContext parserContext) {
        if (match_EOF(parserContext, token)) {
            endRule(parserContext, RuleType.Examples_Table);
            endRule(parserContext, RuleType.Examples);
            endRule(parserContext, RuleType.Examples_Definition);
            endRule(parserContext, RuleType.ScenarioOutline);
            endRule(parserContext, RuleType.Scenario_Definition);
            endRule(parserContext, RuleType.Feature);
            build(parserContext, token);
            return 27;
        }
        if (match_TableRow(parserContext, token)) {
            build(parserContext, token);
            return 26;
        }
        if (match_TagLine(parserContext, token) && lookahead_0(parserContext, token)) {
            endRule(parserContext, RuleType.Examples_Table);
            endRule(parserContext, RuleType.Examples);
            RuleType ruleType = RuleType.Examples_Definition;
            endRule(parserContext, ruleType);
            startRule(parserContext, ruleType);
            startRule(parserContext, RuleType.Tags);
            build(parserContext, token);
            return 22;
        }
        if (match_TagLine(parserContext, token)) {
            endRule(parserContext, RuleType.Examples_Table);
            endRule(parserContext, RuleType.Examples);
            endRule(parserContext, RuleType.Examples_Definition);
            endRule(parserContext, RuleType.ScenarioOutline);
            RuleType ruleType2 = RuleType.Scenario_Definition;
            endRule(parserContext, ruleType2);
            startRule(parserContext, ruleType2);
            startRule(parserContext, RuleType.Tags);
            build(parserContext, token);
            return 11;
        }
        if (match_ExamplesLine(parserContext, token)) {
            endRule(parserContext, RuleType.Examples_Table);
            RuleType ruleType3 = RuleType.Examples;
            endRule(parserContext, ruleType3);
            RuleType ruleType4 = RuleType.Examples_Definition;
            endRule(parserContext, ruleType4);
            startRule(parserContext, ruleType4);
            startRule(parserContext, ruleType3);
            build(parserContext, token);
            return 23;
        }
        if (match_ScenarioLine(parserContext, token)) {
            endRule(parserContext, RuleType.Examples_Table);
            endRule(parserContext, RuleType.Examples);
            endRule(parserContext, RuleType.Examples_Definition);
            endRule(parserContext, RuleType.ScenarioOutline);
            RuleType ruleType5 = RuleType.Scenario_Definition;
            endRule(parserContext, ruleType5);
            startRule(parserContext, ruleType5);
            startRule(parserContext, RuleType.Scenario);
            build(parserContext, token);
            return 12;
        }
        if (match_ScenarioOutlineLine(parserContext, token)) {
            endRule(parserContext, RuleType.Examples_Table);
            endRule(parserContext, RuleType.Examples);
            endRule(parserContext, RuleType.Examples_Definition);
            RuleType ruleType6 = RuleType.ScenarioOutline;
            endRule(parserContext, ruleType6);
            RuleType ruleType7 = RuleType.Scenario_Definition;
            endRule(parserContext, ruleType7);
            startRule(parserContext, ruleType7);
            startRule(parserContext, ruleType6);
            build(parserContext, token);
            return 17;
        }
        if (match_Comment(parserContext, token)) {
            build(parserContext, token);
            return 26;
        }
        if (match_Empty(parserContext, token)) {
            build(parserContext, token);
            return 26;
        }
        token.detach();
        List listAsList = Arrays.asList("#EOF", "#TableRow", "#TagLine", "#ExamplesLine", "#ScenarioLine", "#ScenarioOutlineLine", "#Comment", "#Empty");
        ParserException unexpectedEOFException = token.isEOF() ? new ParserException.UnexpectedEOFException(token, listAsList, "State: 26 - GherkinDocument:0>Feature:2>Scenario_Definition:1>__alt0:1>ScenarioOutline:3>Examples_Definition:1>Examples:2>Examples_Table:0>#TableRow:0") : new ParserException.UnexpectedTokenException(token, listAsList, "State: 26 - GherkinDocument:0>Feature:2>Scenario_Definition:1>__alt0:1>ScenarioOutline:3>Examples_Definition:1>Examples:2>Examples_Table:0>#TableRow:0");
        if (this.stopAtFirstError) {
            throw unexpectedEOFException;
        }
        addError(parserContext, unexpectedEOFException);
        return 26;
    }

    private int matchTokenAt_28(Token token, ParserContext parserContext) {
        if (match_DocStringSeparator(parserContext, token)) {
            build(parserContext, token);
            return 29;
        }
        if (match_Other(parserContext, token)) {
            build(parserContext, token);
            return 28;
        }
        token.detach();
        List listAsList = Arrays.asList("#DocStringSeparator", "#Other");
        ParserException unexpectedEOFException = token.isEOF() ? new ParserException.UnexpectedEOFException(token, listAsList, "State: 28 - GherkinDocument:0>Feature:2>Scenario_Definition:1>__alt0:1>ScenarioOutline:2>Step:1>Step_Arg:0>__alt1:1>DocString:0>#DocStringSeparator:0") : new ParserException.UnexpectedTokenException(token, listAsList, "State: 28 - GherkinDocument:0>Feature:2>Scenario_Definition:1>__alt0:1>ScenarioOutline:2>Step:1>Step_Arg:0>__alt1:1>DocString:0>#DocStringSeparator:0");
        if (this.stopAtFirstError) {
            throw unexpectedEOFException;
        }
        addError(parserContext, unexpectedEOFException);
        return 28;
    }

    private int matchTokenAt_29(Token token, ParserContext parserContext) {
        if (match_EOF(parserContext, token)) {
            endRule(parserContext, RuleType.DocString);
            endRule(parserContext, RuleType.Step);
            endRule(parserContext, RuleType.ScenarioOutline);
            endRule(parserContext, RuleType.Scenario_Definition);
            endRule(parserContext, RuleType.Feature);
            build(parserContext, token);
            return 27;
        }
        if (match_StepLine(parserContext, token)) {
            endRule(parserContext, RuleType.DocString);
            RuleType ruleType = RuleType.Step;
            endRule(parserContext, ruleType);
            startRule(parserContext, ruleType);
            build(parserContext, token);
            return 20;
        }
        if (match_TagLine(parserContext, token) && lookahead_0(parserContext, token)) {
            endRule(parserContext, RuleType.DocString);
            endRule(parserContext, RuleType.Step);
            startRule(parserContext, RuleType.Examples_Definition);
            startRule(parserContext, RuleType.Tags);
            build(parserContext, token);
            return 22;
        }
        if (match_TagLine(parserContext, token)) {
            endRule(parserContext, RuleType.DocString);
            endRule(parserContext, RuleType.Step);
            endRule(parserContext, RuleType.ScenarioOutline);
            RuleType ruleType2 = RuleType.Scenario_Definition;
            endRule(parserContext, ruleType2);
            startRule(parserContext, ruleType2);
            startRule(parserContext, RuleType.Tags);
            build(parserContext, token);
            return 11;
        }
        if (match_ExamplesLine(parserContext, token)) {
            endRule(parserContext, RuleType.DocString);
            endRule(parserContext, RuleType.Step);
            startRule(parserContext, RuleType.Examples_Definition);
            startRule(parserContext, RuleType.Examples);
            build(parserContext, token);
            return 23;
        }
        if (match_ScenarioLine(parserContext, token)) {
            endRule(parserContext, RuleType.DocString);
            endRule(parserContext, RuleType.Step);
            endRule(parserContext, RuleType.ScenarioOutline);
            RuleType ruleType3 = RuleType.Scenario_Definition;
            endRule(parserContext, ruleType3);
            startRule(parserContext, ruleType3);
            startRule(parserContext, RuleType.Scenario);
            build(parserContext, token);
            return 12;
        }
        if (match_ScenarioOutlineLine(parserContext, token)) {
            endRule(parserContext, RuleType.DocString);
            endRule(parserContext, RuleType.Step);
            RuleType ruleType4 = RuleType.ScenarioOutline;
            endRule(parserContext, ruleType4);
            RuleType ruleType5 = RuleType.Scenario_Definition;
            endRule(parserContext, ruleType5);
            startRule(parserContext, ruleType5);
            startRule(parserContext, ruleType4);
            build(parserContext, token);
            return 17;
        }
        if (match_Comment(parserContext, token)) {
            build(parserContext, token);
            return 29;
        }
        if (match_Empty(parserContext, token)) {
            build(parserContext, token);
            return 29;
        }
        token.detach();
        List listAsList = Arrays.asList("#EOF", "#StepLine", "#TagLine", "#ExamplesLine", "#ScenarioLine", "#ScenarioOutlineLine", "#Comment", "#Empty");
        ParserException unexpectedEOFException = token.isEOF() ? new ParserException.UnexpectedEOFException(token, listAsList, "State: 29 - GherkinDocument:0>Feature:2>Scenario_Definition:1>__alt0:1>ScenarioOutline:2>Step:1>Step_Arg:0>__alt1:1>DocString:2>#DocStringSeparator:0") : new ParserException.UnexpectedTokenException(token, listAsList, "State: 29 - GherkinDocument:0>Feature:2>Scenario_Definition:1>__alt0:1>ScenarioOutline:2>Step:1>Step_Arg:0>__alt1:1>DocString:2>#DocStringSeparator:0");
        if (this.stopAtFirstError) {
            throw unexpectedEOFException;
        }
        addError(parserContext, unexpectedEOFException);
        return 29;
    }

    private int matchTokenAt_30(Token token, ParserContext parserContext) {
        if (match_DocStringSeparator(parserContext, token)) {
            build(parserContext, token);
            return 31;
        }
        if (match_Other(parserContext, token)) {
            build(parserContext, token);
            return 30;
        }
        token.detach();
        List listAsList = Arrays.asList("#DocStringSeparator", "#Other");
        ParserException unexpectedEOFException = token.isEOF() ? new ParserException.UnexpectedEOFException(token, listAsList, "State: 30 - GherkinDocument:0>Feature:2>Scenario_Definition:1>__alt0:0>Scenario:2>Step:1>Step_Arg:0>__alt1:1>DocString:0>#DocStringSeparator:0") : new ParserException.UnexpectedTokenException(token, listAsList, "State: 30 - GherkinDocument:0>Feature:2>Scenario_Definition:1>__alt0:0>Scenario:2>Step:1>Step_Arg:0>__alt1:1>DocString:0>#DocStringSeparator:0");
        if (this.stopAtFirstError) {
            throw unexpectedEOFException;
        }
        addError(parserContext, unexpectedEOFException);
        return 30;
    }

    private int matchTokenAt_31(Token token, ParserContext parserContext) {
        if (match_EOF(parserContext, token)) {
            endRule(parserContext, RuleType.DocString);
            endRule(parserContext, RuleType.Step);
            endRule(parserContext, RuleType.Scenario);
            endRule(parserContext, RuleType.Scenario_Definition);
            endRule(parserContext, RuleType.Feature);
            build(parserContext, token);
            return 27;
        }
        if (match_StepLine(parserContext, token)) {
            endRule(parserContext, RuleType.DocString);
            RuleType ruleType = RuleType.Step;
            endRule(parserContext, ruleType);
            startRule(parserContext, ruleType);
            build(parserContext, token);
            return 15;
        }
        if (match_TagLine(parserContext, token)) {
            endRule(parserContext, RuleType.DocString);
            endRule(parserContext, RuleType.Step);
            endRule(parserContext, RuleType.Scenario);
            RuleType ruleType2 = RuleType.Scenario_Definition;
            endRule(parserContext, ruleType2);
            startRule(parserContext, ruleType2);
            startRule(parserContext, RuleType.Tags);
            build(parserContext, token);
            return 11;
        }
        if (match_ScenarioLine(parserContext, token)) {
            endRule(parserContext, RuleType.DocString);
            endRule(parserContext, RuleType.Step);
            RuleType ruleType3 = RuleType.Scenario;
            endRule(parserContext, ruleType3);
            RuleType ruleType4 = RuleType.Scenario_Definition;
            endRule(parserContext, ruleType4);
            startRule(parserContext, ruleType4);
            startRule(parserContext, ruleType3);
            build(parserContext, token);
            return 12;
        }
        if (match_ScenarioOutlineLine(parserContext, token)) {
            endRule(parserContext, RuleType.DocString);
            endRule(parserContext, RuleType.Step);
            endRule(parserContext, RuleType.Scenario);
            RuleType ruleType5 = RuleType.Scenario_Definition;
            endRule(parserContext, ruleType5);
            startRule(parserContext, ruleType5);
            startRule(parserContext, RuleType.ScenarioOutline);
            build(parserContext, token);
            return 17;
        }
        if (match_Comment(parserContext, token)) {
            build(parserContext, token);
            return 31;
        }
        if (match_Empty(parserContext, token)) {
            build(parserContext, token);
            return 31;
        }
        token.detach();
        List listAsList = Arrays.asList("#EOF", "#StepLine", "#TagLine", "#ScenarioLine", "#ScenarioOutlineLine", "#Comment", "#Empty");
        ParserException unexpectedEOFException = token.isEOF() ? new ParserException.UnexpectedEOFException(token, listAsList, "State: 31 - GherkinDocument:0>Feature:2>Scenario_Definition:1>__alt0:0>Scenario:2>Step:1>Step_Arg:0>__alt1:1>DocString:2>#DocStringSeparator:0") : new ParserException.UnexpectedTokenException(token, listAsList, "State: 31 - GherkinDocument:0>Feature:2>Scenario_Definition:1>__alt0:0>Scenario:2>Step:1>Step_Arg:0>__alt1:1>DocString:2>#DocStringSeparator:0");
        if (this.stopAtFirstError) {
            throw unexpectedEOFException;
        }
        addError(parserContext, unexpectedEOFException);
        return 31;
    }

    private int matchTokenAt_32(Token token, ParserContext parserContext) {
        if (match_DocStringSeparator(parserContext, token)) {
            build(parserContext, token);
            return 33;
        }
        if (match_Other(parserContext, token)) {
            build(parserContext, token);
            return 32;
        }
        token.detach();
        List listAsList = Arrays.asList("#DocStringSeparator", "#Other");
        ParserException unexpectedEOFException = token.isEOF() ? new ParserException.UnexpectedEOFException(token, listAsList, "State: 32 - GherkinDocument:0>Feature:1>Background:2>Step:1>Step_Arg:0>__alt1:1>DocString:0>#DocStringSeparator:0") : new ParserException.UnexpectedTokenException(token, listAsList, "State: 32 - GherkinDocument:0>Feature:1>Background:2>Step:1>Step_Arg:0>__alt1:1>DocString:0>#DocStringSeparator:0");
        if (this.stopAtFirstError) {
            throw unexpectedEOFException;
        }
        addError(parserContext, unexpectedEOFException);
        return 32;
    }

    private int matchTokenAt_33(Token token, ParserContext parserContext) {
        if (match_EOF(parserContext, token)) {
            endRule(parserContext, RuleType.DocString);
            endRule(parserContext, RuleType.Step);
            endRule(parserContext, RuleType.Background);
            endRule(parserContext, RuleType.Feature);
            build(parserContext, token);
            return 27;
        }
        if (match_StepLine(parserContext, token)) {
            endRule(parserContext, RuleType.DocString);
            RuleType ruleType = RuleType.Step;
            endRule(parserContext, ruleType);
            startRule(parserContext, ruleType);
            build(parserContext, token);
            return 9;
        }
        if (match_TagLine(parserContext, token)) {
            endRule(parserContext, RuleType.DocString);
            endRule(parserContext, RuleType.Step);
            endRule(parserContext, RuleType.Background);
            startRule(parserContext, RuleType.Scenario_Definition);
            startRule(parserContext, RuleType.Tags);
            build(parserContext, token);
            return 11;
        }
        if (match_ScenarioLine(parserContext, token)) {
            endRule(parserContext, RuleType.DocString);
            endRule(parserContext, RuleType.Step);
            endRule(parserContext, RuleType.Background);
            startRule(parserContext, RuleType.Scenario_Definition);
            startRule(parserContext, RuleType.Scenario);
            build(parserContext, token);
            return 12;
        }
        if (match_ScenarioOutlineLine(parserContext, token)) {
            endRule(parserContext, RuleType.DocString);
            endRule(parserContext, RuleType.Step);
            endRule(parserContext, RuleType.Background);
            startRule(parserContext, RuleType.Scenario_Definition);
            startRule(parserContext, RuleType.ScenarioOutline);
            build(parserContext, token);
            return 17;
        }
        if (match_Comment(parserContext, token)) {
            build(parserContext, token);
            return 33;
        }
        if (match_Empty(parserContext, token)) {
            build(parserContext, token);
            return 33;
        }
        token.detach();
        List listAsList = Arrays.asList("#EOF", "#StepLine", "#TagLine", "#ScenarioLine", "#ScenarioOutlineLine", "#Comment", "#Empty");
        ParserException unexpectedEOFException = token.isEOF() ? new ParserException.UnexpectedEOFException(token, listAsList, "State: 33 - GherkinDocument:0>Feature:1>Background:2>Step:1>Step_Arg:0>__alt1:1>DocString:2>#DocStringSeparator:0") : new ParserException.UnexpectedTokenException(token, listAsList, "State: 33 - GherkinDocument:0>Feature:1>Background:2>Step:1>Step_Arg:0>__alt1:1>DocString:2>#DocStringSeparator:0");
        if (this.stopAtFirstError) {
            throw unexpectedEOFException;
        }
        addError(parserContext, unexpectedEOFException);
        return 33;
    }

    private boolean lookahead_0(ParserContext parserContext, Token token) {
        boolean z;
        token.detach();
        ArrayDeque arrayDeque = new ArrayDeque();
        while (true) {
            Token token2 = readToken(parserContext);
            token2.detach();
            arrayDeque.add(token2);
            if (!match_ExamplesLine(parserContext, token2)) {
                if (!match_Empty(parserContext, token2) && !match_Comment(parserContext, token2) && !match_TagLine(parserContext, token2)) {
                    z = false;
                    break;
                }
            } else {
                z = true;
                break;
            }
        }
        parserContext.tokenQueue.addAll(arrayDeque);
        return z;
    }
}
